package instafram.command;

import instafram.tree.controller.ZTreeController;
import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;

public class AddNodeCommand extends AbsCommand{

	private ZTreeNode selectedNode;
	private ZTreeNode parent;
	
	public AddNodeCommand(ZTreeController controller, ZTreeNode parent, ZTreeNode selectedNode) {
		super(controller);
		this.selectedNode = selectedNode;
		this.parent = parent;
	}

	@Override
	public void doCommand() {
		controller.addNode(parent, selectedNode.getNode());
	}

	@Override
	public void undoCommand() {
		controller.removeNode(selectedNode, false);
	}
	
	
}
