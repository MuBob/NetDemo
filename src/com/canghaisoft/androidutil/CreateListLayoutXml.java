package com.canghaisoft.androidutil;

import java.lang.reflect.Field;

 
import com.canghaisoft.file.FileReadUtil;

public class CreateListLayoutXml extends BaseClass{

	Class targetClass;
	public static final String replacementString = "<!-- entity -->";
	public static final String oneFieldStringXml = Create.getDemoPath() + "\\onefieldxmldemo.xml";;

	public CreateListLayoutXml(String name,Class targetClass){
		this(name);
		this.targetClass = targetClass;
	}
	public CreateListLayoutXml(String name){
		super(name,Create.DemoListLayoutXmlPath,Create.LayoutXmlPath,getLayoutXmlNameByName(name));
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
//		System.out.println(oneFieldStringXmlString);
		StringBuffer fieldStringBuffer = new StringBuffer();
		if(targetClass != null){

			Field[] fields = targetClass.getDeclaredFields();

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
		}else{
//			fieldStringBuffer
//			        .append("<com.ynet.citylife.widget.PullToRefreshListView android:id=\"@+id/pullToRefreshListView1\" android:layout_width=\"match_parent\" android:layout_height=\"wrap_content\"></com.ynet.citylife.widget.PullToRefreshListView>");
			textString = textString.replaceAll(replacementString,fieldStringBuffer.toString());
		}


		write(getPathString(),textString);


	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".xml";
	}
	public static void createOne(String name,Class entityClass) throws Exception{
		CreateListLayoutXml createLayoutXml = new CreateListLayoutXml(name);
		createLayoutXml.setTargetClass(entityClass);
		createLayoutXml.execute();

	}

	public static void createOne(String name) throws Exception{
		CreateListLayoutXml createLayoutXml = new CreateListLayoutXml(name);
		createLayoutXml.execute();

	}
	public static void main(String[] args){

//		try{
//			createOne("GoodsActivity",Goods.class);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
	}

}
