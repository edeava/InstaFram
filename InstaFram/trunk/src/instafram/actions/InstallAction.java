package instafram.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import instafram.install.model.InstallPackage;
import instafram.install.view.InstallView;

public class InstallAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int approved = chooser.showOpenDialog(null);
		System.out.println(approved == JFileChooser.APPROVE_OPTION);
		if(approved == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			
			FileInputStream fileIn;
			try {
				fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				
				InstallPackage pack = (InstallPackage) in.readUnshared();
				
				try {
					InstallView install = new InstallView(pack);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					;
				}
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Fajl ne postoji");
			} catch (ClassNotFoundException e1) {
				
			}
		}
	}

}
