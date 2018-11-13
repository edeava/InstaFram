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

public class PanelD extends JPanel implements ObserverUpdate{

	public TabbedPane tb;
	private PanelO observer;
	private JPanel dole;
	
	public PanelD(LayoutManager arg0) {
		super(arg0);
		observer = new PanelO();
	//	observer.addObserver(this);
		tb = new TabbedPane(this);
		dole = new JPanel();
		JSplitPane panel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tb, dole);
		panel.setResizeWeight(0.5);
		add(panel);
	}

	@Override
	public void onUpdate() {
		dole.removeAll();
		dole.add(new JLabel(tb.node.getNode().getName() + " " +
							tb.node.getNode().getSadrzaj() + " " +
							tb.node.getParent() + " " +
							tb.node.getChildCount() + " " +
							ZTreeController.dfs(tb.node, new ArrayList<>(), tb.node.preorderEnumeration(), 0)), BorderLayout.CENTER);
	}

	public PanelO getObserver() {
		return observer;
	}
	
}
