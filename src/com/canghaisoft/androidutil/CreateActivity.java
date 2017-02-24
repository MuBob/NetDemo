package com.canghaisoft.androidutil;

import java.io.File;

import com.canghaisoft.file.FileReadUtil;

import util.StringUtils;

public  class CreateActivity extends BaseClass{


	public CreateActivity(String name){
		this(name,Create.DemoActivityPath,Create.ActivityPath,getActivityNameByName(name));
	}

	public CreateActivity(String name,String modeFilePath,String filePath,String fileName){
		super(name,modeFilePath,filePath,fileName);
	}

	@Override
	public void execute() throws Exception{

		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		textString = textString.replaceAll("DemoActivity",getActivityNameByName(name));
		textString = textString.replaceAll("DemoClass",getDemoClassName(name));
		textString = textString.replaceAll("DemoResponse",getDemoResponseName(name));
		textString = textString.replaceAll("democlass",getDemoClassName(name).substring(0,1).toLowerCase() + getDemoClassName(name).substring(1,getDemoClassName(name).length()));
		textString = textString.replaceAll("demolayout",getXmlNameByName(name));
		textString = textString.replaceAll("demodrawable",getDrawableNameByName(name));
		textString = textString.replaceAll("IDemoAction",getIActionNameByName(name));
		textString = textString.replaceAll("IDemoActionImpl",getIActionImplNameByName(name));
		write(getPathString(),textString);
	}


	public static void createOne(String activityNameString) throws Exception{
		CreateActivity createActivity = new CreateActivity(activityNameString);
		createActivity.execute();
	}
	
	

	private static String getTitle(String picname) {
		String title="";
		int index=0;
		 for (int i = 0; i < picname.length(); i++) {
//				System.out.println(picname.substring(i,i+1));
			if (picname.substring(i,i+1).matches("\\w")) {
//				System.out.println(picname.substring(i,i+1));
				index=i;
				break;
			}
		}
 

			return picname.substring(0,index);
		
	}

	private static String getActivityName(String picname) {
		String title="";
		int index=0;
		 for (int i = 0; i < picname.length(); i++) {
//				System.out.println(picname.substring(i,i+1));
			if (picname.substring(i,i+1).matches("\\w")) {
//				System.out.println(picname.substring(i,i+1));
				index=i;
				break;
			}
		}
		
			return StringUtils.firstLetterUpper(picname.substring(index,picname.length()))+"Activity";
	 
	}
	
	
	private static String getPicName(String fullpath) {
		 File file=new File(fullpath);
			return file.getName().replace(".jpg", "").replace(".JPG", "").replace(".png", "").replace(".PNG", "");
		}
	
	public static void createOneByPic(String picfullpath) throws Exception{
		String picname=getPicName(picfullpath);
		String activityNameString=getActivityName(picname);
		String title=getTitle(picname);
		System.out.println("picname"+picname+"title:"+title);
 
		
//		CreateActivity createActivity = new CreateActivity(activityNameString);
//		createActivity.execute();
////		CreateEntity createEntity = new CreateEntity(activityNameString);
////		createEntity.execute();
//		CreateResponse createEntity = new CreateResponse(activityNameString);
//		createEntity.execute();
//		CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
//		createLayoutXml.execute();
		CreateLayoutXmlforcontent createContentLayoutXml = new CreateLayoutXmlforcontent(activityNameString);
		createContentLayoutXml.execute();
//		CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
//		createResourceXml.execute(title);
//		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
//		createDrawableXml.execute(picfullpath);
//		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
//		midifyResourceXmlByLayoutXml.execute();
	}
	
