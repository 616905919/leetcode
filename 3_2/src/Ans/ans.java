package Ans;

import java.util.HashMap;

public class ans {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> ma = new HashMap<Character, Integer>();
		int max = 0;
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!ma.containsKey(s.charAt(i))) {
				ma.put(s.charAt(i), i);
			} else {
				if (idx < ma.get(s.charAt(i)) + 1)
					idx = ma.get(s.charAt(i)) + 1;
				ma.put(s.charAt(i), i);
			}
			if (max < i - idx + 1)
				max = i + 1 - idx;
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "acca";
		ans a = new ans();
		int an = a.lengthOfLongestSubstring(s);
		System.out.println(an);
	}
}
