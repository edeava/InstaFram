package instafram.tree.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;

public class ZTreeEditor extends DefaultTreeCellEditor implements ActionListener{
	
	private  Object node = null;
	private JTextField edit = null;
	
	public ZTreeEditor(ZTree tree, DefaultTreeCellRenderer renderer) {
		super(tree, renderer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(node != null) {
			((ZTreeNode) node).setName(e.getActionCommand());
			System.out.println("Akcija");
		}
	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		node = value;
		
		edit=new JTextField(value.toString());
		edit.addActionListener(this);
		return edit;
	}

	@Override
	public boolean isCellEditable(EventObject event) {
		
		if(((MouseEvent) event).getClickCount() == 3) {
				return true;
		}
		return false;
	}
	
	
}
