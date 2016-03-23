import java.util.Arrays;
import java.util.Vector;

public class Solution {
	public String getPermutation(int n, int k) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = new int[] { 1, 2, 6, 24, 120, 720, 5040, 40320 };
		Vector<Integer> v = new Vector<Integer>();
		for (int s : a)
			v.add(s);
		n--;
		k--;
		String ans = "";
		while (n > 0) {
			ans += v.remove(k / b[n - 1]);
			k = k % b[n - 1];
			n--;
		}
		return ans + v.get(0);
	}

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		new Solution().getPermutation(2, 1);
		System.out.println(System.currentTimeMillis() - s);
	}
}
