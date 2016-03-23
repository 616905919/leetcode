public class Solution {
	public int minDistance(String word1, String word2) {
//		if (word1.length() * word2.length() == 0)
//			return Math.max(word1.length(), word2.length());
		int[][] l = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			for (int j = 0; j <= word2.length(); j++) {
				if (i == 0 || j == 0) {
					l[i][j] = Math.max(i, j);
				} else {
					int a = Math.min(l[i - 1][j], l[i][j - 1]) + 1;
					if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
						l[i][j] = Math.min(a, l[i - 1][j - 1]);
					} else
						l[i][j] = Math.min(a, l[i - 1][j - 1] + 1);
				}
			}
		}
		return l[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().minDistance("food", "money"));
	}
}
