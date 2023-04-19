package simpleDelegator3.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator3.frame.DefaultViewContainerFrame;

public class DefaultApplication extends AbstractApplication{
	private static final Logger logger = LoggerFactory.getLogger(DefaultApplication.class);
	public DefaultApplication(){
		logger.debug("before_set_root_view");
		this.setRootView(new DefaultViewContainerFrame());
	}
	
}
