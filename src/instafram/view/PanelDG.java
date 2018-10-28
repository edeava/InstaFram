package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelDG extends APanel{
	
	public PanelDG() {
		
		ToolBar tb = new ToolBar();
		add(tb, BorderLayout.WEST);
		
		//privremeno
		JTextArea ta = new JTextArea("Test za scrollPane", 5, 5);
		
		JScrollPane scrollPane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.SOUTH);

	}
	
	
}
