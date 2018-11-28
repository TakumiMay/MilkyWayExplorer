package guInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel implements ActionListener {

	public static final String NEW_NODE = "new node";

	public static final String SHORT_PATH = "dijkstra";

	public static final String ANOTHER = "another thing";

	public static final String DIJKSTRA = "d";

	private JButton btnNewNode;

	private JButton btnShortPath;

	private JButton btnAnother;

	private JButton btnDijs;

	private ContainerPanel mainPanel;

	public OptionsPanel(ContainerPanel mainP) {
		mainPanel = mainP;
		setLayout(new GridBagLayout());
		GridBagConstraints constrains = new GridBagConstraints();
		setPreferredSize(new Dimension(200, 600));

		if (mainP.getGraphRepre().equals(MainPanel.LIST_GRAPH)) {
			btnNewNode = new JButton("Add node");
			btnNewNode.addActionListener(this);
			btnNewNode.setActionCommand(NEW_NODE);
			btnNewNode.setPreferredSize(new Dimension(150, 30));

			constrains.gridx = 1;// position column
			constrains.gridy = 0;// position row
			constrains.gridwidth = 3;// columns
			constrains.gridheight = 1;// rows

			add(btnNewNode, constrains);

			JLabel emptySpace = new JLabel("Hola");
			emptySpace.setPreferredSize(new Dimension(150, 30));
			constrains.gridy = 1;
			add(emptySpace, constrains);

			btnShortPath = new JButton("Short Path");
			btnShortPath.addActionListener(this);
			btnShortPath.setActionCommand(SHORT_PATH);
			btnShortPath.setPreferredSize(new Dimension(150, 30));

			constrains.gridx = 1;
			constrains.gridy = 2;
			constrains.gridwidth = 3;
			constrains.gridheight = 1;

			add(btnShortPath, constrains);

			btnDijs = new JButton("Dijkstra");
			btnDijs.addActionListener(this);
			btnDijs.setActionCommand(DIJKSTRA);
			btnDijs.setPreferredSize(new Dimension(150, 30));

			constrains.gridx = 1;
			constrains.gridy = 6;
			constrains.gridwidth = 3;
			constrains.gridheight = 1;

			add(btnDijs, constrains);
		}
		else if(mainP.getGraphRepre().equals(MainPanel.MATRIX_GRAPH)) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(DIJKSTRA)) {
			mainPanel.openDjWindow();
		} else if (event.getActionCommand().equals(NEW_NODE)) {

		} else if (event.getActionCommand().equals(SHORT_PATH)) {

		} else if (event.getActionCommand().equals(ANOTHER)) {

		}
	}

}
