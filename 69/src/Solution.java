public class Solution {
	public int mySqrt(int x) {
		int a = 0, b = 46340;
		if (x >= b * b)
			return b;
		while (b - a > 1) {
			int s = (int) ((a + b) / 2) * ((a + b) / 2);
			if (s > x)
				b = (a + b) / 2;
			else if (s == x)
				return (a + b) / 2;
			else
				a = (a + b) / 2;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().mySqrt(2147395600));
	}
}
