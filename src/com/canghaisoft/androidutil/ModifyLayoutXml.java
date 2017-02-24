package com.canghaisoft.androidutil;

import java.util.HashMap;
import java.util.List;

import com.canghaisoft.file.FileReadUtil;

public class ModifyLayoutXml extends BaseClass{
	public ModifyLayoutXml(String name){
		super(name);
	}


	@Override
	public String getPathString(){
		return new CreateActivity(name).getPathString();
	}

 
	public static void modify(String filepath) throws Exception {
		 
			new ModifyLayoutXml(getName(filepath)).execute(filepath);
		 
	}
	
	
	public void execute(String filepath) throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		XmlInfoUtil xmlInfoUtil = new XmlInfoUtil(filepath);
		String textString = fileReadUtil.getFileTextString(filepath);
		List<HashMap<String, String>> idList = xmlInfoUtil.getIdList();

//		System.err.print(idList);
//		System.err.print("000000000000000000000000");
//		System.out.println();
		for(HashMap<String, String> map:idList){
				final String fieldIdname = map.get("id");
				String fieldIdXmlname = map.get("id");
				String fieldType = getSimpleType(map.get("type"));
//				System.out.println();
//				System.err.print("fieldType333333333333333"+fieldType);
				String newfieldIdname=null;
//				StringBuffer newfieldIdname= new StringBuffer();
				if(fieldIdname.contains("_activity_")){
					continue;
				}else{
					String [] idnames=	fieldIdname.split("_");
					String lastName=fieldIdname;
					if(idnames.length>1){
						lastName=idnames[idnames.length-1];
					}
					
//					System.out.println();
//					System.err.print("fieldType11111111111111111"+fieldType);
//					System.out.println();
//					System.err.print("lastName"+lastName);
//					System.out.println();
					
					if(lastName.contains(fieldType)){
						newfieldIdname=lastName+"_"+getActivityFilePathString(filepath);

//						System.out.println();
//						System.err.println("newfieldIdname"+newfieldIdname);
//						System.out.println("\"@+id/"+fieldIdname+"\"");
//						System.out.println("\"@+id/"+newfieldIdname+"\"");
						textString=	textString.replaceAll("[\"][@][+]id/"+fieldIdname+"\"", "\"@+id/"+newfieldIdname+"\"");

						continue;
					}else{
						newfieldIdname=fieldIdname+fieldType+"_"+getActivityFilePathString(filepath);
//						System.out.println();
//						System.err.println("newfieldIdname"+newfieldIdname);
//						System.out.println("\"@+id/"+fieldIdname+"\"");
//						System.out.println("\"@+id/"+newfieldIdname+"\"");
						textString=	textString.replaceAll("[\"][@][+]id/"+fieldIdname+"\"", "\"@+id/"+newfieldIdname+"\"");
//						System.out.println(textString);
					}
				}
				 

	 
			}

		 
//System.out.println(textString);
		write(filepath,textString);
		
	}
	
	private String getActivityFilePathString(String filepath) {
		FileReadUtil fileReadUtil = new FileReadUtil();
		List<String> strings=fileReadUtil.getFileText(filepath);
		for (String string : strings) {
			if(string.contains("tools:context")){
//				System.out.println("tools:context"+string);
				int contextIndex=string.indexOf("tools:context");
				int firstyinhao=string.indexOf("\"",contextIndex);
				int secondyinhao=string.indexOf("\"",firstyinhao+2);
//				System.out.println("firstyinhao"+firstyinhao);
//				System.out.println("secondyinhao"+secondyinhao);
				String classname=string.substring(firstyinhao,secondyinhao).replaceAll("\"", "");
//				System.out.println("classname"+classname);
				String simpleclassname=getSimpleClassName(classname);
				
//				System.out.println("simpleclassname"+simpleclassname);
				String activitylayoutname=getLayoutXmlNameByName(simpleclassname);
//				System.out.println("activitylayoutname"+activitylayoutname);
				return activitylayoutname;
				
				
			}
		 
		}
 
		
		
		String classname="";
		return null;
	}

	public static String getName(String filepath) {
		FileReadUtil fileReadUtil = new FileReadUtil();
		List<String> strings=fileReadUtil.getFileText(filepath);
		for (String string : strings) {
			if(string.contains("tools:context")){
//				System.out.println("tools:context"+string);
				int contextIndex=string.indexOf("tools:context");
				int firstyinhao=string.indexOf("\"",contextIndex);
				int secondyinhao=string.indexOf("\"",firstyinhao+2);
//				System.out.println("firstyinhao"+firstyinhao);
//				System.out.println("secondyinhao"+secondyinhao);
				String classname=string.substring(firstyinhao,secondyinhao).replaceAll("\"", "");
//				System.out.println("classname"+classname);
				String simpleclassname=getSimpleClassName(classname);
				
//				System.out.println("simpleclassname"+simpleclassname);
				String activitylayoutname=getLayoutXmlNameByName(simpleclassname);
//				System.out.println("activitylayoutname"+activitylayoutname);
				return activitylayoutname;
				
				
			}
		 
		}
 
		
		
		String classname="";
		return null;
	}
