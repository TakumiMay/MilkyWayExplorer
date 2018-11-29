package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.omg.PortableInterceptor.INACTIVE;

public class GraphAM <K extends Comparable <K>,T> implements IGraph<K,T>{
	
	/**
	 * Constant used as an infinite weight in the matrix
	 */
	public static final int MAX_WEIGHT = 200000;
	
	
	private int size;
	private HashMap<K, Node<K,T>> nodes;
	private Edge<K,T>[][] matrixA;
	private boolean directed;
	private HashMap<K, Double> distances;
	private HashMap<K, Boolean> visited; 
	private int cNodes;
	private ArrayList<Double> otherDistances;
	public int suma;

	public GraphAM(int size, boolean directed) {
		cNodes = 0;
		this.size = size;
		nodes = new HashMap<>();
		this.directed = directed;
		matrixA = new Edge[size][size];
		distances = new HashMap<K, Double>();
		visited = new HashMap<K, Boolean>();
		otherDistances = new ArrayList<>();
		suma =0;
		
		initializeMatrix();
		
	}
	
	public void initializeMatrix() {
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				if (i==j) {
					Edge<K, T> edge = new Edge<>(0);
					matrixA[i][j] = edge;
				}
				else {
					Edge<K, T> edge = new Edge<>(MAX_WEIGHT);
					matrixA[i][j] = edge;
				}
				
			}
		}
	}
	
	
	/**
	 * Add a Node to the HashMap of node
	 * @param key
	 * @param node
	 */
	@Override
	public void addNode(K key, T element, int position) {
		cNodes++;
		Node<K, T> node = new Node<K, T>(element, position);
		node.setKey(key);
		nodes.put(key, node);
		visited.put(key, false);
	}
	public void addNode(K key, T element) {
		
		Node<K, T> node = new Node<K, T>(element, cNodes);
		node.setKey(key);
		nodes.put(key, node);
		cNodes++;
		visited.put(key, false);
	}
	
	
	public void addEdge(K key1,K key2, double weight) {
		int p1 = nodes.get(key1).getPosition();
		int p2 = nodes.get(key2).getPosition();
		Edge<K, T> e = new Edge<>(weight);
		e.setAdjacentTo(key2);
		
		matrixA[p1][p2] = e;
		matrixA[p1][p1] = new Edge<>(0);
		if (!directed) {
			Edge<K, T> e2 = new Edge<>(weight);
			e2.setAdjacentTo(key1);
			matrixA[p2][p1] = e2;
		}
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist an edge, false in other case.
	 */
	public boolean exist(K element1, K element2) {
		boolean result;
		int p1 = nodes.get(element1).getPosition();
		int p2 = nodes.get(element2).getPosition();
		if (matrixA[p1][p2].getWeight() == MAX_WEIGHT) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	
	/**
	 * Delete a edge between two nodes
	 */
	public void deleteEdge(K key, K key2) {
		int element1 = nodes.get(key).getPosition();
		int element2 = nodes.get(key2).getPosition();
		matrixA[element1][element2] = null;
	}
	
	public void deleteNode(K key) {
		nodes.remove(key);
		int j = nodes.get(key).getPosition();
		for (int i = 0; i < matrixA.length; i++) {
			matrixA[i][j] = null;
			matrixA[j][i] = null;
		}
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public HashMap<K, Node<K, T>> getNodes() {
		return nodes;
	}


	public void setNodes(HashMap<K, Node<K, T>> nodes) {
		this.nodes = nodes;
	}


	public Edge<K, T>[][] getMatrixA() {
		return matrixA;
	}


	public void setMatrixA(Edge<K, T>[][] matrixA) {
		this.matrixA = matrixA;
	}


	public boolean isDirected() {
		return directed;
	}


	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	
//	public Edge<K, T>[][] floydWarshall(){
//		Edge<K, T>[][] floydW = new Edge[size][size];
//		for (int i = 0; i < matrixA.length; i++) {
//			for (int j = 0; j < matrixA.length; j++) {
//				floydW[i][j] = matrixA[i][j];
//			}
//		}	
//		
//		 for(int k = 0; k < size; k++ ){
//		        for(int i = 0; i < size; i++ ){
//		            for(int j = 0; j < size; j++ ){
//		            	if (floydW[i][k]!=null) {
//		            		if (floydW[i][k].getWeight() + floydW[k][j].getWeight() < floydW[i][j].getWeight()) {
//			            		Edge<K, T> newEdge = new Edge<>(floydW[i][k].getWeight() + floydW[k][j].getWeight());
//			            		floydW[i][j] = newEdge;
//			            	}
//						}
//		            	
//		            		 
//		            }
//		        }
//		    }
//		
//		return floydW;
//	}
	
	public double[][] floydWarshall(){
		double[][] floydW = new double[size][size];
		
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				
				floydW[i][j] = matrixA[i][j].getWeight();
			}
		}
		
		
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
//		            	floydW[i][j] = Math.min(floydW[i][j], (floydW[i][k] + floydW[k][j]));
					if (floydW[i][k] + floydW[k][j] < floydW[i][j]) {

						floydW[i][j] = floydW[i][k] + floydW[k][j];
					}
				}
			}
		}
		
		
		
		return floydW;
	}
	
	/**
	 * Sort the edges using the weight
	 * @return A priority queue with the edges sorted.
	 */
	public PriorityQueue<Edge<K, T>> sortEdges(){
		PriorityQueue<Edge<K, T>> result = new PriorityQueue<>();
		
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				if (matrixA[i][j].getWeight() != MAX_WEIGHT && matrixA[i][j].getWeight() != 0) {
//					System.out.println(matrixA[i][j].getWeight());
					result.add( matrixA[i][j]);	
				}
				
			}
		}
		
		return result;
	}
	
	public PriorityQueue<Edge<K, T>> sortEdges(PriorityQueue<Edge<K, T>> pq,Node<K, T>source){
		
		
		int i = source.getPosition();
//		System.out.print("Encolo aristas de: "+source.getKey() +" ");

		for (int j = 0; j < matrixA.length; j++) {
			
			if ((matrixA[i][j].getWeight() != MAX_WEIGHT) && (matrixA[i][j].getWeight() != 0) && (matrixA[i][j]!= null)) {	
				
//				System.out.print(matrixA[i][j].getWeight()+" ");
				pq.add(matrixA[i][j]);	
			}
			
		}
//		System.out.println();
		return pq;
	}
	
	

	
	public void kruskal() {
		PriorityQueue<Edge<K, T>> pq = sortEdges();
		HashMap<K, Node<K,T>> fathers = new HashMap<>();
		HashMap<K, K> keys = new HashMap<>();
		fathers.putAll(nodes);
		for(Node<K,T> n: nodes.values()) {
			keys.put(n.getKey(), n.getKey());
		}
		int c = 0;	
	}
	
	/**
	 * 
	 * @param source Key of the node to start the prim
	 * @return MST
	 */
	public ArrayList<Node<K, T>> prim(K source){
		PriorityQueue<Edge<K, T>> pq = new PriorityQueue<>();
		pq = sortEdges(pq, nodes.get(source));
		HashMap<K,Boolean> visited = new HashMap<>();
		for(Node<K, T> n: nodes.values()) {
			K key = n.getKey();
			visited.put(key, false);
		}
		ArrayList<Node<K, T>> route = new ArrayList<>();
//		for(Node<K, T> n: nodes.values()) {
//			K key = n.getKey();
//			distances.put(key, Integer.MAX_VALUE);
//		}
//		distances.put(source, 0);
		
		visited.put(source, true);
		route.add(nodes.get(source));
		int c = 0;
		while (route.size()!=nodes.size()) {
			K key = pq.peek().getAdjacentTo();
			if (visited.get(key)) {
				pq.poll();
			}
			else {
				visited.put(key, true);
				route.add(nodes.get(key));
//				int distance = pq.peek().getWeight() + distances.get(key);
//				if(distance < distances.get(key)){
					distances.put(key, pq.peek().getWeight());
//				}
				
				pq.poll();
				pq = sortEdges(pq, nodes.get(key));
			}	
			c++;
		}		
		return route;
		
	}
	
	
