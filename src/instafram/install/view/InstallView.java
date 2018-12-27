package instafram.install.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import instafram.install.model.InstallPackage;
import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.PredefinedParameter;
import instafram.treeComponent.view.GuiBuilder;

public class InstallView extends JDialog{

	private InstallPackage pack;
	private int cursor = 0;
	private boolean shortcut = false;
	private boolean run = false;
	
	public InstallView(InstallPackage pack1) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		this.pack = pack1;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrSize = kit.getScreenSize();
		setSize(scrSize.width / 2, scrSize.height / 2);
		
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
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
				if(GuiBuilder.parametar != null) {
					if(GuiBuilder.parametar.getGui() == PredefinedParameter.DESKTOP_SHORTCUT) {
						int indeks = GuiBuilder.parametar.getVrednost().lastIndexOf("|");
						shortcut = Boolean.parseBoolean(GuiBuilder.parametar.getVrednost().substring(indeks + 1, GuiBuilder.parametar.getVrednost().length()));
					}
					if(GuiBuilder.parametar.getGui() == PredefinedParameter.RUN_AFTER_FINISH) {
						int indeks = GuiBuilder.parametar.getVrednost().lastIndexOf("|");
						String string = GuiBuilder.parametar.getVrednost().substring(indeks + 1, GuiBuilder.parametar.getVrednost().length());
						boolean trt = Boolean.parseBoolean(string);
						run = trt;
					}
				}
				
				if(cursor > pack.getParametri().size() - 1) {
					try {
						end();
					} catch (IOException e1) {
						
					}
					setVisible(false);
					dispose();
					cursor--;
				}
				
				Parametar p = pack.getParametri().get(cursor);
				sidePanel.removeAll();
				sidePanel.add(GuiBuilder.build(p.getGui(), p));
				
				cursor++;
				
				sidePanel.updateUI();
				//revalidate();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}
	
	public void end() throws IOException {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = null;
		int approved = chooser.showOpenDialog(null);
		System.out.println(approved == JFileChooser.APPROVE_OPTION);
		if(approved == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			Files.copy(new File(pack.getSource()).toPath(), new File(file.getPath() + pack.getSource().substring(pack.getSource().lastIndexOf("\\"), pack.getSource().length())).toPath());
		}
		if(shortcut) {
			Files.copy(new File(pack.getSource()).toPath(), new File(System.getProperty("user.home") + "/Desktop" + pack.getSource().substring(pack.getSource().lastIndexOf("\\"), pack.getSource().length())).toPath());
		}
		if(run)
			Desktop.getDesktop().open(new File(pack.getSource()));
	}
}
