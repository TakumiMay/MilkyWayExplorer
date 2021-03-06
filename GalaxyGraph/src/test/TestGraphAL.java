package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import collections.Edge;
import collections.GraphAL;
import collections.GraphAM;
import collections.Node;
import exceptions.NodeException;

class TestGraphAL {

private GraphAL<String, String> graphAL;
	
	public void setupStage1() {
		graphAL = new GraphAL<>(false);
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
	
	public void setupStage5() {
		setupStage1();
		graphAL.addNode("1", "1");
		graphAL.addNode("2", "2");
		graphAL.addNode("3", "3");
		graphAL.addNode("4", "4");
		graphAL.addNode("5", "5");
		
		graphAL.addEdge("2", "1", 1);
		graphAL.addEdge("2", "5", 1);
		graphAL.addEdge("2", "4", 1);
		graphAL.addEdge("3", "4", 1);
		graphAL.addEdge("3", "2", 1);
		graphAL.addEdge("4", "5", 1);
		graphAL.addEdge("1", "5", 1);
		
	}
	
	public void setupStage6() {
		setupStage1();
		graphAL.addNode("A", "1");
		graphAL.addNode("B", "3");
		graphAL.addNode("C", "0");
		graphAL.addNode("D","4");
		graphAL.addNode("E","3");
		graphAL.addNode("Z","10");
	
		graphAL.addEdge("A", "B", 4);
		graphAL.addEdge("A", "C", 2);
		graphAL.addEdge("B", "D", 5);
		graphAL.addEdge("B", "C", 1);
		graphAL.addEdge("C", "D", 8);
		graphAL.addEdge("C", "E", 10);
		graphAL.addEdge("E", "Z", 3);
		graphAL.addEdge("D", "E", 2);
		graphAL.addEdge("D", "Z", 6);
		
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
		setupStage5();
		Node inicio = graphAL.getAdjacencyList().get("3");
		graphAL.bfs(inicio);

		Node fin = graphAL.getAdjacencyList().get("1");
		graphAL.printPath(inicio, fin, "");
		//assertTrue(graphAL.printPath(inicio, fin, "").equals("3-0-2-1-1-2"));
		
	}
	
	@Test
	public void testDFS() {
		setupStage5();
		graphAL.dfs();
		PriorityQueue<Node> noditos = graphAL.timeStampsNodes();
		//System.out.println(noditos.isEmpty());
		while(!(noditos.isEmpty())) {
			Node n = (Node)noditos.poll();
			System.out.println(""+n.getKey()+"-"+n.getD()+"-"+n.getF());
		}
	}
	
//	@Test
//	public void testPrim() {
//		System.out.println("TEST PRIM----------------");
//		setupStage3();
//		
//		
//		ArrayList<Node<String, String>> ar = new ArrayList();
////		System.out.println(graphAM.getNodes().get("Vega").getKey());
//		ar = graphAL.prim("Vega");
//		System.out.println(ar.size());
//		
//		for (int i = 0; i < ar.size(); i++) {
//			System.out.println(ar.get(i).getKey());
//			
//		}
//		System.out.println("FIN TEST PRIM----------------");
//	}
	
	@Test
	public void testDijkstra() {
		setupStage6();
		graphAL.dijkstra("A");
		ArrayList<String> bla;
		try {
			bla = graphAL.dijkstraPath("D");
			for (int i = 0; i < bla.size(); i++) {
				System.out.println(bla.get(i));
			}
			graphAL.getDistances().forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		} catch (NodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
