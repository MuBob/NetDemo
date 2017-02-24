package utils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/18.
 */

public class StringUtil {
    public static String[] splitList(String listStr) throws Exception {
        if (listStr == null) {
            throw new Exception("分解空列表串");
        }
        if (listStr.startsWith("[")) {
            listStr = listStr.substring(1, listStr.length());
        } else {
            throw new Exception("列表串开头非法");
        }
        if (listStr.endsWith("]")) {
            listStr = listStr.substring(0, listStr.length() - 1);
        } else {
            throw new Exception("列表串结尾非法");
        }
        if (listStr.trim().equals("")||!listStr.trim().startsWith("{")||!listStr.trim().endsWith("}")) {
            String[] result=new String[1];
            result[0]=listStr;
            return result;
        }
        ArrayList<String> splits = new ArrayList<String>();
        boolean isFirstList = true;
        int length = listStr.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if ('}' == listStr.charAt(j)||j==length-1) {
                    splits.add(listStr.substring(isFirstList ? i : (i + 1), ++j));
                    isFirstList = false;
                    i = j + 1;
                    break;
                }
            }
        }
        String[] result = new String[splits.size()];
        for (int i = 0; i < splits.size(); i++) {
            result[i] = splits.get(i);
        }
        return result;
    }

}
