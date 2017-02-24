package com.zonetry.base.action;

import java.util.Map;

import com.zonetry.base.bean.IResponseSuccess;
import com.zonetry.base.java.NetUtil;
import com.zonetry.base.net.IResponseListener;

public class BaseActionImpl {
	
	public static final String URL = "url";//网络传输时的绝对url地址
	public static final String PATH = "path";//相对地址
	public static final String TOKEN = "token";//令牌
	public static final String CODE  = "code";//服务器端是否返回成功的标志，成功返回200

	
	public  final <T extends IResponseSuccess> void request(Map<String, Object> map,
			IResponseListener<T> responseListener) {
		NetUtil.request(map, responseListener);
	}
	public void logv(String key,Object value){
//		Log.v(mActivity.getClass().getSimpleName()+"\t"+key,"key:"+key+"\tvalue:"+ value);
	}
	public void log(String key,Object value){
//		Log.log(mActivity.getClass().getSimpleName()+"\t"+key,"key:"+key+"\tvalue:"+ value);
	}
	public void logi(String key,Object value){
//		Log.i(mActivity.getClass().getSimpleName()+"\t"+key,"key:"+key+"\tvalue:"+ value);
	}
	public void loge(String key,Object value){
//		Log.e(mActivity.getClass().getSimpleName()+"\t"+key,"key:"+key+"\tvalue:"+ value);
//		if (value instanceof Throwable) {
//			((Throwable)value).printStackTrace();
//		}
	}

	public void showToast(String text) {
//		Toast.makeText(mActivity.getApplicationContext(), text, Toast.LENGTH_LONG).show();

	}
}
