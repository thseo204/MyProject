package mainframe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(500, 600);
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

}
