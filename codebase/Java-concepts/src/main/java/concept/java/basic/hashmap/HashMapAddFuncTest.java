package concept.java.basic.hashmap;

import java.util.HashMap;

public class HashMapAddFuncTest {
	public static void main(String[] args) {
		HashMap<String, Object> map=new HashMap<>();
		
		Object o	=new Object();
		System.out.println(o);
		System.out.println("val :"+map.put("1", o));
		System.out.println("val :"+map.put("1", o));
		System.out.println("val :"+map.put("1", new Object()));
		System.out.println("val :"+map.get("1"));
		
		
	}

}
