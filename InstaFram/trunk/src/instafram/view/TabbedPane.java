package instafram.view;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class TabbedPane extends JTabbedPane{

	public TabbedPane() {
		super(JTabbedPane.TOP);
		
	}

	public void addTab(String title) {
		JTextArea ta = new JTextArea(title, 10, 20);
		JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		super.addTab("Tab" + getTabCount(), sp);
	}
	
	
}
