package collections;

import java.util.HashMap;
import java.util.Set;



public class GraphAL <K,T> implements IGraph<K,T>{
	
	
	private boolean directed;
	private HashMap<K, Node<K,T>> adjacencyList;
	

	public GraphAL() {
		adjacencyList = new HashMap<>();
		
	}
	@Override
	public void addNode(K key, T element, int position) {
		Node node = new Node<K, T>(element, position);
		adjacencyList.put(key, node);
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
		Set<K> keys = adjacencyList.keySet();
      
//		dfsVisit(g,u);
		
	}
	
	public void dfsVisit(GraphAL g, Node<K, T> u) {
		
	}


	
}
