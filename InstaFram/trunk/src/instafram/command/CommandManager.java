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
		doCommands.remove(c);
		undoCommands.add(c);
		c.doCommand();
	}
	
	public void undoCommand() {
		if(undoCommands.isEmpty())
			return;
		AbsCommand c = undoCommands.get(undoCommands.size() - 1);
		undoCommands.remove(c);
		doCommands.add(c);
		c.undoCommand();
	}
	
	public void clear() {
		doCommands.removeAll(doCommands);
		undoCommands.removeAll(undoCommands);
	}
}
