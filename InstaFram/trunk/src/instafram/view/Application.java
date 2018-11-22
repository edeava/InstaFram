package instafram.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

import instafram.actions.CloseListener;
import instafram.tree.actions.ZTreeActionManager;
import instafram.tree.controller.ZTreeController;
import instafram.tree.model.ZTreeNode;
import instafram.tree.view.ZTree;
import instafram.treeComponent.model.Proizvod;

public class Application extends JFrame{

	private static Application instance;
	private ZTree tree;
	private PanelD workspace;
	private JScrollPane treeSc;
	
	public ZTree getTree() {
		return tree;
	}

	private Application(){
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrSize = kit.getScreenSize();
		setSize(scrSize.width / 2, scrSize.height / 2);
		setTitle("InstaFram");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("Img/camera.png").getImage());
		workspace = new PanelD(new BorderLayout());
		tree = new ZTree( new ZTreeController());
		tree.getController().addObservers(workspace.getDesnoDole());
		tree.getController().addObservers(workspace.getTb());

		((ZTreeNode) tree.getModel().getRoot()).addObserver(workspace.getDesnoDole());
		((ZTreeNode) tree.getModel().getRoot()).addObserver(workspace.getTb());
		
		MenuBar menu = new MenuBar(tree);
		this.setJMenuBar(menu);
		
		ToolBar toolBar = new ToolBar(tree);
		add(toolBar, BorderLayout.NORTH);
		
		ToolBar tb = new ToolBar(tree);
		tb.setRemoveAction(workspace.getTb());
		
		workspace.add(tb, BorderLayout.NORTH);
		
		treeSc = new JScrollPane(tree);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeSc, workspace);
		split.setResizeWeight(0.25);
		add(split, BorderLayout.CENTER);
		
		JLabel lb = new JLabel("Status bar");
		add(lb, BorderLayout.SOUTH);
		
		if(Application.option("Da li zelite da ucitate postojeci projekat?", "Ucitavanje") == JOptionPane.YES_OPTION)
			tree.getActionManager().getLoadAction().actionPerformed(null);
		
		CloseListener close = new CloseListener();
		close.setSave(tree.getActionManager().getSaveAction());
		this.addWindowListener(close);
	}

	public static Application getInstance() {
		if(instance == null)
			instance = new Application();
		return instance;
	}
	
	public static int option(String message, String title) {
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public PanelD getWorkspace() {
		return workspace;
	}

	public JScrollPane getTreeSc() {
		return treeSc;
	}
}
