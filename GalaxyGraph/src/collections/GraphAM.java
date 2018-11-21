package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class GraphAM <K extends Comparable <K>,T> implements IGraph<K,T>{
	
	
	private int size;
	private HashMap<K, Node<K,T>> nodes;
	private Edge<K,T>[][] matrixA;
	private boolean directed;

	public GraphAM(int size, boolean directed) {
		this.size = size;
		nodes = new HashMap<>();
		this.directed = directed;
		matrixA = new Edge[size][size];
		
	}
	
	
	/**
	 * Add a Node to the HashMap of node
	 * @param key
	 * @param node
	 */
	@Override
	public void addNode(K key, T element, int position) {
		Node<K, T> node = new Node<K, T>(element, position);
		node.setKey(key);
		nodes.put(key, node);
	}
	
	public void addEdge(K key1,K key2, int weight) {
		int p1 = nodes.get(key1).getPosition();
		int p2 = nodes.get(key2).getPosition();
		Edge<K, T> e = new Edge<>(weight);
		e.setAdjacentTo(key2);
		matrixA[p1][p2] = e;
		if (!directed) {
			matrixA[p2][p1] = e;
		}
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a vertex, false in other case.
	 */
	public boolean exist(K element1, K element2) {
		int p1 = nodes.get(element1).getPosition();
		int p2 = nodes.get(element2).getPosition();
		return matrixA[p1][p2] == null ? false : true;
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
	
	public Edge<K, T>[][] floydWarshall(){
		Edge<K, T>[][] floydW = new Edge[size][size];
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				floydW[i][j] = matrixA[i][j];
			}
		}	
		
		 for(int k = 0; k < size; k++ ){
		        for(int i = 0; i < size; i++ ){
		            for(int j = 0; j < size; j++ ){
		            	if (floydW[i][k].getWeight() + floydW[k][j].getWeight() < floydW[i][j].getWeight()) {
		            		Edge<K, T> newEdge = new Edge<>(floydW[i][k].getWeight() + floydW[k][j].getWeight());
		            		floydW[i][j] = newEdge;
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
				if (matrixA[i][j] != null) {
					result.add( matrixA[i][j]);	
				}
				
			}
		}
		
		return result;
	}
	
	public PriorityQueue<Edge<K, T>> sortEdges(PriorityQueue<Edge<K, T>> pq,Node<K, T>source){
		
		
		int i = source.getPosition();

		for (int j = 0; j < matrixA.length; j++) {
			
			if (matrixA[i][j]!=null) {
				
				pq.add(matrixA[i][j]);
			}
			
		}
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
		pq = sortEdges(pq,nodes.get(source));
		HashMap<K,Boolean> visited = new HashMap<>();
		ArrayList<Node<K, T>> route = new ArrayList<>();
		
		visited.put(source, true);
		route.add(nodes.get(source));
		int c = 0;
		while (c<nodes.size()-1) {
			K key = pq.peek().getAdjacentTo();
			if (visited.get(key)!=null) {
				pq.poll();
			}
			else {
				visited.put(key, true);
				route.add(nodes.get(key));
				pq.poll();
				pq = sortEdges(pq, nodes.get(key));
			}	
			c++;
		}		
		return route;
		
	}
	
	//prim recibe el nodo donde empiezo
	
}
