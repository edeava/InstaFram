package instafram.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import instafram.actions.AboutAction;
import instafram.tree.view.ZTree;

public class MenuBar extends JMenuBar{

	public MenuBar(ZTree tree) {
		super();

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
			
		JMenuItem mNew = new JMenuItem("mNew");
		mNew.setIcon(new ImageIcon("Img/new.png"));
		mNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.VK_ALT));
		
		JMenuItem mOpen = new JMenuItem("mOpen");
		mOpen.setIcon(new ImageIcon("Img/open.jpg"));
		mOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.VK_ALT));
		JMenuItem mClose = new JMenuItem("mClose");
		mClose.setIcon(new ImageIcon("Img/close.png"));
		mClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.VK_ALT));
		JMenuItem mSwitch = new JMenuItem("mSwitch");
		mSwitch.setIcon(new ImageIcon("Img/switch.png"));
		mSwitch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.VK_ALT));
		
		JMenuItem mSave = new JMenuItem("mSave");
		mSave.setIcon(new ImageIcon("Img/save.png"));
		mSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.VK_ALT));
		JMenuItem mSaveAs = new JMenuItem("mSave");
		mSaveAs.setIcon(new ImageIcon("Img/saveAs.png"));
		mSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.VK_ALT));
		
		JMenu mExport = new JMenu("mExport");
		JMenuItem mExpToPdf = new JMenuItem("mExpToPdf");
		mExpToPdf.setIcon(new ImageIcon("Img/pdf.png"));
		mExpToPdf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.VK_ALT));
		JMenuItem mExpToMsExcell = new JMenuItem("mExpToMsExcell");
		mExpToMsExcell.setIcon(new ImageIcon("Img/excell.png"));
		mExpToMsExcell.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.VK_ALT));
		JMenuItem mExpToMsWord = new JMenuItem("mExpToMsWord");
		mExpToMsWord.setIcon(new ImageIcon("Img/word.png"));
		mExpToMsWord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.VK_ALT));
		
		mExport.add(mExpToPdf);
		mExport.add(mExpToMsExcell);
		mExport.add(mExpToMsWord);
		mExport.setIcon(new ImageIcon("Img/export.png"));
		
		JMenuItem mImport = new JMenuItem("mImport");
		mImport.addActionListener(tree.getActionManager().getLoadAction());
		mImport.setIcon(new ImageIcon("Img/import.png"));
		
		JMenuItem mExit = new JMenuItem("mExit");
		mExit.setIcon(new ImageIcon("Img/exit.png"));
		
		file.add(mNew);
		file.addSeparator();
		
		file.add(mOpen);
		file.add(mClose);
		file.add(mSwitch);
		file.addSeparator();
		
		file.add(mSave);
		file.add(mSaveAs);
		file.addSeparator();
		
		file.add(mExport);
		file.add(mImport);
		file.addSeparator();
		
		file.add(mExit);
		
		JMenu view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		JMenu tools = new JMenu("Tools");
		tools.setMnemonic(KeyEvent.VK_T);
		JMenu parametrizacija = new JMenu("Parametrizacija");
		JMenu pomoc = new JMenu("Pomoc");
		JMenu about = new JMenu("About");
		
		JMenuItem aboutMe = new JMenuItem("About Developer");
		aboutMe.addActionListener(new AboutAction());
		about.add(aboutMe);
		
		add(file);
		add(view);
		add(tools);
		add(Box.createHorizontalGlue());
		add(parametrizacija);
		add(pomoc);
		add(about);
	}
	
	
	
}
