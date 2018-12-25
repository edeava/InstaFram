package instafram.command;

import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;

public class RemoveNodeCommand extends AbsCommand{

	private ZTreeNode selectedNode;
	private ZTreeNode parent;
	
	public RemoveNodeCommand(IZTreeController controller, ZTreeNode parent, ZTreeNode selectedNode) {
		super(controller);
		this.selectedNode = selectedNode;
		this.selectedNode.setParent(parent);
		this.parent = parent;
	}

	@Override
	public void doCommand() {
		controller.removeNode(selectedNode, true);
	}

	@Override
	public void undoCommand() {
		((ZTreeController) controller).addCmdNode(parent, selectedNode);
	}
}
