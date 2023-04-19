package simpleDelegator3.core.view;

import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator3.api.view.ViewContainer;
import simpleDelegator3.api.view.ViewManager;
import simpleDelegator3.application.Application;
import simpleDelegator3.frame.AbstractViewContainerFrame;

/**
 * A default implementation of View Manager. It manages the views added to the application
 * and those which are removed from the application. It also is resposible of launching
 * the views lifecycle and add them to the current perspective. 
 * 
 * It's also responsible for keeping the visual part of the application stable.
 * 
 * @author Mario Garcia
 * @since 1.0
 *
 */
//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewManager.java
public abstract class AbstractViewManager implements ViewManager
{
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractViewManager.class);
	private Application 				application;
	private ViewContainer view;
	private Map<Object,ViewContainer> 	views;

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	public void addView(ViewContainer view){	
		logger.info("add_view:"+view.getId());
		Map<Object,ViewContainer> 				viewContainerCollection = this.getViews();
		ViewContainer 							viewContainer 			= viewContainerCollection.get(view.getId());	
		Application								app						= this.getApplication();		
		this.view = view;
		String									viewId					= view.getId();
		 /* Views must have their ids and these ids must not be repeated */		
			if (viewId!=null && viewContainer == null)
			{
				
			}
		logger.info("setting_view");
		view.setApplication(app);
		//this.addView(view,constraint);
		
		
		
	}
	/**
	 * Default constructor. It creates a new List where the views are
	 * added.
	 */
	public AbstractViewManager(){
		this.views = new HashMap<Object,ViewContainer>();		
	}
	public Map<Object, ViewContainer> getViews() {
		return this.views;
	}
	public ViewContainer getView() {
		return view;
	}

	public Container arrangeViews()
	{
		logger.info("arrange_views_started");
		//Map<Object,ViewContainer> cviews 					= new HashMap<Object, ViewContainer>();
		ViewContainer viewContainerCollection 	= this.getView();
		if(null !=viewContainerCollection) {
			logger.info("viewContainerCollection_is_not_null: "+ viewContainerCollection.getId());
		}else {
			logger.info("viewContainerCollection_is_null");
		}
	 /* ViewManager and Perspectives can make different decisions about its views so
	  * it is mandatory to create different view collections. */
		JPanel myPanel = new JPanel();
		//myPanel.add(viewContainerCollection);
		JLabel lbl = new JLabel("test");
		myPanel.add(lbl);
		logger.info("arrange_views_finished");
		return viewContainerCollection.getContentPane();
	}
}
