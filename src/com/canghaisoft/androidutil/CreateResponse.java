package com.canghaisoft.androidutil;

import com.canghaisoft.file.FileReadUtil;
import com.canghaisoft.file.FileWriteUtil;

public class CreateResponse extends BaseClass{



	public CreateResponse(String name){
		super(name,Create.DemoEntityPath,Create.EntityPath,getDemoResponseName(name));
	}

	@Override
	public void execute() throws Exception{

		FileReadUtil fileReadUtil = new FileReadUtil();
		String textString = fileReadUtil.getFileTextString(getDemoFilePath());
		textString = textString.replaceAll("DemoResponse",getDemoResponseName(name));
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setAppend(false);
		write(getPathString(),textString);
	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".java";
	}
	public static void createOne(String name) throws Exception{
		CreateResponse createEntity = new CreateResponse(name);
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
