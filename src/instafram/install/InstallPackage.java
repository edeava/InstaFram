package instafram.install;

import java.io.File;
import java.util.ArrayList;

import instafram.treeComponent.model.Parametar;

public class InstallPackage {

	private Logo logo;
	private int lookNFeel;
	private File source;
	private ArrayList<Parametar> parametri = new ArrayList<>();
	
	public InstallPackage(Logo logo, int lookNFeel, ArrayList<Parametar> parametri, File source) {
		super();
		this.logo = logo;
		this.lookNFeel = lookNFeel;
		this.source = source;
		this.parametri = parametri;
	}
	
	public Logo getLogo() {
		return logo;
	}
	public void setLogo(Logo logo) {
		this.logo = logo;
	}
	public int getLookNFeel() {
		return lookNFeel;
	}
	public void setLookNFeel(int lookNFeel) {
		this.lookNFeel = lookNFeel;
	}
	public ArrayList<Parametar> getParametri() {
		return parametri;
	}

	public File getSource() {
		return source;
	}

	public void setSource(File source) {
		this.source = source;
	}

	public void setParametri(ArrayList<Parametar> parametri) {
		this.parametri = parametri;
	}
}
