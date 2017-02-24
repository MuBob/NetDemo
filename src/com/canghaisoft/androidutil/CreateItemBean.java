package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateItemBean extends BaseClass{


	public CreateItemBean(String name){
		super(name,Create.DemoItemBeanPath,Create.BeanPath,name);
	}

	@Override
	public void execute() throws Exception{

		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		textString = textString.replaceAll("DemoItemBean",name);
		textString = textString.replaceAll("DemoBean",name);
		
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		write(getPathString(),textString);
	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}
	public static void createOne(String name) throws Exception{
		CreateItemBean createItemBean = new CreateItemBean(name);
		createItemBean.execute();

	}
	public static void main(String[] args){

		try{

//			Create.main(args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
