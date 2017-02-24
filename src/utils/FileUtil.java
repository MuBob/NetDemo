package utils;

import java.io.File;
import java.io.IOException;


/**
 * Created by Administrator on 2016/8/16.
 */
public class FileUtil {
    private final static String LAST_NAME_JAVA=".java";
    private final static String LAST_NAME_JSON=".json";
    public static File createJavaFile(String path, String foreName){
        return createFile(path, foreName, LAST_NAME_JAVA);
    }
    public static File createJsonFile(String path, String foreName){
        return createFile(path, foreName, LAST_NAME_JSON);
    }
    private static File createFile(String path, String foreName, String lastName){
        File dir=new File(path);
        if (dir.exists()){
            dir.delete();
        }
        dir.mkdirs();
        File file = new File(dir.getAbsolutePath().concat(File.separator)
                .concat(foreName.trim().replace(".", "/")).concat(lastName));
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
