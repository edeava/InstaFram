package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PanelDG extends APanel{
	
	public PanelDG() {
		
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		ToolBar tb = new ToolBar();
		add(tb, BorderLayout.NORTH);
		
		//privremeno
		JTextArea ta = new JTextArea("Test za scrollPane", 10, 20);
		
		JScrollPane scrollPane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.SOUTH);

	}
	
	
}
