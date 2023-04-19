package simpleDelegator3.api.view;


import java.awt.Container;

import simpleDelegator3.core.view.AbstractViewContainer;

/**
 * This interface should be implemented by classes used for managing
 * several views.<br/><br/>
 * Views can be added to the manager and then re-arranged before it can
 * be shown.
 * 
 * @author Mario Garcia
 * @since 1.0
 *
 */
//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/api/src/main/java/org/viewaframework/view/ViewManager.java
public interface ViewManager /*extends ApplicationAware*/
{
	public static final String ROOT_VIEW_ID = "rootViewId";

	/**
	 * Adds a view to the manager
	 * 
	 * @param view
	 * @throws
	 */
	//public void addView(ViewContainer view) throws ViewException;
	public void addView(ViewContainer view);
	public ViewContainer getView();
	public Container arrangeViews();
	public void setRootView(ViewContainerFrame view);
	public ViewContainerFrame getRootView();

}