//	private String getSimpleClassName(String classname) {
//
//		try {
//			if(classname.contains(".")){
//			String[] classnamelist=classname.split(".");
//			for (String string : classnamelist) {
//				System.out.println("classnameliststring"+string);
//			}
//			System.out.println("classnamelist"+classnamelist);
//		String	simpleclassname=classnamelist[classnamelist.length-1];
//			System.out.println("simpleclassname"+simpleclassname);
//			}else{
//				return classname;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	private static String getSimpleClassName(String classname) {

		
		if(classname.contains(".")){
//			System.out.println();
			String [] slist=classname.split("[.]");
//			for (String s : slist) {
////				System.out.println(s);
//			}
			if(slist!=null&&slist.length>0)
			return slist[slist.length-1];
		}else{
			
			return classname;
		}
		return classname;
	}

	private String getSimpleType(String type) {
		String result=type;
		 try {
			 if(type.contains(".")){
		String [] ll=	type.split("[.]");
		result= ll[ll.length-1];
			 }
			 
			 if(result.contains(" ")){
					String [] l2=	type.split(" ");
					result= l2[0];
			 }
			 
			 if(result.contains("\\s+")){
					String [] l3=	type.split("\\s+");
					result= l3[0];
			 }
			 return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public void execute() throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getPathString());
		String replacementString_fieldView = "//fieldView";
		String replacementString_initFieldView = "//initFieldView";
		String replacementString_setupFieldView = "//setupFieldView";

		StringBuffer fieldStringBuffer = new StringBuffer();
		StringBuffer fieldViewStringBuffer = new StringBuffer();
		StringBuffer initFieldViewStringBuffer = new StringBuffer();
		StringBuffer setupFieldViewStringBuffer = new StringBuffer();
		XmlInfoUtil xmlInfoUtil = new XmlInfoUtil(new CreateLayoutXml(name).getPathString());
		List<HashMap<String, String>> idList = xmlInfoUtil.getIdList();

		for(HashMap<String, String> map:idList){
				String fieldIdname = map.get("id");
				String fieldIdXmlname = map.get("id");
				if(fieldIdname.equals("pullToRefreshListView1")){
					continue;
				}
				String fieldType = map.get("type").replace("com.ynet.citylife.widget.","");

				fieldViewStringBuffer.append("\t");
				fieldViewStringBuffer.append(map.get("type") + " " + fieldIdname + " ;");
				fieldViewStringBuffer.append("\r\n");

				initFieldViewStringBuffer.append("\t\t");
				initFieldViewStringBuffer.append(fieldIdname + "=(" + fieldType + ")this.findViewById(R.id." + fieldIdXmlname + ") ;");
				initFieldViewStringBuffer.append("\r\n");
			}

			textString = textString.replaceAll(replacementString_fieldView,fieldViewStringBuffer.toString());
			textString = textString.replaceAll(replacementString_initFieldView,initFieldViewStringBuffer.toString());
			textString = textString.replaceAll(replacementString_setupFieldView,setupFieldViewStringBuffer.toString());


		write(getPathString(),textString);

	}

	public static void createOne(String name) throws Exception{
		ModifyLayoutXml modifyActivityByLayoutXml = new ModifyLayoutXml(name);
		modifyActivityByLayoutXml.execute();

	}

	public static void main(String[] args) throws Exception{
//		try{
//			createOne("LoginActivity");
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		String filepath="E:\\android\\workspace\\ZoneTryMain\\app\\src\\main\\res\\layout\\activity_login.xml";
		String filepath="E:\\android\\workspace\\ZoneTryMain\\app\\src\\main\\res\\layout\\content_chat.xml";
 
//		new ModifyLayoutXml(getName(path)).execute(path);
		ModifyLayoutXml.modify(filepath);
		
		
	}


 
}
