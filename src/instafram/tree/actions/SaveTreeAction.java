package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;

public class SaveTreeAction extends ZTreeAbsAction{

	public SaveTreeAction(IZTreeController controller) {
		super(controller);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int approved = chooser.showSaveDialog(null);
		System.out.println(approved == JFileChooser.APPROVE_OPTION);
		if(approved == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		
			if(selectedNode == null)
				selectedNode = (ZTreeNode) controller.getTree().getModel().getRoot();
			
			try {
				controller.saveTree(selectedNode, file);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Fajl ne postoji!");
			}
		}
	}
}
