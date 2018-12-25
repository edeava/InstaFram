package instafram.tree.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import instafram.command.CommandManager;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Proizvod;

public class SaveTreeAction extends ZTreeAbsAction{

	private File file;
	

	public SaveTreeAction(IZTreeController controller, CommandManager manager) {
		super(controller, manager);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(file == null) {
			JFileChooser chooser = new JFileChooser();
			int approved = chooser.showSaveDialog(null);
			System.out.println(approved == JFileChooser.APPROVE_OPTION);
			if(approved == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();	
			}
			
		}
		
		selectedNode = (ZTreeNode) controller.getTree().getModel().getRoot();
		
		while(!(selectedNode.getNode() instanceof Proizvod))
			selectedNode = (ZTreeNode) selectedNode.getParent();
		
		try {
			controller.saveTree(selectedNode, file);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Fajl ne postoji!");
		}
	}
}
