package com.zonetry.base.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.canghaisoft.androidutil.CreateListAdapterItemLayoutXml;
import com.canghaisoft.androidutil.CreateRecyclerViewAdapter;
import com.zonetry.base.bean.IResponseSuccess;
import com.zonetry.base.constant.Info;
import com.zonetry.base.net.INet;
import com.zonetry.base.net.IResponseListener;
import com.zonetry.base.util.StringUtil;

import create.CreateListItemBeanByJson;
import create.CreateResponseByJson;
import create.Str2Bean;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import util.StringUtils;

public class NetUtil  {
//    public static final String ZC_APP_ID = "265c2860193c4707b96ad1ebb62ac804";
//    public static final String ZC_APP_KEY = "MThhOTYwNmJmNzFlNDNkZmE0Yzk0OTA5NmYxYjk3MzY=";
//    public static final String URL_PRE_STRING="http://api.zonetry.com/PLAT110T";//url鍓嶇疆灞炴��
//    public static final String URL_PRE_STRING="http://192.168.0.153:8080/ZONETRY101";
	 public static final String URL_PRE_STRING="http://zonetry.top:8800/ZONETRY20X";
//	 public static final String URL_PRE_STRING="http://192.168.0.192:8080/ZONETRY101";
	
	 private static String token=null;
   
	public static final <T extends IResponseSuccess> void request(Map<String, Object> params,
			IResponseListener<T> responseListener) {
		Map<String, Object> oldparams=params;
		String url=(String) params.get("url");
		String path=null;
		if (url==null||url.length()==0) {
			 path=(String) params.get("path");
			if (path!=null) {
				 url=URL_PRE_STRING+(path.startsWith("/")?"":"/")+path;
			}
		}
		params.remove("path");
		params.remove("url");
		try {
		String result=	post(url, params);
		if (responseListener!=null) 
			responseListener.onResponse(result);
		//如果Bean没有创建,创建新的bean
		oldparams.put("path", path);
		if (responseListener.isSuccess(result)) {
			createBeanByRequest(oldparams,result,responseListener);
		}
		
		 
		} catch (Exception e) {
			if (responseListener!=null)
			responseListener.onError(e);
		}
	}
	private static <T extends IResponseSuccess> void createBeanByRequest(Map<String, Object> oldparams, String response,
			IResponseListener<T> responseListener) throws Exception {
	
		
		
		
		
//		
//		String beanPath="E:\\android\\workspace\\ZoneTryMain\\app\\src\\main\\java\\com\\zonetry\\platform\\bean\\";
//		try {
//			if(responseListener.isSuccess(response)){
//				String fullPath=beanPath;
//				File file=new File(fullPath);
////				if (file.exists()) {
////					 
////				}else{
//				
					org.json.JSONObject jsonObject=new org.json.JSONObject(response);
				 
					if (jsonObject.has("data")){

						String dataString =jsonObject.getString("data");
						Object dataObject =jsonObject.get("data");
						if(dataObject instanceof org.json.JSONObject){
							
							new CreateResponseByJson(oldparams.get("path").toString(), dataString).execute();
						}else{
							if (dataObject instanceof JSONArray) {
								if (dataObject!=null) {
									JSONArray dataArray=jsonObject.getJSONArray("data");
									if (dataArray.get(0)!=null) {
//										new CreateResponseByJson(oldparams.get("path").toString(), dataString).execute();
										new CreateListItemBeanByJson(oldparams.get("path").toString(), dataArray.get(0).toString()).execute();
//										new CreateRecyclerViewAdapter(getAdapterName(oldparams.get("path").toString())).execute();
//										new CreateListAdapterItemLayoutXml(getAdapterName(oldparams.get("path").toString())).execute();
//										new CreateListItemBeanByJson(oldparams.get("path").toString(), dataArray.get(0).toString()).execute();
									}
 
									}
									
								}
							}
							
						}
//						
//					 
//			        
//			 
////				}
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	private static String getAdapterName(Object object) {
		String classname=null;
		try {
			 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"Adapter");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("classname::::::::::object"+object+"\nadaptername"+classname);
		}
		return classname;
		
	}
 
