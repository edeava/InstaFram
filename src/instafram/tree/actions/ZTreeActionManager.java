package instafram.tree.actions;

import java.util.ArrayList;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;
import instafram.view.TabbedPane;

public class ZTreeActionManager implements TreeSelectionListener{
	private AddNodeAction addNode;
	private RemoveNodeAction removeNode;
	private EditNodeAction editNode;
	private SaveTreeAction saveAction;
	private LoadTreeAction loadAction;
	private SaveAsTreeAction saveAs;
	private CopyNodeAction copy;
		
	public ZTreeActionManager(IZTreeController controller) {
		this.addNode = new AddNodeAction(controller);
		this.removeNode = new RemoveNodeAction(controller);
		this.editNode = new EditNodeAction(controller);
		this.saveAction = new SaveTreeAction(controller);
		this.loadAction = new LoadTreeAction(controller);
		this.saveAs = new SaveAsTreeAction(controller);
		//this.copy = new CopyNodeAction(controller, Application.getInstance().getClipboard());
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		TreePath[] paths = arg0.getPaths();
		TreePath path = paths[0];
		ArrayList<ZTreeNode> selectedNodes = new ArrayList<>();
		
		if(path != null) {
			ZTreeNode selectedNode = (ZTreeNode) path.getPathComponent(path.getPathCount() - 1);
			
			this.addNode.setSelectedNode(selectedNode);
			this.removeNode.setSelectedNode(selectedNode);
			this.editNode.setSelectedNode(selectedNode);
			this.saveAction.setSelectedNode(selectedNode);
			this.loadAction.setSelectedNode(selectedNode);
			this.saveAs.setSelectedNode(selectedNode);
			
			selectedNode.notifyObserver();
		}
		
		if(paths != null) {
			//for (int i = 0; i < paths.length; i++) 
				//selectedNodes.add((ZTreeNode) paths[i].getPathComponent(path.getPathCount() - 1));
			
			//copy.setSelectedNode(selectedNodes);
		}
	}


	public AddNodeAction getAddNode() {
		return addNode;
	}


	public RemoveNodeAction getRemoveNode() {
		return removeNode;
	}


	public LoadTreeAction getLoadAction() {
		return loadAction;
	}

	public EditNodeAction getEditNode() {
		return editNode;
	}
	
	public SaveTreeAction getSaveAction() {
		return saveAction;
	}

	public SaveAsTreeAction getSaveAs() {
		return saveAs;
	}
}
