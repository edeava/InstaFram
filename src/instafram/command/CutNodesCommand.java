package instafram.command;

import java.util.ArrayList;
import java.util.Iterator;

import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Parametar;

public class CutNodesCommand extends AbsCommand{

	private ArrayList<ZTreeNode> selectedNodes = new ArrayList<>();
	private ZTreeNode selectedNode;
	
	public CutNodesCommand(IZTreeController controller, ArrayList<ZTreeNode> selectedNodes) {
		super(controller);
		this.selectedNodes = selectedNodes;
	}

	@Override
	public void doCommand() {
		selectedNode = (ZTreeNode) selectedNodes.get(0).getParent();
		controller.cutNodes(selectedNodes);
	}

	@Override
	public void undoCommand() {
		controller.pasteNodes(selectedNode, selectedNodes);
	}

	
}
