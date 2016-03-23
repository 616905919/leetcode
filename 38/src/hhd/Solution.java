package hhd;

public class Solution {
	public static String[] hhd = new String[100];

	public String countAndSay(int n) {
		hhd[1] = "1";
		hhd[2] = "11";
		if (n == 1)
			return "1";
		return get(n);
	}

	private String get(int n) {
		String s = null;
		if (hhd[n - 1] == null)
			hhd[n - 1] = get(n - 1);
		s = hhd[n - 1];
		String ss = "";
		int m = 1;
		if (s.length() == 1)
			return "11";
		int i = 1;
		for (; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1))
				m++;
			else {
				ss = ss + m + s.charAt(i - 1);
				m = 1;
			}
		}
		if (m != 0)
			return  ss + m + s.charAt(i - 1);
		else
			return  ss + 1 + s.charAt(i - 1);
		//return hhd[n];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		long ssss = System.currentTimeMillis();
		System.out.println(s.countAndSay(4));
		System.out.println(System.currentTimeMillis() - ssss);
	}
}
