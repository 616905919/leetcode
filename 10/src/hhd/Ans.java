package hhd;

public class Ans {
	public boolean match(char a, char b) {
		if (b == '.' || a==b) 
			return true;
		else
			return false;
	}

	public boolean isMatch(String s, String p) {
		int indexs = 0;
		for (int i = 0; i < p.length(); i++) {
			if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
				boolean ma = isMatch(s.substring(indexs, s.length()),
						p.substring(i + 2, p.length()));
				while (indexs < s.length()
						&& match(s.charAt(indexs), p.charAt(i))) {
					ma = ma
							|| isMatch(s.substring(indexs + 1, s.length()),
									p.substring(i + 2, p.length()));
					if (ma)
						return ma;
					indexs++;
				}
				i++;
			} else if ((indexs < s.length())
					&& match(s.charAt(indexs), p.charAt(i)))
				indexs++;
			else
				return false;
		}
		if (indexs == s.length())
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		Ans a = new Ans();
		System.out.println(a.isMatch("aaa", "a*a"));
	}
}
