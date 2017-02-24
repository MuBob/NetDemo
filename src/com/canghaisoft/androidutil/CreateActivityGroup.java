package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;

public final class CreateActivityGroup extends BaseClass{

	public CreateActivityGroup(String name,String modeFilePath,String filePath,String fileName){
		super(name,modeFilePath,filePath,fileName);
	}

	public CreateActivityGroup(String name){
		this(name,Create.DemoActivityGroupPath,Create.ActivityGroupPath,getActivityNameByName(name));
	}

	@Override
	public void execute() throws Exception{

		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		textString = textString.replaceAll("DemoActivityGroup",getActivityNameByName(name));
		textString = textString.replaceAll("demoactivitygroupxml",getLayoutXmlNameByName(name));

		write(getPathString(),textString);
	}


	public static void createOne(String activityNameString) throws Exception{
		CreateActivityGroup createActivityGroup = new CreateActivityGroup(activityNameString);
		createActivityGroup.execute();
	}

	public static void createAll(String activityNameString) throws Exception{

		CreateActivityGroup createActivityGroup = new CreateActivityGroup(activityNameString);
		createActivityGroup.execute();
		CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
		createLayoutXml.execute();
		CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
		createResourceXml.execute();
		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
		createDrawableXml.execute();
		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
		midifyResourceXmlByLayoutXml.execute();
	}

	public static void main(String[] args){
		try{
			createAll("GoodsManagerActivityGroup");
			createAll("MobileOrderActivityGroup");
			createAll("OrderManagerActivityGroup");
			createAll("MemberManagerActivityGroup");

		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}

}
