package utils;

/**
 * Created by Administrator on 2016/8/17.
 */
public class TextUtils {
    public static boolean isEmpty(CharSequence text){
        if (text==null){
            return true;
        }
        if ("".equals(text)){
            return true;
        }
        return false;
    }
}
