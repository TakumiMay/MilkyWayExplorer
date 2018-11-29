package guInterface;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	
	static boolean adding =false;
	
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
		
		if(GraphRepresentation.equals(MainPanel.LIST_GRAPH)) {
			changeRepresentation(true);
		}
		else {
			changeRepresentation(false);
		}
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
	public void putStarInfoOnVisualizer(int x, int y) {
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
	
	public void addStar(int x, int y) {
		
		if(app.searchStarbyPos(x, y)!=null){
			JOptionPane.showConfirmDialog(this, "Ya hay una estrella en ese lugar. Presione add new node de nuevo");
			adding = false;
			return;
			
		}
	
		String name = JOptionPane.showInputDialog("Ingrese el nombre de la estrella");
		String age = JOptionPane.showInputDialog("Ingrese la edad de la estrella");
		String mass = JOptionPane.showInputDialog("Ingrese la masa de la estrella");
		String color = JOptionPane.showInputDialog("Ingrese el color de la estrella");
		char c;
		if(color.equalsIgnoreCase("Azul")) {
			c = Star.BLUE;
		}
		else if(color.equalsIgnoreCase("Cafe") || color.equalsIgnoreCase("Marron")){
			c = Star.BROWN;
		}
		else if(color.equalsIgnoreCase("Rojo") || color.equalsIgnoreCase("Roja")) {
			c = Star.RED;
		}
		else if(color.equalsIgnoreCase("Amarillo")||color.equalsIgnoreCase("Amarilla")){
			c = Star.YELLOW;
		}
		else if (color.equalsIgnoreCase("Blanca") || color.equalsIgnoreCase("Blanco")){
			c = Star.WHITE;
		}
		else {
			c = Star.YELLOW;
		}
		int planets;
		try {
			planets = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de planetas que orbitan la estrella"));
			
		}
		catch(Exception e) {
			JOptionPane.showConfirmDialog(this, "Formato inválido");
			adding = false;
			return;
		}
		
		
		app.addStar(name, age, mass, c, planets);
		Star s= app.getNodes().get(name).getElement();
		s.setPos(x, y);
		boolean go = false;
		do {
			try {
				String key = JOptionPane.showInputDialog(this, "Escriba el nombre de la estrella a la cual se hará un camino");
				double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia entre las estrellas"));
				app.addPath(name, key, peso);
			}
			catch(Exception e) {
				JOptionPane.showConfirmDialog(this, "Formato inválido, intente de nuevo");
				adding = false;
				return;
			}
			
			String op = JOptionPane.showInputDialog(this, "¿Desea agregar otra estre adyacente? Si/No");
			if(op.equalsIgnoreCase("sí") ||op.equalsIgnoreCase("si") ) {
				go =true;
			}
			else {
				go = false;
			}
		
		
		
		}while(go);
		
		adding = false;
		graph.getGraph().repaint();
		
		
	}
	public String getPrimPath() {
		return app.getPrimRoute();
	}
	
	/**
	 * True if adjacency list, false if adjacency matrix
	 * @param representation
	 */
	public void changeRepresentation(boolean representation) {
		app.setWorkingOnAL(representation);
	}
	
	public HashMap<String, Node<String, Star>> getNodes(){
		return app.getNodes();//getAl().getAdjacencyList();
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

	public String getFloydMatrix() {
		// TODO Auto-generated method stub
		return null;
	}
}