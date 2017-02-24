package com.zonetry.base.util;

/**
 * 记录日志.
 * 用法:log("key",value)
 * 其中key为名称,value为值
 * 例如,要打印变量name的名称:log("name",name);
 */
 public class Log {

	static Boolean isAndroid=false;
 
	public static void log(String key,Object value){
		if (isAndroid()) {
			android.util.Log.d(key,""+ value);
		
		}else{
			System.out.println("key:"+key+"\tvalue:"+value);
		}
	}
	
	private static boolean isAndroid() {
//		if (isAndroid==null) {
//				try{
//				    Class.forName("android.util.Log");
//					isAndroid=true;
//				}catch(Exception e){
//					isAndroid=false;
////				    System.err.println("android.util.Log这个类真的不存在!");
//				}
//		}
//		return isAndroid;
		return false;
	}

	public static void v(String key,Object value){
		if (isAndroid()) {
			 android.util.Log.v(key,""+ value);
		}else{
			System.out.println("key:"+key+"\tvalue:"+value);
		}
	}
	
	public static void d(String key,Object value){
		if (isAndroid()) {
			android.util.Log.d(key,""+ value);
		}else{
			System.out.println("key:"+key+"\tvalue:"+value);
		}
	}
	
	public static void i(String key,Object value){
		if (isAndroid()) {
			 android.util.Log.i(key,""+ value);
		}else{
			System.out.println("key:"+key+"\tvalue:"+value);
		}
	}
	
	public static void e(String key,Object value){
		if (isAndroid()) {
			 android.util.Log.e(key,""+ value);
		}else{
		    System.err.println("key:"+key+"\tvalue:"+value);
		}
	}
}
