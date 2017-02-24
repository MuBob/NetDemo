package com.canghaisoft.androidutil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import util.StringUtils;

 
import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateRecyclerViewAdapter extends BaseClass{
	Class targetClass;

	public static final String replacementString = "<!-- entity -->";
	public static final String oneFieldStringXml = Create.getDemoPath() + "\\onefieldxmldemo.xml";;

	public CreateRecyclerViewAdapter(String name){
		super(name,Create.DemoRecyclerViewAdapterPath,Create.ListRecyclerViewAdapterPath,getAdapterNameByName(name));
	}

	public CreateRecyclerViewAdapter(String name,Class targetClass){
		this(name);
		this.targetClass = targetClass;
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
		textString = textString.replaceAll("DemoRecyclerViewAdapter",getAdapterNameByName(name));
		String className =targetClass==null?getDemoClassName(name):targetClass.getSimpleName();
		textString = textString.replaceAll("DemoClass",className);
		textString = textString.replaceAll("democlass",StringUtils.firstLetterLower(className));
		textString = textString.replaceAll("itemdemolayout",getAdapterItemLayoutXmlNameByAdapterName(name));
		textString = textString.replaceAll("DemoViewHolder",getViewHolderNameByAdapterName(getAdapterNameByName(name)));
		textString = textString.replaceAll("DemoItemBean",getAdapterItemNameByAdapterName(getAdapterNameByName(name)));
		
		
//		DemoBean
		if(targetClass!=null){

		Field[] fields = targetClass.getDeclaredFields();
		StringBuffer fieldStringBuffer = new StringBuffer();
		for(int i = 0;i < fields.length;i++){
			Field field = fields[i];
			String fieldName = field.getName();
//			System.out.println(fieldName);
//			System.out.println(field.getName());
//			System.out.println(field.getType());
			if(fieldName.equals("serialVersionUID")){
				continue;
			}
//			fieldStringBuffer.append("\tpublic static final String " + fieldName.toUpperCase() + " = \"" + fieldName + "\" ;\r\n");
		}
		String replacementString_fieldView = "//fieldView";
		String replacementString_initFieldView = "//initFieldView";
		String replacementString_setupFieldView = "//setupFieldView";

		StringBuffer fieldViewStringBuffer = new StringBuffer();
		StringBuffer initFieldViewStringBuffer = new StringBuffer();
		StringBuffer setupFieldViewStringBuffer = new StringBuffer();
		List<HashMap<String, String>> fieldslist = new XmlInfoUtil(new CreateListAdapterItemLayoutXml(name).getPathString()).getIdList();

		for(HashMap<String, String> map:fieldslist){
			String fieldIdname = map.get("id").replace(getAdapterItemLayoutXmlNameByName(name) + "_","");
			String fieldIdXmlname = map.get("id");
			if(fieldIdname.equals("pullToRefreshListView1")){
				continue;
			}
			String fieldType = map.get("type").replace("com.ynet.citylife.widget.","");

//			fieldViewStringBuffer.append("\t");
//			fieldViewStringBuffer.append(map.get("type") + " " + fieldIdname + " ;");
//			fieldViewStringBuffer.append("\r\n");

			initFieldViewStringBuffer.append("\t\t");
			initFieldViewStringBuffer.append(fieldType);
			initFieldViewStringBuffer.append(" ");
			initFieldViewStringBuffer.append(fieldIdname + " = (" + fieldType + ")convertView.findViewById(R.id." + fieldIdXmlname + ") ;");
			initFieldViewStringBuffer.append("\r\n");

			setupFieldViewStringBuffer.append("\t\t");
			setupFieldViewStringBuffer.append(fieldIdname + ".set" + "Text" + "(\"\"+" + "entity.get" + StringUtils.firstLetterUpper(fieldIdname) + "()" + ");");
			setupFieldViewStringBuffer.append("\r\n");

		}
		textString = textString.replaceAll(replacementString,"");
		textString = textString.replaceAll(replacementString_fieldView,fieldViewStringBuffer.toString());
		textString = textString.replaceAll(replacementString_initFieldView,initFieldViewStringBuffer.toString());
		textString = textString.replaceAll(replacementString_setupFieldView,setupFieldViewStringBuffer.toString());

		}
	
		write(getPathString(),textString);
		
		createDemoItemBeanIfNotExist(getAdapterItemNameByAdapterName(getAdapterNameByName(name)));
		createitemdemolayoutIfNotExist(getAdapterNameByName(name));

	}



	private void createitemdemolayoutIfNotExist(String adapterName) {
//		CreateLayoutXml.createOne(adapterItemNameByAdapterName);
	 
		try {
			new CreateListAdapterItemLayoutXml(adapterName).execute();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}

	private void createDemoItemBeanIfNotExist(String adapterItemNameByAdapterName) {

		try {
			new CreateItemBean(getAdapterItemNameByAdapterName(adapterItemNameByAdapterName)).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}
	public static void createOne(String name,Class entityClass) throws Exception{
		CreateRecyclerViewAdapter createListAdapter = new CreateRecyclerViewAdapter(name);
		createListAdapter.setTargetClass(entityClass);
		createListAdapter.execute();
	}

	
	protected void write(String pathString,String textString){
		textString = textString.replaceAll("com.mycompany",Create.srcmycompanyString.replace("\\src\\","").replaceAll("[\\\\]","."));
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		System.out.println(getClass().getName());
		System.out.println("·��" + pathString);
//		System.out.println("����" + textString);
		fileWriteUtil.writetoFileIfNotExists(pathString,textString);

	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		try{
//			createOne("MobileOrderResultActivity",MobileOrderResult.class);
//			createOne("EnterpriseServiceCellAdapter");
			createOne("HomeCellAdapter");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public static void createOne(String adaptername) throws Exception {
	 
	 createOne(adaptername, null);
	}

	public void excuteWithBean(String itemjson) throws Exception {
		execute();
		
	}



}
