package collections;

public interface IQueue<E> {
	
	public boolean isEmpty();
	public void enQueue(E element);
	public NodeQueue<E> deQueue();
	public NodeQueue<E> front();
	

}
