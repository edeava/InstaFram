package instafram.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import instafram.tree.model.ZTreeNode;
import instafram.view.TabbedPane;

public class RemoveTab extends AbstractAction{
	
	private TabbedPane tab;

	public RemoveTab(TabbedPane tab) {
		super();
		this.tab = tab;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(tab.getSelectedComponent() != null)
			tab.remove(tab.getSelectedComponent());
	}

}
