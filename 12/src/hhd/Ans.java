package hhd;

public class Ans {
	public String intToRoman(int num) {
		if (num == 40)
			return "XL";
		else if (num == 4)
			return "IV";
		else if (num == 9)
			return "IX";
		else if (num == 90)
			return "XC";
		String ans = "";
		int[] list = new int[] { 1000, 500, 100, 50, 10, 5, 1 };
		char[] lc = new char[] { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		for (int i = 0; i < 7; i++) {
			if (i == 3) {
				if (num >= 90) {
					num -= 90;
					ans = ans.concat("XC");
				}
			} else if (i == 4) {
				if (num >= 40) {
					num -= 40;
					ans = ans.concat("XL");
				}
			} else if (i == 5) {
				if (num == 9) {
					num -= 9;
					ans = ans.concat("IX");
				}
			} else if (i == 6) {
				if (num == 4) {
					num -= 4;
					ans = ans.concat("IV");
				}
			}
			else if(i==2){
				if(num>=400) {
					num-=400;
					ans=ans.concat("CD");
				}
			}
			else if ( i== 1){
				if(num >= 900 )
				{
					num-=900;
					ans=ans.concat("CM");
				}
			}
			for (int j = 0; j < num / list[i]; j++) {
				ans += lc[i];
			}
			num %= list[i];
		}
		return ans;
	}
}
