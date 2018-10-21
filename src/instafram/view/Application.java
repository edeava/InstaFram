package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Application extends JFrame{

	
	public Application() throws HeadlessException {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrSize = kit.getScreenSize();
		setSize(scrSize.width / 2, scrSize.height / 2);
		setTitle("InstaFram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("Img/camera.png").getImage());
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);

	}

}
