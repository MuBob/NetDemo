package utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/8/16.
 */
public class WriterUtil {
    public static void write(File file, String content) throws Exception{
        if (file==null||!file.exists()){
            throw new Exception("文件不存在");
        }
        if(content==null){
            throw new Exception("写入内容为null");
        }
        FileOutputStream fos=new FileOutputStream(file);
        ByteArrayInputStream bis=new ByteArrayInputStream(content.getBytes());
        byte[] b=new byte[2048];
        int len=0;
        while((len=bis.read(b, 0, b.length))>0){
            fos.write(b, 0, len);
            fos.flush();
        }
        fos.close();
    }
}