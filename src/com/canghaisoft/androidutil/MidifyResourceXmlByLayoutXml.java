package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;

public class MidifyResourceXmlByLayoutXml extends BaseClass{

	String flagString = "<!-- newclass -->";
	public MidifyResourceXmlByLayoutXml(String name){
		super(name,Create.DemoAndroidManifestPath,Create.getProgrammePath(),"AndroidManifest.xml");
	}

	@Override
	public void execute() throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		String activityclasstextString = fileReadUtil.getFileTextString(getDemoFilePath());
		activityclasstextString = activityclasstextString.replace("DemoActivity",getActivityNameByName(name));
		activityclasstextString = activityclasstextString.replace("demoxml",getXmlNameByName(name));
		activityclasstextString=activityclasstextString.replaceAll("DemoActivity",getActivityNameByName(name));
		String manifestPath = getPathString();
		String androidManifestString = fileReadUtil.getFileTextString(manifestPath);
		if(androidManifestString.contains(".activity."+getActivityNameByName(name))){ return; }

		androidManifestString = androidManifestString.replace(flagString,activityclasstextString);
		write(manifestPath,androidManifestString);

	}

	@Override
	public String getPathString(){
		return Create.getProgrammePath() + "\\AndroidManifest.xml";

	}
	public static void createOne(String activityNameString) throws Exception{
		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
		midifyResourceXmlByLayoutXml.execute();
	}

	public static void main(String[] args){

		try{
//			createOne("GoodsManagerActivity");
//			createOne("MobileOrderActivity");
//			createOne("OrderManagerActivity");
//			createOne("MemberManagerActivity");
//			createOne("VoucherVertifyActivity");
//			createOne("QrcodeCashierActivity");
//			createOne("MemberManagerActivity");
//			createOne("StatisticAnalysisActivity");
//			createOne("SystemMsgActivity");
//			createOne("PersonalCenterActivity");
//			createOne("ShopManagerActivity");
//			createOne("ShopDetailEditActivity");
//			createOne("GoodsDetailActivity");
//			createOne("GoodsDetailEditActivity");
//			createOne("OrderResultActivity");
//			createOne("VoucherVertifyHistory");
//			createOne("LoginActivity");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
