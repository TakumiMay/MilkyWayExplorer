package guInterface;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanel extends JPanel {
	
	private JLabel labName; private JTextField txtName;
	
	private JLabel labAge; private JTextField txtAge;
	
	private JLabel labColor; private JTextField txtColor;
	
	private JLabel labMass; private JTextField txtMass;
	
	private JLabel labPlanets; private JTextField txtPlanets;
	
	private ContainerOptionsPanel container;
	
	public InfoPanel(ContainerOptionsPanel container) {
		this.container = container;
		setLayout(new GridLayout(5,2));
		setPreferredSize(new Dimension(200, 220));
		
		labName = new JLabel("Nombre: ");
		txtName= new JTextField();
		txtName.setEditable(false);
		add(labName);
		add(txtName);
		
		labAge = new JLabel("Edad: ");
		txtAge= new JTextField();
		txtAge.setEditable(false);
		add(labAge);
		add(txtAge);
		
		labColor = new JLabel("Color: ");
		txtColor= new JTextField();
		txtColor.setEditable(false);
		add(labColor);
		add(txtColor);
		
		labMass = new JLabel("Masa: ");
		txtMass= new JTextField();
		txtMass.setEditable(false);
		add(labMass);
		add(txtMass);
		
		labPlanets = new JLabel("Planetas: ");
		txtPlanets= new JTextField();
		txtPlanets.setEditable(false);
		add(labPlanets);
		add(txtPlanets);
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
}