package instafram.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import instafram.actions.UpdateSadrzajAction;
import instafram.tree.model.ZTreeNode;

public class TabbedPane extends JTabbedPane{

	public ZTreeNode node;
	PanelD panel;
	public TabbedPane(PanelD panel) {
		super(JTabbedPane.TOP);
		this.panel = panel;
		
	}

	public void addTab(ZTreeNode node) {
		this.node = node;
		JTextArea ta = new JTextArea(node.getNode().getSadrzaj(), 10, 20);
		ta.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				node.getNode().setSadrzaj(ta.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				node.getNode().setSadrzaj(ta.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				node.getNode().setSadrzaj(ta.getText());
			}
		});
		
		JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.onUpdate();
		super.addTab("Tab" + getTabCount(), sp);
	}
	
	
}

