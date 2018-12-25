package instafram.tree.actions;

import java.util.ArrayList;

import javax.swing.AbstractAction;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;

public abstract class ZTreeAbsAction extends AbstractAction{
	protected IZTreeController controller;
	protected CommandManager manager;
	protected ZTreeNode selectedNode;
	
	public ZTreeAbsAction(IZTreeController controller, CommandManager manager) {
		this.controller = controller;
		this.manager = manager;
		this.setEnabled(false);
	}

	public void setSelectedNode(ZTreeNode selectedNode){
		this.selectedNode = selectedNode;
		this.setEnabled(this.selectedNode.getAllowsChildren());
	}
	
}
