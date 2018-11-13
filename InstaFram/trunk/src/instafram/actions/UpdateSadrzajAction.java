package instafram.actions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import instafram.view.Application;

public class UpdateSadrzajAction extends KeyAdapter{
	private String sadrzaj;
	
	public UpdateSadrzajAction(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			Application.getInstance().getWorkspace().getObserver().setSadrzaj(sadrzaj);
		}
	}

	
	
}
