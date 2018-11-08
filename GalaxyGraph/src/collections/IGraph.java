package collections;

public interface IGraph<T> {
	void addEdge(T key1, Node node);
	void addNode(T key, T key2);
	boolean exist(T key, T key2);
	void deleteEdge(K key);
	void deleteNode(K key);

}
