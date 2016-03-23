package hhd;

public class Ans {

	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		String[] tmp = new String[numRows + 1];
		char[] aaa= new char[s.length()];
		for (int i = 0; i < numRows; i++) {
			tmp[i] = "";
		}
		int x = 1;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			tmp[index] += s.charAt(i);
			index += x;
			if (index == numRows - 1 || index == 0)
				x *= -1;
		}
		String ans = "";
		for (int i = 0; i < numRows; i++) {
			ans += tmp[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ans a = new Ans();
		System.out.println(a.convert("PAYPALISHIRING", 3));

	}

}
