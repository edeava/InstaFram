package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import instafram.command.AddNodeCommand;
import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Modul;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.Proizvod;
import instafram.treeComponent.view.ParametarEditDialog;
import instafram.view.Application;

public class AddNodeAction extends ZTreeAbsAction{

	public static int i = 1;

	public AddNodeAction(IZTreeController controller, CommandManager manager) {
		super(controller, manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(selectedNode == null)
			selectedNode = (ZTreeNode) controller.getTree().getModel().getRoot();
		
		if(selectedNode.getNode() instanceof Proizvod && !selectedNode.isRoot()) {
			//controller.addNode(selectedNode, new Modul("Modul" + (selectedNode.getChildCount() + 1)));
			manager.addCommand(new AddNodeCommand(controller, selectedNode, new Modul("Modul" + (selectedNode.getChildCount() + 1))));
			manager.doCommand();
		}else if(selectedNode.getNode() instanceof Modul) {
			ParametarEditDialog pD = new ParametarEditDialog();
			pD.setModal(true);
			pD.setVisible(true);
			Parametar p = pD.createParametar("Parametar" + (selectedNode.getChildCount() + 1));
			if(p != null) {
				//controller.addNode(selectedNode, p);
				manager.addCommand(new AddNodeCommand(controller, selectedNode, p));
				manager.doCommand();
			}
		}
		else if(selectedNode.getNode() instanceof Parametar) {
			//nista
		}
		else {
			//controller.addNode(selectedNode, new Proizvod("Proizvod" + AddNodeAction.i++));
			manager.addCommand(new AddNodeCommand(controller, selectedNode, new Proizvod("Proizvod" + AddNodeAction.i++)));
			manager.doCommand();
		}
	}
}
