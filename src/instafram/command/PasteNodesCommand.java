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
		for (Iterator iterator = selectedNodes.iterator(); iterator.hasNext();) {
			ZTreeNode tmpNode = (ZTreeNode) iterator.next();
			if(tmpNode.getNode() instanceof Parametar) {
				prevNode = (ZTreeNode) tmpNode.getParent();
				controller.addNode(selectedNode, tmpNode.getNode());
				tmpNode.setParent(selectedNode);
			}
		}
	}

	@Override
	public void undoCommand() {
		for (Iterator iterator = selectedNodes.iterator(); iterator.hasNext();) {
			ZTreeNode zTreeNode = (ZTreeNode) iterator.next();
			if(zTreeNode.getNode() instanceof Parametar) {
				controller.removeNode(zTreeNode, false);
			}
		}
	}
}
