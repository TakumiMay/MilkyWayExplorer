package collections;

import java.util.HashMap;

public class Node <K,T>{
	private T element;
	private HashMap<K, Edge<K,T>> list;
	private int position;

	public Node(T element, int position) {
		this.element = element;
		this.position = position;
		list = new HashMap<>();
	}


	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public HashMap<K, Edge<K,T>> getList() {
		return list;
	}


	public void setList(HashMap<K, Edge<K,T>> adyacenceList) {
		this.list = adyacenceList;
	}
	
	public void addEdge(K key, Edge<K,T> edge) {
		list.put(key, edge);
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
