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
		ImageIcon ima = new ImageIcon("stars_images/predeterminated.png");
		labImage = new JLabel(ima);
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

	public InfoPanel getInfo() {
		return info;
	}

	public void setInfo(InfoPanel info) {
		this.info = info;
	}

	public OptionsPanel getOptions() {
		return options;
	}

	public void setOptions(OptionsPanel options) {
		this.options = options;
	}

	public JLabel getLabImage() {
		return labImage;
	}

	public void setLabImage(JLabel labImage) {
		this.labImage = labImage;
	}
}