	private static String getClassName(Object object) {
		String classname=null;
		try {
			 classname=StringUtils.firstLetterUpper(object.toString().replace("/", "").replace("\\", "")+"Response");
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("classname::::::::::object"+object+"\nclassname"+classname);
		}
		return classname;
		
	}
	public static String post(String apiUrl,
            Map<String, Object> params) throws Exception {
		params.remove("url");
        String str = null;
        URL url = new URL(apiUrl);//鏍规嵁鍙傛暟鍒涘缓URL瀵硅薄
        HttpURLConnection con = (HttpURLConnection) url.openConnection();//寰楀埌HttpURLConnection瀵硅薄
 
        con.setRequestProperty("Content-Type",  "application/json; charset=UTF-8"); 
        con.setRequestProperty("Accept", "application/json"); 
//        con.setRequestProperty("User-Agent", "Android/5.0.1/1.0/A0000044586A07/c82b53ba874440bd8f7d205de77a3a44/c07fc2f72ee4b179");
//        mHeaders.put("Accept", "application/json");
//        mHeaders.put("Content-Type", "application/json; charset=UTF-8");
//        mHeaders.put("User-Agent", "Android/"
//                + SystemInfo.getSystemVersionName() + "/"
//                + SystemInfo.getVersionName(content) + "/"
//                + SystemInfo.getIMEI(content) + "/"
//                + SystemInfo.getDeviceId(content)+"/"
//                + SystemInfo.getAndroidId(content));
        
        
        String     appId="cc4fcb66853d44e89fb695b71fd2fb08";
        String appKey="HpUlKrRIbvtCu/vs5hoump3BAmD5fAw+1G1GKYS2J9/3nhvnSyukSA==";
        
//        con.getHeaderFields().put(key, value)
//        mHeaders.put("appId",appId);
//        mHeaders.put("appKey",appKey);
        
        con.setRequestProperty("appId",appId);
        con.setRequestProperty("appKey",appKey);
        
        
//        token=null;
        if (token!=null) {
            con.setRequestProperty("token",token);
		}
   
        
        
        con.setRequestMethod("POST");
        con.setReadTimeout(5000);
        con.setDoInput(true);
        con.setDoOutput(true);//鎸囩ず搴旂敤绋嬪簭瑕佸皢鏁版嵁鍐欏叆 URL 杩炴帴銆�
        String content = getContent(params);//瑙ｆ瀽鍙傛暟锛堣姹傜殑鍐呭锛�
        System.out.println("request:\t"+url+"\tparams:"+content);
        
        
        
        
        con.setRequestProperty("Accept-Charset","UTF-8");
        con.setRequestProperty("Connection", "Keep-Alive");
        
        
        
//        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//璁剧疆鍐呭
        con.setRequestProperty("Content-Length", content.length()+"");//璁剧疆鍐呭闀垮害
        OutputStream os = con.getOutputStream();
        os.write(content.getBytes("utf-8"));//鍙戦�佸弬鏁板唴瀹�
        os.flush();
        os.close();
      Map<String,List<String>> map=  con.getHeaderFields();
    		  
        for (Map.Entry<String, ?> en : map.entrySet()) {
			System.out.println(en.getKey()+":"+en.getValue());
		}
        if (con.getHeaderField("token")!=null&&con.getHeaderField("token").length()>0) {
            System.out.println("TTTTTTTTTtoken"+con.getHeaderField("token"));
			token=con.getHeaderField("token");
		}

        if(con.getResponseCode() == 200){
            str = formatIsToString(con.getInputStream());
//            System.out.println("result200:\t"+str);
    
        }

        return str;
    }
	
		protected static  String getString(Map<String, Object> apiParams) throws Exception {
 
		    JSONObject json = new JSONObject();
//           try {
//				json.put("appId", ZC_APP_ID);
//			    json.put("appKey", ZC_APP_KEY);
////				if (Info.getTOKEN()!=null) {
////					json.put(INet.TOKEN, Info.getTOKEN());
////				}
//			} catch (JSONException e1) {
//				e1.printStackTrace();
//			}
     
           apiParams.remove("path");
           apiParams.remove("url");
 
			for (Map.Entry<String, Object> entry : apiParams.entrySet()) {
				if (entry.getValue()!=null) {
					try {
						json.put(entry.getKey(), entry.getValue().toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
 
			return json.toString();
		}
	
	private static String getContent(Map<String, Object>  params) throws Exception {
		return getString(params);
//		return "{\"appKey\":\"MThhOTYwNmJmNzFlNDNkZmE0Yzk0OTA5NmYxYjk3MzY=\",\"appId\":\"265c2860193c4707b96ad1ebb62ac804\"}";

    }
	
	public static String formatIsToString(InputStream is)throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        try {
            while( (len=is.read(buf)) != -1){
                baos.write(buf, 0, len);
            }
            baos.flush();
            baos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return new String(baos.toByteArray(),"utf-8");
//        System.out.println(Arrays.toString(baos.toByteArray()));
        return new String(baos.toByteArray(),"utf-8");
    }


}
