package com.canghaisoft.file;

import java.io.File;
import java.io.IOException;

public class MoveIMG{

	public static String fengefu = "/";
	public static String panfuString = ":" + fengefu;
	public static void main(String[] args){

		String targetDesksString = new String("E");
		String sourceDeskStrings = new String("CDF");
		move(new File("E:/Pictures"),new File("C:/"));

	}

	private static void move(String sourceDeskStrings,String targetDesksString){
		File targetDesk = new File(targetDesksString + panfuString);

		for(int i = 0;i < sourceDeskStrings.length();i++){
			char onechar = sourceDeskStrings.charAt(i);
			File sourceDesk = new File(String.valueOf(onechar) + panfuString);
			move(sourceDesk,targetDesk);
		}
	}

	/**
	 * ��sourseDesk���ƶ���targetDesk��
	 * @param sourseDesk
	 * @param targetDesk
	 */
	private static void move(File sourseDesk,File targetDesk){
		
		File[] files = sourseDesk.listFiles();
		for(File file:files){
			System.out.println("��ʼ�ƶ�" + file + "\t" + "��" + targetDesk);
			if(file.isDirectory()){
				move(file,targetDesk);
			}else{
				moveOne(file,targetDesk);
			}
		}

	}

	private static void moveOne(File sourceFile,File targetDesk){
		String filename = sourceFile.getName();
		if(filename.startsWith("IMG_")){
			if(filename.length() > 15){
				String dateString = filename.substring(4,12);
				String hourString = filename.substring(13,15);
				String mubiaoFileString = targetDesk.getName() + fengefu + "IMG" + fengefu + dateString + fengefu + hourString + fengefu + sourceFile.getName();
				File mubiaoFile = new File(mubiaoFileString);
				moveFile(sourceFile,mubiaoFile);
			}

        }
		
	}

	private static void moveFile(File sourceFile,File targetFile){
//		System.out.println("��" + sourceFile.getAbsolutePath() + "\t��ʼ");
//		System.out.println("��" + targetFile.getAbsolutePath() + "\t����");

		if(!targetFile.exists()){
			if(!targetFile.getParentFile().exists()){
				targetFile.getParentFile().mkdirs();
			}
			try{
				FileWriteUtil.copyFile(sourceFile,targetFile);
			}catch (IOException e){
				System.out.println("�ļ�" + targetFile.getAbsolutePath() + "������,�½����ļ�ʧ��,�����Ƿ���Ȩ�޴����ļ�");
				e.printStackTrace();
			}
		}else{
			if(sourceFile.length() == targetFile.length()){
				try{
					sourceFile.deleteOnExit();
				}catch (Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("�ļ��ظ�,��鿴");
				System.out.println("��" + sourceFile.getAbsolutePath() + "\t��ʼ");
				System.out.println("��" + targetFile.getAbsolutePath() + "\t����");
			}
		}

//		try{
//			FileWriteUtil.copyFile(sourceFile,targetFile);
//		}catch (IOException e){
//			e.printStackTrace();
//		}catch (Exception e){
//			e.printStackTrace();
//		}
	}
}
