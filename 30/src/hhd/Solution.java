package hhd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
	public static List<Integer> ans = new ArrayList<Integer>();
	public static String sss;

	public void getans(int beg, int wi, HashMap<String, Integer> hm, int sum) {
		HashMap<String, Integer> tmph = (HashMap<String, Integer>) hm.clone();
		if (sss.length() - beg < sum)
			return;
		while (sss.length() - beg >= sum) {
			hm = (HashMap<String, Integer>) tmph.clone();
			for (int i = 0; i + wi <= sss.length() - beg; i += wi) {
				Integer a;
				if ((a = hm.remove(sss.substring(beg + i, beg + i + wi))) != null) {
					if (--a != 0)
						hm.put(sss.substring(beg + i, beg + i + wi), a);
					else if (hm.isEmpty()) {
						ans.add(beg);
						beg += wi;
						while (sss.length() > beg + sum + wi) {
							if (sss.substring(beg - wi, beg).equals(
									sss.substring(beg + sum - wi, beg + sum))) {
								ans.add(beg);
								beg += wi;
							} else
								break;
						}
						break;
					}
				} else {
					beg+=wi;
					while (sss.length() > beg + sum + wi) {
						if (sss.substring(beg - wi, beg).equals(
								sss.substring(beg + sum - wi, beg + sum))) {
							beg += wi;
						} else if (!tmph.containsKey(sss.substring(beg + sum
								- wi, beg + sum))) {
							beg += wi;
						} else
							break;
					}
					break;
				}
			}
		}
	}

	public List<Integer> findSubstring(String s, String[] words) {
		sss = s;
		ans = new ArrayList<Integer>();
		if (words.length == 0)
			return ans;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = words.length - 1; i >= 0; i--) {
			if (hm.containsKey(words[i]))
				hm.put(words[i], hm.remove(words[i]) + 1);
			else
				hm.put(words[i], 1);
		}
		for (int i = 0; i < words[0].length(); i++) {
			getans(i, words[0].length(), hm, words[0].length() * words.length);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\jiang_000\\Desktop\\111.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// FileInputStream(pathName));
		// StringBuffer sb = new StringBuffer(sss);
		// BufferedWriter br = new BufferedWriter(new FileWriter(f));
		// BufferedWriter br2 =
		String ss = "barfoothefoobarman";
		String[] bb = { "foo","bar"};
		String sss = "abababababababababababababababa"
				+ "bababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
		// br.write(sss);
		// br.flush();
		String[] aa = { "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba" };
		Solution hh = new Solution();
		System.out.println(sss);
		hh.findSubstring(ss, bb);
	}

}
