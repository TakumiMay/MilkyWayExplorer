package collections;

public class NodeQueue<T> {
	
	private NodeQueue<T> next;
	private T info;
	
	public NodeQueue(T elem){
		info = elem;
	}
	public boolean NodoEnlazadoSimple() {
		return true;
	}
	public NodeQueue<T> getNext() {
		return next;
	}
	public void setNext(NodeQueue<T> next) {
		this.next = next;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public void disconectNext() {
		next = next.next;
	}
	
}
