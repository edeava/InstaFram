package instafram.install.view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import instafram.install.model.InstallPackage;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.view.GuiBuilder;

public class InstallView extends JDialog{

	InstallPackage pack;
	
	public InstallView(InstallPackage pack1) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		this.pack = pack1;
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel sidePanel = new JPanel();
		
		JButton next = new JButton("Next");
		JButton cancel = new JButton("Cancel");
		Box box = Box.createHorizontalBox();
		box.add(next);
		box.add(cancel);
		
		mainPanel.add(box, BorderLayout.SOUTH);
		mainPanel.add(sidePanel, BorderLayout.CENTER);
		
		if(pack.getLookNFeel() == 0) {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}else if(pack.getLookNFeel() == 1) {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}else UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		
		setTitle(pack.getAutor());
		setIconImage(new ImageIcon(pack.getLogo()).getImage());
		
		add(mainPanel);
		
		for(Parametar p : pack.getParametri()) {
			sidePanel.removeAll();
			sidePanel.add(GuiBuilder.build(p.getGui(), p));
			this.pack();
		}
		
		setModal(true);
		setVisible(true);
	}
	
	
}
