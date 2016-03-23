package hhd;

public class Solution {
	boolean sol(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= 9; k++) {
						board[i][j] = (char) ('0' + k);
						if (isok(board, i, j)) {
							if (sol(board))
								return true;
						}
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

	private boolean isok(char[][] board, int i, int j) {
		for (int m = 0; m < 9; m++) {
			if (m != j && board[i][m] == board[i][j])
				return false;
			if (m != i && board[m][j] == board[i][j])
				return false;
		}
		for (int x = i / 3 * 3; x < i / 3 * 3 + 3; ++x) {
			for (int y = j / 3 * 3; y < j / 3 * 3 + 3; ++y) {
				if (x != i || y != j) {
					if (board[x][y] == board[i][j])
						return false;
				}
			}
		}
		return true;
	}

	public void solveSudoku(char[][] board) {
		sol(board);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		char [][] c = new char[][]{"..9748...".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),"..7...24.".toCharArray(),".64.1.59.".toCharArray(),".98...3..".toCharArray()	
		,"...8.3.2.".toCharArray(),"........6".toCharArray(),"...2759..".toCharArray()};
		s.solveSudoku(c);
	}
}
