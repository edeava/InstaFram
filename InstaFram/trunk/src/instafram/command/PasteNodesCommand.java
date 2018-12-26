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
		this.selectedNodes = selectedNodes;
		this.selectedNode = selectedNode;
	}

	@Override
	public void doCommand() {
		controller.pasteNodes(selectedNode, selectedNodes);
	}

	@Override
	public void undoCommand() {
		controller.cutNodes(selectedNodes);
	}
}
