package utils;


/**
 * Created by Administrator on 2016/8/15.
 */
public class CaptureUtil {

    /**
     * 转成驼峰
     *
     * @param str
     * @return
     */
    public static String captureStringLeaveUnderscore(String str) {

        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String temp = str.replaceAll("^_+", "");

        if (!TextUtils.isEmpty(temp)) {
            str = temp;
        }

        String[] strings = str.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            stringBuilder.append(captureName(strings[i]));
        }
        return stringBuilder.toString();
    }


    public static String captureName(String text) {

        if (text.length() > 0) {
            text = text.substring(0, 1).toUpperCase() + text.substring(1);
        }
        return text;
    }

}
