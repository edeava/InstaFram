package instafram.view;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Tab extends JScrollPane{
	private JTextArea ta;
	private JScrollPane sp;
	
	public Tab(String title) {
		super();
		JTextArea ta = new JTextArea(title, 10, 20);
		this.add(ta);
	}
	
	public JTextArea getTa() {
		return ta;
	}
	
	public JScrollPane getSp() {
		return sp;
	}
			
}
