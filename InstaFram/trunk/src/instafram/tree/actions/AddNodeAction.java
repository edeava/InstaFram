package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Modul;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.Proizvod;
import instafram.view.Application;

public class AddNodeAction extends ZTreeAbsAction{

	public static int i = 1;
	
	public AddNodeAction(IZTreeController controller) {
		super(controller);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(selectedNode == null)
			selectedNode = (ZTreeNode) controller.getTree().getModel().getRoot();
		
		if(selectedNode.getNode() instanceof Proizvod && !selectedNode.isRoot())
			controller.addNode(selectedNode, new Modul("Modul" + AddNodeAction.i++));
		else if(selectedNode.getNode() instanceof Modul)
			controller.addNode(selectedNode, new Parametar("Parametar" + (selectedNode.getChildCount() + 1)));
		else
			controller.addNode(selectedNode, new Proizvod("Proizvod" + AddNodeAction.i++));
	}
}
