package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateListResponse extends BaseClass{



	public CreateListResponse(String name){
		super(name,Create.DemoEntityPath,Create.EntityPath,getDemoResponseName(name));
	}

	@Override
	public void execute() throws Exception{

		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		textString = textString.replaceAll("DemoListResponse",getDemoResponseName(name));
		textString = textString.replaceAll("DemoListItemBean",getDemoListItemBeanName(name));
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		write(getPathString(),textString);
	}



	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}
	public static void createOne(String name) throws Exception{
		CreateListResponse createEntity = new CreateListResponse(name);
		createEntity.execute();

	}
	public static void main(String[] args){

		try{

			Create.main(args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
