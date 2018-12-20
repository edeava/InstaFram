package instafram.tree.model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.util.ElementFilter;

public class TreeElementSelection implements Transferable, ClipboardOwner{

	static public DataFlavor flavor;
	private DataFlavor[] supportedFlavors = new DataFlavor[100];
	public ArrayList<ZTreeNode> treeElements = new ArrayList<>();
	
	public TreeElementSelection(ArrayList<ZTreeNode> treeElements) {
		super();
		this.treeElements = treeElements;
		try {
			flavor = new DataFlavor (Class.forName ("java.util.ArrayList"),"Elements");
		}catch (ClassNotFoundException e) {
			 
		} 
	}
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals (flavor))
			 return (treeElements);
		else
			 throw new UnsupportedFlavorException (flavor);
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}
	
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		
		return flavor.equals(this.flavor);
	}
}
