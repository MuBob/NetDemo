package utils;

import entity.DBType;
import entity.JSONParser;
import entity.PrimType;
import org.apache.commons.lang.text.StrBuilder;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/17.
 */
public class GenerateUtil {

    public static String generate(GenerateConfig config) {
        String jsonString = config.getBody();
        /*Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(jsonString, new TypeToken<Map<String, Object>>() {
        }.getType());
        System.out.println("generate().得到的集合长度" + map.size());
        return getObjFromMap(map, config);*/
        try {
            Map<String, Object> map = JSONParser.parserMap(jsonString);
            return getObjFromMap(map, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getObjFromMap(Map<String, Object> map, GenerateConfig config) {
        StringBuffer totalText = new StringBuffer();
        Iterator<String> iteratorKey = map.keySet().iterator();
//    	System.out.println("3333333333333333333333333333333333333333333333");

        if (config.isExtendModelClass()){
            totalText.append(generateDBTable(config.getClassName(), ""));
            innerIndex=0;//内部类生成索引置零
        }
        totalText.append(generateClassStart(config.getClassName(), config.isStaticClass(), config.isExtendModelClass()));
        totalText.append(generateConstructor(config.getClassName()));
        
//        System.err.println("1111111111111111111111111111111111111111111111111111111111111generateClassStart(config.getClassName(), config.isStaticClass())"+config.getClassName());
        
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//        	 String key = entry.getKey();
//             Object value = map.get(key);
//             String nextType = TypeUtil.getType(value);
//             if (!nextType.equals(PrimType.TYPE_INNER_CLASS)) {
//                 boolean isNum = nextType.equals(PrimType.TYPE_NUMBER);
//                 boolean isList = nextType.equals(PrimType.TYPE_LIST);
//                 nextType = typeNum2Str(nextType);
//                 totalText.append(generateAttrs(nextType, key));
////                 totalText.append(generateAttrs(nextType, value));
//             }
//             
//             
//		}
        while (iteratorKey.hasNext()) {
            String nextKey = iteratorKey.next();
            Object nextValue = map.get(nextKey);
            String nextType = TypeUtil.getType(nextValue);
            /*System.out.println("---------------------------------------------------------------------" +
                    "key="+nextKey+"; value="+nextValue+"; type="+nextType+";");*/
            if (!nextType.equals(PrimType.TYPE_INNER_CLASS)) {
                boolean isNum = nextType.equals(PrimType.TYPE_NUMBER);
                boolean isList = nextType.equals(PrimType.TYPE_LIST);
                nextType = typeNum2Str(nextType);
                if (config.isExtendModelClass()){
                    totalText.append(generateDBAttrs(nextType, nextKey));
                }
                totalText.append(generateAttrs(nextType, nextKey));
                if (config.isHaveGetter()) {
                    totalText.append(generateGetter(nextType, nextKey));
                }
                if (isNum && config.isHaveGetterNumber()) {
                    totalText.append(generateGetterNumber(nextKey, nextValue));
                }
                if (config.isHaveSetter()) {
                    totalText.append(generateSetter(nextType, nextKey));
                }
                if (isList) {
                    try {
                        String[] split = StringUtil.splitList(nextValue.toString());
                        String jsonBean=split[0].trim();
                        if (jsonBean.startsWith("{")&&jsonBean.endsWith("}")) {
                            GenerateConfig config1 = new GenerateConfig(generateBeanName(nextKey), jsonBean, true);
                            config1.setExtendModelClass(config.isExtendModelClass());
                            totalText.append(generate(config1));
                        }else{
                            GenerateConfig config2 = new GenerateConfig(generateBeanName(CaptureUtil.captureName(nextKey)), "{}", true);
                            config2.setExtendModelClass(config.isExtendModelClass());
                            totalText.append(generate(config2));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                String type=CaptureUtil.captureName(generateBeanName(nextKey));
                String jsonBean=nextValue.toString().trim();
                totalText.append(generate(new GenerateConfig(generateBeanName(nextKey), jsonBean, true)));
                totalText.append(generateAttrs(type, nextKey));
                if (config.isHaveGetter()) {
                    totalText.append(generateGetter(type, nextKey));
                }
                if (config.isHaveSetter()) {
                    totalText.append(generateSetter(type, nextKey));
                }
            }
        }
        totalText.append(generateClassEnd());
        return totalText.toString();
    }

    private static long innerIndex;
    private static String generateDBAttrs(String type, String key) {
        StringBuffer text=new StringBuffer();
        if (type.equals(PrimType.TYPE_LIST)){
            //集合
            text.append(generateDBForeignBean(key, ++innerIndex, type, null, null));
        }else if (type.equals(PrimType.TYPE_INNER_CLASS)){
            //内部类
            text.append(generateDBForeignBean(key, ++innerIndex, type, null, null));
        }else {
            //通用类型
            text.append(generateDBColumn(key));
        }
        return text.toString();
    }

    private static String generateConstructor(String className){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.PUBLIC_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(className);
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.FIRS_BRACE_CHAR);
        text.append(CharUtil.FIRS_BRACE_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }
    private static String generateAttrs(String type, String key) {
        StringBuffer text = new StringBuffer();
        text.append(CharUtil.PRIVATE_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(type);
        if (type.equals(PrimType.TYPE_LIST)) {
            text.append(CharUtil.FIRS_ANGLE_CHAR);
            text.append(CaptureUtil.captureName(generateBeanName(key)));
            text.append(CharUtil.LAST_ANGLE_CHAR);
        }
        text.append(CharUtil.SPACE_CHAR);
        text.append(key);
        text.append(CharUtil.SEMICOLON_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    private static String generateDBTable(String name, String id){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.AT);
        text.append(DBType.TITLE_TABLE);
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(DBType.NAME);
        text.append(CharUtil.EQUAL_CHAR);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(name);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.ID);
        text.append(CharUtil.EQUAL_CHAR);
        if (!TextUtils.isEmpty(id)) {
            text.append(CharUtil.QUOTE_MARKS_CHAR);
            text.append(id);
            text.append(CharUtil.QUOTE_MARKS_CHAR);
        }
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    private static String generateDBColumn(String name){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.AT);
        text.append(DBType.TITLE_COLUMN);
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(DBType.NAME);
        text.append(CharUtil.EQUAL_CHAR);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(name);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    /**
     *     @ForeignModel(
     *     name = "districts",
     *     innerIndex = 1,
     *     foreignBeanClass = LocationBean.class, foreignKeys = {"cityId"}, foreignKeyTypes = {String.class})
     * @param name
     * @param innerIndex
     * @param innerBeanClass
     * @return
     */
    private static String generateDBForeignBean(String name, long innerIndex, String innerBeanClass, String[] foreignKeys, String[] foreignKeyTypes){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.AT);text.append(DBType.TITLE_FOREIGN);text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(DBType.NAME);text.append(CharUtil.EQUAL_CHAR);text.append(CharUtil.QUOTE_MARKS_CHAR);text.append(name);text.append(CharUtil.QUOTE_MARKS_CHAR);text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.INNER_INDEX);text.append(CharUtil.EQUAL_CHAR);text.append(innerIndex);text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.FOREIGN_BEAN_CLASS);text.append(CharUtil.EQUAL_CHAR);text.append(innerBeanClass);text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.FOREIGN_KEYS);text.append(CharUtil.EQUAL_CHAR);text.append(generateArrayListJson(foreignKeys, true));text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.FOREIGN_KEY_TYPES);text.append(CharUtil.EQUAL_CHAR);text.append(generateArrayListJson(foreignKeyTypes, false));text.append(CharUtil.COMMA_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    private static String generateArrayListJson(String[] array, boolean isStringJson){
        StringBuffer text=new StringBuffer();
        if (array!=null&&array.length>0){
            text.append(CharUtil.FIRS_BRACE_CHAR);
            for (int i = 0; i < array.length; i++) {
                if (i>0)
                    text.append(CharUtil.COMMA_CHAR);
                if (isStringJson)
                    text.append(CharUtil.QUOTE_MARKS_CHAR);
                text.append(array[i]);
                if (isStringJson)
                    text.append(CharUtil.QUOTE_MARKS_CHAR);
            }
            text.append(CharUtil.LAST_BRACE_CHAR);
        }
        return text.toString();
    }

    private static String generateBeanName(String key) {
        return key.concat("Bean");
    }

    private static String generateGetter(String type, String key) {
        StringBuffer text = new StringBuffer();
        text.append(CharUtil.PUBLIC_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        if (type.equals(PrimType.TYPE_LIST)) {
            text.append(CharUtil.PACKAGE_JAVA_UTIL);
        }
        text.append(type);
        if (type.equals(PrimType.TYPE_LIST)) {
            text.append(CharUtil.FIRS_ANGLE_CHAR);
            text.append(CaptureUtil.captureName(generateBeanName(key)));
            text.append(CharUtil.LAST_ANGLE_CHAR);
        }
        text.append(CharUtil.SPACE_CHAR);
        text.append(CharUtil.GET_CHAR);
        text.append(CaptureUtil.captureName(key));
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.FIRS_BRACE_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        text.append(CharUtil.RETURN_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(key);
        text.append(CharUtil.SEMICOLON_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        text.append(generateClassEnd());
        return text.toString();
    }

    private static String typeNum2Str(String type) {
        if (type != null && type.equals(PrimType.TYPE_NUMBER)) {
            return PrimType.TYPE_STRING;
        }
        return type;
    }

    private static String generateGetterNumber(String key, Object nextValue) {
        String type = PrimType.TYPE_NUMBER;
        if (nextValue instanceof Double) {
            type = PrimType.TYPE_DOUBLE;
        } else if (nextValue instanceof Integer) {
            type = PrimType.TYPE_INTEGER;
        } else if (nextValue instanceof Long) {
            type = PrimType.TYPE_LONG;
        }
        StringBuffer text = new StringBuffer();
        text.append(CharUtil.PUBLIC_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(type);
        text.append(CharUtil.SPACE_CHAR);
        text.append(CharUtil.GET_CHAR);
        text.append(CaptureUtil.captureName(key));
        text.append(CaptureUtil.captureName(CharUtil.NUMBER_CHAR));
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.FIRS_BRACE_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        text.append(CharUtil.RETURN_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(type);
        text.append(CharUtil.POINT_CHAR);
        text.append(CharUtil.PARSE_CHAR);
        if (type.equals(PrimType.TYPE_INTEGER)) {
            text.append(CaptureUtil.captureName(CharUtil.INT_TYPE_CHAR));
        } else {
            text.append(type);
        }
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(key);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.SEMICOLON_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        text.append(generateClassEnd());
        return text.toString();
    }

    private static String generateSetter(String type, String key) {
        StringBuffer text = new StringBuffer();
        text.append(CharUtil.PUBLIC_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(CharUtil.VOID_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(CharUtil.SET_CHAR);
        text.append(CaptureUtil.captureName(key));
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(type);
        if (type.equals(PrimType.TYPE_LIST)) {
            text.append(CharUtil.FIRS_ANGLE_CHAR);
            text.append(CaptureUtil.captureName(generateBeanName(key)));
            text.append(CharUtil.LAST_ANGLE_CHAR);
        }
        text.append(CharUtil.SPACE_CHAR);
        text.append(key);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.FIRS_BRACE_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        text.append(CharUtil.THIS_CHAR);
        text.append(CharUtil.POINT_CHAR);
        text.append(key);
        text.append(CharUtil.EQUAL_CHAR);
        text.append(key);
        text.append(CharUtil.SEMICOLON_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        text.append(generateClassEnd());
        return text.toString();
    }

    private static String generateClassStart(String className, boolean haveStatic, boolean isDatabase) {
        StringBuffer text = new StringBuffer();
        text.append(CharUtil.PUBLIC_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        if (haveStatic) {
            text.append(CharUtil.STATIC_CHAR);
            text.append(CharUtil.SPACE_CHAR);
        }
        text.append(CharUtil.CLASS_CHAR);
        text.append(CharUtil.SPACE_CHAR);
        text.append(CaptureUtil.captureName(className));
        text.append(CharUtil.SPACE_CHAR);
//        text.append(haveStatic?CharUtil.IMPLEMENTS_CHAR:CharUtil.EXTENS_CHAR);
        text.append(CharUtil.EXTENS_CHAR);
        text.append(CharUtil.SPACE_CHAR);
         
        text.append(isDatabase?CharUtil.DATABASE_SERIALIZABLE_IMPLEMENTS_CHART:(haveStatic?CharUtil.INNER_SERIALIZABLE_IMPLEMENTS_CHAR:CharUtil.OUTER_SERIALIZABLE_IMPLEMENTS_CHAR));
        text.append(CharUtil.SPACE_CHAR);
        text.append(CharUtil.FIRS_BRACE_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    private static String generateClassEnd() {
        StringBuffer text = new StringBuffer();
        text.append(CharUtil.LAST_BRACE_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }
}
