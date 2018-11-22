package instafram.actions;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import instafram.tree.actions.SaveTreeAction;

public class CloseListener implements WindowListener{

	private SaveTreeAction save;
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Da li zelite da sacuvate?", 
													"Izlaz", 
													JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION)
			save.actionPerformed(null);
		else if(result == JOptionPane.NO_OPTION) 
			System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setSave(SaveTreeAction save) {
		this.save = save;
	}
}
