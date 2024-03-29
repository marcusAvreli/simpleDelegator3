package simpleDelegator3.frame;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator3.api.view.ViewContainer;
import simpleDelegator3.api.view.ViewContainerFrame;
import simpleDelegator3.application.Application;
import simpleDelegator3.core.view.AbstractViewContainer;
//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewContainerFrame.java
public abstract class AbstractViewContainerFrame extends AbstractViewContainer implements ViewContainerFrame 
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractViewContainerFrame.class);
	private JFrame frame;
	




	/**
	 * 
	 */
	public AbstractViewContainerFrame(){
		super("FRAME");
		logger.debug("frame_constructor_called");
	//	this.application=app;
		
	}


	

	/* (non-Javadoc)
	 * @see org.viewaframework.view.ViewContainerFrame#getFrame()
	 */
	public JFrame getFrame() {
	
		if (this.frame == null){
			logger.debug("create_frame_started");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();     
			GraphicsDevice 		gd = ge.getDefaultScreenDevice();
			this.frame = new JFrame("FRAME");
			//TODO
			this.frame.getContentPane().setLayout(new BorderLayout());
			
			this.frame.setName("FRAME");
			this.frame.addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent arg0) {				
					getApplication().close();
				}
			});
			this.frame.setBounds(gd.getDefaultConfiguration().getBounds());		
			this.frame.setLocationByPlatform(true);
			logger.debug("create_frame_finished");
			
			
		}else {
			logger.debug("frame_is_not_null");
		}
		return this.frame;
	}

	
	
}