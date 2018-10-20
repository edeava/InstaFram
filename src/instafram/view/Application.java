package instafram.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Application extends JFrame{

	
	public Application() throws HeadlessException {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrSize = kit.getScreenSize();
		setSize(scrSize.width / 2, scrSize.height / 2);
		setTitle("InstaFram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
	}

	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);

	}

}
