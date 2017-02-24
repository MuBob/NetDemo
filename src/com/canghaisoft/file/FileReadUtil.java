package com.canghaisoft.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReadUtil {

	
	private String charset = CharsetUtil.defaultCharset;//默认jvm默认字节集
	private String splitString="\r\n";//分隔符,默认换行符,读取文件后的文本默认用此分割
	private String regexString="\t";//用于每行中的分割文本的字符,不支持正则表达式
	private int limit=0;//spilt中的次数限制
	

	public FileReadUtil() {
		super();
	}

	public FileReadUtil(String charset) {
		super();
		this.charset = charset;
	}



	public String getCharset() {

		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSplitString() {
		return splitString;
	}

	public void setSplitString(String splitString) {
		this.splitString = splitString;
	}

	public String getRegexString() {
		return regexString;
	}

	public void setRegexString(String regexString) {
		this.regexString = regexString;
	}
	

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * 获得该文件中的一行数据,通过行数选择获得的行数, 行数从0开始
	 * 
	 * @param fileAddress
	 * @return
	 */
	public String getOneLineString(String fileAddress, int lineNumber) {

		String lineString = "";
		FileInputStream fis = null;
		InputStreamReader ipReader = null;
		BufferedReader reader = null;
		try {
			fis = new FileInputStream(fileAddress);
			ipReader = new InputStreamReader(fis, getCharset());
			reader = new BufferedReader(ipReader);

			for (int i = 0; (lineString = reader.readLine()) != null; i++) {
				if (i == lineNumber) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
				ipReader.close();
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return lineString;

	}

	/**
	 * 获得该文件的首行文本
	 * 
	 * @param fileAddress,lineNumber
	 * @return
	 */
	public String getFirstLineString(String fileAddress) {
		return getOneLineString(fileAddress, 0);
	}

	/**
	 * 输入一个文本地址,返回文本集合,每个元素即为一行,此方法耗时最少,建议使用此方法
	 * 
	 * @param fileAddress
	 * @return
	 */
	public List<String> getFileText(String fileAddress) {

		String lineString = "";
		FileInputStream fis = null;
		InputStreamReader ipReader = null;
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();

		try {
			fis = new FileInputStream(fileAddress);
			ipReader = new InputStreamReader(fis,getCharset());
			reader = new BufferedReader(ipReader);

			while ((lineString = reader.readLine()) != null) {
				list.add(lineString);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
				ipReader.close();
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * 输入一个文本地址,返回含有list<string>的list集合 
	 * 本方法中使用了lineString.split(regex, limit)分割文本,需要设置limit
	 * 可使用setRegex(),setLimit()设置正则表达式和次数限制.
	 * 
	 * @param fileAddress
	 * @return
	 */
	public List<List<String>> getFileTextSplitList(String fileAddress) {

		String lineString = "";
		FileInputStream fis = null;
		InputStreamReader ipReader = null;
		BufferedReader reader = null;
		List<List<String>> list = new ArrayList<List<String>>();

		try {
			fis = new FileInputStream(fileAddress);
			ipReader = new InputStreamReader(fis, getCharset());
			reader = new BufferedReader(ipReader);

			while ((lineString = reader.readLine()) != null) {
				List<String> lineList=new ArrayList<String> ();
				String [] rowStrings=lineString.split(regexString, limit);
				for (String string : rowStrings) {
					lineList.add(string);
				}
				
				list.add(lineList);
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
				ipReader.close();
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * 输入一个文本地址,返回文本集合,每个元素即为一行,此方法耗时最少
	 * 
	 * @param fileAddress
	 * @return
	 */
	public List<String> getFileTextList(String fileAddress) {
		return getFileText(fileAddress);
	}

	/**
	 * 输入一个文本地址,返回文本数组,每个元素即为一行
	 * 
	 * @param fileAddress
	 * @return
	 */
	public String[] getFileTextArray(String fileAddress) {
		List<String> list = getFileText(fileAddress);
//		String[] newArray = new String[list.size()];
//		for (int i = 0; i < newArray.length; i++) {
//			newArray[i] = list.get(i);
//		}
		String[] newArray =(String[])list.toArray();
		return newArray;
	}
	/**
	 * 输入一个文本地址,返回文本字符串,默认以\r\n分割,可以通过setSplitString()设置.
	 * 
	 * @param fileAddress
	 * @return
	 */
	public  String getFileTextString(String fileAddress) {

		String lineString = "";
		FileInputStream fis = null;
		InputStreamReader ipReader = null;
		BufferedReader reader = null;
		 
        StringBuffer stringBuffer=new StringBuffer();
        File file=new File(fileAddress);
        if (file.exists()) {
			
		
		try {
			fis = new FileInputStream(fileAddress);
			ipReader = new InputStreamReader(fis, getCharset());
			reader = new BufferedReader(ipReader);

			while ((lineString = reader.readLine()) != null) {
				
				stringBuffer.append(lineString);
				stringBuffer.append(splitString);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (reader!=null) reader.close();
				if (ipReader!=null) ipReader.close();
				if (fis!=null) fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
        }else {
			System.out.println("文件"+fileAddress+"不存在");
		}
		return stringBuffer.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 

//		String fileAddress="C:\\Users\\canghai\\Desktop\\a16.txt";
//		String fileAddress = FileUtil.getSrcPath("AndroidManifest.xml");
		String fileAddress = FileUtil.getSrcPath("EventDetailActivity.java");
		System.out.println(CharsetUtil.checkCharset(fileAddress));
		FileReadUtil fileReadUtil =new FileReadUtil();
		fileReadUtil.setCharset(CharsetUtil.checkCharset(fileAddress));
//		fileReadUtil.setCharset("utf-16");
		String textString=fileReadUtil.getFileTextString(fileAddress);
		System.out.println(textString);
		



	    }



	 

}
