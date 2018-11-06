package collections;

import java.util.HashMap;

public class NodeGraph <K,T> {
	private T element;
	private HashMap<K, NodeGraph<K,T>> list;
	

	public NodeGraph(T element) {
		this.element = element;
		list = new HashMap<>();
	}


	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public HashMap<K, NodeGraph<K,T>> getList() {
		return list;
	}


	public void setList(HashMap<K, NodeGraph<K,T>> adyacenceList) {
		this.list = adyacenceList;
	}
	
	public void addToList(K key, NodeGraph<K,T>node) {
		list.put(key, node);
	}
	
	

}
