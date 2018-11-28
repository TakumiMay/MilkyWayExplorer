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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionsPanel extends JPanel implements ActionListener {

	public static final String NEW_NODE = "new node";

	public static final String SHORT_PATH = "dijkstra";

	public static final String DIJKSTRA = "dijkstra";
	
	public static final String FLOYD = "floyd";
	
	public static final String BACK = "back";

	private JButton btnNewNode;

	private JButton btnShortPath;

	private JButton btnDijs;

	private JButton btnFloyd;
	
	private JButton btnBack;
	
	
	private JLabel labImage;
	private JLabel labName; private JTextField txtName;
	private JLabel labAge; private JTextField txtAge;
	private JLabel labColor; private JTextField txtColor;
	private JLabel labMass; private JTextField txtMass;
	private JLabel labPlanets; private JTextField txtPlanets;
	
	
	/**
	 * To see the stars we
	 */
	private JPanel starVisualization;
	private JPanel adjustButtons;

	private ContainerPanel mainPanel;

	public OptionsPanel(ContainerPanel mainP) {
		mainPanel = mainP;
		setLayout(new GridBagLayout());
		GridBagConstraints constrains = new GridBagConstraints();
		starVisualization = new JPanel();
		starVisualization.setLayout(new BorderLayout());
		adjustButtons = new JPanel();
		
		setPreferredSize(new Dimension(200, 600));
		adjustButtons.setLayout(new GridLayout(5,2));
		
		labImage = new JLabel(new ImageIcon("star_images/predeterminated.png"));
		starVisualization.add(labImage, BorderLayout.CENTER);
		
		labName = new JLabel("Nombre: ");
		txtName= new JTextField();
		txtName.setEditable(false);
		adjustButtons.add(labName);
		adjustButtons.add(txtName);
		
		labAge = new JLabel("Edad: ");
		txtAge= new JTextField();
		txtAge.setEditable(false);
		adjustButtons.add(labAge);
		adjustButtons.add(txtAge);
		
		labColor = new JLabel("Color: ");
		txtColor= new JTextField();
		txtColor.setEditable(false);
		adjustButtons.add(labColor);
		adjustButtons.add(txtColor);
		
		labMass = new JLabel("Mass: ");
		txtMass= new JTextField();
		txtMass.setEditable(false);
		adjustButtons.add(labMass);
		adjustButtons.add(txtMass);
		
		labPlanets = new JLabel("Planets: ");
		txtPlanets= new JTextField();
		txtPlanets.setEditable(false);
		adjustButtons.add(labPlanets);
		adjustButtons.add(txtPlanets);
		
		starVisualization.add(adjustButtons, BorderLayout.SOUTH);

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

		if (mainP.getGraphRepre().equals(MainPanel.LIST_GRAPH)) {
			btnDijs = new JButton("Dijkstra");
			btnDijs.addActionListener(this);
			btnDijs.setActionCommand(DIJKSTRA);
			btnDijs.setPreferredSize(new Dimension(150, 30));

			constrains.gridx = 1;
			constrains.gridy = 6;
			constrains.gridwidth = 3;
			constrains.gridheight = 1;

			add(btnDijs, constrains);
		} else if (mainP.getGraphRepre().equals(MainPanel.MATRIX_GRAPH)) {
			btnFloyd = new JButton("Floyd Warshall");
			btnFloyd.addActionListener(this);
			btnFloyd.setActionCommand(FLOYD);
			btnFloyd.setPreferredSize(new Dimension(150, 30));

			constrains.gridx = 1;
			constrains.gridy = 6;
			constrains.gridwidth = 3;
			constrains.gridheight = 1;

			add(btnFloyd, constrains);
		}
		
		btnBack = new JButton("Volver");
		btnBack.addActionListener(this);
		btnBack.setActionCommand(BACK);
		btnBack.setPreferredSize(new Dimension(150, 30));

		constrains.gridx = 1;
		constrains.gridy = 7;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;

		add(btnBack, constrains);
		
		
		
	}
	
	

	public JLabel getLabImage() {
		return labImage;
	}



	public JTextField getTxtName() {
		return txtName;
	}



	public JTextField getTxtAge() {
		return txtAge;
	}



	public JTextField getTxtColor() {
		return txtColor;
	}



	public JTextField getTxtMass() {
		return txtMass;
	}



	public JTextField getTxtPlanets() {
		return txtPlanets;
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals(DIJKSTRA)) {
			mainPanel.openDjWindow();
		} else if (command.equals(FLOYD)) {
			
		} else if (command.equals(BACK)) {
			mainPanel.back();
		} else if (command.equals(SHORT_PATH)) {
			
		} else if (command.equals(NEW_NODE)) {
			
		}
	}

}
