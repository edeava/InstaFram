package instafram.tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import instafram.treeComponent.model.Parametar;

public class ZTreeNode extends DefaultMutableTreeNode implements Observable, Serializable{
	
	private static final long serialversionUID = 129348938L;
	private transient ArrayList<ObserverUpdate> observers = new ArrayList<>();
	private IZTreeNode node;
	
	public ZTreeNode(IZTreeNode node) {
		super();
		this.node = node;
	}
	
	public ZTreeNode(ZTreeNode clone) {
		this.node = clone.node;
		int n = clone.getChildCount();
		for (int i = 0; i < n; i++) {
			this.insert((MutableTreeNode) clone.getChildAt(0), i);
		}
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

	@Override
	public void setUserObject(Object arg0) {
		if(arg0 instanceof String)
			node.setName((String) arg0);
	}

	@Override
	public void notifyObserver() {
		if(observers == null)
			return;
		for(ObserverUpdate o : observers) {
			o.onUpdate(this);
		}
	}

	@Override
	public void addObserver(ObserverUpdate o) {
		if(observers == null)
			observers = new ArrayList<>();
		observers.add(o);
	}
	
	public void setName(String name) {
		this.node.setName(name);
		notifyObserver();
	}

	public ArrayList<ObserverUpdate> getObservers() {
		return observers;
	}
}
