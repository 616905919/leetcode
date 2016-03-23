package hhd;

public class Solution {
	public static int[] mm = new int[10000];
	public int get(int n){
		if(n<=2) return mm[n];
		if(mm[n]!=0) return mm[n];
		else mm[n] = get(n-1)+get(n-2);
		return mm[n];
	}
    public int climbStairs(int n) {
        mm[0] = 0;
        mm[1] = 1;
        mm[2] = 2 ; 
        return get(n);
    }
}
