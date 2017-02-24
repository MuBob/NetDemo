package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateResourceXml extends BaseClass{

	private CharSequence flagString="<!-- newtitle -->";
	public CreateResourceXml(String name){
		super(name,Create.DemoResourceXmlPath,Create.ResourceXmlPath,getResourceLayoutXmlNameByName(name));
	}
	
 
	public void execute(String value) throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		String activityclasstextString = fileReadUtil.getFileTextString(getDemoFilePath());
		activityclasstextString = activityclasstextString.replace("DemoActivity",value);
		activityclasstextString = activityclasstextString.replace("demoxml",getXmlNameByName(name));
		activityclasstextString = activityclasstextString.replace("demoBean",getXmlNameByName(name));
		String manifestPath = getPathString();
		String androidManifestString = fileReadUtil.getFileTextString(manifestPath);
		if(androidManifestString.contains(getActivityNameByName(name))){ return; }
		 
	 
		androidManifestString = androidManifestString.replace(flagString,activityclasstextString+""+flagString);
		write(manifestPath,androidManifestString);
	}
	
	@Override
	public void execute() throws Exception{
//		FileReadUtil fileReadUtil = new FileReadUtil();
//		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
//		FileWriteUtil fileWriteUtil = new FileWriteUtil();
//		fileWriteUtil.setAppend(false);
//		textString = textString.replaceAll("DemoClass",getActivityNameByName(name));
//		textString = textString.replaceAll("demoxml",getXmlNameByName(name));
//		write(getPathString(),textString);
		FileReadUtil fileReadUtil = new FileReadUtil();
		String activityclasstextString = fileReadUtil.getFileTextString(getDemoFilePath());
		activityclasstextString = activityclasstextString.replace("DemoActivity",getActivityNameByName(name));
		activityclasstextString = activityclasstextString.replace("demoxml",getXmlNameByName(name));
		activityclasstextString = activityclasstextString.replace("demoBean",getXmlNameByName(name));
		String manifestPath = getPathString();
		String androidManifestString = fileReadUtil.getFileTextString(manifestPath);
		if(androidManifestString.contains(getActivityNameByName(name))){ return; }
		 
	 
		androidManifestString = androidManifestString.replace(flagString,activityclasstextString+""+flagString);
		write(manifestPath,androidManifestString);
	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + "title" + ".xml";

	}
	public static void createOne(String name) throws Exception{
		CreateResourceXml createResourceXml = new CreateResourceXml(name);
		createResourceXml.execute();

	}
}
