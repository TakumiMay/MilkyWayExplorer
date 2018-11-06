package collections;

import java.util.HashMap;

public class GraphAM <K,T>{
	
	private NodeGraphAM<T>[][] matrixA;
	private int size;

	public GraphAM(int size) {
		this.size = size;
		matrixA = new NodeGraphAM[size][size];
		
	}
	
	public void addElement(int key1,int key2, NodeGraphAM<T> node) {
		matrixA[key1][key2] = node;
	}

	/**
	 * Tell if there is a connection between two elements or not
	 * @return true if exist a vertex, false in other case.
	 */
	public boolean exist(int element1, int element2) {
		return matrixA[element1][element2] == null ? false : true;
	}
	
	/**
	 * Delete a vertex between two nodes
	 */
	public void delete(int element1, int element2) {
		matrixA[element1][element2] = null;
	}
}
