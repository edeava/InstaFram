package instafram.treeComponent.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.PredefinedParameter;

public class ParametarEditDialog extends JDialog{

	private int okClick = 0;
	private PredefinedParameter gui;
	private String nodeName;
	private String vrednost;
	
	public ParametarEditDialog() {
		Box box = Box.createVerticalBox();
		
		JLabel lbl = new JLabel("Tip parametra:");
		JComboBox<String> cb = new JComboBox<>();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		
		JComboBox<PredefinedParameter> cbP = new JComboBox<>(PredefinedParameter.values());
		JComboBox<PredefinedParameter> cbC = new JComboBox<>();
		
		while(cbP.getItemAt(0) != PredefinedParameter.NAME) {
			cbC.addItem(cbP.getItemAt(0));
			cbP.removeItemAt(0);
		}
		cbC.removeItem(PredefinedParameter.PATH);
		
		cb.addItem("Predefinisani");
		cb.addItem("Custom");
		JButton btnOk = new JButton("Ok");
		JTextField tf = new JTextField(10);
		JTextField tf1 = new JTextField(10);
			
		panel1.add(lbl);
		panel1.add(cb);
		panel2.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				okClick++;
				if(cb.getSelectedItem() == "Predefinisani") {
					if(okClick == 1) {
						lbl.setText("Predefinisani parametar");
						panel1.removeAll();
						panel1.add(lbl);
						panel1.add(cbP);
						pack();
						
					}
					else if(okClick == 2) {
						gui = (PredefinedParameter) cbP.getSelectedItem();
						setVisible(false);
						dispose();
					}
				}else {
					if(okClick == 1) {
						lbl.setText("Name");
						JLabel lb = new JLabel("Label");
						JPanel panel4 = new JPanel();
						panel4.add(lb);
						panel4.add(tf1);
						panel1.removeAll();
						panel1.add(lbl);
						panel1.add(tf);
						box.remove(panel2);
						JPanel panel3 = new JPanel();
						panel3.add(cbC);
						box.add(panel4);
						box.add(panel3);
						box.add(panel2);
						pack();
						
					}
					else if(okClick == 2) {
						gui = (PredefinedParameter) cbC.getSelectedItem();
						nodeName = tf.getText();
						vrednost = tf1.getText();
						setVisible(false);
						dispose();
					}
				}
			}
		});
		
		box.add(panel1);
		box.add(panel2);
		this.add(box, BorderLayout.CENTER);
		this.pack();
	}

	public Parametar createParametar(String name) {
		if(this.nodeName == null) {
			nodeName = name;
		}
		
		if(getGui() != null)
			return new Parametar(nodeName, getGui(), vrednost);
		return null;
	}
	
	public PredefinedParameter getGui() {
		return gui;
	}

	public int getOkClick() {
		return okClick;
	}
}
