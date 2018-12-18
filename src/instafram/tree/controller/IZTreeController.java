package instafram.tree.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;

public interface IZTreeController {
	public void setTree(ZTree tree);
	public ZTree getTree();
	public void addNode(ZTreeNode parent, IZTreeNode node);
	public void editNode(ZTreeNode node);
	public void removeNode(ZTreeNode node);
	public void saveTree(ZTreeNode root, File file) throws IOException;
	public void loadTree(ZTreeNode root, File file) throws IOException, FileNotFoundException, ClassNotFoundException;
	public void addObservers(ObserverUpdate o);
}
	