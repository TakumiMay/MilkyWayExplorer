package guInterface;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


import collections.GraphAL;
import collections.Node;
import javazoom.jl.player.Player;
import model.GraphApp;
import model.Star;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

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
	
	/**
	 * Search the Star clicked by the user and takes its information
	 * @param x
	 * @param y
	 */
	public void searhInfoStar(int x, int y) {
		Star s = app.searchStarbyPos(x, y);
		if(s!=null) {
			
		}
	}
	
	public static void main(String[] args) {
		
		MainWindow gui = new MainWindow();
		gui.setVisible(true);
		
		Player apl;
		try {
			apl = new Player(new FileInputStream("raw/HaloSong.mp3"));
			apl.play();
		} catch (FileNotFoundException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HashMap<String, Node<String, Star>> getNodes(){
		return app.getAl().getAdjacencyList();
	}
	public GraphAL<String, Star> getGraphAL(){
		return app.getAl();
	}
	
}
