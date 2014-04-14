package azhdev.anmc.util;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 *Logger.java
 *
 * @author Azhdev
 *
 * copyright 2014 Azhdev
 */

public class Log {
	private static Logger logger = LogManager.getLogger("FML");
	
	public static void init(){
		logger.log(Level.INFO, "Starting");
	}
	
	/**
	 * 
	 * @param info
	 * @param childName
	 */
	public static void addInfo(String info){
			logger.log(Level.INFO, info);
	}
	
	/**
	 * 
	 * @param error
	 * @param childName
	 */
	public static void addError(String error){
			logger.log(Level.ERROR,  error);
	}
	
	/**
	 * 
	 * @param warning
	 * @param childName
	 */
	public static void addWarning(String warning, String childName){
		logger.log(Level.WARN, warning);
	}
}
