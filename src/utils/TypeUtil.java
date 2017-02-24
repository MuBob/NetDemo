package utils;


import entity.PrimType;

import java.awt.*;

/**
 * Created by Administrator on 2016/8/17.
 */
public class TypeUtil {
    public static String getType(Object value) {
        if (isBoolean(value.toString())) {
            return PrimType.TYPE_BOOLEAN;
        } else if (isNumber(value.toString())) {
            return PrimType.TYPE_NUMBER;
        } else if (isNull(value.toString())) {
            return PrimType.TYPE_NULL;
        } else if (isString(value.toString())) {
            return PrimType.TYPE_STRING;
        } else if (isBeanList(value.toString())) {
            return PrimType.TYPE_LIST;
        } else if (isInnerClass(value.toString())) {
            return PrimType.TYPE_INNER_CLASS;
        }
        return PrimType.TYPE_STRING;
    }

    public static boolean isBoolean(String value) {
        return ("true".equals(value.trim()) || "false".equals(value.trim()));
    }

    public static boolean isNumber(String value) {
        return (value.trim().matches("^-?\\d+$"));
    }

    public static boolean isString(String value) {
        return (value.trim().matches("^((!\\{|!\\}|!\\[|!\\]).)*$"));
    }

    public static boolean isNull(String value) {
        return ("".equals(value.trim()) || "null".equals(value.trim()));
    }

    public static boolean isInnerClass(String value) {
        return (fileterEnter(value.trim()).trim().matches("^\\{.*$"));
    }

    public static boolean isBeanList(String value) {
        return (fileterEnter(value.trim()).matches("^\\[.*$"));
    }

    public static String fileterEnter(String oldStr){
        String newStr=oldStr.replaceAll("\\n","");
        return newStr;
    }
}
