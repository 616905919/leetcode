import java.util.Arrays;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (target < matrix[0][0])
			return false;
		if (target >= matrix[matrix.length - 1][0])
			return Arrays.binarySearch(matrix[matrix.length - 1], target) >= 0;
		int i = 0;
		int j = matrix.length - 1;
		while (j - i > 1) {
			int s = (i + j) / 2;
			if (matrix[s][0] == target)
				return true;
			else if (matrix[s][0] < target)
				i = s;
			else
				j = s;
		}
		return Arrays.binarySearch(matrix[i], target) >= 0;

	}
}
