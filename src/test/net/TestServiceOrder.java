package test.net;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.net.IResponseListenerSimpleImpl;

public class TestServiceOrder  extends BaseTest{

	
	public static void main(String[] args) {
		new TestServiceOrder().excute();
	}

	private void excute() {
        Map<String,Object> map=new HashMap<>();
        
         
        
        map.clear();
        map.put(PATH,"/Entsvc/Order/List/Buyer");
        map.put("pageIndex", 1);
        map.put("pageCount", 10);
 
        request(map, new IResponseListenerSimpleImpl<>());
		
	}

}
