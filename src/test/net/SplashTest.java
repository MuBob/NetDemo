package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

public class SplashTest extends BaseTest{

	public static void main(String[] args) {
		new SplashTest().request();

	}
	
	 
	 void request(){
		 
		 
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
        
        
		 

		 
		 
		 
        
//        Map<String,Object> map=new HashMap<>();
        map.clear();
        map.put(PATH,"/App/Startup");

 
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
        
        
        

//        map.clear();
//      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
        
        map.clear();
        map.put(PATH,"/Datadict/Nation/List");
        
      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
        
        
      map.clear();
      map.put(PATH,"/User/Signup/Mobile");
      map.put("countryCode", "86");
      map.put("mobile", "18800008888");
      map.put("password", "123456");
      map.put("captcha", "123456");
      map.put("channel", "1");
      map.put("appType", "2");
      map.put("appVersion", "100");
      
    request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
		 
		 
		 
		 
		 
		 
		 
		 
	 }

}
