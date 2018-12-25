package instafram.tree.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import instafram.command.AddNodeCommand;
import instafram.command.CommandManager;
import instafram.command.RemoveNodeCommand;
import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;

public class ZTreeController implements IZTreeController{

	private ZTree tree;
	private ArrayList<ObserverUpdate> observers = new ArrayList<>();
	private boolean changed = true;
	private CommandManager manager = new CommandManager();
	
	@Override
	public void setTree(ZTree tree) {
		this.tree = tree;
	}

	@Override
	public void addNode(ZTreeNode parent, IZTreeNode node) {
		ZTreeNode newChild = new ZTreeNode(node);
		
		for(ObserverUpdate o : observers)
			if(!newChild.getObservers().contains(o))
				newChild.addObserver(o);
		
		tree.getModel().insertNodeInto(newChild, parent, parent.getChildCount());
		parent.addNode(node);
		changed = true;
	}
	
	public void addCmdNode(ZTreeNode parent, ZTreeNode node) {
		for(ObserverUpdate o : observers)
			if(!node.getObservers().contains(o))
				node.addObserver(o);
		
		tree.getModel().insertNodeInto(node, parent, parent.getChildCount());
		changed = true;
	}

	@Override
	public void editNode(ZTreeNode node) {
		
	}

	@Override
	public void removeNode(ZTreeNode node, boolean msg) {
		ZTreeNode parent = (ZTreeNode) node.getParent();
		
		int brL = 0;
		Enumeration<ZTreeNode> e = node.preorderEnumeration();
		brL = dfs(node, new ArrayList<>(), e, brL);
		
		if(!msg || Application.option("Brisete cvor sa " + brL + " listova, i " +
				node.getChildCount() + " deteta.\nDa li ste sugurni?", "Paznja") == JOptionPane.YES_OPTION) {
		
			//parent.removeNode(node.getNode());
			this.tree.getModel().removeNodeFromParent(node);
			this.tree.setSelectionPath(new TreePath(parent.getPath()));
			changed = true;
		}
	}

	@Override
	public void saveTree(ZTreeNode root, File file) throws IOException, FileNotFoundException{
		if(!changed)
			return;
		if(file == null)
			return;
		
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
		//dfs(root, out, new ArrayList<>(), e);
		
		out.writeUnshared(root);
		
		out.close();
		fileOut.close();
		changed = true;
	}
	
	public static int dfs(ZTreeNode root, ArrayList<ZTreeNode> visited, Enumeration<ZTreeNode> e, int brListova) {
		visited.add(root);
		
		while(e.hasMoreElements()) {
			ZTreeNode next = (ZTreeNode) e.nextElement();
			if(next.isLeaf())
				brListova++;
			int tmp;
			if(!visited.contains(next))
				dfs(next, visited, next.preorderEnumeration(), brListova);
			
		}
		return brListova;
	}

	public static void dfs(ZTreeNode root, ArrayList<ObserverUpdate> observers, ArrayList<ZTreeNode> visited, Enumeration<ZTreeNode> e) {
		visited.add(root);
		for(ObserverUpdate o : observers)
			root.addObserver(o);
		
		while(e.hasMoreElements()) {
			ZTreeNode next = (ZTreeNode) e.nextElement();
			if(!visited.contains(next))
				dfs(next, observers, visited, next.preorderEnumeration());
		}
	}
	
	@Override
	public void loadTree(ZTreeNode root, File file) throws IOException, FileNotFoundException, ClassNotFoundException{

		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		observers.addAll(root.getObservers());
			
		try{
			ZTreeNode tmp = (ZTreeNode) in.readUnshared();
			root = new ZTreeNode(tmp);
			
			Enumeration<ZTreeNode> e = root.preorderEnumeration();
			dfs(root, observers, new ArrayList<ZTreeNode>(), e);
			
			getTree().setRoot(root);
			this.tree.setSelectionPath(new TreePath(root.getPath()));
			this.getTree().update();
			getTree().getModel().reload();
			
		}finally {
			
			in.close();
			fileIn.close();
		}
	}

	@Override
	public ZTree getTree() {
		return tree;
	}
	
	public void addObservers(ObserverUpdate o) {
		observers.add(o);
	}
}