	public static void createAllByPic(String picfullpath) throws Exception{
		String picname=getPicName(picfullpath);
		String activityNameString=getActivityName(picname);
		String title=getTitle(picname);
		System.out.println("picname"+picname+"title:"+title);
 
		
		CreateActivity createActivity = new CreateActivity(activityNameString);
		createActivity.execute();
//		CreateEntity createEntity = new CreateEntity(activityNameString);
//		createEntity.execute();
		CreateResponse createEntity = new CreateResponse(activityNameString);
		createEntity.execute();
		CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
		createLayoutXml.execute();
		CreateLayoutXmlforcontent createContentLayoutXml = new CreateLayoutXmlforcontent(activityNameString);
		createContentLayoutXml.execute();
		CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
		createResourceXml.execute(title);

		
		CreateIAction createIAction = new CreateIAction(activityNameString);
		createIAction.execute();
		CreateIActionImpl createIActionImpl = new CreateIActionImpl(activityNameString);
		createIActionImpl.execute();
		
		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
		midifyResourceXmlByLayoutXml.execute();
		
		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
		createDrawableXml.execute(picfullpath);
	}
	public static void createAll(String activityNameString,String title) throws Exception{
		CreateActivity createActivity = new CreateActivity(activityNameString);
		createActivity.execute();
//		CreateEntity createEntity = new CreateEntity(activityNameString);
//		createEntity.execute();
		CreateResponse createEntity = new CreateResponse(activityNameString);
		createEntity.execute();
		CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
		createLayoutXml.execute();
		CreateLayoutXmlforcontent createContentLayoutXml = new CreateLayoutXmlforcontent(activityNameString);
		createContentLayoutXml.execute();
		CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
		createResourceXml.execute(title);
		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
		createDrawableXml.execute();
		
		CreateIAction createIAction = new CreateIAction(activityNameString);
		createIAction.execute();
		CreateIActionImpl createIActionImpl = new CreateIActionImpl(activityNameString);
		createIActionImpl.execute();
		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
		midifyResourceXmlByLayoutXml.execute();
	}
	public static void createAll(String activityNameString) throws Exception{
		CreateActivity createActivity = new CreateActivity(activityNameString);
		createActivity.execute();
//		CreateEntity createEntity = new CreateEntity(activityNameString);
//		createEntity.execute();
		CreateResponse createEntity = new CreateResponse(activityNameString);
		createEntity.execute();
		CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
		createLayoutXml.execute();
		CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
		createResourceXml.execute();
		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
		createDrawableXml.execute();
		
		CreateIAction createIAction = new CreateIAction(activityNameString);
		createIAction.execute();
		CreateIActionImpl createIActionImpl = new CreateIActionImpl(activityNameString);
		createIActionImpl.execute();
		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
		midifyResourceXmlByLayoutXml.execute();
	}

	public static void createAll(String activityNameString,boolean createActivityflag,boolean createEntityflag,boolean createLayoutXmlflag,boolean createResourceXmlflag,
	        boolean createDrawableXmlflag,boolean midifyResourceXmlByLayoutXmlflag) throws Exception{
		if(createActivityflag){
			CreateActivity createActivity = new CreateActivity(activityNameString);
			createActivity.execute();
		}
		if(createEntityflag){
			CreateEntity createEntity = new CreateEntity(activityNameString);
			createEntity.execute();
		}
		if(createLayoutXmlflag){
			CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
			createLayoutXml.execute();
		}
		if(createResourceXmlflag){
			CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
			createResourceXml.execute();
		}
		createDrawableXmlflag=false;
		if(createDrawableXmlflag){
			CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
			createDrawableXml.execute();
		}
		if(midifyResourceXmlByLayoutXmlflag){
			MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
			midifyResourceXmlByLayoutXml.execute();
		}
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
//			createAll("ShopDetailEditActivity",true,false,true,true,false,true);
//			createAll("GoodsDetailActivity",true,false,true,true,false,true);
//			createAll("GoodsDetailEditActivity",true,false,true,true,false,true);
//			createAll("OrderResultActivity",true,false,true,true,false,true);
//			createAll("VoucherVertifyHistory",true,true,true,true,true,true);
//			createAll("LoginActivity",true,true,true,true,true,true);
//			createAll("StartActivity",true,false,true,true,true,true);
//			createAll("VoucherVertifyActivity",true,false,false,false,false,false);
//			createAll("FavoriteItemActivity",true,true,true,true,false,true);
			createAll("RegistActivity");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}

}
