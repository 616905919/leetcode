package hhd;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		String an = "";
		int ind = 0;
		while (true) {
			char c;
			if (ind == strs[0].length())
				return an;
			else
				c = strs[0].charAt(ind);
			for (int i = 1; i < strs.length; i++) {
				if (ind == strs[i].length() || c != strs[i].charAt(ind))
					return an;
			}
			an += c;
			ind++;
		}
	}
}
