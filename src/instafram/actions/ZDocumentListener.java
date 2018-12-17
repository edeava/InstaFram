package instafram.actions;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import instafram.tree.model.ZTreeNode;

public class ZDocumentListener implements DocumentListener{
	
	private ZTreeNode node;
	private JTextArea ta;
	
	public ZDocumentListener(ZTreeNode node, JTextArea ta) {
		super();
		this.node = node;
		this.ta = ta;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		//node.setSadrzaj(ta.getText());
		
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		//node.setSadrzaj(ta.getText());
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		//node.setSadrzaj(ta.getText());
	}

}
