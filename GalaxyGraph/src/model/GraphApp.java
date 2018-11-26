package model;

import collections.GraphAL;
import collections.GraphAM;

public class GraphApp {
	private GraphAL<String, Star> al;
	private GraphAM<String, Star> am;

	public GraphApp() {
		//al = new GraphAL<>(false);
		//am = new GraphAM<>(15, false);
		inicializeStars();
		
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
	
	public void inicializeStars() {
		al =new GraphAL(false);
		am =new GraphAM(16, false);
		
		al.addNode("Sol", new Star("Sun", "4.6 billones", "1 masa solar", Star.YELLOW, 8));
		al.getAdjacencyList().get("Sol").getElement().setPos(395, 295);
		
		al.addNode("Próxima Centauri", new Star("Próxima Centauri", "4.85 billones", "0.123 masas solares", Star.RED, 1));
		al.getAdjacencyList().get("Próxima Centauri").getElement().setPos(395, 380);
		
		al.addNode("Alfa Centauri A", new Star("Alfa Centauri A", "4.4 billones", "1.100 masas solares", Star.YELLOW, 0));
		al.getAdjacencyList().get("Alfa Centauri A").getElement().setPos(350, 440);
		
		al.addNode("Alfa Centauri B", new Star("Alfa Centauri B", "6.5 billones", "0.907 masas solares", Star.RED, 1));
		al.getAdjacencyList().get("Alfa Centauri B").getElement().setPos(435, 430);
		
		al.addNode("Estrella de Barnard", new Star("Estrella de Barnard", "10 billones", "0.144 masas solares", Star.RED, 1));
		al.getAdjacencyList().get("Estrella de Barnard").getElement().setPos(560, 267);
		
		al.addNode("Luhman 16A", new Star("Luhman 16A", "700 millones", "33.5 masas jovianas", Star.BROWN, 0));
		al.getAdjacencyList().get("Luhman 16A").getElement().setPos(540, 205);
		
		al.addNode("Luhman 16B", new Star("Luhman 16B", "700 millones", "28.6 masas jovianas", Star.BROWN, 0));
		al.getAdjacencyList().get("Luhman 16B").getElement().setPos(600, 212);
		
		al.addNode("WISE 0855-0714", new Star("WISE 0855-0714", "7.3 millones", "6.5 masas jovianas", Star.BROWN, 0));
		al.getAdjacencyList().get("WISE 0855-0714").getElement().setPos(375, 215);
		
		al.addNode("Wolf 359", new Star("Wolf 359", "225 millones", "0.085 masas solares", Star.RED, 0));
		al.getAdjacencyList().get("Wolf 359").getElement().setPos(525, 388);
		
		al.addNode("Lalande 21185", new Star("Lalande 21185", "7.5 billones", "0.46 masas solares", Star.RED, 2));
		al.getAdjacencyList().get("Lalande 21185").getElement().setPos(275, 267);
		
		al.addNode("Sirio A", new Star("Sirio A", " 250 millones", "2.063 masas solares", Star.WHITE, 0));
		al.getAdjacencyList().get("Sirio A").getElement().setPos(255, 355);
		
		al.addNode("Sirio B", new Star("Sirio B", " 228 millones", "1.018 masas solares", Star.WHITE, 0));
		al.getAdjacencyList().get("Sirio B").getElement().setPos(270, 402);
		
		al.addNode("Tau Ceti", new Star("Tau Ceti", " 5.8 billones", "0.783 masas solares", Star.YELLOW, 0));
		al.getAdjacencyList().get("Tau Ceti").getElement().setPos(150, 431);
		
		al.addNode("YZ Ceti", new Star("YZ Ceti", " 5.0 billones", "0.130 masas solares", Star.RED, 3));
		al.getAdjacencyList().get("YZ Ceti").getElement().setPos(157, 300);
		
		al.addNode("Ross 154", new Star("Ross 154", " 1.0 billones", "0.17 masas solares", Star.RED, 0));
		al.getAdjacencyList().get("Ross 154").getElement().setPos(627, 326);
		
		al.addNode("Ross 248", new Star("Ross 248", " 1.3 billones", "0.136 masas solares", Star.RED, 0));
		al.getAdjacencyList().get("Ross 248").getElement().setPos(665, 365);
		
		al.addEdge("Sol", "Próxima Centauri", 4.24);
		al.addEdge("Próxima Centauri", "Alfa Centauri A", 0.237);
		al.addEdge("Próxima Centauri", "Alfa Centauri B", 0.237);
		al.addEdge("Sol", "Estrella de Barnard", 5.96);
		al.addEdge("Estrella de Barnard", "Luhman 16A", 1.36);
		al.addEdge("Luhman 16A", "Luhman 16B", 4.7);
		al.addEdge("Sol", "WISE 0855-0714", 7.2);
		al.addEdge("WISE 0855-0714","Luhman 16A" , 5.2);
		al.addEdge("WISE 0855-0714","Lalande 21185" , 1.0);
		al.addEdge("Lalande 21185", "Sirio A" , 4.1);
		al.addEdge("Sirio A", "Sirio B", 0.0031);
		al.addEdge("Sirio B","Próxima Centauri", 6.0);
		al.addEdge("Sirio B","Tau Ceti", 1.2);
		al.addEdge("Tau Ceti", "YZ Ceti", 0.3);
		al.addEdge("Alfa Centauri B","Wolf 359" , 3.4);
		al.addEdge("Wolf 359", "Ross 248" , 4.4);
		al.addEdge("Ross 248", "Ross 154" , 0.012);
		al.addEdge("Ross 154", "Estrella de Barnard", 7.2);
		
		
		
		
		
		
		
		
		
		
		//al.addEdge("Sol", "Sirio A", 8.55);
		
		//al.addEdge("Próxima Centauri", "Sirio A", 6.1);
		
		//al.addEdge("Sol", "Alfa Centauri A", 4.36);
		//al.addEdge("Sol", "Sirio B", 8.55);
		
		
		
		am.addNode("Sol", new Star("Sun", "4.6 billones", "1 masa solar", Star.YELLOW, 8));
		am.addNode("Próxima Centauri", new Star("Próxima Centauri", "4.85 billones", "0.123 masas solares", Star.RED, 1));
		am.addNode("Alfa Centauri A", new Star("Alfa Centauri A", "4.4 billones", "1.100 masas solares", Star.YELLOW, 0));
		am.addNode("Alfa Centauri B", new Star("Alfa Centauri B", "6.5 billones", "0.907 masas solares", Star.RED, 1));
		am.addNode("Estrella de Barnard", new Star("Estrella de Barnard", "10 billones", "0.144 masas solares", Star.RED, 1));
		am.addNode("Luhman 16A", new Star("Luhman 16A", "700 millones", "33.5 masas jovianas", Star.BROWN, 0));
		am.addNode("Luhman 16B", new Star("Luhman 16B", "700 millones", "28.6 masas jovianas", Star.BROWN, 0));
		am.addNode("WISE 0855-0714", new Star("WISE 0855-0714", "7.3 millones", "6.5 masas jovianas", Star.BROWN, 0));
		am.addNode("Wolf 359", new Star("Wolf 359", "225 millones", "0.085 masas solares", Star.RED, 0));
		am.addNode("Lalande 21185", new Star("Lalande 21185", "7.5 billones", "0.46 masas solares", Star.RED, 2));
		am.addNode("Sirio A", new Star("Sirio A", " 250 millones", "2.063 masas solares", Star.WHITE, 0));
		am.addNode("Sirio B", new Star("Sirio B", " 228 millones", "1.018 masas solares", Star.WHITE, 0));
		am.addNode("Tau Ceti", new Star("Tau Ceti", " 5.8 billones", "0.783 masas solares", Star.YELLOW, 0));
		am.addNode("YZ Ceti", new Star("YZ Ceti", " 5.0 billones", "0.130 masas solares", Star.RED, 3));
		am.addNode("Ross 154", new Star("Ross 154", " 1.0 billones", "0.17 masas solares", Star.RED, 0));
		am.addNode("Ross 248", new Star("Ross 248", " 1.3 billones", "0.136 masas solares", Star.RED, 0));

		
		
//		al.addNode("B", "3");
//		graphAL.addNode("C", "0");
//		graphAL.addNode("D","4");
//		graphAL.addNode("E","3");
//		graphAL.addNode("Z","10");
//	
//		graphAL.addEdge("A", "B", 4);
//		graphAL.addEdge("A", "C", 2);
//		graphAL.addEdge("B", "D", 5);
//		graphAL.addEdge("B", "C", 1);
//		graphAL.addEdge("C", "D", 8);
//		graphAL.addEdge("C", "E", 10);
//		graphAL.addEdge("E", "Z", 3);
//		graphAL.addEdge("D", "E", 2);
//		graphAL.addEdge("D", "Z", 6);
		
	}
	
	
}
