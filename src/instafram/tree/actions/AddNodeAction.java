package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Kompanija;
import instafram.view.Application;

public class AddNodeAction extends ZTreeAbsAction implements Observer{

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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setSelectedNode(ZTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		this.setEnabled(this.selectedNode.getAllowsChildren());
	}
}
