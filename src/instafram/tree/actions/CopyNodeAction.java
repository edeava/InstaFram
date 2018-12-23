package instafram.tree.actions;

import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.tree.TreePath;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.TreeElementSelection;
import instafram.tree.model.ZTreeNode;
import instafram.view.Application;

public class CopyNodeAction extends ZTreeAbsAction{

	protected ArrayList<ZTreeNode> selectedNodes = new ArrayList<>();
	private Clipboard clipboard;
	
	public CopyNodeAction(IZTreeController controller, Clipboard clipboard) {
		super(controller);
		this.clipboard = clipboard;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		selectedNodes.clear();
		TreePath[] paths = controller.getTree().getSelectionPaths();
		int n = paths.length;
		for (int i = 0; i < n; i++) 
			selectedNodes.add((ZTreeNode) paths[i].getPathComponent(paths[i].getPathCount() - 1));
		
		TreeElementSelection selection = new TreeElementSelection(selectedNodes);
		clipboard.setContents(selection, Application.getInstance());
	}

	public void setSelectedNode(ArrayList<ZTreeNode> selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

}
