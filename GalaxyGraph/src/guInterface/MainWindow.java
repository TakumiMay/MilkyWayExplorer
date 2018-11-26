package guInterface;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.GraphApp;

public class MainWindow extends JFrame {

	private MainPanel main;
	
	private GraphPanel graph;
	
	private GraphApp app;
	
	public MainWindow() {
		setTitle("Milky Way Explorer");
		//setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage((new ImageIcon("imgs/star_icon.png")).getImage());
		setLocationRelativeTo(null);
		
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
}
