package instafram.view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;

public class PanelDDole extends JPanel implements ObserverUpdate{

	private JLabel lbIme = new JLabel();
	private JLabel lbSadrzaj = new JLabel();
	private JLabel lbRoditelj = new JLabel();
	private JLabel lbBrDece = new JLabel();
	private JLabel lbBrListova = new JLabel();
	
	

	public PanelDDole() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(lbIme);
		add(lbSadrzaj);
		add(lbRoditelj);
		add(lbBrDece);
		add(lbBrListova);
	}



	@Override
	public void onUpdate(ZTreeNode node) {
		lbIme.setText("Ime:\t" + node.getNode().getName());
		lbSadrzaj.setText("Sadrzaj: " + node.getNode().getSadrzaj());
		lbRoditelj.setText("Roditelj: " + node.getParent());
		lbBrDece.setText("Broj dece: " + node.getChildCount());
		lbBrListova.setText("Broj listova: " + ZTreeController.dfs(node, new ArrayList<>(), node.preorderEnumeration(), 0));
		
	}
	
	
}
