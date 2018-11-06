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
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

import instafram.tree.actions.ZTreeActionManager;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;
import instafram.treeComponent.model.Kompanija;

public class Application extends JFrame{

	private static Application instance;
	private ZTree tree;
	
	public ZTree getTree() {
		return tree;
	}

	private Application(){
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrSize = kit.getScreenSize();
		setSize(scrSize.width / 2, scrSize.height / 2);
		setTitle("InstaFram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("Img/camera.png").getImage());
		
		tree = new ZTree(new ZTreeNode(new Kompanija("Kompanije")), new ZTreeController());
		
		MenuBar menu = new MenuBar(tree);
		this.setJMenuBar(menu);
		
		ToolBar toolBar = new ToolBar(tree);
		add(toolBar, BorderLayout.NORTH);
		
		ToolBar tb = new ToolBar(tree);
		PanelD workspace = new PanelD(new BorderLayout());
		workspace.add(tb, BorderLayout.NORTH);
		
		JScrollPane treeSc = new JScrollPane(tree);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeSc, workspace);
		split.setResizeWeight(0.25);
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
