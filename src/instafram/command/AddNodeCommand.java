package instafram.command;

import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;

public class AddNodeCommand extends AbsCommand{

	private ZTreeNode selectedNode;
	private ZTreeNode parent;
	
	public AddNodeCommand(IZTreeController controller, ZTreeNode parent, IZTreeNode selectedNode) {
		super(controller);
		this.selectedNode = new ZTreeNode(selectedNode);
		this.selectedNode.setParent(parent);
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
