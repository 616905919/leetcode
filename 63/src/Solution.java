public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0]==1) return 0;
		obstacleGrid[0][0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (i - 1 >= 0)
						obstacleGrid[i][j] += obstacleGrid[i - 1][j];
					if (j - 1 >= 0)
						obstacleGrid[i][j] += obstacleGrid[i][j - 1];
				} else if (!(i == j && i == 0))
					obstacleGrid[i][j] = 0;
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
