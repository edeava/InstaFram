package instafram.command;

import instafram.tree.controller.ZTreeController;

public abstract class AbsCommand {
	
	protected ZTreeController controller;
	
	public AbsCommand(ZTreeController controller) {
		super();
		this.controller = controller;
	}
	
	public ZTreeController getController() {
		return controller;
	}


	public void setController(ZTreeController controller) {
		this.controller = controller;
	}

	public abstract void doCommand();
	public abstract void undoCommand();
	
}
