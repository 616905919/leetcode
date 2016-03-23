public class Solution {
	public int[][] generateMatrix(int n) {
		int tmp = 1;
		int m = n;
		int[][] ans = new int[m][m];
		for (int i = 0; i < m / 2; i++) {
			for (int j = i; j < m - 1 - i; j++) {
				ans[i][j] = tmp++;
			}
			for (int j = i; j < m - i - 1; j++) {
				ans[j][m - i - 1] = tmp++;
			}
			for (int j = m - i - 1; j > i; j--)
				ans[m - i - 1][j] = tmp++;
			for (int j = m - i - 1; j > i; j--)
				ans[j][i] = tmp++;
		}
		if(m%2==1) ans[m/2][m/2]=tmp;
		return ans;
	}
	public static void main(String[] args) {
		new Solution().generateMatrix(2);
	}
}
