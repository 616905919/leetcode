package hhd;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> letterCombinations(String digits) {
		String[] s = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };
		List<String> ans = new ArrayList<String>();
		if (digits.length() == 0)
			return ans;
		for(int i = 0 ; i< s[Integer.valueOf(digits. charAt(0)+"")].length();i++){
			ans.add(s[Integer.valueOf(digits.charAt(0)+"")].charAt(i)+"");
		}
		List<String> tmp = new ArrayList<String>();
		for (int i = 1; i < digits.length(); i++) {
			String s1=s[Integer.valueOf(digits.charAt(i)+"")];
			tmp = new ArrayList<String>(ans);
			ans = new ArrayList<String>();
			for(String str: tmp){
				for( int j = 0 ; j < s1.length(); j++){
					ans.add(str.concat(s1.charAt(j)+""));
				}
			}
		}
		return ans;
	}
}
