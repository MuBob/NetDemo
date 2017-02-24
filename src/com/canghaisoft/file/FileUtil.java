package com.canghaisoft.file;



public class FileUtil {
	String fileReadAddress;
	String fileWriteAddress;
    String text;
	static String charset = CharsetUtil.defaultCharset;
	boolean append=false;
	
	
	public FileUtil() {
		super();
	}

	
	public FileUtil(String fileReadAddress, String fileWriteAddress, String text) {
		super();
		this.fileReadAddress = fileReadAddress;
		this.fileWriteAddress = fileWriteAddress;
		this.text = text;
	}


	public String getFileReadAddress() {
		return fileReadAddress;
	}

	public void setFileReadAddress(String fileReadAddress) {
		this.fileReadAddress = fileReadAddress;
	}

	public String getFileWriteAddress() {
		return fileWriteAddress;
	}

	public void setFileWriteAddress(String fileWriteAddress) {
		this.fileWriteAddress = fileWriteAddress;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public boolean isAppend() {
		return append;
	}

	public void setAppend(boolean append) {
		this.append = append;
	}

	public static String getFileTextString (String fileAddress){
		FileReadUtil fileReadUtil = new FileReadUtil();
		fileReadUtil.setCharset(CharsetUtil.checkCharset(fileAddress));
		return fileReadUtil.getFileTextString(fileAddress);
		
	}
	
	public static  boolean writetoFile(String fileAddress,String text){
		FileWriteUtil fileWriteUtil = new FileWriteUtil();
		fileWriteUtil.setCharset(charset,true);
		return fileWriteUtil.writetoFile(fileAddress, text);
	}
	
	public  String getFileTextString (){
		charset = CharsetUtil.checkCharset(fileReadAddress);
		return getFileTextString(fileReadAddress);
		
	}
	
	public  boolean writetoFile(){
		FileWriteUtil fileWriteUtil =new FileWriteUtil();
		fileWriteUtil.setAppend(append);
		
		if ("GB".equals(charset.substring(0,2).toUpperCase())) {
			charset="GBK";
			fileWriteUtil.setCharset(charset);
		}else if ("UTF-8".equals(charset.toUpperCase())) {
			fileWriteUtil.setCharset(charset);
		} else {
			return false;
		}
		
		if (fileWriteAddress.toLowerCase().endsWith(".jar")) {
			return false;
		}
		return fileWriteUtil.writetoFile(fileWriteAddress, text);
		 
	}
	

	 public String replaceFirst(String regex, String replacement)
	  {
	    text = getFileTextString(fileReadAddress).replaceFirst(regex, replacement);
	    writetoFile();
	    return text;
	  }

	  public String replaceAll(String regex, String replacement)
	  {
	    text = getFileTextString(fileReadAddress).replaceAll(regex, replacement);
	    writetoFile();
	    return text;
	  }

	  public String replace(CharSequence target, CharSequence replacement)
	  {
	    text = getFileTextString(fileReadAddress).replace(target, replacement);
	    writetoFile();
	    return text;
	  }
	
	public static String getSrcPath(String fileName){
		String relativelyPath = System.getProperty("user.dir");
		return relativelyPath + "/file/" + fileName;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println();
		String fileAddress="C:\\Users\\canghai\\Desktop\\web.xml" ;
		fileAddress="D:\\canghai\\work\\zubunet\\yuandaima87\\WebRoot\\WEB-INF\\site-servlet.xml";
		//fileAddress="D:\\3603\\bookissue17345.html";
		String text ="";
		System.out.println("文件"+fileAddress+"的内容是:");
		System.out.println(getFileTextString(fileAddress));
		
		

	}

}
