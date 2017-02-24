package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.net.IResponseListenerSimpleImpl;

public class TestExpertOrder extends BaseTest{

	
	public static void main(String[] args) {
		new TestExpertOrder().excute();
	}

	private void excute() {
        Map<String,Object> map=new HashMap<>();
        map.put(PATH,"/Expert/Subject/Review");
      map.put("snapshotNo","4cf6f0e8b6c94a39836860b472d89c37");
      map.put("reviewResult",true);

        
//        map.put(PATH,"/Expert/Review");
//        map.put("uid","4b2e8858356844e9a55e06cf46877ff4");
//        map.put("reviewResult",true);
        
//        map.clear();
//        map.put(PATH,"/Expert/Subject/List/My");
////        map.put("pageIndex", 1);
////        map.put("pageCount", 10);
 
        request(map, new IResponseListenerSimpleImpl<>());
        
        map.put(PATH,"/Expert/Subject/Review");
      map.put("snapshotNo","a74b8232c48d4d70b2473b118b8b519d");
      map.put("reviewResult",true);

        
//        map.put(PATH,"/Expert/Review");
//        map.put("uid","4b2e8858356844e9a55e06cf46877ff4");
//        map.put("reviewResult",true);
        
//        map.clear();
//        map.put(PATH,"/Expert/Subject/List/My");
////        map.put("pageIndex", 1);
////        map.put("pageCount", 10);
 
        request(map, new IResponseListenerSimpleImpl<>());
		
	}

}