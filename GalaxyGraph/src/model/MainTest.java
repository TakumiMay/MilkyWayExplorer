package model;

import collections.Graph;
import collections.NodeGraph;

public class MainTest {

	public MainTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println("Prueba grafo, true si existe la arista entre dos elementos");
		Graph<Integer, Integer> testGrafo = new Graph<>();
		
		testGrafo.addElement(1, new NodeGraph<Integer, Integer>(2));
		testGrafo.addElement(1, new NodeGraph<Integer, Integer>(3));
		testGrafo.addElement(2, new NodeGraph<Integer, Integer>(3));
		System.out.println(testGrafo.exist(1, 2));
	}

}
