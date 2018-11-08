package collections;

public class Edge <T>{
	
	private T adjacentTo;	
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

	

}
