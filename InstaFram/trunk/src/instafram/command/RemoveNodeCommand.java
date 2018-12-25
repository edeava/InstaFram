package instafram.command;

import instafram.tree.controller.ZTreeController;
import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;

public class RemoveNodeCommand extends AbsCommand{

	private ZTreeNode selectedNode;
	private ZTreeNode parent;
	
	public RemoveNodeCommand(ZTreeController controller, ZTreeNode parent, ZTreeNode selectedNode) {
		super(controller);
		this.selectedNode = selectedNode;
		this.parent = parent;
	}

	@Override
	public void doCommand() {
		controller.removeNode(selectedNode, false);
	}

	@Override
	public void undoCommand() {
		controller.addNode(parent, selectedNode.getNode());
	}
}
