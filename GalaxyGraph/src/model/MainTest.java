package model;

import collections.GraphAL;
import collections.NodeGraphAL;

public class MainTest {

	public MainTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println("Prueba grafo, true si existe la arista entre dos elementos");
		GraphAL<Integer, Integer> testGrafo = new GraphAL<>();
		
		testGrafo.addElement(1, new NodeGraphAL<Integer, Integer>(2));
		testGrafo.addElement(1, new NodeGraphAL<Integer, Integer>(3));
		testGrafo.addElement(2, new NodeGraphAL<Integer, Integer>(3));
		System.out.println(testGrafo.exist(1, 2));
	}

}
