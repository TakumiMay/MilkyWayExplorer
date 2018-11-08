package collections;

import java.util.HashMap;

public class NodeGraphAL <K,T> {
	private T element;
//	private HashMap<K, NodeGraphAL<K,T>> list;
	private HashMap<K, Edge<T>> list;
	

	public NodeGraphAL(T element) {
		this.element = element;
		list = new HashMap<>();
	}


	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public HashMap<K, Edge<T>> getList() {
		return list;
	}


	public void setList(HashMap<K, Edge<T>> adyacenceList) {
		this.list = adyacenceList;
	}
	
	public void addEdge(K key, Edge<T> edge) {
		list.put(key, edge);
	}
	
	

}
