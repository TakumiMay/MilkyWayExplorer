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
	
	/**
	 * To paint
	 */
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
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setPos(int x, int y) {
		this.posX = x;
		this.posY = y;
	
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
	
	
	
	

}
