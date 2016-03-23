import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		List<Integer> ans = new ArrayList<Integer>();
		if (m == 0)
			return ans;
		int n = matrix[0].length;
		for (int i = 0; i < Integer.min(n / 2, m / 2); i++) {
			int j = i;
			for (; j < n - i - 1; j++) {
				ans.add(matrix[i][j]);
			}
			j = i;
			for (; j < m - i - 1; j++) {
				ans.add(matrix[j][n - i - 1]);
			}
			for (j = n - i - 1; j > i; j--) {
				ans.add(matrix[m - i - 1][j]);
			}
			for (j = m - i - 1; j > i; j--) {
				ans.add(matrix[j][i]);
			}
		}
		if (m == n) {
			if (m % 2 == 1)
				ans.add(matrix[matrix.length / 2][matrix.length / 2]);
		} else if (m < n) {
			if (m % 2 == 1) {
				for (int i = m / 2; i <= n - 1 - m / 2; i++) {
					ans.add(matrix[m / 2][i]);
				}
			}
		} else {
			if (n % 2 == 1) {
				for (int i = n / 2; i <= m - 1 - n / 2; i++) {
					ans.add(matrix[i][n / 2]);
				}
			}
		}
		return ans;
	}
}
