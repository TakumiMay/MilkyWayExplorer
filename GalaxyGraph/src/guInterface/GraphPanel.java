package guInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import collections.Edge;
import collections.Node;
import model.Star;

public class GraphPanel extends JPanel implements MouseListener{
	
	private ContainerPanel mainPanel;
	private int x;
	private int y;
	
	public GraphPanel(ContainerPanel mainP) {
		mainPanel = mainP;
		setPreferredSize(new Dimension(800, 600));
		
		Image ima = Toolkit.getDefaultToolkit().createImage("./imgs/telescope.png");
		Cursor cursin = Toolkit.getDefaultToolkit().createCustomCursor(ima, new Point(10,10), "cursor");
		setCursor(cursin);

		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.setColor(Color.DARK_GRAY);
		g.drawImage(new ImageIcon("imgs/foreground1.gif").getImage(), 0, 0, size.width, size.height, this);
		
		g.fillRect(0, 0, 800, size.height);
		for (Node<String, Star> nd : mainPanel.getNodes().values()) {
			int posXStart = nd.getElement().getPosX();
			int posYStart = nd.getElement().getPosY();
			for (Edge<String, Star> ed : nd.getList().values()) {
				int posXEnd = mainPanel.getNodes().get(ed.getAdjacentTo()).getElement().getPosX();
				int posYEnd = mainPanel.getNodes().get(ed.getAdjacentTo()).getElement().getPosY();
				g.drawLine(posXStart, posYStart, posXEnd, posYEnd);
				
				g.setColor(Color.BLACK);
				g.drawString(ed.getWeight()+"", ((posXStart+posXEnd)/2), ((posYStart+posYEnd)/2));
			}
		}
		
		for (Node<String, Star> st : mainPanel.getNodes().values()) {
			Star a = st.getElement();
			char color = a.getColor();
			int s = 0;
			int x = a.getPosX()-7;
			int y =a.getPosY()-7;
			if (color == Star.BLUE) {
				s = 35;
				a.setArea(s,s);
				g.setColor(new Color(83, 138, 213));
			} else if (color == Star.BROWN) {
				s = 15;
				a.setArea(s,s);
				g.setColor(new Color(184, 71, 47));
				//s = 20;
			} else if (color == Star.RED) {
				s = 23;
				a.setArea(s,s);
//				g.setColor(new Color(232, 57, 48));
				g.setColor(Color.RED);
			} else if (color == Star.WHITE) {
				s = 30;
				a.setArea(s,s);
				g.setColor(Color.WHITE);
			} else if (color == Star.YELLOW) {
				s = 25;
				a.setArea(s,s);
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
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println(e.getX());
//		System.out.println(e.getY());
		this.x = e.getX();
		this.y = e.getY();
		mainPanel.getMainW().putStarInfoOnVisualizer(e.getX(), e.getY());
		if(MainWindow.adding) {
			mainPanel.getMainW().addStar(e.getX(), e.getY());
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
