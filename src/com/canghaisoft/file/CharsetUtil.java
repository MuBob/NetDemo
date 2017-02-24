package com.canghaisoft.file;
 

 

public class CharsetUtil{
	public static String defaultCharset = "UTF-8";
	//= Charset.defaultCharset().toString();
	public static String checkCharset(String fileAddress){
 
			return defaultCharset;
	 

	}

	public static String getDefaultCharset(){
		return defaultCharset;
	}

	public static void setDefaultCharset(String defaultCharset){
		CharsetUtil.defaultCharset = defaultCharset;
	}



}
