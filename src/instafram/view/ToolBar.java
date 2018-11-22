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
	
	public ToolBar(ZTree tree) {
		super(SwingConstants.HORIZONTAL);
		
		btnNew = new JButton();
		btnNew.addActionListener(tree.getActionManager().getAddNode());
		btnNew.setIcon(new ImageIcon("Img/new.png"));
		add(btnNew);
		
		btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("Img/open.jpg"));
		add(btnOpen);
		
		btnClose = new JButton();
		btnClose.setToolTipText("Close");
		btnClose.addActionListener(tree.getActionManager().getRemoveNode());
		btnClose.setIcon(new ImageIcon("Img/close.png"));
		add(btnClose);
		
		btnSwitch = new JButton();
		btnSwitch.setToolTipText("Exit Tab");
		btnSwitch.setIcon(new ImageIcon("Img/switch.png"));
		add(btnSwitch);
		
		addSeparator();
		
		btnSave = new JButton();
		btnSave.setToolTipText("Save");
		btnSave.addActionListener(tree.getActionManager().getSaveAction());
		btnSave.setIcon(new ImageIcon("Img/save.png"));
		add(btnSave);
		
		btnSaveAs = new JButton();
		btnSaveAs.setToolTipText("SaveAs");
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
