package instafram.tree.model;

import java.util.ArrayList;
import java.util.Observer;

import javax.swing.tree.DefaultMutableTreeNode;

import instafram.view.PanelO;

public class ZTreeNode extends DefaultMutableTreeNode implements ObserverUpdate, Observable{
	
	private ArrayList<ObserverUpdate> observers = new ArrayList<>();
	private IZTreeNode node;
	
	public ZTreeNode(IZTreeNode node) {
		super();
		this.node = node;
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
		for(ObserverUpdate o : observers) {
			o.notify();
		}
	}

	@Override
	public void addObserver(ObserverUpdate o) {
		observers.add(o);
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}
}
