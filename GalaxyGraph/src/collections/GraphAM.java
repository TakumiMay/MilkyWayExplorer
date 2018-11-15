package collections;

import java.util.HashMap;

public class GraphAM <K,T> implements IGraph<K,T>{
	
	
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
		Node node = new Node<K, T>(element, position);
		nodes.put(key, node);
	}
	
	public void addEdge(K key1,K key2, int weight) {
		int p1 = nodes.get(key1).getPosition();
		int p2 = nodes.get(key1).getPosition();
		Edge<K, T> e = new Edge<>(weight);
		e.setAdjacentTo(key2);
		matrixA[p1][p2] = e;
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a vertex, false in other case.
	 */
	public boolean exist(K element1, K element2) {
		int p1 = nodes.get(element1).getPosition();
		int p2 = nodes.get(element1).getPosition();
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
	}
}
