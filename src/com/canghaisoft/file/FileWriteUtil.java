package com.canghaisoft.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriteUtil {

	private String charset = CharsetUtil.defaultCharset;
	private boolean append=false;
	
	public FileWriteUtil(){
		super();
	}

	public FileWriteUtil(String charset,boolean append){
		super();
		this.charset = charset;
		this.append = append;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
	public void setCharset(String charset,boolean append) {
		this.charset = charset;
		this.append = append;
	}
	
	public boolean isAppend() {
		return append;
	}
	public void setAppend(boolean append) {
		this.append = append;
	}
	
	public boolean writetoFileIfNotExists(String fileAddress,String text){
	    File file=new File(fileAddress);
	    if (!file.exists()) {
			 return writetoFile(fileAddress,text);
		}else{
			return false;
		}
	}
	
	
	public boolean writetoFile(String fileAddress,String text){
//		return  writetoFile0(fileAddress,text);
	    File file=new File(fileAddress);
	    if (!file.exists()) {
			 return writetoFile0(fileAddress,text);
		}else{
			return false;
		}
	}
/**
 * ��һ���ļ���д��һ���ַ����ı�,�����Ƿ�д��ɹ�.
 * @param fileAddress
 * @param text
 * @return
 */
	 boolean writetoFile0(String fileAddress,String text){
//		text = text.replaceAll("com.mycompany",Create.srcmycompanyString.replace("\\src\\","").replaceAll("[\\\\]","."));
		FileOutputStream fos=null;
		OutputStreamWriter opsWriter=null;
		BufferedWriter bw=null;
	    boolean flag=false;
	    File file=new File(fileAddress);
	    if (!file.exists()) {
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("�ļ�"+fileAddress+"������,�½����ļ�ʧ��,�����Ƿ���Ȩ�޴����ļ�");
				e.printStackTrace();
				return false;
			}
		}
		try {
			fos = new FileOutputStream(fileAddress,append);
			opsWriter=new OutputStreamWriter(fos,charset);
			bw=new BufferedWriter(opsWriter);

			bw.write(text);
			flag=true;
			 
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}finally{
			try {
				
				bw.flush();
				bw.close();
				opsWriter.close();
				fos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		return flag;
	}

	// �����ļ�
	public static void copyFile(File sourceFile,File targetFile) throws IOException{
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try{
			// �½��ļ����������������л���
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// �½��ļ���������������л���
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// ��������
			byte[] b = new byte[1024 * 16];
			int len;
			while((len = inBuff.read(b)) != -1){
				outBuff.write(b,0,len);
			}
			// ˢ�´˻���������
			outBuff.flush();
		}finally{
			// �ر���
			if(inBuff != null)
				inBuff.close();
			if(outBuff != null)
				outBuff.close();
		}
	}

}
