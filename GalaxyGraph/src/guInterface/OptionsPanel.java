package guInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionsPanel extends JPanel implements ActionListener {

	public static final String NEW_NODE = "new node";

	public static final String PRIM = "prim";

	public static final String DIJKSTRA = "dijkstra";

	public static final String FLOYD = "floyd";

	public static final String BACK = "back";

	private JButton btnNewNode;

	private JButton btnPrim;

	private JButton btnDijs;

	private JButton btnFloyd;

	private JButton btnBack;

	private ContainerOptionsPanel container;

	public OptionsPanel(ContainerOptionsPanel container) {
		this.container = container;
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(200, 180));
		GridBagConstraints constrains = new GridBagConstraints();

		btnNewNode = new JButton("Add node");
		btnNewNode.addActionListener(this);
		btnNewNode.setActionCommand(NEW_NODE);
		btnNewNode.setPreferredSize(new Dimension(150, 30));

		constrains.gridx = 1;// position column
		constrains.gridy = 0;// position row
		constrains.gridwidth = 3;// columns
		constrains.gridheight = 1;// rows

		add(btnNewNode, constrains);

		JLabel emptySpace = new JLabel("");
		emptySpace.setPreferredSize(new Dimension(150, 30));
		constrains.gridy = 1;
		add(emptySpace, constrains);

		btnPrim = new JButton("Prim");
		btnPrim.addActionListener(this);
		btnPrim.setActionCommand(PRIM);
		btnPrim.setPreferredSize(new Dimension(150, 30));

		constrains.gridx = 1;
		constrains.gridy = 2;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;

		add(btnPrim, constrains);

		btnDijs = new JButton("Dijkstra");
		btnDijs.addActionListener(this);
		btnDijs.setActionCommand(DIJKSTRA);
		btnDijs.setPreferredSize(new Dimension(150, 30));

		constrains.gridx = 1;
		constrains.gridy = 6;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;

		add(btnDijs, constrains);
		
		if (container.getContainer().getGraphRepre().equals(MainPanel.MATRIX_GRAPH)) {
			btnFloyd = new JButton("Floyd Warshall");
			btnFloyd.addActionListener(this);
			btnFloyd.setActionCommand(FLOYD);
			btnFloyd.setPreferredSize(new Dimension(150, 30));

			constrains.gridx = 1;
			constrains.gridy = 7;
			constrains.gridwidth = 3;
			constrains.gridheight = 1;

			add(btnFloyd, constrains);
		}

		btnBack = new JButton("Volver");
		btnBack.addActionListener(this);
		btnBack.setActionCommand(BACK);
		btnBack.setPreferredSize(new Dimension(150, 30));

		constrains.gridx = 1;
		constrains.gridy = 8;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;

		add(btnBack, constrains);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals(DIJKSTRA)) {
			container.getContainer().openDjWindow();
		} else if (command.equals(FLOYD)) {
			String floyd = "";
			JOptionPane.showMessageDialog(this, floyd, "Floyd", JOptionPane.PLAIN_MESSAGE);
		} else if (command.equals(BACK)) {
			container.getContainer().back();
		} else if (command.equals(PRIM)) {
			String prim = "La ruta Prim es: ";
			JOptionPane.showMessageDialog(this, prim, "Prim", JOptionPane.PLAIN_MESSAGE);
		} else if (command.equals(NEW_NODE)) {

		}
	}

}
