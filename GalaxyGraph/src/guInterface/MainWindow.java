package guInterface;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private MainPanel main;
	
	
	
	public MainWindow() {
		setTitle("Milky Way Explorer");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage((new ImageIcon("imgs/star_icon.png")).getImage());
		setLocationRelativeTo(null);
		
		main = new MainPanel(this);
		
		add(main);
		pack();
	}
	
	public static void main(String[] args) {
		
		MainWindow gui = new MainWindow();
		gui.setVisible(true);
		
	}
}
