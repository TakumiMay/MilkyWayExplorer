package guInterface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DijkstraOptionsPanel extends JPanel implements ActionListener{

	public static final String DIJKSTRA = "dijkstra";
	
	private JLabel labFrom;
	
	private JTextField txtFromNode;
	
	private JLabel labTo;
	
	private JTextField txtToNode;
	
	private JButton btnIDK;
	
	private DijkstraWindow window;
	
	public DijkstraOptionsPanel(DijkstraWindow djWindow) {
		window = djWindow;
		setPreferredSize(new Dimension(1000, 50));
		setLayout(new GridLayout());
		
		labFrom = new JLabel("Desde: ");
		txtFromNode = new JTextField();
		labTo = new JLabel("Hasta: ");
		txtToNode = new JTextField();
		btnIDK = new JButton("Dijkstra");
		btnIDK.addActionListener(this);
		btnIDK.setActionCommand(DIJKSTRA);
		
		add(new JLabel(""));
		add(labFrom);
		add(txtFromNode);
		add(new JLabel(""));
		add(labTo);
		add(txtToNode);
		add(new JLabel(""));
		add(btnIDK);
		add(new JLabel(""));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals(DIJKSTRA)) {
			String from = txtFromNode.getText();
			String to = txtToNode.getText();
			window.dijkstra(from, to);
		}
	}
}
