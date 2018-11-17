package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import collections.Edge;
import collections.GraphAM;

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
		
	}
	
	@Test
	public void testSortEdges() {
		setupStage3();
		PriorityQueue<Edge<String, String>> cola = graphAM.sortEdges();
		
		for (int i = 0; i < cola.size(); i++) {
			System.out.println(cola.poll().getWeight());
			
		}	
		
	}
	

}
