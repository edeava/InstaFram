package instafram.command;

import java.util.ArrayList;
import java.util.Iterator;

import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Parametar;

public class PasteNodesCommand extends AbsCommand{
	
	private ArrayList<ZTreeNode> selectedNodes = new ArrayList<>();
	private ZTreeNode selectedNode;
	private ZTreeNode prevNode;
	
	public PasteNodesCommand(IZTreeController controller, ArrayList<ZTreeNode> selectedNodes, ZTreeNode selectedNode) {
		super(controller);
		for(ZTreeNode node : selectedNodes)
			this.selectedNodes.add(node);
		this.selectedNode = selectedNode;
	}

	@Override
	public void doCommand() {
		prevNode = (ZTreeNode) selectedNodes.get(0).getParent();
		controller.pasteNodes(selectedNode, selectedNodes);
		for(ZTreeNode node : selectedNodes)
			node.setParent(selectedNode);
	}

	@Override
	public void undoCommand() {
		controller.cutNodes(selectedNodes);
		for(ZTreeNode node : selectedNodes)
			node.setParent(prevNode);
	}
}
