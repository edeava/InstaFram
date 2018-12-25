package instafram.tree.actions;

import java.awt.event.ActionEvent;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;

public class UndoAction extends ZTreeAbsAction{
	
	public UndoAction(IZTreeController controller, CommandManager manager) {
		super(controller, manager);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		manager.undoCommand();
	}

}
