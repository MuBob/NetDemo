package test;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.TransformException;

import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.exception.NetException;
import com.zonetry.base.exception.ServiceException;
import com.zonetry.base.net.IResponseListenerSimpleImpl;

import test.net.BaseTest;

public class ProjectStepDemo extends BaseTest{

	public static void main(String[] args) {
		ProjectStepDemo demo=new ProjectStepDemo();
		demo.projectlist();
		demo.projectdetail();		

	}
	
	
	public  void create(){
//        Map<String,Object> map=new HashMap<>();
////      map.put(PATH,"/Entsvc/Order/Get/Buyer");
//      map.put(PATH,"/Project/Get");
//      map.put("projectId", "");
//      map.put("editable", true);
//      map.put("preview", false);
// 
//      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
		
		 
		
	}
	
	public  void projectlist(){
        Map<String,Object> map=new HashMap<>();
//      map.put(PATH,"/Entsvc/Order/Get/Buyer");
      map.put(PATH,"/Project/List/My");
 
 
      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){
    	  @Override
    	public void onResponse(String response) {
    		// TODO Auto-generated method stub
    		super.onResponse(response);
    		try {
				if (isSuccess(response)) {
					
				}
			} catch (NetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	  
      });
		
		 
		
	}
	
	public  void projectdetail(){
        Map<String,Object> map=new HashMap<>();
//      map.put(PATH,"/Entsvc/Order/Get/Buyer");
      map.put(PATH,"/Project/Get");
      map.put("projectId", "b964c9fd72f444d4888cb087bef168ac");
      map.put("editable", true);
      map.put("preview", false);
 
      request(map,new IResponseListenerSimpleImpl<SimpleResponse>(){});
		
		 
		
	}
	

}
