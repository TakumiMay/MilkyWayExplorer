package collections;

public class Edge <K,T> implements Comparable<Edge<K, T>>{
	
	private K adjacentTo;	
	private double weight;	
	
	public Edge(double weight) {
		super();
		this.weight = weight;
		
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public K getAdjacentTo() {
		return adjacentTo;
	}

	public void setAdjacentTo(K adjacentTo) {
		this.adjacentTo = adjacentTo;
	}
	

	
	@Override
	public int compareTo(Edge<K, T> o) {
		
		if(this.getWeight()<o.getWeight()) {
			return -1;
		}
		else {
			return 1;
		}
		
		
	}
	

}
