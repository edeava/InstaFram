package instafram.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutFrame extends JDialog{

	public AboutFrame() throws HeadlessException {
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JLabel lb = new JLabel("Stefan Zivkovic RN14/17");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(lb, BorderLayout.NORTH);
		
		panel.add(new JLabel(new ImageIcon("Img/ja.jpg")), BorderLayout.CENTER);
		
		this.add(panel);
		this.pack();
		setVisible(true);
	}
	
}
