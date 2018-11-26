package model;

public class Star {
	
	public static final char YELLOW = 'Y';
	public static final char BLUE = 'B';
	public static final char RED = 'R';
	public static final char WHITE = 'W';
	
	private String name;
	private double age;
	private double size;
	private char color;
	private int planets;
	
	public Star(String name, double age, double size, char color, int planets) {
		super();
		this.name = name;
		this.age = age;
		this.size = size;
		this.color = color;
		this.planets = planets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
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
