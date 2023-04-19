package simpleDelegator3.core.annotation.processor;

import simpleDelegator3.api.view.ViewContainer;

/**
 * 
 * @author Mario Garcia
 * @since 1.0.2
 *
 */
public class ViewsProcessorWrapper {

	
	private boolean rootView;
	private boolean trayView;
	private ViewContainer view;

	public ViewsProcessorWrapper(ViewContainer view,boolean rootView,boolean trayView){
		this.view =view;
		
		this.rootView = rootView;
		this.trayView = trayView;
	}

	

	public ViewContainer getView() {
		return view;
	}

	public boolean isRootView() {
		return rootView;
	}

	public boolean isTrayView() {
		return trayView;
	}

	

	public void setRootView(boolean rootView) {
		this.rootView = rootView;
	}

	public void setTrayView(boolean trayView) {
		this.trayView = trayView;
	}
	
	public void setView(ViewContainer view) {
		this.view = view;
	}
	
}