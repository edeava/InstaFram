package instafram.treeComponent.model;

import java.util.ArrayList;

import instafram.tree.model.IZTreeNode;

public class Konfiguracija implements IZTreeNode{
	private String name;

	public Konfiguracija() {
		name = "Konfiguracija";
	}

	public Konfiguracija(String name) {
		super();
		this.name = name;
	}

	@Override
	public void addNode(IZTreeNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNode(IZTreeNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<IZTreeNode> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return name;
	}
}
