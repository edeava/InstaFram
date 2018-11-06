package instafram.tree.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.tree.TreePath;

import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;
import instafram.treeComponent.model.Kompanija;

public class ZTreeController implements IZTreeController{

	private ZTree tree;
	
	@Override
	public void setTree(ZTree tree) {
		this.tree = tree;
	}

	@Override
	public void addNode(ZTreeNode parent, IZTreeNode node) {
		ZTreeNode newChild = new ZTreeNode(node);
		tree.getModel().insertNodeInto(newChild, parent, parent.getChildCount());
		parent.addNode(node);
	}

	@Override
	public void editNode(ZTreeNode node) {
		
	}

	@Override
	public void removeNode(ZTreeNode node) {
		ZTreeNode parent = (ZTreeNode) node.getParent();
		parent.removeNode(node.getNode());
		this.tree.getModel().removeNodeFromParent(node);
		this.tree.setSelectionPath(new TreePath(parent.getPath()));
	}

	@Override
	public void saveTree(ZTreeNode root, File file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			Enumeration<ZTreeNode> e = root.preorderEnumeration();
			
			dfs(root, out, new ArrayList<>(), e);
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dfs(ZTreeNode root, BufferedWriter out, ArrayList<ZTreeNode> visited, Enumeration<ZTreeNode> e) throws IOException {
		visited.add(root);
		out.write(root.getNode().getName() + " ");
		
		while(e.hasMoreElements()) {
			ZTreeNode next = (ZTreeNode) e.nextElement();
			if(!visited.contains(next))
				dfs(next, out, visited, next.preorderEnumeration());
		}
		out.write(")");
	}
	
	@Override
	public void loadTree(ZTreeNode root, File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			int flag = in.read();
			char c = (char) flag;
			String komp = "";
			
			while(flag != -1) {
				if(c == ' ') {
					addNode(root, new Kompanija(komp));
					komp = "";
					root = (ZTreeNode) root.getFirstChild();
				}else if(c == ')') {
					root = (ZTreeNode) root.getParent();
				}else {
					komp += c;
				}
				
				flag = in.read();
				c = (char) flag;
			}
			
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ZTree getTree() {
		return tree;
	}
}
