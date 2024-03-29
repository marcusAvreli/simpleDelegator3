package simpleDelegator3.api.core;

import simpleDelegator3.application.Application;

/**
 * This is the launcher of the <code>Application</code>. It is a singleton.
 * It should launch the application life cycle in a new Thread.
 * 
 * @author Mario Garcia
 * @since 1.0
 *
 */
public interface ApplicationLauncher {
	
 /* ****************************** SPLASH SCREEN MESSAGE KEYS ************************************ */	
	public static final String SPLASH_KEY_MESSAGE_OPENING = "splash.opening";
	public static final String SPLASH_KEY_MESSAGE_PREPAREUI = "splash.prepareui";
	public static final String SPLASH_KEY_MESSAGE_PREPARE = "splash.prepare";
	public static final String SPLASH_KEY_MESSAGE_STARTING = "splash.starting";
 /* ********************************* OBJECT VALUES KEYS ***************************************** */	
	public static final String SPLASH_KEY_VALUE_TEXT_COLOR = "splash.text.color";
	public static final String SPLASH_KEY_VALUE_TEXT_SIZE ="splash.font.size";
	public static final String SPLASH_KEY_VALUE_PROGRESS_COLOR ="splash.progress.color";
	public static final String SPLASH_KEY_VALUE_DEFAULT_PROGRESS_COLOR ="splash.progress.color.default";
	public static final String SPLASH_KEY_VALUE_DEFAULT_TEXT_SIZE ="splash.font.size.default";
	public static final String SPLASH_KEY_VALUE_DEFAULT_TEXT_COLOR = "splash.text.color.default";
 /* *********************************** DEFAULT VALUES ******************************************* */
	
/* ************************************** OTHER KEYS ********************************************* */	
	public static final String VIEWA_FILE_NAME = "viewa.properties";
	public static final String APPLICATION_BUNDLE_NAME = "Application";
	public static final String APPLICATION_VERSION = "application.version";
	public static final String APPLICATION_NAME = "application.name";	
	public static final String APPLICATION_LOCALE = "application.locale";
	public static final String APPLICATION_SPLASH = "application.splash";
	public static final String LOCALE_SEPARATOR = "_";	
	
	/**
	 * @param clazz
	 */
	public Application execute(Class<? extends Application> clazz) throws Exception;

}