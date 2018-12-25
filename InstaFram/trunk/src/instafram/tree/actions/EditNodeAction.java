package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;

public class EditNodeAction extends ZTreeAbsAction implements Observer{


	public EditNodeAction(IZTreeController controller, CommandManager manager) {
		super(controller, manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedNode(ZTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		this.setEnabled(true);
	}
	
}
