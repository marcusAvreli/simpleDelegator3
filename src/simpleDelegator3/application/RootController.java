package simpleDelegator3.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator3.core.core.DefaultApplicationLauncher;
import simpleDelegator3.frame.AbstractViewContainerFrame;
import simpleDelegator3.frame.DefaultViewContainerFrame;

//CLIENT
public class RootController extends DefaultApplication{


	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	public static String Log4JPath = null;
	
	public void init() {
		//query for jframe
		//AbstractViewContainerFrame ab = new DefaultViewContainerFrame(this);
		//ab.setApplication(this);
		
				
		//this.setRootView(ab);
	}
	public static void main(String[] args) {
		/*PanelModel model = new PanelModel();
		ViewFrame frame = new ViewFrame(model);
		Controller c = new Controller(frame);
		*/
		initApp();   
		try {
			new DefaultApplicationLauncher().execute(RootController.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static Properties getApplicationProperties() {
		InputStream inputStream = null;
		Properties applicationProp = null;
		try {
			inputStream = new FileInputStream(new File("./resources/application.properties"));
			applicationProp = new Properties();
			applicationProp.load(inputStream);
			inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}

	return applicationProp;
	}
	public static void initApp() {
		Properties applicationProperties = getApplicationProperties();
		setLog4JPath(applicationProperties.getProperty("LOG4J_PATH"));          
		loadLog4j();
	}

	private static void loadLog4j() {
		LoggerContext context=(LoggerContext)LogManager.getContext(false);
		context.setConfigLocation(new File(getLog4JPath()).toURI());      
	}

	public static String getLog4JPath() {
		return Log4JPath;
	}

	public static void setLog4JPath(String log4jPath) {
		Log4JPath = log4jPath;
	}
}
