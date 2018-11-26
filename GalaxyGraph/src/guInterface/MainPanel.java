package guInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener{

	public static final String GO_PAINT_GRAPH = "go";
	
	public static final ImageIcon FONDO_PANEL = new ImageIcon("imgs/galaxyWallpaper.jpg");
	
	private JButton btnGoPaintGraph;
	
	private MainWindow mainW; 
	
	public MainPanel(MainWindow gui) {
		mainW = gui;
		setLayout(new GridBagLayout());
		
		GridBagConstraints constrains = new GridBagConstraints();
		
		setPreferredSize(new Dimension(400, 500));
		
		btnGoPaintGraph = new JButton("Paint Galaxy Graph");
		btnGoPaintGraph.addActionListener(this);
		btnGoPaintGraph.setActionCommand(GO_PAINT_GRAPH);
		btnGoPaintGraph.setPreferredSize(new Dimension(150, 30));
		
		constrains.gridx = 1;//position column
		constrains.gridy = 0;//position row
		constrains.gridwidth = 3;//columns
		constrains.gridheight = 1;//rows
		
		add(btnGoPaintGraph, constrains);		
	}
	
	public void paintComponent(Graphics g) {
		Dimension tamano = getSize();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, tamano.width, tamano.height);
		
		g.drawImage(FONDO_PANEL.getImage(), 0, 0, tamano.width, tamano.height, this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (command == GO_PAINT_GRAPH) {
			mainW.startApp();
		}
	}

	
}
