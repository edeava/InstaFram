package instafram.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogInFrame extends JDialog{

	private static final String adminPass = "admin";
	private static final String userPass = "student";
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JButton btnLogIn;
	private String korisnik;
	
	public LogInFrame() {
		setTitle("Log In");
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel lbUsername = new JLabel("Username");
		tfUsername = new JTextField(15);
		
		JLabel lbPassword = new JLabel("Password");
		tfPassword = new JTextField(15);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(tfUsername.getText().equals("admin") &&
				   tfPassword.getText().equals(adminPass)) {
					
					korisnik = "admin";
				setVisible(false);
				dispose();
				}
				
				else if(tfUsername.getText().equals("konfigurator") &&
						tfPassword.getText().equals(userPass)) {
					korisnik = "konfigurator";
					setVisible(false);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Pogresan username ili lozinka");
			}
		});
		
		panel.add(lbUsername, BorderLayout.NORTH);
		panel.add(tfUsername, BorderLayout.NORTH);
		panel.add(lbPassword, BorderLayout.CENTER);
		panel.add(tfPassword, BorderLayout.CENTER);
		panel.add(btnLogIn, BorderLayout.SOUTH);
		
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		setVisible(true);
		
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public String getKorisnik() {
		return korisnik;
	}
}
