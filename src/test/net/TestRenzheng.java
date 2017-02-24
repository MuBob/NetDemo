package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

public class TestRenzheng extends BaseTest{
	public static void main(String[] args) {
		
		TestRenzheng renzheng=	new TestRenzheng();
//		renzheng.login();
		renzheng.excute();
	}

	private void excute() {
        Map<String,Object> map=new HashMap<>();
        
        
//      
      map.clear();
//      map.put(PATH,"/Expert/Review");
      map.put(PATH,"/User/Realname/Review");
//      map.put(PATH,"/Investor/Review");
//
//      
////      map.put("uid","3a585a5d09904e6c92f3bad327906f98");
////      map.put("uid","16745d1056e742a8ac270a0cbc4d34f2");
      map.put("uid","5153d617ab2a43a68703b67e813a2e56");
//      
//      
      map.put("reviewResult",true);
      
      
//      map.clear();
      
      
//      map.put(PATH,"/Project/Detail/App");
//      map.put("projectId","47e685ec00204b2a9cc56f4c0578dbb8");
    
      
      
      

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
