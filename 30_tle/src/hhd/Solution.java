package hhd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<Integer> ans = new ArrayList<Integer>();

	public void hhd(String s, int i, String[] words) {
		int l = words.length;
		int[] inds = new int[words.length];
		for (int j = 0; j < l; j++) {
			inds[j] = s.indexOf(words[j]);
			if (inds[j] == -1)
				return;
		}
		for (int j = 0; j < l - 1; j++) {
			for (int k = j + 1; k < l; k++) {
				if (inds[j] == inds[k]) {
					inds[k] = s.substring(j + 1).indexOf(words[k])+j+1;
					if (inds[k] == j)
						return;
				}
			}
		}
		Arrays.sort(inds);
		for (int j = 0; j < l - 1; j++) {
			if (inds[j + 1] - inds[j] != words[0].length()) {
				hhd(s.substring(inds[j + 1]), i + inds[j + 1], words);
				return;
			}
		}
		ans.add(inds[0]);
		hhd(s.substring(inds[l - 1] + words[0].length()), i + inds[l - 1]
				+ words[0].length(), words);
		return;
	}

	public List<Integer> findSubstring(String s, String[] words) {
		if (s.length() < words[0].length() * words.length)
			return ans;
		hhd(s, 0, words);
		return ans;
	}

	public static void main(String[] args) {
		String ss = "aaa";
		String[] w = new String[] { "a", "a" };
		Solution a = new Solution();
		a.findSubstring(ss, w);
	}
}
