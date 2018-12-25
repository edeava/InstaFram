package instafram.install;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import instafram.treeComponent.model.Parametar;

public class InstallPackage implements Serializable{

	private String logo;
	private int lookNFeel;
	private String source;
	private String autor;
	private ArrayList<Parametar> parametri = new ArrayList<>();
	
	public InstallPackage(String logo, int lookNFeel, ArrayList<Parametar> parametri, String source, String autor) {
		super();
		this.logo = logo;
		this.lookNFeel = lookNFeel;
		this.source = source;
		this.parametri = parametri;
		this.autor = autor;
	}

	public String getLogo() {
		return logo;
	}

	public int getLookNFeel() {
		return lookNFeel;
	}

	public String getSource() {
		return source;
	}

	public String getAutor() {
		return autor;
	}

	public ArrayList<Parametar> getParametri() {
		return parametri;
	}
}
