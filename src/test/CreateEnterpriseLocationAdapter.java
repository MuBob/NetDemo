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

public class CreateEnterpriseLocationAdapter extends BaseTest{
	
	
	public static void main(String[] args) {
		new CreateEnterpriseLocationAdapter().excute();
	}

	private void excute() {
		
		
		 
        Map<String,Object> map=new HashMap<>();
		map.clear();
		map.put(PATH, "/Entsvc/Goods/Detail");
		map.put("goodsID", 1);
 

	 
		    
		  request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){

			  @Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
//				super.onResponse(response);
				  System.out.println(response);
				  
				  String newpath= "/EnterpriseServiceTypeSelectAdapter"
						  ;
				  String itemjson="";
//				  try {
//				   itemjson=data.getJSONArray(str).getString(0);
					  
/*					  itemjson="{\"typeID\" : 101," +
        "                                                                                               \"name\" : \"个人独资企业\",\n" +
        "                                                                                               \"synopsis\" : \"一人拥有的独资公司，结构简单，适合于经营个人业务\",\n" +
        "                                                                                               \"period\" : \"≤20个工作日\",\n" +
        "                                                                                               \"desc\" : \"个人独资企业是指依照《中华人民共和国个人独资企业法》在中国境内设立，由一个自然人投资，财产为投资个人所有，投资人以其个人财产对企业债务承担无限责任的经营实体。\\n独资企业，即为个人出资经营、归个人所有和控制、由个人承担经营风险和享有全部经营收益的企业。 以独资经营方式经营的独资企业有无限的经济责任，破产时借方可以扣留业主的个人财产。\\n［设立条件］\\n1.投资人为一个自然人；\\n2.有合法的企业名称；\\n3.有投资人申报的出资；\\n4.有固定的生产经营场所和必要的生产经营条件；\\n5.有必要的从业人员。\",\n" +
        "                                                                                               \"certificateCount\" : 1}";
;	  itemjson=itemjson.replaceAll("\\s", "");*/
					  
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
			 
		});
		}
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	 

}
