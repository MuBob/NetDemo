package test;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.java.EncryptUtil;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

import junit.framework.TestCase;
import test.net.BaseTest;
import test.net.TestRoleGet;

public class TestEnterpriseService extends BaseTest{

	public static void main(String[] args) {
		new TestEnterpriseService().excute();
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
    	public void onResponseSuccess(SimpleResponse bean) {
    		// TODO Auto-generated method stub
    		super.onResponseSuccess(bean);
    	    map.clear();

    	     
    	    map.put(PATH,"/Entsvc/Main");
    	    request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
    	     @Override
    	    public void onResponseSuccess(SimpleResponse bean) {
    	    	// TODO Auto-generated method stub
    	    	super.onResponseSuccess(bean);
    	    	
    	    	   requestDetail();
    	    }
    	     
    	    	
    	    });
    	    
//    	    requestDetail();
    		
    	}
    });
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	}



	protected void requestDetail() {
        Map<String,Object> map=new HashMap<>();
//        map.put(PATH,"/Entsvc/Order/Get/Buyer");
        map.put(PATH,"/Entsvc/Goods/Detail");
        
        map.put("goodsID", 1);
        request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
        	@Override
        	public void onResponseSuccess(SimpleResponse bean) {
        		// TODO Auto-generated method stub
        		super.onResponseSuccess(bean);
        	
        		map.clear();
                map.put(PATH,"/Entsvc/Goods/Recommend/Location/List");
                
                map.put("goodsID", 1);
                
                map.put("typeID", 103);
                map.put("locationID", "5f9eaf290c6e46969c6cc8e656fa02f0");
                map.put("recommendGoodsID", "2");
                map.put("pageIndex",0);
                map.put("pageCount",20);
                
                request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
                	@Override
                	public void onResponseSuccess(SimpleResponse bean) {
                		// TODO Auto-generated method stub
                		super.onResponseSuccess(bean);

                		map.clear();
                        map.put(PATH,"/Entsvc/Goods/Location/List");
                      
                        map.put("goodsID", 1);
                        map.put("typeID", 105);
                        map.put("districtID", "f2c9408f1e4f4e1cb8dbcb2878015cd8");
                        
                        
                        
                        request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
                        	@Override
                        	public void onResponseSuccess(SimpleResponse bean) {
                        		// TODO Auto-generated method stub
                        		super.onResponseSuccess(bean);
                        		
                        		
                        	}
                        });
                		
                	}
                });
        	}
        });
 	   
        
		
		
	}
}
