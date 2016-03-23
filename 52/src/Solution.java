import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<String>> ans = new ArrayList<List<String>>();

	void isok(char[][] c, int ind, int n, int[] st) {
		int i = ind;
		for (int j = 0; j < n; j++) {
			if (st[j] != -100)
				continue;
			c[i][j] = 'Q';
			st[j] = i;
			if (ok(st, i, j, n)) {
				if (i == n - 1)
					putinans(c);
				else {
					isok(c, ind + 1, n, st);
				}
			}
			c[i][j] = '.';
			st[j] = -100;
		}
	}

	private void putinans(char[][] c) {
		List<String> m = new ArrayList<String>();
		for (int i = 0; i < c.length; i++) {
			m.add(new String(c[i]));
		}
		ans.add(m);
	}

	private boolean ok(int[] st, int i, int j, int k) {
		for (int m = 0; m < k; m++) {
			if (m != j && Math.abs(st[m] - st[j]) == Math.abs(m - j))
				return false;
		}
		return true;
	}

	public int totalNQueens(int n) {
		ans = new ArrayList<List<String>>();
		char[][] c = new char[n][n];
		for (int i = 0; i < c.length; i++) {
			Arrays.fill(c[i], '.');
		}
		int[] st = new int[n];
		Arrays.fill(st, -100);
		isok(c, 0, n, st);
		return ans.size();
	}

	public static void main(String[] args) {
		Long s = System.currentTimeMillis();
		System.out.println(ans.size());
		System.out.println(System.currentTimeMillis() - s);
	}
}
