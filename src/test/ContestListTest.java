package test;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;

import create.CreateListAdapterByInnerJson;
import test.net.BaseTest;

public class ContestListTest extends BaseTest{

	public static void main(String[] args) {
		ContestListTest demo=new ContestListTest();
		demo.createAdapter();
	 	

	}

	
	void createAdapter(){
		
/*	String	  itemjson=     "{\n" +
            "    \"contestID\" : 1,\n" +
            "    \"logo\" : \"http://p3.pstatp.com/list/204x140/f0100015f5f0f132d51\",\n" +
            "    \"posterImage\" : \"http://p3.pstatp.com/large/f0100015f5f0f132d51\",\n" +
            "    \"contestName\" : \"再砍全队最高分\",\n" +
            "    \"isRecommend\" : false,\n" +
            "    \"isSelf\" : false,\n" +
            "    \"link\" : \"http://www.toutiao.com/a6340405894535299329/\",\n" +
            "    \"statusName\" : \"进行中\"\n" +
            "  }";*/
String itemjson="";
		  
		  itemjson=itemjson.replaceAll("\\s", "");
		  			  
		  		   if (itemjson!=null&&itemjson.length()>0) {
		  				String newpath="/Contest/List";
		  				CreateListAdapterByInnerJson create=	new CreateListAdapterByInnerJson(newpath,null,itemjson);
		  				try {
		  					create.excute();
		  				} catch (Exception e) {
		  					// TODO Auto-generated catch block
		  					e.printStackTrace();
		  				}
		  			}
		  		  
		  		  
		
		
	}
	private void create() {
        Map<String,Object> map=new HashMap<>();
//      map.put(PATH,"/Entsvc/Order/Get/Buyer");
      map.put(PATH,"/Contest/List");
      
      map.put("pageIndex", 0);
      map.put("pageCount", 10);
      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
		
	}
 

}
