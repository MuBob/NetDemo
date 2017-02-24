package com.canghaisoft.androidutil;

import java.lang.reflect.Field;

import com.canghaisoft.file.FileReadUtil;

public class CreateItemLayoutXml extends BaseClass{

	Class targetClass;
	public static final String replacementString = "<!-- entity -->";
	public static final String oneFieldStringXml = Create.getDemoPath() + "\\onefieldxmldemo.xml";;

	public CreateItemLayoutXml(String name,Class targetClass){
		this(name);
		this.targetClass = targetClass;
	}
	public CreateItemLayoutXml(String name){
		super(name,Create.DemoContentLayoutXmlPath,Create.LayoutXmlPath,getContentXmlNameByName(name));
	}

	public Class getTargetClass(){
		return targetClass;
	}

	public void setTargetClass(Class targetClass){
		this.targetClass = targetClass;
	}
	@Override
	public void execute() throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());

		String oneFieldStringXmlString = fileReadUtil.getFileTextString(oneFieldStringXml);
		System.out.println(oneFieldStringXmlString);
		if(targetClass != null){

			Field[] fields = targetClass.getDeclaredFields();
			StringBuffer fieldStringBuffer = new StringBuffer();
			for(int i = 0;i < fields.length;i++){
				Field field = fields[i];
				String fieldName = field.getName();
				System.out.println(fieldName);
				if(fieldName.equals("serialVersionUID")){
					continue;
				}

				fieldStringBuffer.append(oneFieldStringXmlString.replace("fieldname",fieldName));
				fieldStringBuffer.append("\r\n");
			}
		
			textString = textString.replaceAll(replacementString,fieldStringBuffer.toString());
		}
	
		textString = textString.replaceAll("DemoActivity",getActivityNameByName(name));
		textString = textString.replaceAll("DemoClass",getDemoClassName(name));
		textString = textString.replaceAll("DemoResponse",getDemoResponseName(name));
		textString = textString.replaceAll("democlass",getDemoClassName(name).substring(0,1).toLowerCase() + getDemoClassName(name).substring(1,getDemoClassName(name).length()));
		textString = textString.replaceAll("demolayout",getXmlNameByName(name));
		textString = textString.replaceAll("demodrawable",getDrawableNameByName(name));
		write(getPathString(),textString);


	}


	
	
	
	
	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".xml";
	}
	public static void createOne(String name,Class entityClass) throws Exception{
		CreateItemLayoutXml createLayoutXml = new CreateItemLayoutXml(name);
		createLayoutXml.setTargetClass(entityClass);
		createLayoutXml.execute();

	}

	public static void createOne(String name) throws Exception{
		CreateItemLayoutXml createLayoutXml = new CreateItemLayoutXml(name);
		createLayoutXml.execute();

	}
	public static void main(String[] args){

		try{
//			createOne("GoodsActivity",Goods.class);
//			createOne("LoginActivity",null);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
