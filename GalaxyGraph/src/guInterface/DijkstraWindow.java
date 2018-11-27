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
	private MainWindow gui;

	private int sizeNode;
	public DijkstraWindow(MainWindow main) {
		sizeNode = 0;
		gui = main;
		
		setTitle("Dijkstra");
		setVisible(true);
		setPreferredSize(new Dimension(1000, 600));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1000, 600);
		gui.getGraphAL().dijkstra("Sol");
		try {
			ArrayList<String> alDijsktra = gui.getGraphAL().dijkstraPath("Luhman 16B");
			
			int posXStart = gui.getNodes().get(alDijsktra.get(0)).getElement().getPosX();
			int posYStart = gui.getNodes().get(alDijsktra.get(0)).getElement().getPosY();
			g.setColor(colors(gui.getNodes().get(alDijsktra.get(0)).getElement().getColor()));
			g.fillOval(posXStart, posYStart, sizeNode, sizeNode);
			g.drawString(alDijsktra.get(0), posXStart, posYStart);
			for (int i = 1; i < alDijsktra.size()-1; i++) {
				int posXEnd = gui.getNodes().get(alDijsktra.get(i)).getElement().getPosX();
				int posYEnd = gui.getNodes().get(alDijsktra.get(i)).getElement().getPosY();
				g.setColor(colors(gui.getNodes().get(alDijsktra.get(i)).getElement().getColor()));
				g.fillOval(posXEnd, posYEnd, sizeNode, sizeNode);
				g.drawLine(posXStart, posYStart, posXEnd, posYEnd);
				g.drawString(alDijsktra.get(i), posXEnd, posYEnd);
				i++;
				posXStart = gui.getNodes().get(alDijsktra.get(i)).getElement().getPosX();
				posYStart = gui.getNodes().get(alDijsktra.get(i)).getElement().getPosY();
				g.setColor(colors(gui.getNodes().get(alDijsktra.get(i)).getElement().getColor()));
				g.fillOval(posXStart, posYStart, sizeNode, sizeNode);
				g.drawString(alDijsktra.get(i), posXStart, posYStart);
				
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
