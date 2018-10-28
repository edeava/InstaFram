package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class InstaPanel extends JPanel{

	public InstaPanel(Dimension scrSize) {
		PanelDG desnoGore = new PanelDG();
		desnoGore.setPreferredSize(new Dimension(scrSize.width / 4 - 25, scrSize.height / 4 - 75));
		
		PanelDD desnoDole = new PanelDD();
		desnoDole.setPreferredSize(new Dimension(scrSize.width / 4 - 25, scrSize.height / 4 - 75));
		
		PanelL levo = new PanelL();
		levo.setPreferredSize(new Dimension(scrSize.width / 4 - 25, scrSize.height / 2 - 150));
		
		JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, desnoGore, desnoDole);
		sp1.setDividerLocation(200);
		
		JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, levo, sp1);
		add(sp2, BorderLayout.CENTER);
		
		JLabel lb = new JLabel("Status Bar");
		add(lb, BorderLayout.SOUTH);
	}
	
}
