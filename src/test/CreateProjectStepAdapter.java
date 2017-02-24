package test;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.net.IResponseListenerSimpleImpl;

import create.CreateListAdapterByInnerJson;
import test.net.BaseTest;

public class CreateProjectStepAdapter extends BaseTest{

	
	

	public static void main(String[] args) {
		new CreateProjectStepAdapter().excute();
	}

	private String itemjson;

	private void excute() {
		
		   itemjson="{                 \"no\": \"00001\",                 \"time\": \"2008-08-08\",                 \"event\": \"公司成立\"             }";
;	  itemjson=itemjson.replaceAll("\\s", "");
			  
		   if (itemjson!=null&&itemjson.length()>0) {
				String newpath="/Project/Step/Detail";
				CreateListAdapterByInnerJson create=	new CreateListAdapterByInnerJson(newpath,null,itemjson);
				try {
					create.excute();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		  
		  
	 
		
		
		
		
		
	
		
	}
		
		
		
	
	
	
	 
}
