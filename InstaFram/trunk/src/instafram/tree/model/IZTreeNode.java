package instafram.tree.model;

import java.util.ArrayList;

public interface IZTreeNode {
	void addNode(IZTreeNode node);
	void removeNode(IZTreeNode node);
	ArrayList<IZTreeNode> getChildren();
	String getName();
	void setName(String name);
	String toString();
}
