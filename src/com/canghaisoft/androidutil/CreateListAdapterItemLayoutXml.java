package com.canghaisoft.androidutil;

import java.lang.reflect.Field;

 
import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

import util.StringUtils;

public class CreateListAdapterItemLayoutXml extends BaseClass{

	Class targetClass;
	public static final String replacementString = "<!-- entity -->";
	public static final String oneFieldStringXml = Create.getDemoPath() + "\\onefieldxmldemo.xml";;

	public CreateListAdapterItemLayoutXml(String name,Class targetClass){
		this(name);
		this.targetClass = targetClass;
	}
	public CreateListAdapterItemLayoutXml(String name){
		super(name,Create.DemoListItemLayoutXmlPath,Create.LayoutXmlPath,getAdapterItemLayoutXmlNameByAdapterName(name));
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
		
	 
//		textString = textString.replaceAll("itemdemolayout",getAdapterItemLayoutXmlNameByName(name));
//		textString = textString.replaceAll("DemoViewHolder",getViewHolderNameByAdapterName(getAdapterNameByName(name)));
//		textString = textString.replaceAll("DemoItemBean",getAdapterItemNameByAdapterName(getAdapterNameByName(name)));
		textString = textString.replaceAll("DemoRecyclerViewAdapter",name);
		
		
		
		
		
		
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

				fieldStringBuffer.append(oneFieldStringXmlString.replace("fieldname",getFileName() + "_" + fieldName));
				fieldStringBuffer.append("\r\n");
			}
			textString = textString.replaceAll(replacementString,fieldStringBuffer.toString());
		}else{
			
		}
//		System.out.println(textString);
		write(getPathString(),textString);

	}

	@Override
    public String getPathString(){
		return getFilePath() + "\\" + "" + getFileName() + ".xml";
	}

	public static void createOne(String name,Class entityClass) throws Exception{
		CreateListAdapterItemLayoutXml createLayoutXml = new CreateListAdapterItemLayoutXml(name);
		createLayoutXml.setTargetClass(entityClass);
		createLayoutXml.execute();

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

	public static void main(String[] args){

		try{
//			createOne("MobileOrderResultActivity",MobileOrderResult.class);
//			createOne("GoodsActivity",Goods.class);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void excuteWithBean(String itemjson) {
		excuteWithBean(itemjson);
		
	}

}
