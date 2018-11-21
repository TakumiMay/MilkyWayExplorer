package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

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
	
	@Test
	public void testPrim() {
		setupStage3();
		
		
		ArrayList<Node<String, String>> ar = new ArrayList();
		ar = graphAM.prim("Vega");
		System.out.println(ar.size());
		
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getKey());
			
		}
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void testSortEdges() {
		System.out.println("test sort edges");
		setupStage3();
//		PriorityQueue<Edge<String, String>> cola = graphAM.sortEdges();
		PriorityQueue<Edge<String, String>> cola = new PriorityQueue<>();
		cola = graphAM.sortEdges(cola, graphAM.getNodes().get("Vega"));
		System.out.println("tamaño :"+cola.size());
		System.out.println(cola.peek().getWeight());
//		System.out.println(cola.size());
//		int e = cola.peek().getWeight();
//		
//
//		while (!cola.isEmpty()) {
//			System.out.println(cola.poll().getWeight());
//			
//		}
		
		
		
					
		
	}
	

}
