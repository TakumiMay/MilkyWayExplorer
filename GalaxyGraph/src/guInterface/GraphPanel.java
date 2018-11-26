package guInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GraphPanel extends JPanel implements ActionListener, MouseListener{

	private MainWindow mainW; 
	
	private OptionsPanel options;
	
	public GraphPanel(MainWindow gui) {
		mainW = gui;
		options =  new OptionsPanel(this);
		setPreferredSize(new Dimension(1000, 1000));
		setLayout(new BorderLayout());
		addMouseListener(this);
		add(options, BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, size.height);
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
