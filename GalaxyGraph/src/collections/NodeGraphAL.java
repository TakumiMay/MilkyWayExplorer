package collections;

import java.util.HashMap;

public class NodeGraphAL <K,T> {
	private T element;
	private HashMap<K, NodeGraphAL<K,T>> list;
	

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


	public HashMap<K, NodeGraphAL<K,T>> getList() {
		return list;
	}


	public void setList(HashMap<K, NodeGraphAL<K,T>> adyacenceList) {
		this.list = adyacenceList;
	}
	
	public void addToList(K key, NodeGraphAL<K,T>node) {
		list.put(key, node);
	}
	
	

}
