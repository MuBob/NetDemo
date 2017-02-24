package com.canghaisoft.androidutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.canghaisoft.file.FileReadUtil;
 
 

public class XmlInfoUtil{

	String pathString = "";

	public XmlInfoUtil(String pathString){
		super();
		this.pathString = pathString;
	}

	/**
	 * map���������[id=?,type=?]
	 * @return
	 */
	public List<HashMap<String, String>> getIdList(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		FileReadUtil fileReadUtil = new FileReadUtil();
		List<String> lineStrings = fileReadUtil.getFileTextList(pathString);
//		System.out.println(lineStrings);
		for(int i = 0;i < lineStrings.size();i++){
		String	oneLineString=lineStrings.get(i);

			if(oneLineString.contains("android:id")){
//				System.out.println("YYYYYYYYYYYYYY");
				HashMap<String, String> map = new HashMap<String, String>();
				int idindex=oneLineString.indexOf("android:id");
				oneLineString = oneLineString.substring(idindex,oneLineString.length());
//				System.out.println(oneLineString);
				int idstartindex = oneLineString.indexOf("@+id/") + "@+id/".length();
				oneLineString = oneLineString.substring(idstartindex,oneLineString.length());
//				System.out.println(oneLineString);
				int idendindex = oneLineString.indexOf("\"");
//				System.out.println("idstartindex" + idstartindex);
//				System.out.println("idendindex" + idendindex);
				String idString = oneLineString.substring(0,idendindex);
//				System.out.println(idString);
				map.put("id",idString);
				
				
				String type=getType(i,pathString);
				
	 
				
				map.put("type",type);
				
				
				
				
				
//				System.out.println(map);
//				String oneLineString2 = lineStrings.get(i).substring(0,idindex);
//				if(oneLineString2.contains("<")){
//					oneLineString2 = oneLineString2.substring(oneLineString2.indexOf("<"),oneLineString2.length());
//					oneLineString2 += " ";
////					System.out.println(oneLineString2);
//					String typeString = oneLineString2.substring(oneLineString2.indexOf("<") + 1,oneLineString2.indexOf(" "));
//					typeString = typeString.trim();
//					System.out.println("type"+typeString);
//					map.put("type",typeString);
//				}else{
//					if(i > -1){
//						oneLineString2 = lineStrings.get(i - 1);
//						oneLineString2 += " ";
////						System.out.println(oneLineString2);
////						System.out.println("<index" + oneLineString2.indexOf("<"));
//						if (oneLineString2.indexOf("<")==-1) {
//							continue ;
//						}
//						oneLineString2 = oneLineString2.substring(oneLineString2.indexOf("<"),oneLineString2.length());
//						String typeString = oneLineString2.substring(oneLineString2.indexOf("<") + 1,oneLineString2.indexOf(" "));
//						typeString = typeString.trim();
//						System.out.println("type"+typeString);
//						map.put("type",typeString);
//					}
//
//				}
				list.add(map);

			}else{
//				System.out.println("NNNNNNNNNNNNNNNN");
			}
		}


		return list;

	}
	private String getType(int idindex, String pathString) {
		String type=null;
		FileReadUtil fileReadUtil = new FileReadUtil();
		List<String> lineStrings = fileReadUtil.getFileTextList(pathString);
//		System.out.println(lineStrings);
		for(int i = idindex;i>0;i--){
			
		String	oneLineString=lineStrings.get(i);
		if(oneLineString.contains("<")) {
			int startIndex=oneLineString.indexOf("<");
			int konggeIndex=oneLineString.indexOf(" ");
//			System.out.println("startIndex"+startIndex);
//			System.out.println("konggeIndex"+konggeIndex);
			String fulltype=null;
			if (konggeIndex>0) {
				 fulltype=oneLineString.substring(startIndex, konggeIndex).replace("<", "");
			}else{
				fulltype=oneLineString.substring(startIndex).replace("<", "");
			}
		
			String simpleType=fulltype;
			 
			
			
			try {
				String[] fulltypelist=fulltype.split(".");
				simpleType=fulltypelist[fulltypelist.length-1];
			} catch (Exception e) {
				// TODO: handle exception
			}
//			System.out.println("simpleType"+simpleType);
			if(simpleType!=null&&simpleType.length()>0)
			return simpleType;
		}
		}
		return null;
	}

