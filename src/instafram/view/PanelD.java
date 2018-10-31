package instafram.view;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class PanelD extends JPanel{

	public PanelD(LayoutManager arg0) {
		super(arg0);
		JTextArea ta = new JTextArea("Test za scrollPane", 10, 20);
		JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel dole = new JPanel();
		JSplitPane panel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, dole);
		
		add(panel);
	}

}
