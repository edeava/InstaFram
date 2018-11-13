package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class PanelD extends JPanel implements Observer{

	private TabbedPane tb;
	private PanelO observer;
	private JPanel dole;
	
	public PanelD(LayoutManager arg0) {
		super(arg0);
		observer = new PanelO();
		observer.addObserver(this);
		tb = new TabbedPane();
		dole = new JPanel();
		JSplitPane panel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tb, dole);
		panel.setResizeWeight(0.5);
		add(panel);
	}

	@Override
	public void update(Observable o, Object arg) {
		dole.removeAll();
		PanelO tmp = (PanelO) arg;
		tb.addTab(tmp.getSadrzaj());
		dole.add(new JLabel(tmp.getName() + " " +
							tmp.getSadrzaj() + " " +
							tmp.getParent() + " " +
							tmp.getChildNumber() + " " +
							tmp.getLeafNumber()), BorderLayout.CENTER);
	}

	public PanelO getObserver() {
		return observer;
	}
}
