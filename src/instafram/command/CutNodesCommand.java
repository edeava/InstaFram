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
		for (Iterator iterator = selectedNodes.iterator(); iterator.hasNext();) {
			ZTreeNode zTreeNode = new ZTreeNode((ZTreeNode) iterator.next());
			if(zTreeNode.getNode() instanceof Parametar) {
				if(zTreeNode.getParent() == null)
					zTreeNode.setParent(selectedNode);
				selectedNode = (ZTreeNode) zTreeNode.getParent();
				controller.removeNode(zTreeNode, false);
			}
		}
	}

	@Override
	public void undoCommand() {
		for (Iterator iterator = selectedNodes.iterator(); iterator.hasNext();) {
			ZTreeNode tmpNode = new ZTreeNode((ZTreeNode) iterator.next());
			if(tmpNode.getNode() instanceof Parametar) {
				((ZTreeController) controller).addCmdNode(selectedNode, tmpNode);
				//tmpNode.setParent(selectedNode);
			}
		}
	}

	
}
