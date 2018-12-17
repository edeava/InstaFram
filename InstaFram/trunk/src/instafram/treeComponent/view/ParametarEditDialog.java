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

import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.PredefinedParameter;

public class ParametarEditDialog extends JDialog{

	private int okClick = 0;
	private PredefinedParameter gui;
	
	public ParametarEditDialog() {
		Box box = Box.createVerticalBox();
		
		JLabel lbl = new JLabel("Tip parametra:");
		JComboBox<String> cb = new JComboBox<>();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		
		JComboBox<PredefinedParameter> cbT = new JComboBox<>(PredefinedParameter.values());
		cbT.removeItemAt(0);
		
		cb.addItem("Predefinisani");
		cb.addItem("Custom");
		JButton btnOk = new JButton("Ok");
			
		panel1.add(lbl);
		panel1.add(cb);
		panel2.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				okClick++;
				
				if(okClick == 1) {
					JPanel panel3 = new JPanel(new FlowLayout());
					box.remove(panel2);
					panel3.add(cbT);
					box.add(panel3);
					box.add(panel2);
					pack();
					
				}
				else if(okClick == 2) {
					gui = (PredefinedParameter) cbT.getSelectedItem();
					setVisible(false);
					dispose();
				}
			}
		});
		
		box.add(panel1);
		box.add(panel2);
		this.add(box, BorderLayout.CENTER);
		this.pack();
	}

	public Parametar createParametar(String name) {
		if(getGui() != null)
			return new Parametar(name, getGui());
		return null;
	}
	
	public PredefinedParameter getGui() {
		return gui;
	}

	public int getOkClick() {
		return okClick;
	}
}
