package entity;


import utils.TypeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/18.
 */
public class JSONParser {
    public static Map<String, Object> parserMap(String json) throws Exception {
        if(json==null||"".equals(json))
            throw new Exception("parserMap().解析Json串为空！");
        json=json.trim();
        if(!json.startsWith("{"))
            throw new Exception("parserMap().Json字符串起始字符出现错误！");
        if (!json.endsWith("}"))
            throw new Exception("parserMap().Json字符串结束字符出现错误！");
        int length=json.length();
        Map<String, Object> target=new HashMap<String, Object>();
        String key=null;
        Object value=null;
        boolean isKey=true;
        for (int i = 0; i < length; i++) {
            char c=json.charAt(i);
//            System.out.print("key===i="+i+"-->"+c);
            if(c=='{'){
                continue;
            }
            if(c=='"'&&isKey){
                for (int j = i+1; j < length; j++) {
                    char c2=json.charAt(j);
                    if(c2=='"'){
                        key=json.substring(i + 1, j);
                        isKey=false;
                        i=j;
                        break;
                    }
                }
            }else if(c==':'&&!isKey){
                int listCount=0;
                for (int j = i+1; j < length; j++) {
                    char c2 = json.charAt(j);
                    if ((c2 == ',' ||c2==']'||c2=='}')&& listCount == 0 || listCount < 0) {
                        String str = json.substring(i+1, j).trim();
                        value=str;
                        if (TypeUtil.isNumber(str)) {
                            if (str.contains(".")) {
                                value = Double.parseDouble(str);
                            } else {
                                try {
                                    value = Integer.parseInt(str);
                                } catch (NumberFormatException e) {
                                    try {
                                        value = Long.parseLong(str);
                                    } catch (NumberFormatException e2) {
                                        throw new Exception("parserMap().Json字符串解析数字出现错误！");
                                    }
                                }
                            }
                        }
                        target.put(key, value);
                        isKey = true;
                        i=j;
                        break;
                    }
                    if (c2 == '{' || c2 == '[') {
                        ++listCount;
                    }else if (c2 == '}' || c2 == ']') {
                        --listCount;
                    }
                }
            }
        }
        return target;
    }
}
