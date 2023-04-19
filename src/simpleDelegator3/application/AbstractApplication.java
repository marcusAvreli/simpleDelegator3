package simpleDelegator3.application;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator3.api.view.ViewContainer;
import simpleDelegator3.api.view.ViewContainerFrame;
import simpleDelegator3.api.view.ViewManager;
import simpleDelegator3.common.CustomApplicationView;
import simpleDelegator3.core.annotation.processor.ViewsProcessorWrapper;
import simpleDelegator3.core.view.AbstractViewContainer;
import simpleDelegator3.core.view.AbstractViewManager;
import simpleDelegator3.core.view.DefaultViewContainer;
import simpleDelegator3.core.view.DefaultViewManager;
import simpleDelegator3.frame.AbstractViewContainerFrame;

///https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/core/AbstractApplication.java
public abstract class AbstractApplication implements Application{
	private static final Logger logger = LoggerFactory.getLogger(AbstractApplication.class);
	private ViewContainerFrame			rootView;
	//private AbstractViewManager 				viewManager;
	private ViewManager 				viewManager;
	private List<ViewsProcessorWrapper> initViews;
	//Application
	@Override
	public void close() {
		logger.debug("close called");
		this.fireClose();
	}
	
	public void fireClose() {
		ViewContainerFrame viewContainerFrame = this.getViewManager().getRootView();
		viewContainerFrame.getFrame().dispose();
	}
	//Application
	@Override
	public void setVisible(boolean visible) {
		
		JFrame frame = this.getRootView().getFrame();
		if (frame != null){
			if (visible){
				frame.setVisible(visible);
				frame.repaint();
			} else {
				frame.setVisible(visible);
			}
		}
	}
	
	//Application
	@Override
	/**
	 * @param rootView
	 */
	public void setRootView(ViewContainerFrame rootView) {
		logger.debug("Setting Root View");
		
			if (this.viewManager!=null){
				this.viewManager.setRootView(rootView);
				this.rootView = rootView;
			}
		
	}
	
	public ViewContainerFrame  getRootView() {	
		logger.debug("get_root_view");
		return rootView;
	}
	public AbstractApplication(){
		this.viewManager 			= new DefaultViewManager(this);
	}
	public AbstractApplication(ViewContainerFrame mainView){
		this();
		//this.setName(name);
		this.setRootView(mainView);
	}
	/* (non-Javadoc)
	 * @see org.viewa.core.Application#getViewManager()
	 */
	public ViewManager getViewManager() {
		return viewManager;
	}
	public void prepare() {
		logger.debug("prepare_started");
		if(null == initViews) {
			ViewsProcessorWrapper wrapper = new ViewsProcessorWrapper(rootView, true, false); 
		ViewContainer simpleView = new DefaultViewContainer("myPanel",new CustomApplicationView());
			initViews = new ArrayList<ViewsProcessorWrapper>();
			
			initViews.add(wrapper);
			wrapper = new ViewsProcessorWrapper(simpleView, false, false);
			initViews.add(wrapper);
		}
		logger.debug("prepare_finished");
	}
	public void prepareUI(){
		logger.debug("Application preparing UI!");
		if (initViews!=null){
			for (ViewsProcessorWrapper w : initViews){
				if (w.isRootView()){
					this.setRootView(ViewContainerFrame.class.cast(w.getView()));
				} else {
					logger.debug("adding_just_view");
					this.getViewManager().addView(w.getView());
				}
				
					
					
				
			}
		}
	}
	public void initUI() {
		
			logger.debug("Application UI initializing!");
			ViewManager viewManager = this.getViewManager();
			logger.debug("after_view_manager");
			Component 	view 		= viewManager.arrangeViews();
			logger.debug("after_arrange_views");
			if(null != view) {
				logger.debug("view_is_not_null");
			}else {
				logger.debug("view_is_null");
			}
			
			view.setVisible(true);
		
	}

}
