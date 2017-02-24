package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateIActionImpl extends BaseClass{



	public CreateIActionImpl(String name){
		super(name,Create.DemoIActionImplPath,Create.IActionImplPath,getIActionImplNameByName(name));
	}

	@Override
	public void execute() throws Exception{

		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		textString = textString.replaceAll("DemoClass",getDemoClassName(name));
		textString = textString.replaceAll("DemoActivity",getActivityNameByName(name));
		textString = textString.replaceAll("DemoResponse",getDemoResponseName(name));
		textString = textString.replaceAll("democlass",getDemoClassName(name).substring(0,1).toLowerCase() + getDemoClassName(name).substring(1,getDemoClassName(name).length()));
		textString = textString.replaceAll("demolayout",getXmlNameByName(name));
		textString = textString.replaceAll("DemoIActionImpl",getIActionImplNameByName(name));
		textString = textString.replaceAll("DemoIAction",getIActionNameByName(name));
		
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
//		System.out.println(getPathString());
//		System.out.println(textString);
		write(getPathString(),textString);
	}



	 
	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}
	public static void createOne(String name) throws Exception{
		CreateIActionImpl createIAction = new CreateIActionImpl(name);
		createIAction.execute();

	}
	public static void main(String[] args) throws Exception{
//		createOne("SplashActivity");
//		createOne("GuidePageActivity");

//		try{
//
//			Create.main(args);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
	}
}
