package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Kompanija;
import instafram.view.Application;

public class AddNodeAction extends ZTreeAbsAction{

	public static int i = 1;
	
	public AddNodeAction(IZTreeController controller) {
		super(controller);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(selectedNode != null)
			controller.addNode(selectedNode, new Kompanija("Kompanija" + AddNodeAction.i++));
		else JOptionPane.showMessageDialog(Application.getInstance(), "Nevalidno dodavanje");
	}
}
