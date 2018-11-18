package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import instafram.tree.controller.ZTreeController;
import instafram.tree.model.Observable;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;

public class PanelD extends JPanel{

	public TabbedPane tb;
	private PanelDDole desnoDole;
	
	public PanelD(LayoutManager arg0) {
		super(arg0);
		tb = new TabbedPane(this);
		desnoDole = new PanelDDole();
		JSplitPane panel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tb, desnoDole);
		panel.setResizeWeight(0.5);
		add(panel);
		
	}

	public TabbedPane getTb() {
		return tb;
	}

	public PanelDDole getDesnoDole() {
		return desnoDole;
	}
}
