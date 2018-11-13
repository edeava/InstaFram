package instafram.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutFrame extends JDialog{

	public AboutFrame() throws HeadlessException {
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(new JLabel("Stefan Zivkovic RN14/17"), BorderLayout.NORTH);
		
		add(new JLabel(new ImageIcon("Img/ja.jpg")), BorderLayout.CENTER);
	}
	
}
