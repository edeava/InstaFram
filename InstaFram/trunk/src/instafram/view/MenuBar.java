package instafram.view;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	public MenuBar() {
		super();

		JMenu file = new JMenu("File");
		JMenuItem mNew = new JMenuItem("mNew");
		mNew.setIcon(new ImageIcon("Img/new.png"));
		
		JMenuItem mOpen = new JMenuItem("mOpen");
		mOpen.setIcon(new ImageIcon("Img/open.jpg"));
		JMenuItem mClose = new JMenuItem("mClose");
		mClose.setIcon(new ImageIcon("Img/close.png"));
		JMenuItem mSwitch = new JMenuItem("mSwitch");
		mSwitch.setIcon(new ImageIcon("Img/switch.png"));
		
		JMenuItem mSave = new JMenuItem("mSave");
		mSave.setIcon(new ImageIcon("Img/save.png"));
		JMenuItem mSaveAs = new JMenuItem("mSave");
		mSaveAs.setIcon(new ImageIcon("Img/saveAs.png"));
		
		JMenu mExport = new JMenu("mExport");
		JMenuItem mExpToPdf = new JMenuItem("mExpToPdf");
		mExpToPdf.setIcon(new ImageIcon("Img/pdf.png"));
		JMenuItem mExpToMsExcell = new JMenuItem("mExpToMsExcell");
		mExpToMsExcell.setIcon(new ImageIcon("Img/excell.png"));
		JMenuItem mExpToMsWord = new JMenuItem("mExpToMsWord");
		mExpToMsWord.setIcon(new ImageIcon("Img/word.png"));
		
		mExport.add(mExpToPdf);
		mExport.add(mExpToMsExcell);
		mExport.add(mExpToMsWord);
		mExport.setIcon(new ImageIcon("Img/export.png"));
		
		JMenu mImport = new JMenu("mImport");
		JMenuItem mImpToPdf = new JMenuItem("mImpToPdf");
		mImpToPdf.setIcon(new ImageIcon("Img/pdf.png"));
		JMenuItem mImpToMsExcell = new JMenuItem("mImpToMsExcell");
		mImpToMsExcell.setIcon(new ImageIcon("Img/excell.png"));
		JMenuItem mImpToMsWord = new JMenuItem("mImpToMsWord");
		mImpToMsWord.setIcon(new ImageIcon("Img/word.png"));
		
		mImport.add(mImpToPdf);
		mImport.add(mImpToMsExcell);
		mImport.add(mImpToMsWord);
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
		JMenu tools = new JMenu("Tools");
		JMenu parametrizacija = new JMenu("Parametrizacija");
		JMenu pomoc = new JMenu("Pomoc");
		JMenu about = new JMenu("About");
		
		add(file);
		add(view);
		add(tools);
		add(Box.createHorizontalGlue());
		add(parametrizacija);
		add(pomoc);
		add(about);
	}
	
	
	
}
