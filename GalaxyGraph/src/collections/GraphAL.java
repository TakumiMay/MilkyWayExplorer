package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;


//import sun.misc.Queue;



public class GraphAL <K extends Comparable <K>,T> implements IGraph<K,T>{
	
	
	private boolean directed;
	private HashMap<K, Node<K,T>> adjacencyList;
	private HashMap<K, Integer> distances; 
	private HashMap<K, Boolean> visited; 
	private int time;
	private int cNodes;
	

	public GraphAL(boolean directed) {
		this.directed = directed;
		adjacencyList = new HashMap<K, Node<K,T>>();
		distances = new HashMap<K, Integer>();
		visited = new HashMap<K, Boolean>();
		time = 0;
		cNodes = 0;
	}
	
	public HashMap<K, Node<K, T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(HashMap<K, Node<K, T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	@Override
	public void addNode(K key, T element, int position) {
		Node<K, T> node = new Node<K, T>(element, cNodes);
		cNodes++;
		node.setKey(key);
		adjacencyList.put(key, node);
		visited.put(node.getKey(), false);
	}
	
	public void addNode(K key, T element) {
		Node<K, T> node = new Node<K, T>(element, cNodes);
		cNodes++;
		node.setKey(key);
		adjacencyList.put(key, node);
		visited.put(node.getKey(), false);
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a edge, false in other case.
	 */
	public boolean exist(K element1, K element2) {
		return adjacencyList.get(element1).getList().get(element2) == null ? false : true;
	}
	
	/**
	 * Delete a edge between two nodes
	 */
	public void deleteEdge(K element1, K element2) {
		adjacencyList.get(element1).getList().remove(element2);
	}
	
	@Override
	public void addEdge(K key1, K key2, int weight) {
		Edge<K, T> e = new Edge<>(weight);
		Node<K, T> node  = adjacencyList.get(key1);
		e.setAdjacentTo(key2);
		node.getList().put(key2, e);
		if (!directed) {
			Edge<K, T> e2 = new Edge<>(weight);
			Node<K, T> node2  = adjacencyList.get(key2);
			e2.setAdjacentTo(key1);
			node2.getList().put(key1, e2);
		}
		
	}

	@Override
	public void deleteNode(K key) {
		adjacencyList.remove(key);
				
	}
	
	public void dfs() {
		for(Node<K, T> u: adjacencyList.values()) {
			u.setColor(Node.WHITE);
			u.setPredecessor(null);
		}
		this.time = 0;
		for(Node<K, T> u: adjacencyList.values()) {
			if(u.getColor()==Node.WHITE) { //un nodo es blanco cuando no ha sido descubierto
				dfsVisit(u);
			}
		}
	}
	private void dfsVisit(Node<K, T> u) {
		this.time = time+1;
		u.setD(time);
		u.setColor(Node.GRAY); //se pinta gris porque ha sido descubierto
//		recorrer los nodos adyacentes al nodo u
		for (Edge<K, T> v : u.getList().values()) { //para cada nodo v adyacente a u
			K key = v.getAdjacentTo();
			if (adjacencyList.get(key).getColor() == Node.WHITE) { //si v no ha sido descubierto
				adjacencyList.get(key).setPredecessor(u); //el predecesor de v es u
				dfsVisit(adjacencyList.get(key)); //visito a v
			}
		}
		u.setColor(Node.BLACK); //se pinta a u de negro pues todos sus adyacentes han sido descubiertos
		this.time = time+1;
		u.setF(time);
	}
	
	public PriorityQueue timeStampsNodes() {
		PriorityQueue visited = new PriorityQueue(new NodeCompare()); //Node compare es para comparar nodos por su atributo D
		for (Node<K, T> n : adjacencyList.values()) { //Recorre todala lista de adyacencia y agrea a la cola
			visited.add(n);
		}
		return visited;
		
	}
	
	public void bfs(Node<K, T> s) {
		for(Node<K, T> u: adjacencyList.values()) {
			if(s!=u) {
				u.setColor(Node.WHITE); //se inicializan los nodos blancos
				u.setD(Integer.MAX_VALUE); //se asignan las distancias como infinito
				u.setPredecessor(null); //se inicializa predecesor null
			}
		}
		s.setColor(Node.GRAY); //se descubre a s
		s.setD(0); //distancia de s a s es cero
		s.setPredecessor(null); //el padre de s es null pues s sera la raiz del arbol bf
		Queue<Node<K, T>> q = new Queue<>();
//		
//		Queue<Node<K, T>> q = new Queue<>(); //cola para nodos grises
		q.enQueue(s);
		while( !(q.isEmpty()) ) {
			Node<K, T> u = q.deQueue().getInfo();
//			recorrer los adyacentes al nodo u
			for (Edge<K, T> edge : u.getList().values()) {
				K key = edge.getAdjacentTo();
				Node<K, T> v = adjacencyList.get(key); //para cada nodo v adyacente a s	
				if (v.getColor() == Node.WHITE) { //si no ha sido descubierto
					v.setColor(Node.GRAY); //se pinta gris
					v.setD(u.getD()+1); //se le asigna la distancia de u +1
					v.setPredecessor(u); // u es predecesor de v en el arbol bf
					q.enQueue(v); // se encola v por ser gris
				}
			}
			u.setColor(Node.BLACK); //se pinta de negro a u porque todos sus adyacentes fueron descubiertos
		}
	}
	//System.out.println(s.getKey()+"-"+s.getD());
	//print s
	// PARA PINTAR EL ARBOL BF:
	public void printPath(Node<K, T> s, Node<K, T> v, String path) {	
		
		if(v == s) {
			path+=s.getKey()+"-"+s.getD();
			System.out.println(v.getKey()+"-"+v.getD());
		} 
		else if(v.getPredecessor() == null) {
			//print "no path from s to v exists"
			path="No hay camino entre "+ s.getKey() +" y "+v.getKey();
			
		}
		else {
			printPath(s, v.getPredecessor(), path);
			path+=s.getKey()+"-"+s.getD();
			System.out.println(v.getKey()+"-"+v.getD());
			//print v
		}
		//return path;
	}
	
	public void dijkstra(Node<K,T> nodeP) {
		
		for(Node<K, T> n: adjacencyList.values()) {
			K key = n.getKey();
			distances.put(key, Integer.MAX_VALUE);
		}
		//Comparator<Edge> ec = new EdgeCompare();
		distances.put(nodeP.getKey(), 0);
		PriorityQueue<Edge<K, T>> queueEdges = new PriorityQueue<>();
		PriorityQueue<Node<K, T>> queueNode = new PriorityQueue<>();
		
		for(Edge<K, T> edge: nodeP.getList().values()) {
			queueEdges.add(edge);
		}
		while(!queueEdges.isEmpty()) {
			int distance = queueEdges.peek().getWeight();
			Node<K, T> n = adjacencyList.get((queueEdges.peek().getAdjacentTo()));
			distances.put(n.getKey(), distance);
			queueNode.add(n);
			queueEdges.poll();
			while(!queueNode.isEmpty()) {
				Node<K, T> nodeVisited = queueNode.poll();
				if(!visited.get(nodeVisited.getKey())){
					visited.put(nodeVisited.getKey(), true);
					relaxEdges(queueEdges, queueNode, nodeVisited);
				}
			}
		}
		
	}
	
	public void relaxEdges(PriorityQueue<Edge<K, T>> qe, PriorityQueue<Node<K, T>> qn, Node<K,T> n) {
		for(Edge<K, T> e: n.getList().values()) {
			qe.add(e);
		}
		while(!qe.isEmpty()) {
			int distance = qe.peek().getWeight() + distances.get(n.getKey());
			K k = adjacencyList.get(qe.peek().getAdjacentTo()).getKey();
			if(distance < distances.get(k)){
//				distances.put( ((Edge<K, T>) qe.peek()).getWeight(), distance);
				distances.put( qe.peek().getAdjacentTo(), distance);
			}
//			qn.add(((Edge<K, T>) qe.poll()).getAdjacentTo());
			qn.add(adjacencyList.get(qe.poll().getAdjacentTo()));
		}
	}
	
	public void addNode(K key, Node<K,T> n) {
		n.setKey(key);
		adjacencyList.put(key, n);
		visited.put(key, false);
	}
	
	public PriorityQueue<Edge<K, T>> sortEdges(PriorityQueue<Edge<K, T>> pq,Node<K, T>source){

		for (Edge<K, T> e : source.getList().values()) {
			pq.add(e);

		}
		return pq;
	}
	
	public ArrayList<Node<K, T>> prim(K source){
		PriorityQueue<Edge<K, T>> pq = new PriorityQueue<>();
		pq = sortEdges(pq, adjacencyList.get(source));
		HashMap<K,Boolean> visited = new HashMap<>();
		ArrayList<Node<K, T>> route = new ArrayList<>();
		
		visited.put(source, true);
		route.add(adjacencyList.get(source));
		int c = 0;
		while (c<adjacencyList.size()-1) {
			K key = pq.peek().getAdjacentTo();
			if (visited.get(key)!=null) {
				pq.poll();
			}
			else {
				visited.put(key, true);
				route.add(adjacencyList.get(key));
				pq.poll();
				pq = sortEdges(pq, adjacencyList.get(key));
			}	
			c++;
		}		
		return route;
		
	}

	public static void main(String[] args) {
		GraphAL<String, Integer> g = new GraphAL<>(false);
//		Node<String, Integer> a = new Node("A", 10);
//		Node<String, Integer> b = new Node("B", 30);
//		Node<String, Integer> c = new Node("C", 23);
//		Node<String, Integer> d = new Node("D", 5);
//		Node<String, Integer> e = new Node("E", 8);
//		Node<String, Integer> z = new Node("Z", 34);
//		Node<String, Integer> w = new Node("W", 13);
//		g.addNode("A", a);
//		g.addNode("B", b);
//		g.addNode("C", c);
//		g.addNode("D",d);
//		g.addNode("E",e);
//		g.addNode("Z",z);
//		//g.addNode(w);
//		g.addEdge(a.getKey(), b.getKey(), 4);
//		g.addEdge(a.getKey(), c.getKey(), 2);
//		g.addEdge(b.getKey(), d.getKey(), 5);
//		g.addEdge(b.getKey(), c.getKey(), 1);
//		g.addEdge(c.getKey(), d.getKey(), 8);
//		g.addEdge(c.getKey(), e.getKey(), 10);
//		g.addEdge(e.getKey(), z.getKey(), 3);
//		g.addEdge(d.getKey(), e.getKey(), 2);
//		g.addEdge(d.getKey(), z.getKey(), 6);
//		
//		g.dijkstra(a);
//		
//		g.distances.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		
		
		

		
		
		
	}     

}