package instafram.command;

import java.util.ArrayList;

import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;

public class RemoveNodeCommand extends AbsCommand{

	private ZTreeNode selectedNode;
	private ZTreeNode parent;
	private ArrayList<ZTreeNode> exChildren = new ArrayList<>();
	
	public RemoveNodeCommand(IZTreeController controller, ZTreeNode parent, ZTreeNode selectedNode) {
		super(controller);
		this.selectedNode = selectedNode;
		this.selectedNode.setParent(parent);
		this.parent = parent;
	}

	@Override
	public void doCommand() {
		exChildren.removeAll(exChildren);
		for(int i = 0; i < selectedNode.getChildCount(); i++) {
			exChildren.add((ZTreeNode) selectedNode.getChildAt(i));
		}
		controller.removeNode(selectedNode, true);
		selectedNode.setParent(parent);
	}

	@Override
	public void undoCommand() {
		controller.addNode(parent, selectedNode.getNode());
		for (ZTreeNode node : exChildren) {
			controller.addNode((ZTreeNode) parent.getChildAt(parent.getChildCount() - 1), node.getNode());
		}
	}
}
