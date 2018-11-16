package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.GraphAM;

class TestGraphAM {
	private GraphAM<String, String> graphAM;
	
	public void setupStage1() {
		graphAM = new GraphAM<>(4, true);
	}
	
	public void setupStage2() {
		graphAM = new GraphAM<>(4, true);
		graphAM.addNode("Vega", "Vega", 0);
		graphAM.addNode("Altair", "Altair", 1);
		graphAM.addNode("GJ876", "GJ876", 2);
		graphAM.addNode("Sun", "Sun", 3);		
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
	

}
