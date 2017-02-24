package com.canghaisoft.androidutil;

import java.io.File;

import com.canghaisoft.file.FileWriteUtil;

public class CreateDrawable extends BaseClass{


	public CreateDrawable(String name){
		super(name,Create.DemoDrawablePath,Create.DrawablePath,getDrawableNameByName(name));
	}
 
	public void execute(String picfullpath) throws Exception{
//		if(!getFileName().contains("activity_group")){ return; }

		FileWriteUtil.copyFile(new File(picfullpath),new File(getPathString()));

	}
	@Override
	public void execute() throws Exception{
//		if(!getFileName().contains("activity_group")){ return; }

		FileWriteUtil.copyFile(new File(getDemoFilePath()),new File(getPathString()));

	}

	@Override
	public String getPathString(){
		return getFilePath() + "\\" + getFileName() + ".jpg";
	}

}
