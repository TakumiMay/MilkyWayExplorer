package collections;

public interface IGraph<K,T> {
	void addNode(K key, T element, int position);
	void addEdge(K key1, K key2, int weight);
	boolean exist(K key, K key2);
	void deleteEdge(K key, K key2);
	void deleteNode(K key);
//	void bfs();
//	void dfs();

}
