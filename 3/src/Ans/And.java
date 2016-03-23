package Ans;

import java.util.HashMap;

public class And {
	public boolean has(String s) {
		HashMap<Character, Integer> ma = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!ma.containsKey(s.charAt(i))) {
				ma.put(s.charAt(i), i);
			} else
				return false;
		}
		return true;
	}

	public int lengthOfLongestSubstring(String s) {
		// HashMap<Character, Integer> ma = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (has(s.substring(i - max, i + 1))) {
				max++;
			}
		}
		return max;

	}
}
