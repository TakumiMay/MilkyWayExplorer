package guInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JPanel;

import collections.Node;
import model.Star;

public class ContainerPanel extends JPanel{

	private MainWindow mainW;
	
	private DijkstraWindow dw;
	
	private String graphRepresentation;
	
	private GraphPanel graph;
	
	private OptionsPanel options;
	
	public ContainerPanel(MainWindow main, String representation) {
		mainW = main;
		graphRepresentation = representation;
		setLayout(new BorderLayout());
		setSize(new Dimension(1000,600));
		graph = new GraphPanel(this);
		options = new OptionsPanel(this);
		dw = new DijkstraWindow(mainW);
		dw.setVisible(false);
		add(graph,BorderLayout.WEST);
		add(options,BorderLayout.EAST);
	}
	
	public HashMap<String, Node<String, Star>> getNodes() {
		return mainW.getNodes();
	}
	
	public void openDjWindow() {
		dw.setVisible(true);
	}
	
	public String getGraphRepre() {
		return graphRepresentation;
	}
}
