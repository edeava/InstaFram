package instafram.tree.actions;

import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Parametar;
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
	private PasteNodeAction paste;
	private CutNodeAction cut;
	private ZTreeNode prevSelected;
		
	public ZTreeActionManager(IZTreeController controller, Clipboard clipboard, CommandManager manager) {
		this.addNode = new AddNodeAction(controller, manager);
		this.removeNode = new RemoveNodeAction(controller, manager);
		this.editNode = new EditNodeAction(controller, manager);
		this.saveAction = new SaveTreeAction(controller, manager);
		this.loadAction = new LoadTreeAction(controller, manager);
		this.saveAs = new SaveAsTreeAction(controller, manager);
		this.copy = new CopyNodeAction(controller, manager, clipboard);
		this.paste = new PasteNodeAction(controller, manager, clipboard);
		this.cut = new CutNodeAction(controller, manager, clipboard);
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		TreePath[] paths = arg0.getPaths();
		TreePath path = paths[0];
		
		if(path != null) {
			ZTreeNode selectedNode = (ZTreeNode) path.getPathComponent(path.getPathCount() - 1);
			
			this.addNode.setSelectedNode(selectedNode);
			this.removeNode.setSelectedNode(selectedNode);
			this.editNode.setSelectedNode(selectedNode);
			this.saveAction.setSelectedNode(selectedNode);
			this.loadAction.setSelectedNode(selectedNode);
			this.saveAs.setSelectedNode(selectedNode);
			this.paste.setSelectedNode(selectedNode);
			
			selectedNode.notifyObserver();
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

	public CopyNodeAction getCopy() {
		return copy;
	}

	public PasteNodeAction getPaste() {
		return paste;
	}

	public CutNodeAction getCut() {
		return cut;
	}
}
