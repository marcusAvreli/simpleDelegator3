package simpleDelegator3.core.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator3.api.view.ViewContainerFrame;
import simpleDelegator3.application.Application;
import simpleDelegator3.application.RootController;
import simpleDelegator3.frame.AbstractViewContainerFrame;
//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/DefaultViewManager.java
public class DefaultViewManager extends AbstractViewManager
{
	private static final Logger logger = LoggerFactory.getLogger(DefaultViewManager.class);
	private ViewContainerFrame rootView;

	/**
	 * Default Constructor
	 */
	public DefaultViewManager(){
		super();
	}

	/**
	 * This constructor gives the manager the application instance as well as
	 * the initial perspective.
	 * 
	 * @param app The application instance
	 * @param perspective The current perspective
	 */
	public DefaultViewManager(Application app){
		this.setApplication(app);
		
	}
	public Container arrangeViews() 
	{
		logger.info("arrange_views_started");
		JFrame 				rootContainer 	= null;
		Container 			container 		= null;
		ViewContainerFrame 	rootView 		= null; 	

	
		rootView 		= this.getRootView();
		logger.info("before_getting_frame");	
		rootContainer 	= rootView.getFrame();
		logger.info("after_getting_frame");
		container 		= super.arrangeViews();
		rootContainer.setContentPane(rootView.getRootPane());
		((JRootPane)rootContainer.getContentPane()).getContentPane().add(container);			
		this.addView(rootView);			
	
		logger.info("arrange_views_finished");	
		return rootContainer;
	}
	public ViewContainerFrame getRootView() {
		if (rootView == null){
			rootView = new AbstractViewContainerFrame(){
				//Just for instancing it
			};
			rootView.setApplication(this.getApplication());
		}
		return rootView;
	}
	/**
	 * @param rootView the rootView to set
	 */
	public void setRootView(ViewContainerFrame rootView) {
		this.rootView = rootView;
	}

}
