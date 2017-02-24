package com.canghaisoft.androidutil;

import java.util.HashMap;
import java.util.List;

import com.canghaisoft.file.FileReadUtil;

public class ModifyActivityByLayoutXml extends BaseClass{
	public ModifyActivityByLayoutXml(String name){
		super(name);
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
		XmlInfoUtil xmlInfoUtil = new XmlInfoUtil(new CreateLayoutXml(name).getPathString());
		List<HashMap<String, String>> idList = xmlInfoUtil.getIdList();

		for(HashMap<String, String> map:idList){
				String fieldIdname = map.get("id");
				String fieldIdXmlname = map.get("id");
				if(fieldIdname.equals("pullToRefreshListView1")){
					continue;
				}
				String fieldType = map.get("type").replace("com.ynet.citylife.widget.","");

				fieldViewStringBuffer.append("\t");
				fieldViewStringBuffer.append(map.get("type") + " " + fieldIdname + " ;");
				fieldViewStringBuffer.append("\r\n");

				initFieldViewStringBuffer.append("\t\t");
				initFieldViewStringBuffer.append(fieldIdname + "=(" + fieldType + ")this.findViewById(R.id." + fieldIdXmlname + ") ;");
				initFieldViewStringBuffer.append("\r\n");
			}

			textString = textString.replaceAll(replacementString_fieldView,fieldViewStringBuffer.toString());
			textString = textString.replaceAll(replacementString_initFieldView,initFieldViewStringBuffer.toString());
			textString = textString.replaceAll(replacementString_setupFieldView,setupFieldViewStringBuffer.toString());


		write(getPathString(),textString);

	}

	public static void createOne(String name) throws Exception{
		ModifyActivityByLayoutXml modifyActivityByLayoutXml = new ModifyActivityByLayoutXml(name);
		modifyActivityByLayoutXml.execute();

	}

	public static void main(String[] args){
		try{
			createOne("LoginActivity");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
