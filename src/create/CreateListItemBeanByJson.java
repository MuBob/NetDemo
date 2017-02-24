package create;

import java.io.File;

import com.canghaisoft.androidutil.Create;
import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

import util.StringUtils;
import utils.FileUtil;
import utils.GenerateConfig;
import utils.GenerateUtil;

public class CreateListItemBeanByJson {
	String name;
	String urlpath;
	String json;
	String adaptername;
	private String parentpath=Create.BeanPath+"\\";
	
 
	
	public CreateListItemBeanByJson(String urlpath,String json,String itemname,String adaptername
			){
		this.urlpath=urlpath;
		this.json=json;
	
		this.name=itemname;
		this.adaptername=adaptername;
		
 
		if (itemname!=null&&itemname.length()>0) {
			name=itemname;
		}else{
			this.name=getClassName(urlpath);
		}
	

 
	 
//	super(name,Create.DemoEntityPath,Create.EntityPath,getDemoResponseName(name));
}
public CreateListItemBeanByJson(String urlpath,String json) {
	 this(urlpath, json, null, null);
	}
public void execute() throws Exception{

		

		FileReadUtil fileReadUtil = new FileReadUtil();
//		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
//		textString = textString.replaceAll("DemoResponse",getDemoResponseName(name));
    	StringBuffer totalText=new StringBuffer("");
        totalText.append("package com.zonetry.platform.bean;\n\n");
        totalText.append("import java.util.List;");
        totalText.append("import com.zonetry.base.bean.BaseResponse;\n\n");
        
        
        
        String beanText=GenerateUtil.generate(new GenerateConfig(name, json));
        totalText.append(beanText);
  
      String  totalText2=totalText.toString();//.replaceAll("com.zonetry.base.bean.BaseResponse", "com.zonetry.base.bean.BaseListResponse").toString();
       
		String fileAddress=parentpath+name+".java"
  				+ "";
      write(fileAddress, totalText2.toString());
//      try {
//            
////          WriterUtil.write(beanFile, totalText.toString());
//  		FileWriteUtil fileWriteUtil = new FileWriteUtil();
//  		fileWriteUtil.setAppend(false);
//  
////  	   	System.out.println("写入文件"+fileAddress+"\n"+ totalText2);
//      	new FileWriteUtil().writetoFile(fileAddress,totalText2);
//      } catch (Exception e) {
//          e.printStackTrace();
//      }

	}
	

protected void write(String pathString,String textString){
	textString = textString.replaceAll("com.mycompany",Create.srcmycompanyString.replace("\\src\\","").replaceAll("[\\\\]","."));
	FileWriteUtil fileWriteUtil = new FileWriteUtil();
	fileWriteUtil.setAppend(false);
	System.out.println(getClass().getName());
	System.out.println("·��" + pathString);
//	System.out.println("����" + textString);
	fileWriteUtil.writetoFile(pathString,textString);

}

	private static String getClassName(Object object) {
		String classname=null;
		try {
			 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"ItemBean");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			System.out.println("classname::::::::::object"+object+"\nclassname"+classname);
		}
		return classname;
		
	}
//	private static String getAdapterName(Object object) {
//		String classname=null;
//		try {
//			 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"Adapter");
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
////			System.out.println("classname::::::::::object"+object+"\nadaptername"+classname);
//		}
//		return classname;
//		
//	}
	
}
