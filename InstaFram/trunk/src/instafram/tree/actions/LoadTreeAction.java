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
import instafram.treeComponent.model.Proizvod;

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
		
			try {
				if(selectedNode == null)
					selectedNode = (ZTreeNode) controller.getTree().getModel().getRoot();
				
				while(!(selectedNode.getNode() instanceof Proizvod))
					selectedNode = (ZTreeNode) selectedNode.getParent();
				
				controller.loadTree(selectedNode, file);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Fajl ne postoji!");
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Klasa ne postoji!");
			}
		}
	}

}
