package guInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContainerOptionsPanel extends JPanel{

	private JLabel labImage;
	
	private InfoPanel info;
	
	private OptionsPanel options;
	
	private ContainerPanel container;
	
	public ContainerOptionsPanel(ContainerPanel containerPanel) {
		container = containerPanel;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 600));
		labImage = new JLabel(new ImageIcon("star_images/predeterminated.png"));
		labImage.setPreferredSize(new Dimension(200, 200));
		info = new InfoPanel(this);
		options = new OptionsPanel(this);
		
		add(labImage, BorderLayout.NORTH);
		add(info, BorderLayout.CENTER);
		add(options, BorderLayout.SOUTH);
	}
	
	public ContainerPanel getContainer() {
		return container;
	}
}
