package instafram.tree.controller;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import instafram.tree.view.ZTree;

public class ZTreeModelListener implements TreeModelListener{
	
	private ZTree tree;
	
	
	public ZTreeModelListener(ZTree tree) {
		super();
		this.tree = tree;
	}

	@Override
	public void treeNodesChanged(TreeModelEvent arg0) {
		this.tree.update();
		
	}

	@Override
	public void treeNodesInserted(TreeModelEvent arg0) {
		this.tree.expandPath(arg0.getTreePath());
		this.tree.update();
	}

	@Override
	public void treeNodesRemoved(TreeModelEvent arg0) {
		this.tree.update();
	}

	@Override
	public void treeStructureChanged(TreeModelEvent arg0) {
		this.tree.update();
	}

}
