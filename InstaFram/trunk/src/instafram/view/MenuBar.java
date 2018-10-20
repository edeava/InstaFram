package instafram.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	public MenuBar() {
		super();

		JMenu file = new JMenu("File");
		JMenuItem mNew = new JMenuItem("mNew");
		
		JMenuItem mOpen = new JMenuItem("mOpen");
		JMenuItem mClose = new JMenuItem("mClose");
		JMenuItem mSwitch = new JMenuItem("mSwitch");
		
		JMenuItem mSave = new JMenuItem("mSave");
		JMenuItem mSaveAs = new JMenuItem("mSave");
		
		JMenu mExport = new JMenu("mExport");
		JMenuItem mExpToPdf = new JMenuItem("mExpToPdf");
		JMenuItem mExpToMsExcell = new JMenuItem("mExpToMsExcell");
		JMenuItem mExpToMsWord = new JMenuItem("mExpToMsWord");
		
		mExport.add(mExpToPdf);
		mExport.add(mExpToMsExcell);
		mExport.add(mExpToMsWord);
		
		JMenu mImport = new JMenu("mImport");
		JMenuItem mImpToPdf = new JMenuItem("mImpToPdf");
		JMenuItem mImpToMsExcell = new JMenuItem("mImpToMsExcell");
		JMenuItem mImpToMsWord = new JMenuItem("mImpToMsWord");
		
		mImport.add(mImpToPdf);
		mImport.add(mImpToMsExcell);
		mImport.add(mImpToMsWord);
		
		JMenuItem mExit = new JMenuItem("mExit");
		
		
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
		
		add(file);
		add(view);
		add(tools);
	}
	
	
	
}
