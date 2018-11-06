package instafram.tree.actions;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.view.Application;

public class RemoveNodeAction extends ZTreeAbsAction implements Observer{

	public RemoveNodeAction(IZTreeController controller) {
		super(controller);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(selectedNode != null && selectedNode.getParent() != null)
			this.controller.removeNode(selectedNode);
		else JOptionPane.showMessageDialog(Application.getInstance(), "Nevalidno brisanje");
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedNode(ZTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		this.setEnabled(!this.selectedNode.isRoot());
	}
	
	
	
}