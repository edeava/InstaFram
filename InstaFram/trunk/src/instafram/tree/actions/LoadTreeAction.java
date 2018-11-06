package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;

public class LoadTreeAction extends ZTreeAbsAction{

	public LoadTreeAction(IZTreeController controller) {
		super(controller);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int approved = chooser.showOpenDialog(null);
		System.out.println(approved == JFileChooser.APPROVE_OPTION);
		if(approved == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		
			if(selectedNode != null)
				controller.loadTree(selectedNode, file);
		}
	}

}
