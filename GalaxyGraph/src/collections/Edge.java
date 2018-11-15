package collections;

public class Edge <K,T>{
	
	private K adjacentTo;	
	private int weight;	
	
	public Edge(int weight) {
		super();
		this.weight = weight;
		
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public K getAdjacentTo() {
		return adjacentTo;
	}

	public void setAdjacentTo(K adjacentTo) {
		this.adjacentTo = adjacentTo;
	}
	
	

}
