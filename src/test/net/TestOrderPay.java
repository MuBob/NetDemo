package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

public class TestOrderPay extends BaseTest{

	
	public static void main(String[] args) {
		new TestOrderPay().excute();
	}

	private void excute() {
        Map<String,Object> map=new HashMap<>();
        
        
//      
      map.clear();
      map.put(PATH,"/Entsvc/Order/Pay/Chooseethod");
      map.put("orderID", "e6f4e5df87c94a9281503bbc2c15f9ec");
      
      map.clear();
      map.put(PATH,"/Entsvc/Order/Pay/Alipay/Params");
      map.put("orderID", "4230e3ca2691414f93aa617dadfecccb");

      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
     	 @Override
     	public void onResponse(String response) {
     		 Log.log("aaaaaaaaa", "aaaaaaaaa");
     		super.onResponse(response);
     		
     	}
     	 
     	 @Override
     		public void onResponseSuccess(SimpleResponse bean) {
     			// TODO Auto-generated method stub
     			super.onResponseSuccess(bean);
     			System.out.println("ooooooooooookkkkkkkkkkkkk");
     		}
     	 @Override
     	public void onError(Throwable e) {
     		 Log.log("onError", "onError"+e);
     		super.onError(e);
     	}
     	 
      });
		
	}
	

}
