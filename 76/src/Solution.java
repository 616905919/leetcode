import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class Solution {
    public String minWindow(String s, String t) {
    	HashMap<Character, Integer> h = new HashMap<Character, Integer>();
    	for(int i = 0 ; i < t.length() ; i++){
    		if(h.containsKey(t.charAt(i))){
    			h.put(t.charAt(i), h.get(t.charAt(i))+1);
    		}
    		else h.put(t.charAt(i), 1);
    	}
    	new Object().equals(new Object());
    	Collection<Integer> c = new ArrayList<Integer>();
    }
}
