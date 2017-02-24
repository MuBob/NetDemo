package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import bean.VersionCheck;

public class Test3 {
public static void main(String[] args) {
    JSONObject json = new JSONObject();
    Map<String ,Object> map=new HashMap<>();
    map.put("dfdfd", 1);
    map.put("dfdfd22", 2);
    map.put("dfdfd33", "aaa");
    map.put("dfd", new VersionCheck());
    List<String> a=new ArrayList<>();
    a.add("777");
    a.add("eoo");
    map.put("a", a);
    Map<String ,Object> bmap=new HashMap<>();
    bmap.put("sss", 1);
//    map.put("bmap", bmap);
    for (Map.Entry<String, Object> entry : map.entrySet()) {
        if (entry.getValue() != null) {
            try {
                json.put(entry.getKey(), new Gson().toJson(entry.getValue()));
//            	  json.put(entry.getKey(), new JSONObject(entry.getValue()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    String s = json.toString();
    System.out.println(s);
    JSONObject json2 = new JSONObject();
    try {
		json2.put("data", map);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String s2 = json2.toString();
    System.out.println(s2);
    String s3="";
	try {
		s3 = new JSONObject(s2).getString("data");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(s3);
    String s4="";
	try {
		s4 = new JSONObject(map).toString();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(s4);
    
    
}
}
