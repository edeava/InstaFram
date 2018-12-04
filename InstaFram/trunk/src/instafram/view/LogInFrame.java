package instafram.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import instafram.actions.LogInAction;

public class LogInFrame extends JDialog{

	private boolean yes = false;
	JTextField tfUsername;
	JTextField tfPassword;
	JButton btnLogIn;
	
	public LogInFrame() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel lbUsername = new JLabel("Username");
		tfUsername = new JTextField(15);
		
		JLabel lbPassword = new JLabel("Password");
		tfPassword = new JTextField(15);
		
		btnLogIn = new JButton("Log In");
		
		
		panel.add(lbUsername, BorderLayout.NORTH);
		panel.add(tfUsername, BorderLayout.NORTH);
		panel.add(lbPassword, BorderLayout.CENTER);
		panel.add(tfPassword, BorderLayout.CENTER);
		panel.add(btnLogIn, BorderLayout.SOUTH);
		
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		setVisible(true);
		
		btnLogIn.addActionListener(new LogInAction(this));
	}

	public boolean isYes() {
		return ((LogInAction) btnLogIn.getActionListeners()[0]).isYes();
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}
}
