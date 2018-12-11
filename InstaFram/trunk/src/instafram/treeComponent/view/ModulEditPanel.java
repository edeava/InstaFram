package instafram.treeComponent.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModulEditPanel extends JPanel implements TreeEditPanel{

	public ModulEditPanel() {
		JLabel lbl = new JLabel("Sadrzaj");
		JTextField tf = new JTextField(10);
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");
		
		this.add(lbl);
		this.add(tf);
		this.add(btnOk);
		this.add(btnCancel);
	}

}
