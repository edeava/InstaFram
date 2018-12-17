package instafram.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import instafram.actions.ZDocumentListener;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Modul;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.view.GuiBuilder;

public class TabbedPane extends JTabbedPane implements ObserverUpdate{

	public ArrayList<ZTreeNode> nodes = new ArrayList<>();
	PanelD panel;
	public TabbedPane(PanelD panel) {
		super(JTabbedPane.TOP);
		this.panel = panel;
		
	}

	public void addTab(ZTreeNode node) {
		if(!nodes.contains(node)) {
			JPanel p = new JPanel();
			if(node.getNode() instanceof Parametar)
				p.add(GuiBuilder.build(((Parametar) node.getNode()).getGui()));
			else if(node.getNode() instanceof Modul) 
				p.add(GuiBuilder.browse(Box.createVerticalBox(), false, "Odaberite putanju"));
			
			//JScrollPane sp = new JScrollPane(null, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			super.addTab(node.toString(), p);
			nodes.add(node);
		}
		this.setSelectedIndex(nodes.indexOf(node));
		this.setTitleAt(getSelectedIndex(), node.getNode().getName());
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

