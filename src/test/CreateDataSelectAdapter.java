package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;

import create.CreateListAdapterByInnerJson;
import test.net.BaseTest;
import util.StringUtils;

public class CreateDataSelectAdapter extends BaseTest{
	
	
	public static void main(String[] args) {
		new CreateDataSelectAdapter().excute();
	}

	private void excute() {
		
		
		 
        Map<String,Object> map=new HashMap<>();
		map.clear();
//		map.put(PATH, "/Entsvc/Goods/Detail");
//		map.put("goodsID", 1);
 

	 
		    
 
				// TODO Auto-generated method stub
//				super.onResponse(response);
//				  System.out.println(response);
				  
				  String newpath= "/EnterpriseServiceProcessList"
						  ;
				  String itemjson;
//				  try {
//				   itemjson=data.getJSONArray(str).getString(0);
					  
					  itemjson="{\n" +
                        "    \"typeID\" : 101,\n" +
                        "    \"locationID\" : \"f0e12e3bb6da42339078257bfd113625\",\n" +
                        "    \"locationName\" : \"北京\",\n" +
                        "    \"price\" : 0.01,\n" +
                        "    \"marketPrice\" : 0.11,\n" +
                        "    \"displayStatus\" : 0\n" +
                        "  }";	
					  
					  itemjson=  "{\"no\":1,\"desc\":\"核名\"}";
					  
					  
					  
					  itemjson=itemjson.replaceAll("\\s", "");
					  
				   if (itemjson!=null&&itemjson.length()>0) {
						CreateListAdapterByInnerJson create=	new CreateListAdapterByInnerJson(newpath,null,itemjson);
						try {
							create.excute();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
//				  try {
//					JSONObject root=new JSONObject(response);
//					JSONObject data=root.getJSONObject("data");
//					Iterator its=	data.keys();
//					
//					for (Iterator iter = data.keys(); iter.hasNext();) {
//						  String str = (String)iter.next();
//						  if (str.endsWith("s")) {
//							  System.out.println(str);
////							  String newpath="/"+"Home"+StringUtils.firstLetterUpper(str.substring(0, str.length()-1));
//							  String newpath= "/User/Bill/List"
//									  ;
//							  String itemjson;
//							  try {
////							   itemjson=data.getJSONArray(str).getString(0);
//								  
//								  itemjson="{\"no\"：\"16fb6ee747ac4dbfa2dd0e744b70117d\",            \"billTypeName\"：\"购买支付\",            \"tradeTypeName\"：\"专家预约\",            \"payMethodName\"：\"余额／支付宝／微信\",            \"money\"：-1.01,            \"notes\"：\"交易描述\",            \"week\"：\"周日\",            \"day\"：\"08-25\"        }";
//;	  itemjson=itemjson.replaceAll("\\s", "");
//								  
//							   if (itemjson!=null&&itemjson.length()>0) {
//									CreateListAdapterByInnerJson create=	new CreateListAdapterByInnerJson(newpath,null,itemjson);
//									create.excute();
//								}
//						} catch (Exception e) {
//							
//						}
//							  
//							
//						  
//						  }
//						 
//						 }
//			 
//					
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				  
				
				
 
 
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
	}
	 

}
