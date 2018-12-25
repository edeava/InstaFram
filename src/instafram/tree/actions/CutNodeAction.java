package instafram.tree.actions;

import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Parametar;

public class CutNodeAction extends CopyNodeAction {

	public CutNodeAction(IZTreeController controller, CommandManager manager, Clipboard clipboard) {
		super(controller, manager, clipboard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		super.actionPerformed(arg0);
		
		for (Iterator iterator = selectedNodes.iterator(); iterator.hasNext();) {
			ZTreeNode zTreeNode = (ZTreeNode) iterator.next();
			if(zTreeNode.getNode() instanceof Parametar)
				controller.removeNode(zTreeNode, false);
		}
	}

}
