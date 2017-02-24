package com.canghaisoft.androidutil;

public class CreateBackup{

//	public static String ProgrammePath = "C:\\android\\workplace\\AndroidFramework1";//锟斤拷目锟斤拷锟侥柯�
//	public static String srcmycompanyString = "\\src\\com\\mycompany";
	public static String ProgrammePath = "E:\\android\\workspace\\ZoneTryMain\\app\\src\\platform";//锟斤拷目锟斤拷锟侥柯�
//	app\src\main\java\com\zonetry
	public static String srcmycompanyString = "\\java\\com\\zonetry\\platform";
	public static final String ActivityPath = getProgrammePath() + getSrcmycompanyString() + "\\activity";//目录
	public static final String ActivityGroupPath = getProgrammePath() + getSrcmycompanyString() + "\\activity\\detail";//目录
	public static final String EntityPath = getProgrammePath() + getSrcmycompanyString() + "\\bean";//目录
	public static final String LayoutXmlPath = getProgrammePath() + "\\res\\layout";//目录
	public static final String ResourceXmlPath = getProgrammePath() + "\\res\\values";//目录
	public static final String AndroidManifestPath = getProgrammePath() + "\\AndroidManifest.xml";
	public static final String DrawablePath = getProgrammePath() + "\\res\\drawable";
	public static final String DaoPath = getProgrammePath() + getSrcmycompanyString() + "\\dao";
	public static final String ListAdapterPath = getProgrammePath() + getSrcmycompanyString() + "\\adapter";
	public static final String IActionPath = getProgrammePath() + getSrcmycompanyString() + "\\action";//目录
	public static final String IActionImplPath = getProgrammePath() + getSrcmycompanyString() + "\\action";//目录

	public static String DemoPath = "E:\\android\\workspace\\zonetryeclipse\\AndroidDevelopTool3forzonetry\\file";
	public static final String DemoActivityPath = getDemoPath() + "\\DemoActivity.java";
	public static final String DemoActivityGroupPath = getDemoPath() + "\\DemoActivityGroup.java";
	public static final String DemoListActivityPath = getDemoPath() + "\\DemoListActivity.java";
	public static final String DemoMainActivityPath = getDemoPath() + "\\DemoMainActivity.java";
	public static final String DemoEntityPath = getDemoPath() + "\\Demo.java";
	public static final String DemoIActionPath = getDemoPath() + "\\DemoIAction.java";
	public static final String DemoIActionImplPath = getDemoPath() + "\\DemoIActionImpl.java";
	public static final String DemoLayoutXmlPath = getDemoPath() + "\\demo.xml";
	public static final String DemoContentLayoutXmlPath = getDemoPath() + "\\content_demo.xml";
	public static final String DemoListLayoutXmlPath = getDemoPath() + "\\demolist.xml";
	public static final String DemoListItemLayoutXmlPath = getDemoPath() + "\\demolistitem.xml";
	public static final String DemoResourceXmlPath = getDemoPath() + "\\string_demo.xml";
	public static final String DemoAndroidManifestPath = getDemoPath() + "\\DemoAndroidManifest.xml";
	public static final String DemoDrawablePath = getDemoPath() + "\\demo.jpg";
	public static final String DemoDaoPath = getDemoPath() + "\\DemoDao.java";
	public static final String DemoListAdapterPath = getDemoPath() + "\\DemoListAdapter.java";

	public static String getSrcmycompanyString(){
		return srcmycompanyString;
	}

	public static void setSrcmycompanyString(String srcmycompanyString){
		CreateBackup.srcmycompanyString = srcmycompanyString;
	}

	public static String getDemoPath(){
		return DemoPath;
	}

	public static void setDemoPath(String demoPath){
		DemoPath = demoPath;
	}

	public static String getProgrammePath(){
		return ProgrammePath;
	}

	public static void setProgrammePath(String programmePath){
		ProgrammePath = programmePath;
	}

	public static void main(String[] args){
//		String activityNameString = "MyTestTTActivity";
//		try{
//			createOne(activityNameString);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
	}

	public static void createOne(String activityNameString) throws Exception{
		createOne(activityNameString,true,true,true,true,true,true);
//		CreateActivity createActivity = new CreateActivity(activityNameString);
//		createActivity.execute();
//		CreateEntity createEntity = new CreateEntity(activityNameString);
//		createEntity.execute();
//		CreateLayoutXml createLayoutXml = new CreateLayoutXml(activityNameString);
//		createLayoutXml.execute();
//		CreateResourceXml createResourceXml = new CreateResourceXml(activityNameString);
//		createResourceXml.execute();
//		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
//		createDrawableXml.execute();
//		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
//		midifyResourceXmlByLayoutXml.execute();
	}

	public static void createOne(String activityNameString,boolean createActivityflag,boolean createEntityflag,boolean createLayoutXmlflag,boolean createResourceXmlflag,
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
		if(createDrawableXmlflag){
		CreateDrawable createDrawableXml = new CreateDrawable(activityNameString);
		createDrawableXml.execute();
		}
		if(midifyResourceXmlByLayoutXmlflag){
		MidifyResourceXmlByLayoutXml midifyResourceXmlByLayoutXml = new MidifyResourceXmlByLayoutXml(activityNameString);
		midifyResourceXmlByLayoutXml.execute();
		}
	}

}
