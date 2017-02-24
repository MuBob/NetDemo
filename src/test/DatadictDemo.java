package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zonetry.base.bean.IResponseSuccess;
import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.java.NetUtil;
import com.zonetry.base.net.IResponseListener;
import com.zonetry.base.net.IResponseListenerSimpleImpl;

import test.net.BaseTest;
import util.StringUtils;

public class DatadictDemo extends BaseTest{
public static void main(String[] args) {
	DatadictDemo demo=
new DatadictDemo();
	demo.excute();
System.out.println(demo.pathlist);
for (int i = 0; i < demo.pathlist.size(); i++) {
	System.out.println(createString(demo.pathlist.get(i)));
}

for (int i = 0; i < demo.faillist.size(); i++) {
	System.err.println(createString(demo.faillist.get(i)));
}

}
private static String getClassName(Object object) {
	String classname=null;
	try {
		 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"ItemBean");
	
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
//		System.out.println("classname::::::::::object"+object+"\nclassname"+classname);
	}
	return classname;
	
}


static String createString(String path){
	String result="requestDatadict(\""+path+"\", BaseListResponse.class, "+getClassName(path)+".class);";
	
    
	
	
	return result;
	
}





//Map <String ,String> urlmap=new HashMap<>();
List<String> pathlist=new ArrayList<>();
List<String> faillist=new ArrayList<>();
public  final <T extends IResponseSuccess> void request(Map<String, Object> map,
		IResponseListener<T> responseListener) {
	final String url=map.get("path").toString();
	IResponseListener<T>  newresponseListener=new IResponseListenerSimpleImpl<T>(){
		
		@Override
		public void onResponse(String response) {
			// TODO Auto-generated method stub
			super.onResponse(response);
			try {
				if (responseListener.isSuccess(response)) {
					pathlist.add(url);
				}else{
					faillist.add(url);
				}
			} catch (Exception e) {
				faillist.add(url);
				e.printStackTrace();
			}
		}
		@Override
		public void onResponseSuccess(T bean) {
	 
			super.onResponseSuccess(bean);
//			urlmap.put(url, value);

	
			
		}
	};
	
	try {
		NetUtil.request(map, newresponseListener);
	} catch (Exception e) {
		e.printStackTrace();
	}
	

}
public void excute(){
    Map<String,Object> map=new HashMap<>();
    
    
    
    
    
    
    
    
	map.clear();
	map.put(PATH,"/Datadict/Location");//00
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
    
	map.clear();
	map.put(PATH,"/Datadict/Country/List");//0
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
    
 
    
	
	map.clear();
	map.put(PATH,"/Datadict/Province/List");//1
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/City/List");//2
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	
	map.clear();
	map.put(PATH,"/Datadict/District/List");//3
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/Nation/List");//4
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/IndustryCategory/List");//5
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
//	
	map.clear();
	map.put(PATH,"/Datadict/ExpertiseField/List");//6
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/FinancingStage/List");//7
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	map.clear();
	map.put(PATH,"/Datadict/ArticleCategory/List");//8
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/AccountChangeType/List");//9
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/AppType/List");//10
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/CertType/List");//11
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/Channel/List");//12
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	
	map.clear();
	map.put(PATH,"/Datadict/Gender/List");//13
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/Degree/List");//14
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/InvestorType/List");//15
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/ProjectStage/List");//16
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/TransactionType/List");//17
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/MoneyUnit/List");//18
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/MarketDataCategory/List");//19
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	map.clear();
	map.put(PATH,"/Datadict/MarketData/List");//20
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	
	map.clear();
	map.put(PATH,"/Datadict/ReportCause/List");//21
	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
	});
	
	
	

//	 map.put(PATH, "/User/Detail");
//
//	       map.put("uid", "233038ada1f94e0a8b0a18ac285c5002");
//	 
//	   	request(map, new IResponseListenerSimpleImpl<SimpleResponse>() {
//		});
	
	
};


}
