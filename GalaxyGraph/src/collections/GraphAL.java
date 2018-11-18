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
	
	public void dijkstra(Node s) {
		
		for(Node n: adjacencyList.values()) {
			K m = (K) n.getKey();
			distances.put(m, Integer.MAX_VALUE);
		}
		//Comparator<Edge> ec = new EdgeCompare();
		distances.put(s.getPosition(), 0);
		PriorityQueue<Edge> queueEdges = new PriorityQueue<Edge>();
		PriorityQueue<Node> queueNode = new PriorityQueue<Node>();
		
		for(Edge e: s.getList().values()) {
			queueEdges.add(e);
		}
		while(!queueEdges.isEmpty()) {
			int distance = ((Edge<K, T>) queueEdges.peek()).getWeight();
			Node n = adjacencyList.get((((Edge<K,T>) queueEdges.peek()).getAdjacentTo()));
			distances.put(n.getKey(), distance);
			queueNode.add(n);
			queueEdges.poll();
		}
		
		while(!queueNode.isEmpty()) {
			Node nodeVisited = queueNode.poll();
			if(!((boolean) visited.get(nodeVisited.getKey()))){
				visited.put(nodeVisited.getKey(), true);
				relaxEdges(queueEdges, queueNode, nodeVisited);
			}
		}
		
		
	}
	
	public void relaxEdges(PriorityQueue qe, PriorityQueue qn, Node n) {
		for(Edge e: n.getList().values()) {
			qe.add(e);
		}
		while(!qe.isEmpty()) {
			int distance = ((Edge<K, T>) qe.peek()).getWeight() + (int)distances.get(n.getKey());
			K k = adjacencyList.get(((Edge<K, T>) qe.peek()).getAdjacentTo()).getKey();
			if(distance < (int)distances.get(k)){
				distances.put( ((Edge<K, T>) qe.peek()).getWeight(), distance);
			}
			qn.add(((Edge<K, T>) qe.poll()).getAdjacentTo());
		}
	}
	
	public void addNode(K key, Node<K,T> n) {
		n.setKey(key);
		adjacencyList.put(key, n);
		visited.put(key, false);
	}

	public static void main(String[] args) {
		GraphAL<String, Integer> g = new GraphAL<>();
		Node<String, Integer> a = new Node("A", 10);
		Node<String, Integer> b = new Node("B", 30);
		Node<String, Integer> c = new Node("C", 23);
		Node<String, Integer> d = new Node("D", 5);
		Node<String, Integer> e = new Node("E", 8);
		Node<String, Integer> z = new Node("Z", 34);
		Node<String, Integer> w = new Node("W", 13);
		g.addNode("A", a);
		g.addNode("B", b);
		g.addNode("C", c);
		g.addNode("D",d);
		g.addNode("E",e);
		g.addNode("Z",z);
		//g.addNode(w);
		g.addEdge(a.getKey(), b.getKey(), 4);
		g.addEdge(a.getKey(), c.getKey(), 2);
		g.addEdge(b.getKey(), d.getKey(), 5);
		g.addEdge(b.getKey(), c.getKey(), 1);
		g.addEdge(c.getKey(), d.getKey(), 8);
		g.addEdge(c.getKey(), e.getKey(), 10);
		g.addEdge(e.getKey(), z.getKey(), 3);
		g.addEdge(d.getKey(), e.getKey(), 2);
		g.addEdge(d.getKey(), z.getKey(), 6);
		
		g.dijkstra(a);
		
		g.distances.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		
		
		

		
		
		
	}     

}