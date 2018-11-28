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
	
	private ContainerPanel graph;
	
	private GraphApp app;
	
	public MainWindow() {
		setTitle("Milky Way Explorer");
		setSize(new Dimension(1000, 600));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage((new ImageIcon("imgs/star_icon.png")).getImage());
//		setLocationRelativeTo(this);
		
		main = new MainPanel(this);
		app = new GraphApp();
		
		add(main);
		pack();
	}
	
	public void startApp(String GraphRepresentation) {
		main.setVisible(false);
		graph = new ContainerPanel(this, GraphRepresentation);
		graph.setVisible(true);
		add(graph);
	}
	
	public void setMainPanelVisible() {
		main.setVisible(true);	
	}
	
	/**
	 * Search the Star clicked by the user and takes its information
	 * @param x
	 * @param y
	 */
	public void searhInfoStar(int x, int y) {
		Star s = app.searchStarbyPos(x, y);
		if(s!=null) {
			graph.getOptions().getLabImage().setIcon(new ImageIcon(app.getImages().get(s.getName())));
			graph.getOptions().getInfo().getTxtName().setText(s.getName());
			graph.getOptions().getInfo().getTxtAge().setText(s.getAge());
			switch(s.getColor()) {
			case Star.BLUE:
				graph.getOptions().getInfo().getTxtColor().setText("Azul");
				break;
			case Star.BROWN:
				graph.getOptions().getInfo().getTxtColor().setText("Marrón");
				break;
			case Star.RED:
				graph.getOptions().getInfo().getTxtColor().setText("Roja");
				break;
			case Star.WHITE:
				graph.getOptions().getInfo().getTxtColor().setText("Blanca");
				break;
			case Star.YELLOW:
				graph.getOptions().getInfo().getTxtColor().setText("Amarilla");
				break;
				
			}
			graph.getOptions().getInfo().getTxtMass().setText(s.getSize());
			graph.getOptions().getInfo().getTxtPlanets().setText(""+s.getPlanets());
			
		}
	}
	
	public HashMap<String, Node<String, Star>> getNodes(){
		return app.getAl().getAdjacencyList();
	}
	
	public GraphAL<String, Star> getGraphAL(){
		return app.getAl();
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
}