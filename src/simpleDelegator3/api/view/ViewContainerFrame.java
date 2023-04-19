package simpleDelegator3.api.view;

import javax.swing.JFrame;

import simpleDelegator3.application.Application;

public interface ViewContainerFrame extends ViewContainer{

	/**
	 * @return
	 */
	public JFrame getFrame();
	public Application	getApplication();
	public void	setApplication(Application application);
	
	
}