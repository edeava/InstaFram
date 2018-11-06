package instafram.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import instafram.tree.actions.AddNodeAction;
import instafram.tree.view.ZTree;

public class ToolBar extends JToolBar{

	public ToolBar(ZTree tree) {
		super(SwingConstants.HORIZONTAL);
		
		JButton btnNew = new JButton();
		btnNew.addActionListener(tree.getActionManager().getAddNode());
		btnNew.setIcon(new ImageIcon("Img/new.png"));
		add(btnNew);
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("Img/open.jpg"));
		add(btnOpen);
		
		JButton btnClose = new JButton();
		btnClose.setToolTipText("Close");
		btnClose.addActionListener(tree.getActionManager().getRemoveNode());
		btnClose.setIcon(new ImageIcon("Img/close.png"));
		add(btnClose);
		
		JButton btnSwitch = new JButton();
		btnSwitch.setToolTipText("Switch");
		btnSwitch.setIcon(new ImageIcon("Img/switch.png"));
		add(btnSwitch);
		
		addSeparator();
		
		JButton btnSave = new JButton();
		btnSave.setToolTipText("Save");
		btnSave.addActionListener(tree.getActionManager().getSaveAction());
		btnSave.setIcon(new ImageIcon("Img/save.png"));
		add(btnSave);
		
		JButton btnSaveAs = new JButton();
		btnSaveAs.setToolTipText("SaveAs");
		btnSaveAs.setIcon(new ImageIcon("Img/saveAs.png"));
		add(btnSaveAs);
		
		addSeparator();
		
		JButton btnExit = new JButton();
		btnExit.setToolTipText("Exit");
		btnExit.setIcon(new ImageIcon("Img/exit.png"));
		add(btnExit);
		
		setFloatable(true);
	}

}
