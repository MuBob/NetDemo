package create;

import utils.FileUtil;
import utils.GenerateConfig;
import utils.GenerateUtil;
import utils.WriterUtil;

import java.io.File;

import com.canghaisoft.file.FileWriteUtil;



/**
 * 通过字符串创建JavaBean文件
 * Created by Administrator on 2016/8/15.
 */
/**
 * 通过字符串创建JavaBean文件
 * Created by Administrator on 2016/8/15.
 */
public class Str2Bean {
    String jsonString;
    String targetFolder;
    String targetName;
//    private final String jsonCachPath="C://str2bean";

    public Str2Bean(String jsonString, String targetFolder,  String targetName){
        this.jsonString=jsonString;
        this.targetFolder=targetFolder;
        this.targetName=targetName;
    }

    public void execute(){
    	System.out.println("222222222222222222222222222222222222222222222222222222"+targetName+"..."+jsonString);
    	StringBuffer totalText=new StringBuffer("");
        totalText.append("package com.zonetry.platform.bean;\n\n");
        
        totalText.append("import com.zonetry.base.bean.BaseResponse;\n\n");
        
        
        
        String beanText=GenerateUtil.generate(new GenerateConfig(targetName, jsonString));

        totalText.append(beanText);
        File beanFile=FileUtil.createJavaFile(targetFolder, targetName);
        try {
        	System.out.println("写入文件"+beanFile+"\n"+ totalText.toString());
            WriterUtil.write(beanFile, totalText.toString());
//        	new FileWriteUtil().writetoFile(fileAddress, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void run() {
//        File jsonFile= FileUtil.createJsonFile(targetFolder, targetName);
//        try {
//            WriterUtil.write(jsonFile, jsonString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String sourceFile=jsonFile.getAbsolutePath()+File.separator+jsonFile.getName();
//        String targetFile=targetFolder+File.separator+targetName;
//       /* try {
//            Jsonschema2Pojo.generate(new HmJsonGeneratorConfig(sourceFile, targetFile));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }*/
//    }
}
