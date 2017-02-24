package util;

public class StringUtils{

	public static String firstLetterLower(String name){
		return name.substring(0,1).toLowerCase() + name.substring(1,name.length());
	}

	public static String firstLetterUpper(String name){
		return name.substring(0,1).toUpperCase() + name.substring(1,name.length());
	}
}
