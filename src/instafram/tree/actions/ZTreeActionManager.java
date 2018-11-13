package instafram.tree.actions;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;

public class ZTreeActionManager implements TreeSelectionListener{
	private AddNodeAction addNode;
	private RemoveNodeAction removeNode;
	private EditNodeAction editNode;
	private SaveTreeAction saveAction;
	private LoadTreeAction loadAction;
		
	public ZTreeActionManager(IZTreeController controller) {
		this.addNode = new AddNodeAction(controller);
		this.removeNode = new RemoveNodeAction(controller);
		this.editNode = new EditNodeAction(controller);
		this.saveAction = new SaveTreeAction(controller);
		this.loadAction = new LoadTreeAction(controller);
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		TreePath path = arg0.getPath();
		
		if(path != null) {
			ZTreeNode selectedNode = (ZTreeNode) path.getPathComponent(path.getPathCount() - 1);
			this.addNode.setSelectedNode(selectedNode);
			this.removeNode.setSelectedNode(selectedNode);
			this.editNode.setSelectedNode(selectedNode);
			this.saveAction.setSelectedNode(selectedNode);
			this.loadAction.setSelectedNode(selectedNode);
			
			selectedNode.pukni(Application.getInstance().getWorkspace().getObserver());
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
}
