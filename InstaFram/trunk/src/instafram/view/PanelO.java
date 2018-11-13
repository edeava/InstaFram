package instafram.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import instafram.tree.actions.ZTreeActionManager;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;
import instafram.treeComponent.model.Proizvod;

public class PanelO extends Observable{
	private String name;
	private String sadrzaj;
	private ZTreeNode parent;
	private int childNumber;
	private int leafNumber = 0;
	
	
	
	public PanelO() {
		super();
	}

	public void setNode(ZTreeNode node) {
		leafNumber = 0;
		name = node.getNode().getName();
		sadrzaj = node.getNode().getSadrzaj();
		parent = (ZTreeNode) node.getParent();
		childNumber = node.getChildCount();
		leafNumber = ZTreeController.dfs(node, new ArrayList<>(), node.preorderEnumeration(), leafNumber);
		setChanged();
		notifyObservers(this);
	}

	public String getName() {
		return name;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public ZTreeNode getParent() {
		return parent;
	}

	public int getChildNumber() {
		return childNumber;
	}

	public int getLeafNumber() {
		return leafNumber;
	}
	
}
