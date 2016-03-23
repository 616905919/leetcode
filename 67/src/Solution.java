public class Solution {
	public String addBinary(String a, String b) {
		int i = a.length()-1;
		int j = b.length()-1;
		String tmp = "";
		int flg = 0;
		for (; i >= 0 && j >= 0; i--, j--) {
			char t = (char) (a.charAt(i) + b.charAt(j) - '0' + flg);
			flg = 0;
			if (t >= '2') {
				t=(char) (t-2);
				flg = 1;
			}
			tmp = "" + t + tmp;
		}
		if (i != j) {
			String hhd;
			int index;
			if (i == -1) {
				hhd = b.substring(0, j + 1);
				index = j;
			} else {
				hhd = a.substring(0, i + 1);
				index = i;
			}
			for (; index >= 0; index--) {
				char t = (char) (hhd.charAt(index) + flg);
				flg = 0;
				if (t >= '2') {
					t = (char)(t-2);
					flg = 1;
				}
				tmp = "" + t + tmp;
			}
		}
		if (flg == 1)
			return "1" + tmp;
		else
			return tmp;
	}
	public static void main(String[] args) {
		char t = '2';
		t= (char) (t+1);
		System.out.println((char)((int)t));
		System.out.println(new Solution().addBinary("1", "1"));
	}
}
