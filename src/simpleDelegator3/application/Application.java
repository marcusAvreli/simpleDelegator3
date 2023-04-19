package simpleDelegator3.application;

import simpleDelegator3.api.view.ViewContainerFrame;
import simpleDelegator3.api.view.ViewManager;
import simpleDelegator3.core.view.AbstractViewManager;
import simpleDelegator3.frame.AbstractViewContainerFrame;

public interface Application {
public void close();
public void setVisible(boolean visible);
public abstract void setRootView(ViewContainerFrame rootView);
public ViewManager getViewManager();
public void prepare();
public void prepareUI() ;
public void initUI() ;
}
