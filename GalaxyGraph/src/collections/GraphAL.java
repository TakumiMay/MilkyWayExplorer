package collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

import sun.misc.Queue;



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
	
	@Override
	public void dfs() {
		for(Node<K, T> u: adjacencyList.values()) {
			u.setVisited(false);
		}
		this.time = 0;
		for(Node<K, T> u: adjacencyList.values()) {
			if( !(u.isVisited()) ) {
				dfsVisit(u);
			}
		}
	}
	
	@Override
	public void dfsVisit(Node<K, T> u) {
		this.time = time+1;
		u.setD(time);
//		recorrer los adyacentes al nodo u
		for (Edge<K, T> s : u.getList().values()) {
			K key = s.getAdjacentTo();
			if (!(adjacencyList.get(key).isVisited())) {
				dfsVisit(adjacencyList.get(key));
			}
		}
//		for(Node<K, T> v: u.adyacentes) {
//			if(!(v.isVisited()) ) {
//				dfsVisit(v);
//			}
//		}
		u.setVisited(true);
		this.time = time+1;
		u.setF(time);
	}
	
	@Override
	public void bfs(Node<K, T> s) {
		for(Node<K, T> u: adjacencyList.values()) {
			if(s!=u) {
				u.setVisited(false);
				u.setD(Integer.MAX_VALUE);
			}
		}
		s.setD(0);
		Queue<Node<K, T>> q = new Queue<>();
		q.enqueue(s);
		while( !(q.isEmpty()) ) {
			Node<K, T> u = q.dequeue();
//			recorrer los adyacentes al nodo s
			for (Edge<K, T> edge : s.getList().values()) {
				K key = edge.getAdjacentTo();
				Node<K, T> n = adjacencyList.get(key);				
				if (!(n.isVisited())) {
					n.setD(u.getD()+1);
					q.enqueue(n);
				}
			}
//			for(Node<K, T> v: s.adyacentes) {
//				if(!(v.isVisited())) {
//					v.setD(u.getD()+1);
//					q.enqueue(v);
//				}
//			}
			u.setVisited(true);
		}
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