package collections;

public class Queue<T> implements IQueue<T> {

	private NodeQueue<T> first;
	private NodeQueue<T> last;
	private int size;

	public Queue() {
		first = null;
		last = null;
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}

	public T peek() {
		T p = null;
		if (isEmpty()) {
			p = first.getInfo();
		}
		return p;
	}

	@Override
	public void enQueue(T element) {
		NodeQueue<T> oLast = new NodeQueue(element);

		if (isEmpty()) {
			first = oLast;
		} else {
			last.setNext(oLast);
		}

		last = oLast;
		size++;
	}

	@Override
	public NodeQueue<T> deQueue() {

		NodeQueue<T> retu = new NodeQueue<T>(first.getInfo());

		first = first.getNext();
		size--;

		return retu;

	}

	@Override
	public NodeQueue<T> front() {
		return first;
	}

}
