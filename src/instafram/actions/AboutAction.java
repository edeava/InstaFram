package instafram.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import instafram.view.AboutFrame;

public class AboutAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutFrame aFrame = new AboutFrame();
		aFrame.setVisible(true);
	}

	
}
