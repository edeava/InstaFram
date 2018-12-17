package instafram.treeComponent.model;

import java.util.ArrayList;

import instafram.tree.model.IZTreeNode;

public class Parametar implements IZTreeNode{

	private String name;
	private PredefinedParameter gui;
	
	public Parametar(String name) {
		super();
		this.name = name;
	}

	public Parametar(String name, PredefinedParameter gui) {
		super();
		this.name = name;
		this.gui = gui;
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
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public PredefinedParameter getGui() {
		return gui;
	}

	public void setGui(PredefinedParameter gui) {
		this.gui = gui;
	}
}
