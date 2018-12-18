package instafram.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import instafram.actions.RemoveTab;
import instafram.tree.actions.AddNodeAction;
import instafram.tree.view.ZTree;

public class ToolBar extends JToolBar{

	private JButton btnNew;
	private JButton btnOpen;
	private JButton btnClose;
	private JButton btnSwitch;
	private JButton btnSave;
	private JButton btnSaveAs;
	private JButton btnExit;
	
	public ToolBar(ZTree tree, String korisnik) {
		super(SwingConstants.HORIZONTAL);
		
		btnNew = new JButton();
		btnNew.addActionListener(tree.getActionManager().getAddNode());
		btnNew.setIcon(new ImageIcon("Img/new.png"));
		add(btnNew);
		if(korisnik.equals("konfigurator"))
			btnNew.setEnabled(false);
		
		btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("Img/open.jpg"));
		add(btnOpen);
		
		btnClose = new JButton();
		btnClose.setToolTipText("Close");
		btnClose.addActionListener(tree.getActionManager().getRemoveNode());
		btnClose.setIcon(new ImageIcon("Img/close.png"));
		add(btnClose);
		if(korisnik.equals("konfigurator"))
			btnClose.setEnabled(false);
		
		btnSwitch = new JButton();
		btnSwitch.setToolTipText("Exit Tab");
		btnSwitch.setIcon(new ImageIcon("Img/switch.png"));
		add(btnSwitch);
		
		addSeparator();
		
		JButton btnCopy = new JButton();
		btnCopy.setToolTipText("Copy Nodes");
		btnCopy.setIcon(new ImageIcon("Img/copy.png"));
		add(btnCopy);
		if(korisnik.equals("konfigurator"))
			btnCopy.setEnabled(false);
		
		JButton btnCut = new JButton();
		btnCut.setToolTipText("Cut Nodes");
		btnCut.setIcon(new ImageIcon("Img/cut.png"));
		add(btnCut);
		if(korisnik.equals("konfigurator"))
			btnCut.setEnabled(false);
		
		JButton btnPaste = new JButton();
		btnPaste.setToolTipText("Paste Nodes");
		btnPaste.setIcon(new ImageIcon("Img/paste.png"));
		add(btnPaste);
		if(korisnik.equals("konfigurator"))
			btnPaste.setEnabled(false);
		
		addSeparator();
		
		btnSave = new JButton();
		btnSave.setToolTipText("Save");
		btnSave.addActionListener(tree.getActionManager().getSaveAction());
		btnSave.setIcon(new ImageIcon("Img/save.png"));
		add(btnSave);
		
		btnSaveAs = new JButton();
		btnSaveAs.setToolTipText("SaveAs");
		btnSaveAs.addActionListener(tree.getActionManager().getSaveAs());
		btnSaveAs.setIcon(new ImageIcon("Img/saveAs.png"));
		add(btnSaveAs);
		
		addSeparator();
		
		btnExit = new JButton();
		btnExit.setToolTipText("Exit");
		btnExit.setIcon(new ImageIcon("Img/exit.png"));
		add(btnExit);
		
		setFloatable(true);
	}

	public void setRemoveAction(TabbedPane tab) {
		btnSwitch.addActionListener(new RemoveTab(tab));
	}
}
