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

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import instafram.tree.model.IZTreeNode;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;

public class ZTreeController implements IZTreeController{

	private ZTree tree;
	private ArrayList<ObserverUpdate> observers = new ArrayList<>();
	private boolean changed = true;
	
	@Override
	public void setTree(ZTree tree) {
		this.tree = tree;
	}

	@Override
	public void addNode(ZTreeNode parent, IZTreeNode node) {
		ZTreeNode newChild = new ZTreeNode(node);
		for(ObserverUpdate o : observers)
			newChild.addObserver(o);
		
		tree.getModel().insertNodeInto(newChild, parent, parent.getChildCount());
		parent.addNode(node);
		changed = true;
	}

	@Override
	public void editNode(ZTreeNode node) {
		
	}

	@Override
	public void removeNode(ZTreeNode node) {
		ZTreeNode parent = (ZTreeNode) node.getParent();
		
		int brL = 0;
		Enumeration<ZTreeNode> e = node.preorderEnumeration();
		brL = dfs(node, new ArrayList<>(), e, brL);
		
		if(Application.option("Brisete cvor sa " + brL + " listova, i " +
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
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		Enumeration<ZTreeNode> e = root.preorderEnumeration();
			
		dfs(root, out, new ArrayList<>(), e);
			
		out.close();
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

	public static void dfs(ZTreeNode root, BufferedWriter out, ArrayList<ZTreeNode> visited, Enumeration<ZTreeNode> e) throws IOException {
		visited.add(root);
		out.write(root.getNode().getName() + "{" + "}" + "ð");
		
		while(e.hasMoreElements()) {
			ZTreeNode next = (ZTreeNode) e.nextElement();
			if(!visited.contains(next))
				dfs(next, out, visited, next.preorderEnumeration());
		}
		out.write(")");
	}
	
	@Override
	public void loadTree(ZTreeNode root, File file) throws IOException, FileNotFoundException{

		BufferedReader in = new BufferedReader(new FileReader(file));
		int flag = in.read();
		ArrayList<ZTreeNode> visited = new ArrayList<>();
		boolean tick = false;
		char c = (char) flag;
		String komp = "", sad = "";
			
		while(flag != -1) {
			if(c == 'ð') {
				if(root == null) {
					root = new ZTreeNode(new Proizvod(komp, sad));
					for(ObserverUpdate o : observers)
						root.addObserver(o);
					tree.setRoot(root);
					visited.add(root);
				}
				else { 
					addNode(root, (IZTreeNode) new Proizvod(komp, sad));
					while(visited.contains(root))
						root = (ZTreeNode) root.getNextNode();
					visited.add(root);
				}
				komp = "";
				sad = "";
				
			}else if(c == ')') {
				root = (ZTreeNode) root.getParent();
			}else if(c == '{') {
				tick = true;
			}else if(c == '}'){
				tick = false;
			}else if(!tick){		
				komp += c;
			}else sad += c;
				
			flag = in.read();
			c = (char) flag;
		}
			
			
		in.close();
	}

	@Override
	public ZTree getTree() {
		return tree;
	}
	
	public void addObservers(ObserverUpdate o) {
		observers.add(o);
	}
}
