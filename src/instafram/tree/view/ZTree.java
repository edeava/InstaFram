package instafram.tree.view;

import java.awt.datatransfer.Clipboard;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import instafram.tree.actions.ZTreeActionManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeModelListener;
import instafram.tree.model.Observable;
import instafram.tree.model.ZTreeModel;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;
import instafram.view.TabbedPane;

public class ZTree extends JTree{
	private IZTreeController controller;
	private ZTreeModel model;
	private ZTreeActionManager actionManager;
	private ZTreeNode root;
	
	public ZTree(IZTreeController controller, ZTreeActionManager actionManager) {
		root = new ZTreeNode(new Proizvod("Kompanija"));
		this.controller = controller;
		this.controller.setTree(this);
		this.actionManager = actionManager;
		this.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
		
		
		this.model = new ZTreeModel(root);
		this.setModel(model);
		this.model.addTreeModelListener(new ZTreeModelListener(this));
		
		this.addTreeSelectionListener(actionManager);
		this.setCellEditor(new ZTreeEditor(this, new DefaultTreeCellRenderer()));
		this.setShowsRootHandles(true);
		this.setEditable(true);
		
		
		
	}

	public void update() {
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public IZTreeController getController() {
		return controller;
	}

	public ZTreeModel getModel() {
		return model;
	}

	public ZTreeActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ZTreeActionManager actionManager) {
		this.actionManager = actionManager;
	}

	public void setRoot(ZTreeNode root) {
		this.root = root;
		this.model.setRoot(this.root);
		model.reload(this.root);
	}
}
