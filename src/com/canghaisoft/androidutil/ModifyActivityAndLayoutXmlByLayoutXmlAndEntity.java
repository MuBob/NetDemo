package com.canghaisoft.androidutil;

import java.util.HashMap;
import java.util.List;

 
import com.canghaisoft.file.FileReadUtil;

public class ModifyActivityAndLayoutXmlByLayoutXmlAndEntity extends BaseClass{
	String idFlag = "android:id=\"@+id/";
	Class clazz;
	public ModifyActivityAndLayoutXmlByLayoutXmlAndEntity(String name){
		super(name);
	}

	public ModifyActivityAndLayoutXmlByLayoutXmlAndEntity(String name,Class clazz){
		super(name);
		this.clazz = clazz;
	}

	@Override
	public String getPathString(){
		return new CreateActivity(name).getPathString();
	}

	@Override
	public void execute() throws Exception{
		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getPathString());
		String replacementString_fieldView = "//fieldView";
		String replacementString_initFieldView = "//initFieldView";
		String replacementString_setupFieldView = "//setupFieldView";

		StringBuffer fieldStringBuffer = new StringBuffer();
		StringBuffer fieldViewStringBuffer = new StringBuffer();
		StringBuffer initFieldViewStringBuffer = new StringBuffer();
		StringBuffer setupFieldViewStringBuffer = new StringBuffer();
		String layoutxmlPathString = new CreateLayoutXml(name).getPathString();
		XmlInfoUtil xmlInfoUtil = new XmlInfoUtil(layoutxmlPathString);
		List<HashMap<String, String>> idList = xmlInfoUtil.getIdList();

		String layoutxmlString = fileReadUtil.getFileTextString(layoutxmlPathString);
		String qianzhuiString = new CreateLayoutXml(name).getFileName() + "_";
		
		for(HashMap<String, String> map:idList){
			String fieldIdname = map.get("id");
			String fieldIdXmlname ="";
			if(fieldIdname.startsWith(qianzhuiString)){
				fieldIdXmlname= map.get("id");
            }else {
				fieldIdXmlname = qianzhuiString + map.get("id");
			}

				String fieldType = map.get("type").replace("com.ynet.citylife.widget.","");

				fieldViewStringBuffer.append("\t");
			fieldViewStringBuffer.append(map.get("type") + " " + fieldIdXmlname.replace(qianzhuiString,"") + " ;");
				fieldViewStringBuffer.append("\r\n");

				initFieldViewStringBuffer.append("\t\t");
			initFieldViewStringBuffer.append(fieldIdXmlname.replace(qianzhuiString,"") + "=(" + fieldType + ")this.findViewById(R.id." + fieldIdXmlname + ") ;");
				initFieldViewStringBuffer.append("\r\n");
				

			setupFieldViewStringBuffer.append("");

				//�޸�ԭxml��id
				String oldOneIdString=idFlag+fieldIdname;
				String newOneIdString=idFlag+fieldIdXmlname;
			layoutxmlString = layoutxmlString.replace(oldOneIdString,newOneIdString);

			}

			textString = textString.replaceAll(replacementString_fieldView,fieldViewStringBuffer.toString());
			textString = textString.replaceAll(replacementString_initFieldView,initFieldViewStringBuffer.toString());
			textString = textString.replaceAll(replacementString_setupFieldView,setupFieldViewStringBuffer.toString());


		write(getPathString(),textString);
		write(layoutxmlPathString,layoutxmlString);
	}

	public static void createOne(String name,Class clazz) throws Exception{
		new ModifyActivityAndLayoutXmlByLayoutXmlAndEntity(name,clazz).execute();
	}

	public static void main(String[] args){
//		try{
//			createOne("VoucherVertifyActivity",VoucherVertify.class);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
	}
}
