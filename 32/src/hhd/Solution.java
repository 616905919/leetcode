package hhd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Solution {
	public int longestValidParentheses_on2(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				int m = 0;
				if (s.charAt(j) == '(')
					m++;
				else {
					if (m == 0)
						break;
					if (m == 1) {
						m--;
						if (ans < j - i + 1)
							ans = j - i + 1;
					} else
						m--;
				}
			}
		}
		return ans;
	}

	class ok {
		int fi;
		int la;
		int le;

		public ok(int a, int b) {
			fi = a;
			la = b;
			le = b - a + 1;

		}
	}

	public int longestValidParentheses(String s) {
		List<ok> hh = new ArrayList<ok>();
		int re = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
				ok tmp = new ok(i, i + 1);
				hh.add(tmp);
				re = 2;
			}
		}
		while (!hh.isEmpty()) {
			ok o1 = hh.remove(0);
			int i = hh.size();
			while (i-- > 0) {
				ok o2 = hh.remove(0);
				if (o1.la + 1 == o2.fi) {
					ok neo = new ok(o1.fi, o2.la);
					// hh.add(neo);
					o1 = neo;
					if (re < o1.le)
						re = o1.le;
				} else {
					hh.add(o1);
					o1 = o2;
				}
			}
			hh.add(o1);
			boolean rebool = true;
			i = hh.size();
			while (i-- > 0) {
				o1 = hh.remove(0);
				while (o1.fi - 1 >= 0 && s.charAt(o1.fi - 1) == '('
						&& o1.la + 1 < s.length() && s.charAt(o1.la + 1) == ')') {
					o1 = new ok(o1.fi - 1, o1.la + 1);
					rebool = false;
					if (o1.le > re)
						re = o1.le;
				}
				hh.add(o1);
			}
			if (rebool)
				return re;
		}
		return re;
	}

	public static void main(String[] args) throws IOException {
		Solution hh = new Solution();
		Integer i = new Integer(12);
		// String ss = "";
		// File f = new File("C:\\Users\\jiang_000\\Desktop\\111.txt");
		// BufferedReader br = new BufferedReader(new FileReader(f));
		// String st;
		// while((st = br.readLine()) != null)
		// {
		// ss=ss.concat(st);
		// }
		// br.close();
		// System.out.println(ss.length());
		i = hh.longestValidParentheses(")(((((()())()()))()(()))(");
		System.out.println(i);
	}
}
