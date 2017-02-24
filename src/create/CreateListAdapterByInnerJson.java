package create;

import com.canghaisoft.androidutil.CreateListAdapterItemLayoutXml;
import com.canghaisoft.androidutil.CreateRecyclerViewAdapter;

import util.StringUtils;

public class CreateListAdapterByInnerJson  {

	String adapterName;
	private String itemjson;
	private String path;
	
	public CreateListAdapterByInnerJson(String path ,String name, String json) {
		 this.path=path;
		 this.adapterName=name;
		 
		this.itemjson = json;
	}
	public void excuteWithBean() throws Exception{
		
//		new CreateResponseByJson(oldparams.get("path").toString(), dataString).execute();
//		new CreateListItemBeanByJson(path, itemjson).execute();
		new CreateRecyclerViewAdapter(getAdapterName(path)).excuteWithBean(itemjson);
		new CreateListAdapterItemLayoutXml(getAdapterName(path)).excuteWithBean(itemjson);
		new CreateListItemBeanByJson(path,itemjson,null, null).execute();
 
	}
	public void excute() throws Exception{
		
//		new CreateResponseByJson(oldparams.get("path").toString(), dataString).execute();
//		new CreateListItemBeanByJson(path, itemjson).execute();
		new CreateRecyclerViewAdapter(getAdapterName(path)).execute();
		new CreateListAdapterItemLayoutXml(getAdapterName(path)).execute();
		new CreateListItemBeanByJson(path,itemjson,null, null).execute();
 
	}
	public static void main(String[] args) throws Exception{

		String adapterName="";
		String itemjson="";
	     /* String itemjson="{\n" +
	                "                                                                                             \"uid\" : \"0fda606634d94237bbbe9506bf5eb841\",\n" +
	                "                                                                                             \"email\" : \"Songmin_iOS@126.com\",\n" +
	                "                                                                                             \"title\" : \"投资经理\",\n" +
	                "                                                                                             \"orgFullName\" : \"红杉资本\",\n" +
	                "                                                                                             \"orgShortName\" : \"红杉资本\",\n" +
	                "                                                                                             \"name\" : \"宋敏\",\n" +
	                "                                                                                             \"avatar\" : \"http://files.zonetry.com/avatar/b337f1a68750473e8534803deb2d450d.png\",\n" +
	                "                                                                                             \"cityName\" : \"北京\",\n" +
	                "                                                                                             \"imId\" : \"zonetry_0fda606634d94237bbbe9506bf5eb841\",\n" +
	                "                                                                                             \"receivedProjectCount\" : 0,\n" +
	                "                                                                                             \"commCount\" : 0,\n" +
	                "                                                                                             \"live\" : 0,\n" +
	                "                                                                                             \"categories\" : [ {\n" +
	                "                                                                                               \"categoryId\" : 6,\n" +
	                "                                                                                               \"categoryName\" : \"社交\"\n" +
	                "                                                                                             }, {\n" +
	                "                                                                                               \"categoryId\" : 5,\n" +
	                "                                                                                               \"categoryName\" : \"游戏\"\n" +
	                "                                                                                             }, {\n" +
	                "                                                                                               \"categoryId\" : 3,\n" +
	                "                                                                                               \"categoryName\" : \"智能设备\"\n" +
	                "                                                                                             }, {\n" +
	                "                                                                                               \"categoryId\" : 8,\n" +
	                "                                                                                               \"categoryName\" : \"O2O\"\n" +
	                "                                                                                             } ],\n" +
	                "                                                                                             \"stages\" : [ {\n" +
	                "                                                                                               \"stageId\" : 1,\n" +
	                "                                                                                               \"stageName\" : \"天使轮\"\n" +
	                "                                                                                             }, {\n" +
	                "                                                                                               \"stageId\" : 3,\n" +
	                "                                                                                               \"stageName\" : \"A 轮\"\n" +
	                "                                                                                             } ],\n" +
	                "                                                                                             \"detailLink\" : \"/detail_investor.html\",\n" +
	                "                                                                                             \"isFocus\" : false\n" +
	                "                                                                                           }";*/
	        
	      String path="/HomeInvestor";
		CreateListAdapterByInnerJson create=	new CreateListAdapterByInnerJson(path,null,itemjson);
		create.excute();
//		experts
		 
	}
	
	
	
	
	
	private  String getAdapterName(Object object) {
		if(adapterName!=null) return adapterName;
		
		String classname=null;
		try {
			 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"Adapter");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("classname::::::::::object"+object+"\nadaptername"+classname);
		}
		return classname;
		
	}
}
