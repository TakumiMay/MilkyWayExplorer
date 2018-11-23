package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import collections.Edge;
import collections.GraphAL;
import collections.GraphAM;
import collections.Node;

class TestGraphAL {

private GraphAL<String, String> graphAL;
	
	public void setupStage1() {
		graphAL = new GraphAL<>(true);
	}
	
	public void setupStage2() {
		setupStage1();
		graphAL.addNode("Vega", "Vega", 0);
		graphAL.addNode("Altair", "Altair", 1);
		graphAL.addNode("GJ876", "GJ876", 2);
		graphAL.addNode("Sun", "Sun", 3);		
	}
	
	public void setupStage3() {
		setupStage2();
		graphAL.addEdge("Vega", "Altair", 2);
		graphAL.addEdge("Altair", "Sun", 1);
		graphAL.addEdge("Sun", "Vega", 6);
		graphAL.addEdge("GJ876", "Altair", 3);
		graphAL.addEdge("Sun", "GJ876", 4);
	}
	public void setupStage4() {
		setupStage2();
		graphAL.addEdge("", "Altair", 2);
		graphAL.addEdge("Altair", "Sun", 1);
		graphAL.addEdge("Sun", "Vega", 6);
		graphAL.addEdge("GJ876", "Altair", 3);
	}

	@Test
	public void testAddNode() {
		setupStage1();
		graphAL.addNode("Vega", "Vega", 1);
		assertTrue(graphAL.getAdjacencyList().get("Vega")!=null);
	}
	@Test 
	public void testAddEdge() {
		setupStage2();
		graphAL.addEdge("Vega", "Altair", 4);
		assertTrue(graphAL.exist("Vega", "Altair"));		
		assertFalse(graphAL.exist("Vega", "Sun"));		
	}
	public void testDeleteNode(){
		setupStage2();
		graphAL.deleteNode("Vega");
//		assertTrue(gra);
	}
	public void testDeleteEdge(){
				
	}
	public void testExist() {
		setupStage3();
		assertTrue(graphAL.exist("Vega", "Altair"));
		
	}
	
	@Test
	public void testBFS() {
		setupStage3();
		graphAL.bfs(graphAL.getAdjacencyList().get("Vega"));
		for (Node<String, String> u: graphAL.getAdjacencyList().values()) {
//			for (Edge<String, String> edge : u.getList().values()) {
//				System.out.println();
//			}
			System.out.println(u.getColor());
		}
		
	}
	
	@Test
	public void testPrim() {
		System.out.println("TEST PRIM----------------");
		setupStage3();
		
		
		ArrayList<Node<String, String>> ar = new ArrayList();
//		System.out.println(graphAM.getNodes().get("Vega").getKey());
		ar = graphAL.prim("Vega");
		System.out.println(ar.size());
		
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getKey());
			
		}
		System.out.println("FIN TEST PRIM----------------");
	}

}