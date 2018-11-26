package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import collections.Edge;
import collections.GraphAM;
import collections.Node;

class TestGraphAM {
	private GraphAM<String, String> graphAM;
	
	public void setupStage1() {
		graphAM = new GraphAM<>(4, true);
	}
	
	public void setupStage2() {
		setupStage1();
		graphAM.addNode("Vega", "Vega", 0);
		graphAM.addNode("Altair", "Altair", 1);
		graphAM.addNode("GJ876", "GJ876", 2);
		graphAM.addNode("Sun", "Sun", 3);		
	}
	
	public void setupStage3() {
		setupStage2();
		graphAM.addEdge("Vega", "Altair", 2);
		graphAM.addEdge("Altair", "Sun", 1);
		graphAM.addEdge("Sun", "Vega", 6);
		graphAM.addEdge("GJ876", "Altair", 3);
		graphAM.addEdge("Sun", "GJ876", 4);
	}
	public void setupStage4() {
		setupStage2();
		graphAM.addEdge("", "Altair", 2);
		graphAM.addEdge("Altair", "Sun", 1);
		graphAM.addEdge("Sun", "Vega", 6);
		graphAM.addEdge("GJ876", "Altair", 3);
	}

	@Test
	public void testAddNode() {
		setupStage1();
		graphAM.addNode("Vega", "Vega", 1);
		assertTrue(graphAM.getNodes().get("Vega")!=null);
	}
	@Test 
	public void testAddEdge() {
		setupStage2();
		graphAM.addEdge("Vega", "Altair", 4);		
		assertTrue(graphAM.exist("Vega", "Altair"));		
		assertFalse(graphAM.exist("Vega", "Sun"));		
	}
	public void testDeleteNode(){
		setupStage2();
		graphAM.deleteNode("Vega");
//		assertTrue(gra);
	}
	public void testDeleteEdge(){
				
	}
	public void testExist() {
		setupStage3();
		assertTrue(graphAM.exist("Vega", "Altair"));
		
	}
	
	//Have to improve the test
	@Test
	public void testPrim() {
		setupStage3();
		
		
		ArrayList<Node<String, String>> ar = new ArrayList();
//		System.out.println(graphAM.getNodes().get("Vega").getKey());
		ar = graphAM.prim("Vega");
		System.out.println(ar.size());
		
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getKey());
			
		}
	}
	@Test
	public void testFloydWarshall() {
		System.out.println("TEST FLOYD WARSHALL");
		setupStage3();
		double floyd [][] = graphAM.floydWarshall();
//		Edge<String, String> floyd [][] = graphAM.getMatrixA();
		System.out.println("tamaño matriz: "+floyd.length);
		
		for (int i = 0; i < floyd.length; i++) {
			for (int j = 0; j < floyd.length; j++) {
				if (floyd[i][j] == Integer.MAX_VALUE) {
					System.out.print("inf");
				}
				else
				System.out.print(floyd[i][j]+" ");
				if (j==3) {
					System.out.println();
				}
//				System.out.print(floyd[i][j].getWeight()+" ");
//				if (j==3) {
//					System.out.println();
//				}
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
//	@Test
	public void testSortEdges() {
		System.out.println("test sort edges");
		setupStage3();
		PriorityQueue<Edge<String, String>> cola = graphAM.sortEdges();		

		while (!cola.isEmpty()) {
			System.out.println(cola.poll().getWeight());
			
		}					
		
	}
	

}
