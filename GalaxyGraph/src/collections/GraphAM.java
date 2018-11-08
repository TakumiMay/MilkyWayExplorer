package collections;

import java.util.HashMap;

public class GraphAM <K,T> implements IGraph<T>{
	
	
	private int size;
	private HashMap<K, NodeGraphAM<T>> nodes;
	private Edge<T>[][] matrixA;
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
	public void addNodes(K key, NodeGraphAM<T> node) {
		nodes.put(key, node);
	}
	
	public void addEdge(int key1,int key2, int weight) {
//		NodeGraphAM<T> start = null;
//		NodeGraphAM<T> end = null;
//		if (directed) {
//			start = nodes.get(key1);
//			end = nodes.get(key2);
//		}
		
		matrixA[key1][key2] = new Edge<>(weight);
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a vertex, false in other case.
	 */
	public boolean exist(int element1, int element2) {
		return matrixA[element1][element2] == null ? false : true;
	}
	
	/**
	 * Delete a edge between two nodes
	 */
	public void deleteEdge(int element1, int element2) {
		matrixA[element1][element2] = null;
	}
	
	public void deleteNode(K key) {
		nodes.remove(key);
	}
}
