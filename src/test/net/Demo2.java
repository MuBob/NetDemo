package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.IResponseSuccess;
import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.java.EncryptUtil;
import com.zonetry.base.java.NetUtil;
import com.zonetry.base.net.IResponseListener;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

 

public class Demo2 extends BaseTest{

	 public static void main(String[] args) {
		 
 
		 

     new Demo2().excute();
     
     
     
     
     
     
 
     
     
     
 
	}
	 
	 void excute(){
		 
		 
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
     map.put("countryCode","86");
     map.put("channel",2);
     map.put("appType",2);
     map.put("appVersion",100);
     
   request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){

	 
 });
		 
   map.clear();
   map.put(PATH, "/User/Detail");

         map.put("uid", "233038ada1f94e0a8b0a18ac285c5002");
   
   
         request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){

        	 
         });
   
   
   
   
   
		 
		 
	 }
	 


	 
 
}
