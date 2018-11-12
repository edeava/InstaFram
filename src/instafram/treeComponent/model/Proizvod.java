package instafram.treeComponent.model;

import java.util.ArrayList;

import instafram.tree.model.IZTreeNode;

public class Proizvod implements IZTreeNode{

	private String name;
	
	public Proizvod() {
		this.name = "Proizvod";
	}

	
	public Proizvod(String name) {
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
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return name;
	}
	
	

}
