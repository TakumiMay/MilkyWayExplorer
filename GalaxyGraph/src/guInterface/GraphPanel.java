package guInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GraphPanel extends JPanel implements ActionListener{

	private MainWindow mainW; 
	
	private OptionsPanel options;
	
	public GraphPanel(MainWindow gui) {
		mainW = gui;
		options =  new OptionsPanel(this);
		setPreferredSize(new Dimension(900, 500));
		setLayout(new BorderLayout());
		
		add(options, BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 500, size.height);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	
}
