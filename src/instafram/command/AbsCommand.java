package instafram.command;

import instafram.tree.controller.IZTreeController;
import instafram.tree.controller.ZTreeController;

public abstract class AbsCommand {
	
	protected IZTreeController controller;
	
	public AbsCommand(IZTreeController controller) {
		super();
		this.controller = controller;
	}
	
	public IZTreeController getController() {
		return controller;
	}


	public void setController(IZTreeController controller) {
		this.controller = controller;
	}

	public abstract void doCommand();
	public abstract void undoCommand();
	
}
