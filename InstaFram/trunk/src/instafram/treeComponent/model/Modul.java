package instafram.treeComponent.model;

import java.util.ArrayList;

import instafram.tree.model.IZTreeNode;

public class Modul implements IZTreeNode{

	private String name;
	private String sadrzaj;

	public Modul(String name) {
		super();
		this.name = name;
		this.sadrzaj = "Sadrzaj";
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
	public String getSadrzaj() {
		return this.sadrzaj;
	}

	@Override
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
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
