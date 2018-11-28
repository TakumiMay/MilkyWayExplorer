package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import collections.GraphAL;
import collections.GraphAM;
import collections.Node;

public class GraphApp {
	private boolean workingOnAL;
	private GraphAL<String, Star> al;
	private GraphAM<String, Star> am;
	private HashMap<String, String> images;

	public GraphApp() {
		//al = new GraphAL<>(false);
		//am = new GraphAM<>(15, false);
		workingOnAL= true;
		images = new HashMap<>();
		inicializeStars();
		
	}
	
	
	
	public Star searchStarbyPos(int x, int y) {

		if(workingOnAL) {
			Collection<Node<String, Star>> hash = al.getAdjacencyList().values();
			for (Iterator<Node<String, Star>> iterator = hash.iterator(); iterator.hasNext();) {
				Node<String, Star> node =  iterator.next();
				if(node.getElement().getArea().contains(x, y)) {
					return node.getElement();
				}
				
				
			}
			return null;
			
		}
		else {
			Collection<Node<String, Star>> hash = am.getNodes().values();
			for (Iterator<Node<String, Star>> iterator = hash.iterator(); iterator.hasNext();) {
				Node<String, Star> node =  iterator.next();
				if(node.getElement().getArea().contains(x, y)) {
					return node.getElement();
				}
				
				
			}
			return null;
		}
		
	}
	
	

	public HashMap<String, String> getPositions() {
		return images;
	}