//	public void dijkstra(Node<K,T> nodeP) {
//		
//		HashMap<K, Node<K, T>> previous = new HashMap<>();
//		PriorityQueue<Edge<K, T>> queueEdges = new PriorityQueue<>();
//		K keyNode = nodeP.getKey();
//		int i = nodeP.getPosition();
//		
//		for(Node<K, T> n: nodes.values()) {
//			K key = n.getKey();			
//			distances.put(key, Integer.MAX_VALUE);
//		}
//		distances.put(keyNode, 0);
//		for (int j = 0; j < matrixA.length; j++) {
//			
//			if (matrixA[i][j].getAdjacentTo() != null) {
//				distances.put(matrixA[i][j].getAdjacentTo(), matrixA[i][j].getWeight());
//			}			
//			if (matrixA[i][j].getWeight() < MAX_WEIGHT && matrixA[i][j].getWeight() != 0) {
//				queueEdges.add(matrixA[i][j]);
//			}
//		}
//		visited.put(keyNode, true);
//		while (!queueEdges.isEmpty()) {
//			K keyAdjacent = queueEdges.poll().getAdjacentTo();
////			System.out.println("Nodo a ver aristas "+keyAdjacent);
//			i = nodes.get(keyAdjacent).getPosition();
//			if (!visited.get(keyAdjacent)) {
//				visited.put(keyAdjacent, true);
//				for (int j = 0; j < matrixA.length; j++) {
//					K keyJ = matrixA[i][j].getAdjacentTo();
//					
//					if (keyJ != null) {
//						if (matrixA[i][j].getWeight() < MAX_WEIGHT && !visited.get(keyJ) && matrixA[i][j].getWeight() != 0) {
//							int newWeight = distances.get(keyAdjacent)+matrixA[i][j].getWeight();
//							if (newWeight < distances.get(keyJ) ) {
//								distances.put(keyJ, newWeight);		
//								previous.put(keyJ, nodes.get(keyAdjacent));
//							}
//							queueEdges.add(matrixA[i][j]);
//						}
//					}
//					
//				}
//			}
//			
//		}
//	}
	
	public void dijkstra(Node<K,T> nodeP) {
		
		for(Node<K, T> n: nodes.values()) {
			K key = n.getKey();			
			distances.put(key, Double.MAX_VALUE);
		}
		
		//Comparator<Edge> ec = new EdgeCompare();
		distances.put(nodeP.getKey(), 0.0);
		PriorityQueue<Edge<K, T>> queueEdges = new PriorityQueue<>();
		PriorityQueue<Node<K, T>> queueNode = new PriorityQueue<>();		
		queueEdges = sortEdges(queueEdges, nodeP);
		
		while(!queueEdges.isEmpty()) {
			double distance = queueEdges.peek().getWeight();
			Node<K, T> n = nodes.get((queueEdges.peek().getAdjacentTo()));
			distances.put(n.getKey(), distance);
			queueNode.add(n);
			queueEdges.poll();
			while(!queueNode.isEmpty()) {
				Node<K, T> nodeVisited = queueNode.poll();
//				System.out.print("Distancias: ");
				for(double a: distances.values()) {
//					System.out.print(a+" ");
				}
//				System.out.println();
				if(!visited.get(nodeVisited.getKey())){
					visited.put(nodeVisited.getKey(), true);
					
					relaxEdges(queueEdges, queueNode, nodeVisited);
				}
			}
		}
		
	}
	
	public void relaxEdges(PriorityQueue<Edge<K, T>> qe, PriorityQueue<Node<K, T>> qn, Node<K,T> n) {
//		for(Edge<K, T> e: n.getList().values()) {
//			qe.add(e);
//		}
		
		qe = sortEdges(qe, n);
		while(!qe.isEmpty()) {
			double distance = qe.peek().getWeight() + distances.get(n.getKey());
//			K k = nodes.get(qe.peek().getAdjacentTo()).getKey();
			K k = qe.peek().getAdjacentTo();	
//			System.out.println(k+" "+distances.get(k));
//			System.out.println(k+" "+qe.peek().getWeight());
			if(distance < distances.get(k)){
//				distances.put( ((Edge<K, T>) qe.peek()).getWeight(), distance);
				distances.put( qe.peek().getAdjacentTo(), distance);
			}
//			qn.add(((Edge<K, T>) qe.poll()).getAdjacentTo());
			qn.add(nodes.get(qe.poll().getAdjacentTo()));
		}
	}

	public HashMap<K, Boolean> getVisited() {
		return visited;
	}

	public void setVisited(HashMap<K, Boolean> visited) {
		this.visited = visited;
	}

	public HashMap<K, Double> getDistances() {
		return distances;
	}

	public void setDistances(HashMap<K, Double> distances) {
		this.distances = distances;
	}

	public ArrayList<Double> getOtherDistances() {
		return otherDistances;
	}

	public void setOtherDistances(ArrayList<Double> otherDistances) {
		this.otherDistances = otherDistances;
	}
	
