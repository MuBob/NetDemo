package com.canghaisoft.file;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class FileInfo
{
  File file;
 // String endWithString = ".java";
  String filenamecondString="";
  String containString = "";
  String replacementString = "";
  Set<String> result1 = new TreeSet();
  Set<String> result2 = new TreeSet();
  FileUtil fileUtil = new FileUtil();

  public String getFilenamecondString() {
	return filenamecondString;
}

public void setFilenamecondString(String filenamecondString) {
	this.filenamecondString = filenamecondString;
}

public FileInfo()
  {
  }
public void init(String fileAddress, String filenamecondString, String containString, String replacementString) {
	file = new File(fileAddress);
	setFilenamecondString(filenamecondString);
	setContainString(containString);
	setReplacementString(replacementString);
	loop();

}



//  public FileInfo(File file) {
//    this.file = file;
//    loop();
//  }
//
//  public FileInfo(String fileAddress)
//  {
//    this.file = new File(fileAddress);
//    loop();
//  }
//  public FileInfo(String fileAddress, String endWithString, String containString) {
//    this.file = new File(fileAddress);
//  //  setEndWithString(endWithString);
//    setFilenamecondString(filenamecondString);
//    setContainString(containString);
//    loop();
//  }
//  public FileInfo(String fileAddress, String endWithString, String containString, String replacementString) {
//    this.file = new File(fileAddress);
//  // setEndWithString(endWithString);
//    setFilenamecondString(filenamecondString);
//    setContainString(containString);
//    setReplacementString(replacementString);
//    loop();
//  }
//  public void execute(String fileAddress, String endWithString, String containString, String replacementString) {
//    this.file = new File(fileAddress);
//    //setEndWithString(endWithString);
//    
//    setContainString(containString);
//    setReplacementString(replacementString);
//    loop();
//  }

  void loop(File file)
  {
    File[] files = file.listFiles();
//    for (File file9 : files){
//      if (file9.isDirectory()) {
//        //if (filenamecond(file9)) {
//         // addInfo1(file);
//          loop(file9);
//        //}
//
//      }
//      
//      ]
//      else if (cond(file9)){//isfile
//        addInfo2(file9);
//      }
    if (files==null) {
		return;
	}
    for (File file9 : files) {
    	if (file9.isDirectory()) {//д©б╪
    		loop(file9);
    	}else {//нд╪Ч
    		if (cond(file9)) addInfo2(file9);
		}
	}
  }

  private void addInfo1(File file)
  {
    result1.add(getInfo(file));
  }

  private void addInfo2(File file)
  {
    result2.add(getInfo(file));
  }

  public void loop()
  {
    try
    {
      loop(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

//  public void startloop()
//  {
//    loop();
//  }

  
  protected boolean cond(File file){
	  return filenamecond(file)&&textcond(file);
  }
  
  
  protected boolean textcond(File file)
  {
//    boolean flag = file.getAbsolutePath().endsWith(this.endWithString);
//    if (flag)
//    {
//      if (isContains(file, this.containString)) {
//        return true;
//      }
//    }
//
//    return false;
	  return isContains(file, containString);
  }

  protected boolean filenamecond(File file) {
	//return  file.getAbsolutePath().endsWith(this.endWithString);
	  
    //return true;
	  return file.getName().matches(filenamecondString);
  }

  protected String getInfo(File file)
  {
    return file.toString();
  }

  public Set<String> getInfo1()
  {
    return result1;
  }

  public Set<String> getInfo2() {
    return result2;
  }
  public File getFile() {
    return file;
  }
  public void setFile(File file) {
    this.file = file;
  }

  public String getContainString()
  {
    return containString;
  }
  public void setContainString(String containString) {
    this.containString = containString;
  }
//  public String getEndWithString() {
//    return this.endWithString;
//  }
//  public void setEndWithString(String endWithString) {
//    this.endWithString = endWithString;
//  }
  public Set<String> getResult1() {
    return result1;
  }
  public Set<String> getResult2() {
    return result2;
  }

  public String getReplacementString() {
    return replacementString;
  }
  public void setReplacementString(String replacementString) {
    this.replacementString = replacementString;
  }
  
  public String readFileInfo(File file) {
//    ReadFileInfo readFileInfo = new ReadFileInfo();
//    return readFileInfo.getFileTextString(file.getAbsolutePath());
	  fileUtil.setFileReadAddress(file.getAbsolutePath());
	  return fileUtil.getFileTextString(file.getAbsolutePath());
  }

//  private boolean writeToFile(File file, String textString, boolean append) {
////    FileWriteUtil writeFileInfo = new FileWriteUtil();
////    writeFileInfo.setAppend(append);
////    writeFileInfo.setCharset(FileReadUtil.checkCharset(file.getAbsolutePath()));
////    return writeFileInfo.writetoFile(file.getAbsolutePath(), textString);
//	  
//	  fileUtil.setFileWriteAddress(file.getAbsolutePath());
//	  fileUtil.setText(textString);
//	  fileUtil.setAppend(append);
//	  fileUtil.setCharset(FileReadUtil.checkCharset(file.getAbsolutePath()));
//	  return fileUtil.writetoFile();
//  }
  public boolean isContains(File file, CharSequence string) {
    try {
      String fileText = fileUtil.getFileTextString(file.getAbsolutePath());
      return fileText.contains(string); 
      } catch (Exception e) {
    }
    return false;
  }

  public boolean replace(File file, String regex, String replacement)
  {
    if (!regex.equals(replacement)) {
      try {
//        SearchFileText seachFileText = new SearchFileText(file.getAbsolutePath());
//        String textString = seachFileText.replaceAll(regex, replacement);
//        return writeToFile(file, textString, false);
    	  fileUtil=new FileUtil();
    	  String fileAddress =file.getAbsolutePath();
    	  fileUtil.setFileReadAddress(fileAddress);
    	  fileUtil.setAppend(false);
    	  fileUtil.setFileWriteAddress(fileAddress);
				fileUtil.setCharset(CharsetUtil.checkCharset(fileAddress));
    	  fileUtil.setText(fileUtil.getFileTextString(fileAddress).replaceAll(regex, replacement));
    	 return fileUtil.writetoFile();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public static void main(String[] args)
  {
   // FileInfo files = new FileInfo("D:\\down2\\AutoCode_SSH", ".xml", "", "");
	  FileInfo fileInfo = new FileInfo();
	  String fileAddress="C:\\Users\\canghai\\Desktop\\zubunetfor3606\\src";
	  String filenamecondString=".+[.](java|xml|properties)";
	  String containString="";
	  String replacementString="";
	  fileInfo.init(fileAddress, filenamecondString, containString, replacementString);
    Set<String> set2 = fileInfo.getInfo2();

    for (String string : set2) {
      System.out.println(string);
    }
    System.out.println("OK");
  }
}