package assertionsusage;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("abc", "def");
		
		Set<Entry<String, String>> keyvalue = hm.entrySet();
	}

}
