package collections;

import java.util.Comparator;
	
public class EdgeCompare implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		
		if(o1.getWeight() < o2.getWeight()) {
			return -1;
		}
		else {
			return 1;
		}		
	}

}

