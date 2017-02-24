package create;

import java.io.File;

import com.canghaisoft.androidutil.Create;
import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

import util.StringUtils;
import utils.FileUtil;
import utils.GenerateConfig;
import utils.GenerateUtil;

public class CreateResponseByJson {

	String name;
	String urlpath;
	String json;
	private String parentpath=Create.BeanPath+"\\";
	
	public CreateResponseByJson(){
		
	}
	
	public CreateResponseByJson(String urlpath,String json
			){
		this.urlpath=urlpath;
		this.json=json;
		this.name=getClassName(urlpath);
	
		
//	super(name,Create.DemoEntityPath,Create.EntityPath,getDemoResponseName(name));
}
	public void execute() throws Exception{

		

		FileReadUtil fileReadUtil = new FileReadUtil();
//		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
//		textString = textString.replaceAll("DemoResponse",getDemoResponseName(name));
    	StringBuffer totalText=new StringBuffer("");
        totalText.append("package com.zonetry.platform.bean;\n\n");
        
        totalText.append("import com.zonetry.base.bean.BaseResponse;\n\n");
        totalText.append("import java.util.List;\n\n");
        
        
        String beanText=GenerateUtil.generate(new GenerateConfig(name, json));
        totalText.append(beanText);
    	String fileAddress=parentpath+name+".java"
				+ "";
        write(fileAddress, totalText.toString());
     
//        try {
//     
////            WriterUtil.write(beanFile, totalText.toString());
//    		FileWriteUtil fileWriteUtil = new FileWriteUtil();
//    		fileWriteUtil.setAppend(false);
//    	
////    	   	System.out.println("写入文件"+fileAddress+"\n"+ totalText.toString());
////        	new FileWriteUtil().writetoFile(fileAddress, totalText.toString()
////        			);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

	}
	protected void write(String pathString,String textString){
		textString = textString.replaceAll("com.mycompany",Create.srcmycompanyString.replace("\\src\\","").replaceAll("[\\\\]","."));
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		System.out.println(getClass().getName());
		System.out.println("·��" + pathString);
//		System.out.println("����" + textString);
//		fileWriteUtil.writetoFileIfNotExists(pathString,textString);
		fileWriteUtil.writetoFile(pathString,textString);

	}
	
	private static String getClassName(Object object) {
		String classname=null;
		try {
			 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"Response");
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			System.out.println("classname::::::::::object"+object+"\nclassname"+classname);
		}
		return classname;
		
	}
	
	
	
	
	
	
	
	
	
}
