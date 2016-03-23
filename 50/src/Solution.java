public class Solution {
	public double myPow(double x, int n) {
		if (n == 0x80000000) {
			return 1 / myPow(x * x, 0x4000000);
		}
		boolean p = false;
		if (n < 0) {
			p = !p;
			n = 0 - n;
		}
		double ans = 1;
		while (n != 0) {
			if (n % 2 == 1)
				ans *= x;
			x *= x;
			n /= 2;
		}
		if (p)
			return 1.0 / ans;
		else
			return ans;
	}
}
