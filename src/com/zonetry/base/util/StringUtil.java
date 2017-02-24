package com.zonetry.base.util;

import android.annotation.SuppressLint;
import java.lang.reflect.Method;

@SuppressLint("DefaultLocale")
public class StringUtil {
	/**
	 * 
	 * 给定一个类，返回里面的所有以get开头的方法名  的 集合组成的字符串
	 * @param o
	 * @return
	 */
		public static final String getMethodStrings(Object object){
			StringBuffer stringBuffer=new StringBuffer();
			Method[] methods = object.getClass().getMethods(); 
			for (Method method : methods) {
			    if(method.getName().startsWith("get")){  
			    	if (method.getName().equals("getClass")) {
						continue;
					}
			    	try {
			    		Object value= method.invoke(object);
			    		String name=method.getName().replace("get", "");
						stringBuffer.append(firstLetterLower(name))
						.append("=")
						.append(value)
						.append(",")
						;
					} catch (Exception e) {
//						e.printStackTrace();
//						System.out.println("method.getName()"+method.getName());
					} 
			    	
			    }
			  
			}
			if (stringBuffer.toString().endsWith(",")) {
				return stringBuffer.toString().substring(0, stringBuffer.length()-1-1);
			}else{
				return stringBuffer.toString();
			}
					
		
		}
		/**
		 * 首字符小写
		 * @param name
		 * @return
		 */
		private static String firstLetterLower(String name){
			if (name==null) 
				return null;
		
			if (name.length()>1) 
				return name.substring(0,1).toLowerCase() + name.substring(1,name.length());
			else
				return name.toLowerCase();
			
		}
 
		/**
		 * 类的toString方法的实现
		 * @param object
		 * @return
		 */
		public static final String getClassToString(Object object){
			if (object==null) return "";
			return object.getClass().getSimpleName()+"["+getMethodStrings(object)+"]";
		}
 
}
