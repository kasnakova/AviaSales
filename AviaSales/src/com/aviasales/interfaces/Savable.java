package com.aviasales.interfaces;
/**
 * Interface for future classes which will be saved in the file
 * @author ildarworld
 *
 */
public interface  Savable {
	public String makeSavebleString();
	public String getClassName();
	public static Savable  getObjectFromString(String line){
		return null;
	};
	
	
}
