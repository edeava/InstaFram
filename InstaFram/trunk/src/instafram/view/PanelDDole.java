package instafram.view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import instafram.actions.InstallAction;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ObserverUpdate;
import instafram.tree.model.ZTreeNode;
import instafram.treeComponent.model.Parametar;

public class PanelDDole extends JPanel implements ObserverUpdate{

	private JLabel lbIme = new JLabel();
	private JLabel lbRoditelj = new JLabel();
	private JLabel lbBrDece = new JLabel();
	private JLabel lbBrListova = new JLabel();
	private JLabel lbGui = new JLabel();
	

	public PanelDDole() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(lbIme);
		add(lbRoditelj);
		add(lbBrDece);
		add(lbBrListova);
		add(lbGui);
		JButton btnInstall = new JButton("Install");
		btnInstall.addActionListener(new InstallAction());
		add(btnInstall);
	}



	@Override
	public void onUpdate(ZTreeNode node) {
		lbIme.setText("Ime:\t" + node.getNode().getName());
		lbRoditelj.setText("Roditelj: " + node.getParent());
		if(node.getNode() instanceof Parametar)
			lbGui.setText("GUI: " + ((Parametar) node.getNode()).getGui());
		else lbGui.setText("");
		lbBrDece.setText("Broj dece: " + node.getChildCount());
		lbBrListova.setText("Broj listova: " + ZTreeController.dfs(node, new ArrayList<>(), node.preorderEnumeration(), 0));
		
	}
	
	
}
