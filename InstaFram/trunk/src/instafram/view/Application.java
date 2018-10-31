package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Application extends JFrame{

	private static Application instance;
	
	private Application(){
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrSize = kit.getScreenSize();
		setSize(scrSize.width / 2, scrSize.height / 2);
		setTitle("InstaFram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("Img/camera.png").getImage());
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		ToolBar tb = new ToolBar();
		PanelD workspace = new PanelD(new BorderLayout());
		workspace.add(tb, BorderLayout.NORTH);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new PanelL(), workspace);
		split.setResizeWeight(1);
		add(split, BorderLayout.CENTER);
		
		JLabel lb = new JLabel("Status bar");
		add(lb, BorderLayout.SOUTH);
	}

	public static Application getInstance() {
		if(instance == null)
			return new Application();
		return instance;
	}

}
