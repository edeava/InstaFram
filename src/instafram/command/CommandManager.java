package instafram.command;

import java.util.ArrayList;

public class CommandManager {
	
	private ArrayList<AbsCommand> doCommands = new ArrayList<>();
	private ArrayList<AbsCommand> undoCommands = new ArrayList<>();
	
	public CommandManager() {
		super();
	}
	
	public void addCommand(AbsCommand command) {
		doCommands.add(command);
	}
	
	public void doCommand() {
		if(doCommands.isEmpty())
			return;
		AbsCommand c = doCommands.get(doCommands.size() - 1);
		c.doCommand();
	}
	
	public void undoCommand() {
		if(undoCommands.isEmpty())
			return;
		AbsCommand c = undoCommands.get(undoCommands.size() - 1);
		c.undoCommand();
	}
	
	public void clear() {
		doCommands.clear();
		undoCommands.clear();
	}
}
