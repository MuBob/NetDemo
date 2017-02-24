package com.zonetry.base.constant;

import android.content.Context;

/**
 * 存储的系统变量
 * @author sks
 *
 */
public class Info {
	public static  final boolean DEBUG=false;
	public static  final boolean TEST=false;
	private static  String TOKEN;

	public static String getTOKEN(Context context) {
		if (TOKEN==null) {//从SP中读取
			
		}
		return TOKEN;
	}

	public static void setTOKEN(Context context,String tOKEN) {
		//存到SP中
		
		TOKEN = tOKEN;
	}
	
	
	
	
}
