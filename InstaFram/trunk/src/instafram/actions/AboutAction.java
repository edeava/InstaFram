package instafram.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import instafram.view.AboutFrame;

public class AboutAction extends AbstractAction{

	
	public AboutAction() {
		super();
		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutFrame aFrame = new AboutFrame();
		aFrame.setVisible(true);
	}

	
}
