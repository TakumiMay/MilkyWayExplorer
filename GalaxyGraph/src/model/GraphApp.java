package model;

import collections.GraphAL;
import collections.GraphAM;

public class GraphApp {
	private GraphAL<String, Star> al;
	private GraphAM<String, Star> am;

	public GraphApp() {
		al = new GraphAL<>(false);
		am = new GraphAM<>(15, false);
		
	}

	public GraphAL<String, Star> getAl() {
		return al;
	}

	public void setAl(GraphAL<String, Star> al) {
		this.al = al;
	}

	public GraphAM<String, Star> getAm() {
		return am;
	}

	public void setAm(GraphAM<String, Star> am) {
		this.am = am;
	}
	
	
}
