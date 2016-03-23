
public class Solution {
    public int uniquePaths(int m, int n) {
        int [][] ls = new int[m][n];
        ls[0][0] = 1;
        for(int i = 0 ; i < m ; i++){
        	for(int j = 0 ; j < n ; j++){
        		if(i-1>=0) ls[i][j]+=ls[i-1][j];
        		if(j-1>=0) ls[i][j]+=ls[i][j-1];
        	}
        }
        return ls[m-1][n-1];
    }
}
