package test.net;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.IResponseSuccess;
import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.java.EncryptUtil;
import com.zonetry.base.java.NetUtil;
import com.zonetry.base.net.INet;
import com.zonetry.base.net.IResponseListener;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

public class BaseTest {

	public static final String URL = "url";//网络传输时的绝对url地址
	public static final String PATH = "path";//相对地址
	public static final String TOKEN = "token";//令牌
	public static final String CODE  = "code";//服务器端是否返回成功的标志，成功返回200

	
	
	
	public BaseTest() {
		super();
		login();
	}


	public   <T extends IResponseSuccess> void request(Map<String, Object> map,
			IResponseListener<T> responseListener) {
		NetUtil.request(map, responseListener);

	}
	
	
	public void login(){
		
	 
			
	        Map<String,Object> map=new HashMap<>();
	        
	        
	        
	        map.clear();
	        map.put(PATH,"/Token");

	        request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
	       	 @Override
	       	public void onResponse(String response) {
	       		 Log.log("aaaaaaaaa", "aaaaaaaaa");
	       		super.onResponse(response);
	       		
	       	}
	       	 @Override
	       	public void onError(Throwable e) {
	       		 Log.log("onError", "onError"+e);
	       		super.onError(e);
	       	}
	       	 
	        });
 
	    
	    map.clear();

	    map.put(PATH,"/User/Logon/Mobile");

	    
	   
	    map.put("mobile","15611681936");
	    map.put("password",EncryptUtil.encryptDES("12345678"));
	    System.out.println("加密后的密码"+EncryptUtil.encryptDES("12345678"));
	    
	    
	    map.put("mobile","17601613846");
	    map.put("password",EncryptUtil.encryptDES("11111111"));
	    System.out.println("加密后的密码"+EncryptUtil.encryptDES("11111111"));
////	      
////	    
	    
	    map.put("mobile","15076171957");
	    map.put("password",EncryptUtil.encryptDES("12345678"));
	    System.out.println("加密后的密码"+EncryptUtil.encryptDES("11111111"));
	       
	    
	    
	    map.put("countryCode","86");
	    map.put("channel",2);
	    map.put("appType",2);
	    map.put("appVersion",100);
	    
	    
	    
	    
	    request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
	    	
	    	@Override
	    	public void onResponseSuccess(SimpleResponse bean) {
	    		// TODO Auto-generated method stub
	    		super.onResponseSuccess(bean);
//	    	    map.clear();
//
//	    	    map.put(PATH, "/Financing/CrazyAngel/List/Success");
//	            map.put("pageIndex", 1);
//	            map.put("pageCount", 10);
//	    	 
//	    	    request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
//	    	    
	    		
	    	}
	    });
	    
	    
	    
	    try {
			Thread.sleep(3000l);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		}
		
		
		
		
		
		
		
		
		
		
 
	
	
	
	
	
	
	
	
	
	
	
	
}
