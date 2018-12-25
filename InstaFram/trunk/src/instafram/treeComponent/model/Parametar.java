package instafram.treeComponent.model;

import java.util.ArrayList;

import instafram.tree.model.IZTreeNode;

public class Parametar implements IZTreeNode{

	private String name;
	private PredefinedParameter gui;
	private String vrednost = "";
	
	public Parametar(String name) {
		super();
		this.name = name;
	}

	public Parametar(Parametar parametar) {
		this.name = parametar.getName();
		this.gui = parametar.getGui();
		this.vrednost = parametar.getVrednost();
	}
	
	public Parametar(String name, PredefinedParameter gui) {
		super();
		this.name = name;
		this.gui = gui;
	}

	public Parametar(String name, PredefinedParameter gui, String vrednost) {
		super();
		this.name = name;
		this.gui = gui;
		this.vrednost = vrednost;
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

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
}
