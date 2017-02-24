package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.java.EncryptUtil;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

import create.CreateListAdapterByInnerJson;
import test.net.BaseTest;
import util.StringUtils;

public class CreateHomeInnerAdapterDemo extends BaseTest {
	
	public static void main(String[] args) {
		
		
		
		new CreateHomeInnerAdapterDemo().excute();
		
		
		
		
	}
	
	public void excute(){
		
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
        
        
		 

		 
		 
		 
//        
////        Map<String,Object> map=new HashMap<>();
//        map.clear();
//        map.put(PATH,"/App/Startup");
//
////    String     appId="cc4fcb66853d44e89fb695b71fd2fb08";
////        String appKey="HpUlKrRIbvtCu/vs5hoump3BAmD5fAw+1G1GKYS2J9/3nhvnSyukSA==";
////        map.put("appId",appId);
////        map.put("appKey",appKey);
////
////        
////        request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
////       	 @Override
////       	public void onResponse(String response) {
////       		 Log.log("aaaaaaaaa", "aaaaaaaaa");
////       		super.onResponse(response);
////       		
////       	}
////       	 @Override
////       	public void onError(Throwable e) {
////       		 Log.log("onError", "onError"+e);
////       		super.onError(e);
////       	}
////       	 
////        });
//        
//        
//        
//
//        
//      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
//
//   	 
//    });
        
//        map.clear();
//        map.put(PATH,"/Datadict/Nation/List");
//        
//      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
//
//   	 
//    });
        
//        
//      map.clear();
//      map.put(PATH,"/User/Signup/Mobile");
//      map.put("countryCode", "86");
//      map.put("mobile", "18800008888");
//      map.put("password", "123456");
//      map.put("captcha", "123456");
//      map.put("channel", "1");
//      map.put("appType", "2");
//      map.put("appVersion", "100");
//      
//    request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
//
// 	 
//  });
//		 
//		
//    map.clear();
//    map.put(PATH, "/User/Logon/UID");
//    map.put("uid", "233038ada1f94e0a8b0a18ac285c5002");
//    map.put("password", "ZbOP5Fr23uYwnKZwSY1HpQ==");
// 
//    map.put("password",EncryptUtil.encryptDES("12345678"));
////    System.out.println("加密后的密码"+EncryptUtil.encryptDES("12345678"));
////    map.put("countryCode","86");
//    map.put("channel",2);
//    map.put("appType",2);
//    map.put("appVersion",100);
//    
//  request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
//
//	 
//});
//    
    
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

	  @Override
	public void onResponse(String response) {
		// TODO Auto-generated method stub
		super.onResponse(response);
		
	    map.clear();
	    map.put(PATH, "/App/Home");

 
	    
	  request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){

		  @Override
		public void onResponse(String response) {
			// TODO Auto-generated method stub
//			super.onResponse(response);
			  System.out.println(response);
			  
			  try {
				JSONObject root=new JSONObject(response);
				JSONObject data=root.getJSONObject("data");
				Iterator its=	data.keys();
				
				for (Iterator iter = data.keys(); iter.hasNext();) {
					  String str = (String)iter.next();
					  if (str.endsWith("s")) {
						  System.out.println(str);
						  String newpath="/"+"Home"+StringUtils.firstLetterUpper(str.substring(0, str.length()-1));
						  String itemjson;
						  try {
						   itemjson=data.getJSONArray(str).getString(0);
						   if (itemjson!=null&&itemjson.length()>0) {
								CreateListAdapterByInnerJson create=	new CreateListAdapterByInnerJson(newpath,null,itemjson);
								create.excute();
							}
					} catch (Exception e) {
						
					}
						  
						
					  
					  }
					 
					 }
		 
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
			
		}
		 
	});
	}
	 
});
		 
		 
		 
		
		
		
		
		
		
	}

}