//	public static void main(String[] args) {
//		GraphAM<String, Integer> g = new GraphAM<>(6,false);
////		Node<String, Integer> a = new Node("A", 10);
////		Node<String, Integer> b = new Node("B", 30);
////		Node<String, Integer> c = new Node("C", 23);
////		Node<String, Integer> d = new Node("D", 5);
////		Node<String, Integer> e = new Node("E", 8);
////		Node<String, Integer> z = new Node("Z", 34);
////		Node<String, Integer> w = new Node("W", 13);
//		g.addNode("A", 10);
//		g.addNode("B", 30);
//		g.addNode("C", 23);
//		g.addNode("D", 5);
//		g.addNode("E", 8);
//		g.addNode("Z", 34);
//		
//		
//		//g.addNode(w);
//		g.addEdge("A", "B", 4);
//		g.addEdge("A", "C", 2);
//		g.addEdge("B", "D", 5);
//		g.addEdge("B", "C", 1);
//		g.addEdge("C", "D", 8);
//		g.addEdge("C", "E", 10);
//		g.addEdge("E", "Z", 3);
//		g.addEdge("D", "E", 2);
//		g.addEdge("D", "Z", 6);
////		for (int i = 0; i < g.size; i++) {
////			for (int j = 0; j < g.size; j++) {
////				System.out.print(g.getMatrixA()[i][j].getWeight()+" ");
////				if (j==g.size-1) {
////					System.out.println();
////				}
////				
////			}			
////		}
//		g.dijkstra(g.getNodes().get("A"));
//		
//		g.distances.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
//		
//		
//		
// 		
//		
//		
//	}  
	
	
	
	
	
	
	
}
