package create;

import java.io.File;

import com.canghaisoft.androidutil.CreateActivity;

public class CreateActivitys {

	
	public static void main(String[] args) {
		File file =new File("C:\\Users\\sks\\Desktop\\pics");
		for (File onefile : file.listFiles()) {
			create(onefile.getPath());
		}
	}
	
	 static void c(String name,String title){
		try {
			CreateActivity.createAll(name,title);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 static void create(String picfullpath){
		 System.out.println(picfullpath);
		try {
			CreateActivity.createAllByPic(picfullpath);
//			CreateActivity.createOneByPic(picfullpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
