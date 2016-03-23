package hhd;

public class Solution {
	public String add(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		String ans = "";
		int ch = 0;
		while (i >= 0 && j >= 0) {
			int m = a.charAt(i) - '0' - '0' + b.charAt(j) + ch;
			ch = 0;
			if (m >= 10) {
				ch = 1;
				m -= 10;
			}
			ans = "" + m + ans;
			i--;
			j--;
		}
		if (j == -1) {
			if (ch != 1)
				return a.substring(0, i + 1) + ans;
			else
				return add(a.substring(0, i + 1), 1 + "") + ans;
		}

		else {
			if (ch != 1)
				return b.substring(0, j + 1) + ans;
			else
				return add(b.substring(0, j + 1), 1 + "") + ans;
		}
	}

	public String multiply(String num1, String num2) {
		if (num1.length() + num2.length() < 10)
			return "" + Integer.parseInt(num1) * Integer.parseInt(num2);
		String tmp = num1;
		String ans = "";
		String e0 = "00000000";
		if (num1.length() < num2.length()) {
			tmp = num2;
			num2 = num1;
			num1 = tmp;
		}
		String[] num18 = new String[100];
		int ind=0;
		while(num1.length()>=8){
			num18[ind] =num1.substring(num1.length() - 8);
			num1 = num1.substring(0, num1.length() - 8);
			ind++;
		}
		for (int i = 0; i < num2.length(); i++) {
			int m = num2.charAt(num2.length() - i - 1) - '0';
			int ze = 0;
			while (num18[ze] != null) {
				String s = "" + m
						* Integer.parseInt(num18[ze]);
				for (int j = i; j > 0; j--) {
					s = s.concat("0");
				}
				for (int j = ze; j > 0; j--)
					s=s.concat(e0);
				ans = add(ans, s);
				ze += 1;
			}
			if (num1.length() > 0) {
				String s = "" + m * Integer.parseInt(num1);
				for (int j = ze + i; j > 0; j--) {
					s = s.concat("0");
				}
				ans = add(ans, s);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out
				.println(s
						.multiply(
								"9369162965141127216164882458728854782080715827760307787224298083754",
								"7204554941577564438"));

	}
}
