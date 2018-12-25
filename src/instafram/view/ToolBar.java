package instafram.view;

import java.awt.Event;
import java.awt.datatransfer.Clipboard;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import instafram.actions.RemoveTab;
import instafram.tree.actions.AddNodeAction;
import instafram.tree.actions.CopyNodeAction;
import instafram.tree.actions.PasteNodeAction;
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
		if(korisnik.equals("student"))
			btnNew.setEnabled(false);
		
		btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("Img/open.jpg"));
		btnOpen.addActionListener(tree.getActionManager().getLoadAction());
		add(btnOpen);
		
		btnClose = new JButton();
		btnClose.setToolTipText("Close");
		btnClose.addActionListener(tree.getActionManager().getRemoveNode());
		btnClose.setIcon(new ImageIcon("Img/close.png"));
		add(btnClose);
		if(korisnik.equals("student"))
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
		btnCopy.addActionListener(tree.getActionManager().getCopy());
		if(korisnik.equals("student"))
			btnCopy.setEnabled(false);
		
		JButton btnCut = new JButton();
		btnCut.setToolTipText("Cut Nodes");
		btnCut.setIcon(new ImageIcon("Img/cut.png"));
		btnCut.addActionListener(tree.getActionManager().getCut());
		add(btnCut);
		if(korisnik.equals("student"))
			btnCut.setEnabled(false);
		
		JButton btnPaste = new JButton();
		btnPaste.setToolTipText("Paste Nodes");
		btnPaste.setIcon(new ImageIcon("Img/paste.png"));
		btnPaste.addActionListener(tree.getActionManager().getPaste());
		add(btnPaste);
		if(korisnik.equals("student"))
			btnPaste.setEnabled(false);
		
		addSeparator();
		
		btnSave = new JButton();
		btnSave.setToolTipText("Save");
		if(korisnik.equals("admin"))
			btnSave.addActionListener(tree.getActionManager().getSaveAction());
		else if(korisnik.equals("student"))
			btnSave.addActionListener(tree.getActionManager().getExport());
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
