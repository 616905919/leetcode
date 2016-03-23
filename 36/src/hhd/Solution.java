package hhd;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			boolean[] list1 = new boolean[9];
			boolean[] list2 = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (list1[board[i][j] - '1'])
						return false;
					else
						list1[board[i][j] - '1'] = true;
				}
				if (board[j][i] != '.') {
					if (list2[board[j][i] - '1'])
						return false;
					else
						list2[board[j][i] - '1'] = true;
				}
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				boolean[] list1 = new boolean[9];
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						if (board[i + m][j + n] != '.') {
							if (list1[board[i + m][j + n] - '1'])
								return false;
							else
								list1[board[i + m][j + n] - '1'] = true;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution h = new Solution();
		char[][] m = new char[][] { "....5..1.".toCharArray(),
				".4.3.....".toCharArray(), ".....3..1".toCharArray(),
				"8......2.".toCharArray(), "..2.7....".toCharArray(),
				".15......".toCharArray(), ".....2...".toCharArray(),
				".2.9.....".toCharArray(), "..4......".toCharArray() };
		System.out.println(h.isValidSudoku(m));

	}
}
