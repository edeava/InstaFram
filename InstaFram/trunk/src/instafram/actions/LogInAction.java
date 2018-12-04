package instafram.actions;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractAction;

import instafram.view.LogInFrame;

public class LogInAction extends AbstractAction{

	private String matrix[][] = new String[1001][2];
	private String username = "";
	private String password = "";
	private LogInFrame log;
	private boolean yes = false;
	
	public LogInAction(LogInFrame log) {
		this.log = log;
		File file = new File("LogIn");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			while((line = in.readLine()) != null) {
				String input[] = line.split(":");
				matrix[i][0] = input[0];
				matrix[i][1] = input[1];
				i++;
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setCred(log.getTfUsername().getText(), log.getTfPassword().getText());
		
		for (int i = 0; i < matrix.length; i++) {
			if(username.equals(matrix[i][0]) &&
			   password.equals(matrix[i][1])) {
				
				yes = true;
				break;
			}
		}
		
		System.out.println("Klik!");
	}
	
	public void setCred(String user, String pass) {
		username = user;
		password = pass;
	}

	public boolean isYes() {
		return yes;
	}
}
