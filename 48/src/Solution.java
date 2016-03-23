public class Solution {
	public void rotate(int[][] matrix) {
		int s = matrix.length;
		int row = s / 2;
		int col = s / 2 + s % 2;
		s--;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[s - j][i];
				matrix[s - j][i] = matrix[s - i][s - j];
				matrix[s - i][s - j] = matrix[j][s - i];
				matrix[j][s - i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Solution s = new Solution();
		s.rotate(m);
	}
}
