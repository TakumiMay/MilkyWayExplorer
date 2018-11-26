package model;

import collections.GraphAL;
import collections.GraphAM;

public class Star {
	
	public static final char YELLOW = 'Y';
	public static final char BLUE = 'B';
	public static final char RED = 'R';
	public static final char WHITE = 'W';
	public static final char BROWN = 'C';
	
	private String name;
	
	/**
	 * In billions 
	 */
	private String age;
	private String size;
	private char color;
	private int planets;
	
	private int posX;
	private int posY;
	
	public Star(String name, String age, String size, char color, int planets) {
		super();
		this.name = name;
		this.age = age;
		this.size = size;
		this.color = color;
		this.planets = planets;
		this.posX = 0;
		this.posY = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getPlanets() {
		return planets;
	}

	public void setPlanets(int planets) {
		this.planets = planets;
	}
	
	
	public void inicializeStars() {
		GraphAL<String, Star> al =new GraphAL(false);
		GraphAM<String, Star> am =new GraphAM(15, false);
		
		al.addNode("Sol", new Star("Sun", "4.6 billones", "1 masa solar", Star.YELLOW, 8));
		al.addNode("Próxima Centauri", new Star("Próxima Centauri", "4.85 billones", "0.123 masas solares", Star.RED, 1));
		al.addNode("Alfa Centauri A", new Star("Alfa Centauri A", "4.4 billones", "1.100 masas solares", Star.YELLOW, 0));
		al.addNode("Alfa Centauri B", new Star("Alfa Centauri B", "6.5 billones", "0.907 masas solares", Star.RED, 1));
		al.addNode("Estrella de Barnard", new Star("Estrella de Barnard", "10 billones", "0.144 masas solares", Star.RED, 1));
		al.addNode("Luhman 16A", new Star("Luhman 16A", "700 millones", "33.5 masas jovianas", Star.BROWN, 0));
		al.addNode("Luhman 16B", new Star("Luhman 16B", "700 millones", "28.6 masas jovianas", Star.BROWN, 0));
		al.addNode("WISE 0855-0714", new Star("WISE 0855-0714", "7.3 millones", "6.5 masas jovianas", Star.BROWN, 0));
		al.addNode("Wolf 359", new Star("Wolf 359", "225 millones", "0.085 masas solares", Star.RED, 0));
		al.addNode("Lalande 21185", new Star("Lalande 21185", "7.5 billones", "0.46 masas solares", Star.RED, 2));
		al.addNode("Sirio A", new Star("Sirio A", " 250 millones", "2.063 masas solares", Star.WHITE, 0));
		al.addNode("Sirio B", new Star("Sirio B", " 228 millones", "1.018 masas solares", Star.WHITE, 0));
		al.addNode("Tau Ceti", new Star("Tau Ceti", " 5.8 billones", "0.783 masas solares", Star.YELLOW, 0));
		al.addNode("YZ Ceti", new Star("YZ Ceti", " 5.0 billones", "0.130 masas solares", Star.RED, 3));
		al.addNode("Ross 154", new Star("Ross 154", " 1.0 billones", "0.17 masas solares", Star.RED, 0));
		al.addNode("Ross 248", new Star("Ross 248", " 1.3 billones", "0.136 masas solares", Star.RED, 0));
		
		al.addEdge("Sol", "Próxima Centauri", 4.24);
		al.addEdge("Próxima Centauri", "Alfa Centauri A", 0.237);
		al.addEdge("Próxima Centauri", "Alfa Centauri B", 0.237);
		al.addEdge("Sol", "Sirio A", 8.55);
		al.addEdge("Sirio A", "Sirio B", 0.00031);
		
		al.addEdge("Próxima Centauri", "Sirio A",6.1);
		
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
