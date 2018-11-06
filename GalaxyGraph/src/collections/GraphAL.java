package collections;

import java.util.HashMap;

public class GraphAL <K,T>{
	
	private HashMap<K, NodeGraphAL<K,T>> adjacencyList;

	public GraphAL() {
		adjacencyList = new HashMap<>();
		
	}
	
	public void addElement(K key, NodeGraphAL<K,T> node) {
		adjacencyList.put(key, node);
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a vertex, false in other case.
	 */
	public boolean exist(K element1, K element2) {
		return adjacencyList.get(element1).getList().get(element2) == null ? false : true;
	}
	
	/**
	 * Delete a vertex between two nodes
	 */
	public void delete(K element1, K element2) {
		adjacencyList.get(element1).getList().remove(element2);
	}
}
