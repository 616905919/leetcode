package hhd;

public class Solution {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		Long ans = (long) 0;
		int a = 1;
		if (dividend > 0) {
			dividend = 0 - dividend;
			a *= -1;
		}
		if (divisor > 0) {
			a *= -1;
			divisor = 0 - divisor;
		}
		while (dividend <= divisor) {
			int s = divisor;
			int max = 1;
			while (dividend - s < s) {
				max += max;
				s += s;
			}
			ans += max;
			dividend -= s;
		}
		ans*=a;
		if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else return (int)(ans*1);
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		Long m = System.currentTimeMillis();
		a.divide(-1010369383
				,-2147483648);
		System.out.println(System.currentTimeMillis() - m);

	}
}
