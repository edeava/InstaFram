package instafram.tree.actions;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import instafram.tree.controller.IZTreeController;
import instafram.tree.model.TreeElementSelection;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Modul;
import instafram.treeComponent.model.Parametar;
import instafram.view.Application;

public class PasteNodeAction extends ZTreeAbsAction{

	private Clipboard clipboard;
	
	public PasteNodeAction(IZTreeController controller, Clipboard clipboard) {
		super(controller);
		this.clipboard = clipboard;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		TreeElementSelection selected = (TreeElementSelection) clipboard.getContents(Application.getInstance());
		if(selected == null || !selected.isDataFlavorSupported(TreeElementSelection.flavor))
			return;
		
		ZTreeNode node = null;
		ArrayList<ZTreeNode> tmpElements;
		try {
			if(!(selectedNode.getNode() instanceof Modul))
				throw new ClassNotFoundException();
			
			tmpElements = (ArrayList<ZTreeNode>) selected.getTransferData(TreeElementSelection.flavor);
			int n = tmpElements.size();
			
			for (int i = 0; i < n; i++) {
				if(tmpElements.get(i).getNode() instanceof Parametar) {
					ZTreeNode tmpNode = new ZTreeNode(tmpElements.get(i));
					controller.addNode(selectedNode, tmpNode.getNode());
				}
			}
		} catch (UnsupportedFlavorException | IOException e) {
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Mozete dodati parametre samo Modulu");
		}
		
	}

	

}
