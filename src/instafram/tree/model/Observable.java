package instafram.tree.model;

import java.util.ArrayList;

public interface Observable{

	public void notifyObserver();
	public void addObserver(ObserverUpdate o);
}