	public List<HashMap<String, String>> getIdList0(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		FileReadUtil fileReadUtil = new FileReadUtil();
		List<String> lineStrings = fileReadUtil.getFileTextList(pathString);
//		System.out.println(lineStrings);
		for(int i = 0;i < lineStrings.size();i++){
		String	oneLineString=lineStrings.get(i);

			if(oneLineString.contains("android:id")){
//				System.out.println("YYYYYYYYYYYYYY");
				HashMap<String, String> map = new HashMap<String, String>();
				int idindex=oneLineString.indexOf("android:id");
				oneLineString = oneLineString.substring(idindex,oneLineString.length());
//				System.out.println(oneLineString);
				int idstartindex = oneLineString.indexOf("@+id/") + "@+id/".length();
				oneLineString = oneLineString.substring(idstartindex,oneLineString.length());
				System.out.println(oneLineString);
				int idendindex = oneLineString.indexOf("\"");
				System.out.println("idstartindex" + idstartindex);
				System.out.println("idendindex" + idendindex);
				String idString = oneLineString.substring(0,idendindex);
//				System.out.println(idString);
				map.put("id",idString);
				String oneLineString2 = lineStrings.get(i).substring(0,idindex);
				if(oneLineString2.contains("<")){
					oneLineString2 = oneLineString2.substring(oneLineString2.indexOf("<"),oneLineString2.length());
					oneLineString2 += " ";
//					System.out.println(oneLineString2);
					String typeString = oneLineString2.substring(oneLineString2.indexOf("<") + 1,oneLineString2.indexOf(" "));
					typeString = typeString.trim();
					map.put("type",typeString);
				}else{
					if(i > 0){
						oneLineString2 = lineStrings.get(i - 1);
						oneLineString2 += " ";
//						System.out.println(oneLineString2);
//						System.out.println("<index" + oneLineString2.indexOf("<"));
						if (oneLineString2.indexOf("<")==-1) {
							continue ;
						}
						oneLineString2 = oneLineString2.substring(oneLineString2.indexOf("<"),oneLineString2.length());
						String typeString = oneLineString2.substring(oneLineString2.indexOf("<") + 1,oneLineString2.indexOf(" "));
						typeString = typeString.trim();
						map.put("type",typeString);
					}

				}
				list.add(map);

			}else{
//				System.out.println("NNNNNNNNNNNNNNNN");
			}
		}


		return list;

	}
	
	
	public static void	printOneXml(String xmlname){
		
		List<HashMap<String, String>> list = new XmlInfoUtil("E:\\workspace18\\jinxin\\res\\layout\\"+xmlname+".xml").getIdList();
//		System.out.println(list);
		
		System.out.println();
		String  replaceString="view_point_";
		for (HashMap<String, String> hashMap : list) {
//			commentStockCode = (EditText) findViewById(R.id.commentStockCode);
			System.out.println(hashMap.get("type")+" "+hashMap.get("id").replace(replaceString, "")+";");
			
			
		}
		System.out.println();
		
		 
		for (HashMap<String, String> hashMap : list) {
//			commentStockCode = (EditText) findViewById(R.id.commentStockCode);
//			System.out.println(hashMap.get("id")+""+hashMap.get("type"));
			System.out.println("\t\t"+hashMap.get("id").replace(replaceString, "")+" = ("+hashMap.get("type")+") view.findViewById(R.id."+hashMap.get("id")+");");
			
			
		}
	}

	public static void main(String[] args){
//		List<HashMap<String, String>> list = new XmlInfoUtil("C:\\android\\workplace\\CityLife0\\res\\layout\\activity_goods_manager.xml").getIdList();
//		layout=R.layout.favorites_detail_tupian;
//		break;
//	case FavoriteItem.TYPE_GUANDIAN:
//		layout=R.layout.favorites_detail_guandian;
//		break;
//	case FavoriteItem.TYPE_LIANJIE:
//		layout=R.layout.favorites_detail_lianjie;
//		break;
//	case FavoriteItem.TYPE_WENZHANG:
//		layout=R.layout.favorites_detail_wenzhang;
//		break;
//	case FavoriteItem.TYPE_WANGZHI:
//		layout=R.layout.favorites_detail_wangzhi;
//		break;
//	case FavoriteItem.TYPE_WENZI:
//		layout=R.layout.favorites_detail_wenzi;
//		printOneXml("favorites_detail_tupian");
//		printOneXml("favorites_detail_guandian");
//		printOneXml("favorites_detail_lianjie");
//		printOneXml("favorites_detail_wenzhang");
//		printOneXml("favorites_detail_wangzhi");
//		printOneXml("item_view_point_wenzi");
//		printOneXml("item_studio_stock_child");

	}
}
