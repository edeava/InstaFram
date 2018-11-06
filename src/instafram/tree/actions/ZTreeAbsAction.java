package instafram.tree.actions;

import javax.swing.AbstractAction;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;

public abstract class ZTreeAbsAction extends AbstractAction{
	protected IZTreeController controller;
	protected ZTreeNode selectedNode;
	
	public ZTreeAbsAction(IZTreeController controller) {
		this.controller = controller;
		this.setEnabled(false);
	}

	public void setSelectedNode(ZTreeNode selectedNode){
		this.selectedNode = selectedNode;
		this.setEnabled(this.selectedNode.getAllowsChildren());
	}
	
	
}
