package guInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import collections.Edge;
import collections.Node;
import javafx.scene.control.Button;
import model.Star;

public class GraphPanel extends JPanel implements ActionListener, MouseListener{

	public static final String DIJKSTRA = "d"; 
	private MainWindow mainW; 
	
	private OptionsPanel options;
	
	private DijkstraWindow dw;
	
	private JButton btnDijs;
	
	public GraphPanel(MainWindow gui) {
		dw = new DijkstraWindow(mainW);
		dw.setVisible(false);
		mainW = gui;
		options =  new OptionsPanel(this);
		setPreferredSize(new Dimension(1500, 1000));
//		setSize(new Dimension(1000, 1000));
		setLayout(new BorderLayout());
		addMouseListener(this);
		btnDijs = new JButton("Dijkstra");
		btnDijs.addActionListener(this);
		btnDijs.setActionCommand(DIJKSTRA);
		add(btnDijs, BorderLayout.SOUTH);
		
	}
	
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.setColor(Color.DARK_GRAY);
		
		g.fillRect(0, 0, 800, size.height);
		for (Node<String, Star> nd : mainW.getNodes().values()) {
			int posXStart = nd.getElement().getPosX();
			int posYStart = nd.getElement().getPosY();
			for (Edge<String, Star> ed : nd.getList().values()) {
				int posXEnd = mainW.getNodes().get(ed.getAdjacentTo()).getElement().getPosX();
				int posYEnd = mainW.getNodes().get(ed.getAdjacentTo()).getElement().getPosY();
				g.drawLine(posXStart, posYStart, posXEnd, posYEnd);
				
				g.setColor(Color.BLACK);
				g.drawString(ed.getWeight()+"", ((posXStart+posXEnd)/2), ((posYStart+posYEnd)/2));
			}
		}
		
		for (Node<String, Star> st : mainW.getNodes().values()) {
			Star a = st.getElement();
			char color = a.getColor();
			int s = 0;
			int x = a.getPosX()-7;
			int y =a.getPosY()-7;
			if (color == Star.BLUE) {
				s = 35;
				g.setColor(new Color(83, 138, 213));
			} else if (color == Star.BROWN) {
				s = 15;
				g.setColor(new Color(184, 71, 47));
				s = 20;
			} else if (color == Star.RED) {
				s = 23;
//				g.setColor(new Color(232, 57, 48));
				g.setColor(Color.RED);
			} else if (color == Star.WHITE) {
				s = 30;
				g.setColor(Color.WHITE);
			} else if (color == Star.YELLOW) {
				s = 25;
				g.setColor(new Color(235, 235, 6));
			}
			
			g.fillOval(x, y, s, s);
			g.drawString(st.getKey(), x, y);
			
//			g.setColor(Color.BLACK);
//			g.fillOval(200, 10, 50, 50);
			
			
//			g.setColor(Color.BLUE);
//			g.fillOval(60, 320, 50, 50);
			
		
		}
				
//		g.drawLine(200+25, 10+50, 50+30, 320+30);		
//		g.drawString("50", ((200+60)/2)+20, (10+320)/2);
		
		
		add(options, BorderLayout.EAST);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(DIJKSTRA)) {
			System.out.println("btn");
			dw.setVisible(true);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	
}
