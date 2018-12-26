package instafram.tree.actions;

import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.tree.TreePath;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.TreeElementSelection;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Parametar;
import instafram.view.Application;

public class CopyNodeAction extends ZTreeAbsAction{

	protected ArrayList<ZTreeNode> selectedNodes = new ArrayList<>();
	private Clipboard clipboard;
	

	public CopyNodeAction(IZTreeController controller, CommandManager manager, Clipboard clipboard) {
		super(controller, manager);
		this.clipboard = clipboard;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		selectedNodes.removeAll(selectedNodes);
		TreePath[] paths = controller.getTree().getSelectionPaths();
		int n = paths.length;
		for (TreePath p : paths) {
			ZTreeNode node = new ZTreeNode((ZTreeNode) p.getPathComponent(p.getPathCount() - 1));
			if(node.getNode() instanceof Parametar)
				selectedNodes.add(node);
		}
		
		TreeElementSelection selection = new TreeElementSelection(selectedNodes);
		clipboard.setContents(selection, Application.getInstance());
	}

	/*public void setSelectedNode(ArrayList<ZTreeNode> selectedNodes) {
		this.selectedNodes = selectedNodes;
	}*/

}
