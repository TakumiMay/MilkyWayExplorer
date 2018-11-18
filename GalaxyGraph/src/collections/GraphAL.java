package collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;



public class GraphAL <K,T> implements IGraph<K,T>{
	
	
	private boolean directed;
	private HashMap<K, Node<K,T>> adjacencyList;
	private HashMap distances; 
	private HashMap visited; 
	private int time;
	

	public GraphAL() {
		adjacencyList = new HashMap<K, Node<K,T>>();
		distances = new HashMap<K, Integer>();
		visited = new HashMap<K, Boolean>();
		time = 0;
	}
	@Override
	public void addNode(K key, T element, int position) {
		Node node = new Node<K, T>(element, position);
		adjacencyList.put(key, node);
		visited.put((node.getPosition(), false);
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
		e.setAdjacentTo(key1);
		node.getList().put(key2, e);
		
	}

	@Override
	public void deleteNode(K key) {
		adjacencyList.remove(key);
				
	}
	
	public void dfs(GraphAL g) {
//		Set<K> keys = adjacencyList.keySet();
		this.time = 0;
		for(Node<K, T> s1: adjacencyList.values()) {
			if(s1.g) {
				dfsVisit(g,u);
			}
		}
	}
	
	public void dfsVisit(GraphAL g, Node<K, T> u) {
		
	}
	
	public void bfs(Node<K, T> u) {
		
	}
	
	public void bfsVisit() {
		
	}
	
	public void dijkstra( Node<K,T> s) {
//		HashMap distances = new HashMap<K, Integer>();
//		HashMap visited = new HashMap<K, Boolean>();
		
		for(Node<K, T> s1: adjacencyList.values()) {
			int m = s1.getPosition();
			distances.put(m, Integer.MAX_VALUE);
		}
		Comparator<Edge> ec = new EdgeCompare();
		distances.put(s.getPosition(), 0);
		PriorityQueue queueEdges = new PriorityQueue(ec);
		PriorityQueue<Node<K,T>> queueNode = new PriorityQueue<Node<K,T>>();
		
		for(Edge e: s.getList().values()) {
			queueEdges.add(e);
		}
		while(!queueEdges.isEmpty()) {
			int distance = ((Edge<K, T>) queueEdges.peek()).getWeight();
			Node<K,T> n = adjacencyList.get((((Edge<K,T>) queueEdges.peek()).getAdjacentTo()));
			distances.put(n.getPosition(), distance);
			queueNode.add(n);
			queueEdges.poll();
		}
		
		while(!queueNode.isEmpty()) {
			Node<K,T> nodeVisited = queueNode.poll();
			if(!(visited.get(nodeVisited.getPosition()))){
				visited.put(nodeVisited.getKey(), true);
				relaxEdges(queue, queueNodes, nodeVisit);
			}
		}
		
		
	}

	//Retorna en un String la ruta desde s hasta t
//	//Recibe el nodo destino t
//	static String path(int t) {
//	    String r="";
//	    while(prev[t]!=-1){
//	        r="-"+t+r;
//	        t=prev[t];
//	    }
//	    if(t!=-1){
//	        r=t+r;
//	    }
//	    return r;
//	}   

}


	

