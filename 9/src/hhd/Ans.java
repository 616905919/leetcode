package hhd;

public class Ans {
	public long reverse(int x) {
		long ans2 = 0;
		while (x / 10 != 0) {
			ans2 += x % 10;
			ans2 *= 10;
			x /= 10;
		}
		ans2 += x % 10;
		return ans2;
	}

	public boolean isPalindrome(int x) {
		if(x<0) return false;
		long ss = reverse(x);
		if (ss==x) return true ;
		else return false;
	}
}
