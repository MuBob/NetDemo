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

	
	private String charset = CharsetUtil.defaultCharset;//Ĭ��jvmĬ���ֽڼ�
	private String splitString="\r\n";//�ָ���,Ĭ�ϻ��з�,��ȡ�ļ�����ı�Ĭ���ô˷ָ�
	private String regexString="\t";//����ÿ���еķָ��ı����ַ�,��֧��������ʽ
	private int limit=0;//spilt�еĴ�������
	

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
	 * ��ø��ļ��е�һ������,ͨ������ѡ���õ�����, ������0��ʼ
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
	 * ��ø��ļ��������ı�
	 * 
	 * @param fileAddress,lineNumber
	 * @return
	 */
	public String getFirstLineString(String fileAddress) {
		return getOneLineString(fileAddress, 0);
	}

	/**
	 * ����һ���ı���ַ,�����ı�����,ÿ��Ԫ�ؼ�Ϊһ��,�˷�����ʱ����,����ʹ�ô˷���
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
	 * ����һ���ı���ַ,���غ���list<string>��list���� 
	 * ��������ʹ����lineString.split(regex, limit)�ָ��ı�,��Ҫ����limit
	 * ��ʹ��setRegex(),setLimit()����������ʽ�ʹ�������.
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
	 * ����һ���ı���ַ,�����ı�����,ÿ��Ԫ�ؼ�Ϊһ��,�˷�����ʱ����
	 * 
	 * @param fileAddress
	 * @return
	 */
	public List<String> getFileTextList(String fileAddress) {
		return getFileText(fileAddress);
	}

	/**
	 * ����һ���ı���ַ,�����ı�����,ÿ��Ԫ�ؼ�Ϊһ��
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
	 * ����һ���ı���ַ,�����ı��ַ���,Ĭ����\r\n�ָ�,����ͨ��setSplitString()����.
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
			System.out.println("�ļ�"+fileAddress+"������");
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
