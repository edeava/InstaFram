package instafram.tree.model;

import java.io.Serializable;
import java.util.ArrayList;

public interface IZTreeNode extends Serializable{
	void addNode(IZTreeNode node);
	void removeNode(IZTreeNode node);
	ArrayList<IZTreeNode> getChildren();
	String getName();
	void setName(String name);
	String toString();
}
