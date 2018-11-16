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
		Node<K, T> node = new Node<K, T>(element, position);
		nodes.put(key, node);
	}
	
	public void addEdge(K key1,K key2, int weight) {
		int p1 = nodes.get(key1).getPosition();
		int p2 = nodes.get(key2).getPosition();
		Edge<K, T> e = new Edge<>(weight);
		e.setAdjacentTo(key2);
		matrixA[p1][p2] = e;
		if (directed) {
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
	
	
}
