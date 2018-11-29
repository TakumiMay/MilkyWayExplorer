package guInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class DijkstraWindow extends JFrame {
	
	private MainWindow gui;
	
	private DijkstraPaintPanel paint;
	
	private DijkstraOptionsPanel options;
	
	public DijkstraWindow(MainWindow main) {
		gui = main;
		setTitle("Dijkstra");
		setVisible(true);
		setPreferredSize(new Dimension(1000, 600));
		setResizable(false);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		paint = new DijkstraPaintPanel(this);
		options = new DijkstraOptionsPanel(this);
		
		add(paint, BorderLayout.CENTER);
		add(options, BorderLayout.SOUTH);
		pack();	
	}
	
	public MainWindow getGui() {
		return gui;
	}

	public void dijkstra(String from, String to) {
		gui.dijkstra(from, to);
		this.setVisible(false);
	}
}
