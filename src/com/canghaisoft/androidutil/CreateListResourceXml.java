package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateListResourceXml extends BaseClass{

	public CreateListResourceXml(String name){
		super(name,Create.DemoResourceXmlPath,Create.ResourceXmlPath,getResourceLayoutXmlNameByName(name));
	}

	@Override
	public void execute() throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		textString = textString.replaceAll("DemoClass",getActivityNameByName(name));
		textString = textString.replaceAll("demoxml",getXmlNameByName(name));
		write(getPathString(),textString);

	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".xml";

	}
	public static void createOne(String name) throws Exception{
		CreateListResourceXml createResourceXml = new CreateListResourceXml(name);
		createResourceXml.execute();

	}
}
