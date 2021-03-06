package collections;

import java.util.Comparator;

public class NodeCompare implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		
		if(o1.getDistanceNode() < o2.getDistanceNode()) {
			return -1;
		}
		else {
			return 1;
		}		
	}
}
