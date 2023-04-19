package simpleDelegator3.api.view;
import javax.swing.RootPaneContainer;

import simpleDelegator3.api.core.ApplicationAware;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/api/src/main/java/org/viewaframework/view/ViewContainer.java
public interface ViewContainer extends RootPaneContainer, ApplicationAware{
	public abstract String getId();
	/**
	 * Sets the name view.
	 * 
	 * @param name the id to set
	 */
	public abstract void setId(String name);
	
	
}
