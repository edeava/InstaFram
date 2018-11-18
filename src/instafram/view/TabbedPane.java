package instafram.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import instafram.actions.ZDocumentListener;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;

public class TabbedPane extends JTabbedPane implements ObserverUpdate{

	public ArrayList<ZTreeNode> nodes = new ArrayList<>();
	PanelD panel;
	public TabbedPane(PanelD panel) {
		super(JTabbedPane.TOP);
		this.panel = panel;
		
	}

	public void addTab(ZTreeNode node) {
		if(!nodes.contains(node)) {
			JTextArea ta = new JTextArea(node.getNode().getSadrzaj(), 10, 20);
			ta.getDocument().addDocumentListener(new ZDocumentListener(node, ta));
			
			JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			super.addTab(node.toString(), sp);
			nodes.add(node);
		}
		this.setSelectedIndex(nodes.indexOf(node));
		this.setTitleAt(getSelectedIndex(), node.getNode().getName());
	}

	public void removeTab() {
		
	}
	
	@Override
	public void onUpdate(ZTreeNode node) {
		addTab(node);
	}
	
	@Override
	public void remove(Component component) {
		nodes.remove(this.getSelectedIndex());
		super.remove(component);
	}

}

