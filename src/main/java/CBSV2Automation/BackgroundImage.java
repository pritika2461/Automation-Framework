package CBSV2Automation;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class BackgroundImage extends JPanel {
	private final Image backgroundImage;

	public BackgroundImage(String imagePath) {
		backgroundImage = new ImageIcon(getClass().getClassLoader().getResource(imagePath)).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
