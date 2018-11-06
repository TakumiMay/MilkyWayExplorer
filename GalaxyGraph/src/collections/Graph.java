package collections;

import java.util.HashMap;

public class Graph <K,T>{
	
	private HashMap<K, NodeGraph<K,T>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<>();
		
	}
	
	public void addElement(K key, NodeGraph<K,T> node) {
		adjacencyList.put(key, node);
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a vertex, false in other case.
	 */
	public boolean exist(K element1, K element2) {
		return adjacencyList.get(element1).getAdyacenceList().get(element2) == null ? false : true;
	}
}
