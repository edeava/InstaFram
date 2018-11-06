package instafram.tree.model;

import javax.swing.tree.DefaultMutableTreeNode;

public class ZTreeNode extends DefaultMutableTreeNode{
	private IZTreeNode node;
	
	public ZTreeNode(IZTreeNode node) {
		super();
		this.node = node;
	}

	public static ZTreeNode createTree(IZTreeNode node) {
		ZTreeNode root = new ZTreeNode(node);
		
		for(IZTreeNode child : node.getChildren())
			root.add(ZTreeNode.createTree(child));
		return root;
	}
	
	public IZTreeNode getNode() {
		return node;
	}

	public void setNode(IZTreeNode node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return node.toString();
	}
	
	public void addNode(IZTreeNode node) {
		this.node.addNode(node);
	}
	
	public void removeNode(IZTreeNode node) {
		this.node.removeNode(node);
	}
	
	@Override
	public boolean equals(Object arg0) {
		return node.getName().equals(((ZTreeNode)arg0).getNode().getName());
	}
}
