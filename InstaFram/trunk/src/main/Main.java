package main;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import instafram.view.Application;
import instafram.view.LogInFrame;

public class Main {

	public static void main(String[] args) {
		LogInFrame login = new LogInFrame();
		if(login.isYes()) {
			Application app = Application.getInstance();
			app.setVisible(true);
		}
	}

}
