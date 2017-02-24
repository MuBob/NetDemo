package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;
import com.zonetry.base.util.Log;

public class TestEnterpriseService  extends BaseTest{

	
	public static void main(String[] args) {
		new TestEnterpriseService().excute();
	}
	
	public void detail(){
        Map<String,Object> map=new HashMap<>();
        
         
        
        map.clear();
        map.put(PATH,"/Entsvc/Goods/Detail");
        map.put("goodsID", "561a308216ca440bb96054066f4cd1b6");

        request(map,new IResponseListenerSimpleImpl<EntsvcGoodsDetailResponse>(){
       	 @Override
       	public void onResponse(String response) {
       		 Log.log("aaaaaaaaa", "aaaaaaaaa");
       		super.onResponse(response);
       		
       	}
       	 @Override
       		public Class<EntsvcGoodsDetailResponse> getTClass() {
       			// TODO Auto-generated method stub
       			return EntsvcGoodsDetailResponse.class;
       		}
       	 
       	 @Override
       		public void onResponseSuccess(EntsvcGoodsDetailResponse bean) {
       			// TODO Auto-generated method stub
       			super.onResponseSuccess(bean);
       			
//       			ordercreate(bean);
//       			orderPay();
       		}
       	 @Override
       	public void onError(Throwable e) {
       		 Log.log("onError", "onError"+e);
       		super.onError(e);
       	}
       	 
        });
	}
	protected void orderPay() {
        Map<String,Object> map=new HashMap<>();
        
        
//      
      map.clear();
      map.put(PATH,"/Entsvc/Order/Pay/Chooseethod");
      map.put("orderID", "df78f2f83e9e4b9b8cf6d49e01fdd1b0");
      

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

	protected void ordercreate(EntsvcGoodsDetailResponse bean) {
        Map<String,Object> map=new HashMap<>();
        
         
//        
        map.clear();
        map.put(PATH,"/Entsvc/Order/Create");
        map.put("snapshotNo", "561a308216ca440bb96054066f4cd1b6");
        map.put("categoryID", 1);
        map.put("typeID",1);
        map.put("cityID",1);
        map.put("districtID",1);
        
        map.put("price",0.02);
        map.put("remarks", "测试订单");
 
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

	public void excute(){
		
		detail();
//		orderPay();
	}
}
