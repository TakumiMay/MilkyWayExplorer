package guInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import exceptions.NodeException;
import model.Star;

public class DijkstraWindow extends JFrame implements ActionListener{
	private MainWindow main;

	private int sizeNode;
	public DijkstraWindow(MainWindow main) {
		sizeNode = 0;
		this.main = main;
		setTitle("Dijkstra");
		setVisible(true);
		setPreferredSize(new Dimension(1000, 600));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1000, 600);
		main.getGraphAL().dijkstra("Sol");
		try {
			ArrayList<String> alDijsktra = main.getGraphAL().dijkstraPath("Luhman 16B");
			int posX = main.getNodes().get(alDijsktra.get(0)).getElement().getPosX();
			int posY = main.getNodes().get(alDijsktra.get(0)).getElement().getPosY();
			
			g.drawOval(posX, posY, sizeNode, sizeNode);
			for (int i = 1; i < alDijsktra.size(); i++) {
				
			}
		} catch (NodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Color colors(char color) {
		Color c = new Color(0, 0, 0);
		if (color == Star.BLUE) {
			sizeNode = 35;
			c = (new Color(83, 138, 213));
		} else if (color == Star.BROWN) {
			
			c = (new Color(184, 71, 47));
			sizeNode = 20;
		} else if (color == Star.RED) {
			sizeNode = 23;
//			g.setColor(new Color(232, 57, 48));
			c = (Color.RED);
		} else if (color == Star.WHITE) {
			sizeNode = 30;
			c = (Color.WHITE);
		} else if (color == Star.YELLOW) {
			sizeNode = 25;
			c = (new Color(235, 235, 6));
		}
		return c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
