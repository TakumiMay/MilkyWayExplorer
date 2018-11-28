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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener{

	public static final String LIST_GRAPH = "list";
	
	public static final String MATRIX_GRAPH = "matrix";

	public static final String CREDITS = "credits";
	
	public static final ImageIcon FONDO_PANEL = new ImageIcon("imgs/galaxyWallpaper.jpg");
	
	public static final ImageIcon LOGO = new ImageIcon("imgs/logo.png");
	
	private JButton btnGraphList;
	
	private JButton btnGraphMatrix;
	
	private JButton btnCredits;
	
	private MainWindow mainW; 
	
	public MainPanel(MainWindow gui) {
		mainW = gui;
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(1000, 600));
		GridBagConstraints constrains = new GridBagConstraints();
		
		JLabel emptySpace = new JLabel(LOGO);
		emptySpace.setPreferredSize(new Dimension(310, 110));
		constrains.gridy = 0;
		add(emptySpace, constrains);
		
		emptySpace = new JLabel("");
		emptySpace.setPreferredSize(new Dimension(150, 30));
		constrains.gridy = 1;
		add(emptySpace, constrains);
		
		btnGraphList = new JButton("Grafo por Lista");
		btnGraphList.addActionListener(this);
		btnGraphList.setActionCommand(LIST_GRAPH);
		btnGraphList.setPreferredSize(new Dimension(150, 30));
		
		constrains.gridx = 1;//position column
		constrains.gridy = 2;//position row
		constrains.gridwidth = 3;//columns
		constrains.gridheight = 1;//rows
		
		add(btnGraphList, constrains);
		emptySpace = new JLabel("");
		emptySpace.setPreferredSize(new Dimension(150, 30));
		constrains.gridy = 3;
		add(emptySpace, constrains);
		
		btnGraphMatrix = new JButton("Grafo por Matriz");
		btnGraphMatrix.addActionListener(this);
		btnGraphMatrix.setActionCommand(MATRIX_GRAPH);
		btnGraphMatrix.setPreferredSize(new Dimension(150, 30));
		
		constrains.gridx = 1;//position column
		constrains.gridy = 4;//position row
		constrains.gridwidth = 3;//columns
		constrains.gridheight = 1;//rows
		
		add(btnGraphMatrix, constrains);
		emptySpace = new JLabel("");
		emptySpace.setPreferredSize(new Dimension(150, 30));
		constrains.gridy = 5;
		add(emptySpace, constrains);
		
		btnCredits = new JButton("Créditos");
		btnCredits.addActionListener(this);
		btnCredits.setActionCommand(CREDITS);
		btnCredits.setPreferredSize(new Dimension(150, 30));
		
		constrains.gridx = 1;//position column
		constrains.gridy = 6;//position row
		constrains.gridwidth = 3;//columns
		constrains.gridheight = 1;//rows
		
		add(btnCredits, constrains);
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
		
		if (command.equals(LIST_GRAPH)) {
			mainW.startApp(LIST_GRAPH);
		} else if(command.equals(MATRIX_GRAPH)) {
			mainW.startApp(MATRIX_GRAPH);
		} else if(command.equals(CREDITS)){
			JOptionPane.showMessageDialog(this, "Felipe Castillo - Daniel Guzmán - Mayumi Tamura", "Créditos", JOptionPane.PLAIN_MESSAGE);
		}
	}

	
}
