package guInterface;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import collections.Node;
import model.GraphApp;
import model.Star;

public class MainWindow extends JFrame {

	private MainPanel main;
	
	private GraphPanel graph;
	
	private GraphApp app;
	
	public MainWindow() {
		setTitle("Milky Way Explorer");
		setPreferredSize(new Dimension(1000, 600));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage((new ImageIcon("imgs/star_icon.png")).getImage());
//		setLocationRelativeTo(this);
		
		main = new MainPanel(this);
		app = new GraphApp();
		
		add(main);
		pack();
	}
	
	public void startApp() {
		graph = new GraphPanel(this);
		main.setVisible(false);
		graph.setVisible(true);
		add(graph);
		
	}
	
	public static void main(String[] args) {
		
		MainWindow gui = new MainWindow();
		gui.setVisible(true);
		
	}
	
	public HashMap<String, Node<String, Star>> getNodes(){
		return app.getAl().getAdjacencyList();
	}
	
}
