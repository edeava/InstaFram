package instafram.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;

import javax.net.ssl.StandardConstants;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import instafram.command.CommandManager;
import instafram.install.InstallPackage;
import instafram.tree.actions.ZTreeAbsAction;
import instafram.tree.controller.IZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Modul;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.PredefinedParameter;
import instafram.treeComponent.model.Proizvod;

public class ExportAction extends ZTreeAbsAction{

	private File file;
	
	
	public ExportAction(IZTreeController controller, CommandManager manager) {
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
		
		if(!(selectedNode.getNode() instanceof Modul)) {
			JOptionPane.showMessageDialog(null, "Odaberite modul!");
			return;
		}
		
		int n = selectedNode.getChildCount(), look = 0;
		String logo = null;
		ArrayList<Parametar> parametri = new ArrayList<>();
		String source = null, autor = null;
		
		for (int i = 0; i < n; i++) {
			Parametar p = (Parametar) ((ZTreeNode) selectedNode.getChildAt(i)).getNode();
			if(p.getGui() == PredefinedParameter.LOOK_AND_FEEL)
				look = Integer.parseInt(p.getVrednost().substring(p.getVrednost().lastIndexOf('|') + 1));
			
			else if(p.getGui() == PredefinedParameter.LOGO)
				logo = p.getVrednost().substring(p.getVrednost().lastIndexOf('/') + 1);
			
			else if(p.getGui() == PredefinedParameter.PATH)
				source = p.getVrednost().substring(p.getVrednost().lastIndexOf('/') + 1);
			
			else if(p.getGui() == PredefinedParameter.AUTHOR)
				autor = p.getVrednost().substring(p.getVrednost().lastIndexOf('|') + 1);
			else parametri.add(p);
		}
		
		//InstallPackage pack = new InstallPackage(logo, look, parametri, source, autor);
		
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			InstallPackage pack = new InstallPackage(logo, look, parametri, source, autor);
			
			out.writeUnshared(pack);
			
			Files.copy(new File(logo).toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Files.copy(new File(source).toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			out.close();
			fileOut.close();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Fajl ne postoji!");
		}
	}
}
