package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileWriteUtil;

import util.StringUtils;

public abstract class BaseClass{
	public BaseClass(String name){
		super();
		this.name = name;
	}

	String charset = "UTF-8";
	protected String name;//����,Ӧ�ø��ļ���ȥ��׺һ��
	String fileName;//�ļ���,����׺
	String filePath;//�ļ��洢·��,ȫ·��
	String createString;//��������ļ��е�������
	String searchString;//���һ��滻����Ĳ��ִ���
	String modeFilePath;//ģ���ļ���ַ,ȫ·��
	boolean success;//�Ƿ�ɹ�
//	FileReadUtil fileReadUtil = new FileReadUtil();
	public BaseClass(String name,String modeFilePath,String filePath,String fileName){
		super();
		this.name = name;
		this.filePath = filePath;
		this.modeFilePath = modeFilePath;
		this.fileName = fileName;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getFileName(){
		return fileName;
	}

	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public String getFilePath(){
		return filePath;
	}

	public void setFilePath(String filePath){
		this.filePath = filePath;
	}


	public abstract void execute() throws Exception;

	public String getCreateString(){
		return createString;
	}

	public void setCreateString(String createString){
		this.createString = createString;
	}

	public String getSearchString(){
		return searchString;
	}

	public void setSearchString(String searchString){
		this.searchString = searchString;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public String getDemoFilePath(){
		return modeFilePath;
	}
	public String getModeFilePath(){
		return modeFilePath;
	}

	public void setModeFilePath(String modeFilePath){
		this.modeFilePath = modeFilePath;
	}

	public static String getAdapterNameByName(String name){
		if (name.contains("Activity")) {
			name = name.substring(0,1).toUpperCase() + name.substring(1,name.length());
			return name.replace("Activity","Adapter");
		}else if (name.contains("Adapter")){
			return name;
		}else{
			return name+"Adapter";
		}

	}

	public static String getViewHolderNameByAdapterName(String name){
		return name.replace("Adapter","ViewHolder");
	}
	

	public static  String getAdapterItemNameByAdapterName(String name) {
		return name.replace("Adapter","").replace("adapter","").replace("ItemBean", "")+"ItemBean";
	}

	
	public static String getActivityNameByName(String name){
		return name.substring(0,1).toUpperCase() + name.substring(1,name.length());
	}

	public static String getLayoutXmlNameByName(String name){
		return getXmlNameByName(name);

	}

	public static String getAdapterItemLayoutXmlNameByName(String name){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i < name.length();i++){
			char ch = name.charAt(i);
			if(Character.isUpperCase(ch)){
				stringBuffer.append("_" + String.valueOf(ch).toLowerCase());
			}else{
				stringBuffer.append("" + ch);
			}
		}
		if(stringBuffer.toString().startsWith("_")){
			stringBuffer.deleteCharAt(0);
		}
		return "item_" + stringBuffer.toString().replace("_item_bean", "");
	}
	
	public static String getAdapterItemLayoutXmlNameByAdapterName(String adaptername){
		adaptername=adaptername.replace("adapter", "").replace("Adapter", "");
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i < adaptername.length();i++){
			char ch = adaptername.charAt(i);
			if(Character.isUpperCase(ch)){
				stringBuffer.append("_" + String.valueOf(ch).toLowerCase());
			}else{
				stringBuffer.append("" + ch);
			}
		}
		if(stringBuffer.toString().startsWith("_")){
			stringBuffer.deleteCharAt(0);
		}
		if(stringBuffer.toString().endsWith("_")){
			stringBuffer.deleteCharAt(stringBuffer.length()-1);
		}
		
		return "item_" + stringBuffer.toString();
	}

	public static String getResourceLayoutXmlNameByName(String name){
		return "string_" + getXmlNameByName(name);
	}

	public static String getAdapterItemResourceLayoutXmlNameByName(String name){
		return "string_item_" + getBaseXmlNameByName(name);
	}


	public static String getDrawableNameByName(String name){
		return getXmlNameByName(name);
	}

	public static String getBaseXmlNameByName(String name){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i < name.length();i++){
			char ch = name.charAt(i);
			if(Character.isUpperCase(ch)){
				stringBuffer.append("_" + String.valueOf(ch).toLowerCase());
			}else{
				stringBuffer.append("" + ch);
			}
		}
		if(stringBuffer.toString().startsWith("_")){
			stringBuffer.deleteCharAt(0);
		}

		return stringBuffer.toString().replace("_activity_group","").replace("_activity","");
	}

	/**
	 * ��������abc_de��ʽ��xml�ļ�
	 * @param name
	 * @return
	 */
	public static String getXmlNameByName(String name){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i < name.length();i++){
			char ch = name.charAt(i);
			if(Character.isUpperCase(ch)){
				stringBuffer.append("_" + String.valueOf(ch).toLowerCase());
			}else{
				stringBuffer.append("" + ch);
			}
		}
		if(stringBuffer.toString().startsWith("_")){
			stringBuffer.deleteCharAt(0);
		}
		if(name.endsWith("ActivityGroup")){
			return "activity_group_" + stringBuffer.toString().replace("_activity_group","");
		}else if(name.endsWith("Activity")){
			return "activity_" + stringBuffer.toString().replace("_activity","");
		}else{
			return stringBuffer.toString().replace("_activity_group","").replace("_activity","");
		}

	}
	
	
	public static String getIActionImplNameByName(String name) {
		return "I"+getActivityNameByName(name).replace("Activity","ActionImpl");
	}

	public static String getIActionNameByName(String name) {
		return "I"+getActivityNameByName(name).replace("Activity","Action");
	}
	
	public static String getClassNameByJson(Object object) {
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
	
	
	public static String getContentXmlNameByName(String name){
		return getXmlNameByName(name).replace("activity_", "content_");
	}
	protected static String getDemoResponseName(String name) {
		return getDemoClassName(name).replace("_activity", "").replace("_Activity", "").replace("activity", "").replace("Activity", "").replace("Response", "") + "Response";
	}
	public static  String getDemoListItemBeanName(String name) {
		return getDemoClassName(name).replace("_activity", "").replace("_Activity", "").replace("activity", "").replace("Activity", "").replace("Response", "") + "ListItenBean";
	}
	
	
	protected static String getDemoClassName(String name){
		if(!(name.endsWith("Activity") || name.endsWith("ActivityGroup"))){
			try{
//				throw new Exception("�������޸�,��Ҫ��Activity��ӦEntity");
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return getActivityNameByName(name).replace("Activity","");
	}
	protected static String getDemoBeanName(String name){
		if(!(name.endsWith("Activity") || name.endsWith("ActivityGroup"))){
			try{
//				throw new Exception("�������޸�,��Ҫ��Activity��ӦEntity");
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return getActivityNameByName(name).replace("Activity","").replace("Bean", "")+"Bean";
	}

	protected String getDemoDaoClassName(String name){
		return getDemoClassName(name) + "Dao";
	}

	protected void write(String pathString,String textString){
		textString = textString.replaceAll("com.mycompany",Create.srcmycompanyString.replace("\\src\\","").replaceAll("[\\\\]","."));
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		System.out.println(getClass().getName());
		System.out.println("·��" + pathString);
//		System.out.println("����" + textString);
		fileWriteUtil.writetoFile(pathString,textString);

	}

	public abstract String getPathString();
}
