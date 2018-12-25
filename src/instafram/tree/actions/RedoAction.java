package instafram.tree.actions;

import java.awt.event.ActionEvent;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;

public class RedoAction extends ZTreeAbsAction{
	
	public RedoAction(IZTreeController controller, CommandManager manager) {
		super(controller, manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		manager.doCommand();
	}

}
