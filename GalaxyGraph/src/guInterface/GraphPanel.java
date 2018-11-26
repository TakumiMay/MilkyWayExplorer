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

import javax.swing.JPanel;

import collections.Node;
import model.Star;

public class GraphPanel extends JPanel implements ActionListener, MouseListener{

	private MainWindow mainW; 
	
	private OptionsPanel options;
	
	public GraphPanel(MainWindow gui) {
		mainW = gui;
		options =  new OptionsPanel(this);
		setPreferredSize(new Dimension(1000, 1000));
		setLayout(new BorderLayout());
		addMouseListener(this);
//		add(options, BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.setColor(Color.WHITE);
		
		g.fillRect(0, 0, 500, size.height);
		for (Node<String, Star> st : mainW.getNodes().values()) {
			Star a = st.getElement();
			char color = a.getColor();
			int s = 0;
//			int x = a.getX();
//			int y =a.getY();
			if (color == Star.BLUE) {
				s = 40;
				g.setColor(new Color(83, 138, 213));
			} else if (color == Star.BROWN) {
				s = 20;
				g.setColor(new Color(184, 71, 47));
				s = 25;
			} else if (color == Star.RED) {
				g.setColor(new Color(232, 57, 48));
			} else if (color == Star.WHITE) {
				s = 35;
				g.setColor(Color.WHITE);
			} else if (color == Star.YELLOW) {
				s = 30;
				g.setColor(new Color(235, 235, 6));
			}
			
//			g.fillOval(x, y, s, s);
			
		
		}
		g.setColor(Color.BLACK);
		g.fillOval(200, 10, 50, 50);
		
		g.setColor(Color.BLUE);
		g.fillOval(60, 320, 50, 50);
		
		
		
		g.drawLine(200+25, 10+50, 50+30, 320+30);
		
		g.drawString("50", ((200+60)/2)+20, (10+320)/2);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		
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
