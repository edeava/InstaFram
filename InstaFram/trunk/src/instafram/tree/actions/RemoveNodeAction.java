package instafram.tree.actions;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.view.Application;

public class RemoveNodeAction extends ZTreeAbsAction{

	public RemoveNodeAction(IZTreeController controller, CommandManager manager) {
		super(controller, manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(selectedNode != null && selectedNode.getParent() != null)
			this.controller.removeNode(selectedNode, true);
		else JOptionPane.showMessageDialog(Application.getInstance(), "Nevalidno brisanje");
		
	}	
}
