package azhdev.anmc.util;

/**
 * 
 * mathHelper.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 * 
 * utility class for some calculations
 *
 */

public class mathHelper {
	
	
	public static int getMinValue(int[] j){
		int minValue = j[0];  
	     for(int i = 1; i < j.length;i++){  
	    	 if(j[i] < minValue){  
	    		 minValue = j[i];  
	    	 }  
	     }  
	    return minValue;  
	}
}