	public void setPositions(HashMap<String, String> positions) {
		this.images = positions;
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
		
		al.addNode("Sol", new Star("Sol", "4.6 billones", "1 masa solar", Star.YELLOW, 8));
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
		
		al.addNode("WISE 0855-0714", new Star("WISE 0855-0714", "7.3 millones", "6.5 masas jovianas", Star.BLUE, 0));
		al.getAdjacencyList().get("WISE 0855-0714").getElement().setPos(375, 215);
		
		al.addNode("Wolf 359", new Star("Wolf 359", "225 millones", "0.085 masas solares", Star.RED, 0));
		al.getAdjacencyList().get("Wolf 359").getElement().setPos(525, 388);
		
		al.addNode("Lalande 21185", new Star("Lalande 21185", "7.5 billones", "0.46 masas solares", Star.RED, 2));
		al.getAdjacencyList().get("Lalande 21185").getElement().setPos(275, 267);
		
		al.addNode("Sirio A", new Star("Sirio A", " 250 millones", "2.063 masas solares", Star.WHITE, 0));
		al.getAdjacencyList().get("Sirio A").getElement().setPos(255, 355);
		
		al.addNode("Sirio B", new Star("Sirio B", " 228 millones", "1.018 masas solares", Star.WHITE, 0));
		al.getAdjacencyList().get("Sirio B").getElement().setPos(270, 420);
		
		al.addNode("Tau Ceti", new Star("Tau Ceti", " 5.8 billones", "0.783 masas solares", Star.YELLOW, 0));
		al.getAdjacencyList().get("Tau Ceti").getElement().setPos(150, 431);
		
		al.addNode("YZ Ceti", new Star("YZ Ceti", " 5.0 billones", "0.130 masas solares", Star.RED, 3));
		al.getAdjacencyList().get("YZ Ceti").getElement().setPos(157, 300);
		
		al.addNode("Ross 154", new Star("Ross 154", " 1.0 billones", "0.17 masas solares", Star.RED, 0));
		al.getAdjacencyList().get("Ross 154").getElement().setPos(627, 326);
		
		al.addNode("Ross 248", new Star("Ross 248", " 1.3 billones", "0.136 masas solares", Star.RED, 0));
		al.getAdjacencyList().get("Ross 248").getElement().setPos(670, 370);
		
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
		
		
		
		am.addNode("Sol", new Star("Sol", "4.6 billones", "1 masa solar", Star.YELLOW, 8));
		am.getNodes().get("Sol").getElement().setPos(395, 295);
		
		am.addNode("Próxima Centauri", new Star("Próxima Centauri", "4.85 billones", "0.123 masas solares", Star.RED, 1));
		am.getNodes().get("Próxima Centauri").getElement().setPos(395, 380);
		
		am.addNode("Alfa Centauri A", new Star("Alfa Centauri A", "4.4 billones", "1.100 masas solares", Star.YELLOW, 0));
		am.getNodes().get("Alfa Centauri A").getElement().setPos(350, 440);
		
		am.addNode("Alfa Centauri B", new Star("Alfa Centauri B", "6.5 billones", "0.907 masas solares", Star.RED, 1));
		am.getNodes().get("Alfa Centauri B").getElement().setPos(435, 430);
		
		am.addNode("Estrella de Barnard", new Star("Estrella de Barnard", "10 billones", "0.144 masas solares", Star.RED, 1));
		am.getNodes().get("Estrella de Barnard").getElement().setPos(560, 267);
		
		am.addNode("Luhman 16A", new Star("Luhman 16A", "700 millones", "33.5 masas jovianas", Star.BROWN, 0));
		am.getNodes().get("Luhman 16A").getElement().setPos(540, 205);
		
		am.addNode("Luhman 16B", new Star("Luhman 16B", "700 millones", "28.6 masas jovianas", Star.BROWN, 0));
		am.getNodes().get("Luhman 16B").getElement().setPos(600, 212);
		
		am.addNode("WISE 0855-0714", new Star("WISE 0855-0714", "7.3 millones", "6.5 masas jovianas", Star.BLUE, 0));
		am.getNodes().get("WISE 0855-0714").getElement().setPos(375, 215);
		
		am.addNode("Wolf 359", new Star("Wolf 359", "225 millones", "0.085 masas solares", Star.RED, 0));
		am.getNodes().get("Wolf 359").getElement().setPos(525, 388);
		
		am.addNode("Lalande 21185", new Star("Lalande 21185", "7.5 billones", "0.46 masas solares", Star.RED, 2));
		am.getNodes().get("Lalande 21185").getElement().setPos(275, 267);
		
		am.addNode("Sirio A", new Star("Sirio A", " 250 millones", "2.063 masas solares", Star.WHITE, 0));
		am.getNodes().get("Sirio A").getElement().setPos(255, 355);
		
		am.addNode("Sirio B", new Star("Sirio B", " 228 millones", "1.018 masas solares", Star.WHITE, 0));
		am.getNodes().get("Sirio B").getElement().setPos(270, 420);
		
		am.addNode("Tau Ceti", new Star("Tau Ceti", " 5.8 billones", "0.783 masas solares", Star.YELLOW, 0));
		am.getNodes().get("Tau Ceti").getElement().setPos(150, 431);
		
		am.addNode("YZ Ceti", new Star("YZ Ceti", " 5.0 billones", "0.130 masas solares", Star.RED, 3));
		am.getNodes().get("YZ Ceti").getElement().setPos(157, 300);
		
		am.addNode("Ross 154", new Star("Ross 154", " 1.0 billones", "0.17 masas solares", Star.RED, 0));
		am.getNodes().get("Ross 154").getElement().setPos(627, 326);
		
		am.addNode("Ross 248", new Star("Ross 248", " 1.3 billones", "0.136 masas solares", Star.RED, 0));
		am.getNodes().get("Ross 248").getElement().setPos(670, 370);
		
		
		am.addEdge("Sol", "Próxima Centauri", 4.24);
		am.addEdge("Próxima Centauri", "Alfa Centauri A", 0.237);
		am.addEdge("Próxima Centauri", "Alfa Centauri B", 0.237);
		am.addEdge("Sol", "Estrella de Barnard", 5.96);
		am.addEdge("Estrella de Barnard", "Luhman 16A", 1.36);
		am.addEdge("Luhman 16A", "Luhman 16B", 4.7);
		am.addEdge("Sol", "WISE 0855-0714", 7.2);
		am.addEdge("WISE 0855-0714","Luhman 16A" , 5.2);
		am.addEdge("WISE 0855-0714","Lalande 21185" , 1.0);
		am.addEdge("Lalande 21185", "Sirio A" , 4.1);
		am.addEdge("Sirio A", "Sirio B", 0.0031);
		am.addEdge("Sirio B","Próxima Centauri", 6.0);
		am.addEdge("Sirio B","Tau Ceti", 1.2);
		am.addEdge("Tau Ceti", "YZ Ceti", 0.3);
		am.addEdge("Alfa Centauri B","Wolf 359" , 3.4);
		am.addEdge("Wolf 359", "Ross 248" , 4.4);
		am.addEdge("Ross 248", "Ross 154" , 0.012);
		am.addEdge("Ross 154", "Estrella de Barnard", 7.2);
		
		images.put("Alfa Centauri A", "stars_images/Alfa Centauri A.jpg");
		images.put("Alfa Centauri B", "stars_images/Alfa Centauri B.jpg");
		images.put("Estrella de Barnard", "stars_images/Estrella de Barnard.jpg");
		images.put("Lalande 21185", "stars_images/Lalande 21185.jpg");
		images.put("Luhman 16A", "stars_images/Luhman 16A.jpg");
		images.put("Luhman 16B", "stars_images/Luhman 16B.jpg");
		images.put("Próxima Centauri", "stars_images/Próxima Centauri.jpg");
		images.put("Ross 154", "stars_images/Ross 154.jpg");
		images.put("Ross 248", "stars_images/Ross 248.jpg");
		images.put("Sirio A", "stars_images/Sirio A.jpg");
		images.put("Sirio B", "stars_images/Sirio B.jpg");
		images.put("Sol", "stars_images/Sol.jpg");
		images.put("Tau Ceti", "stars_images/Tau Ceti.jpg");
		images.put("WISE 0855-0714", "stars_images/WISE 0855-0714.jpg");
		images.put("Wolf 359", "stars_images/Wolf 359.jpg");
		images.put("YZ Ceti", "stars_images/YT Ceti.jpg");


		
		
		
	}
	
	
}
