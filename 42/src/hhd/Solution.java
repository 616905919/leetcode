package hhd;

import java.util.Arrays;

public class Solution {
	public int trap(int[] height) {
	    if(height.length <=1) return 0;
		int i = -1, j = height.length;
		int s=0;
		while(i<height.length && height[++i] == 0);//i++;
		while(j>=0 && height[--j] == 0 );//j--;
		if(i>=j) return 0;
		int last = Math.min(height[i], height[j]);
		boolean zuo = height[i] <= height[j];
		s+= last*(j-i+1);
		while(i<=j){
			if(zuo){
				if(height[i] <=last) {
					i++;
					continue;
				}
			}else if(height[j]<=last) {
				j--;
				continue;
			}
			int newlast = Math.min(height[i], height[j]);
			s+= (newlast-last)*(j-i+1);
			zuo = height[i] <= height[j];
			last = newlast;
		}
		int sum =0;
		for( int k= 0  ; k < height.length; sum+=height[k] , k++);
		return s - sum;
	}
	public static void main (String[] args){
		Solution s = new Solution();
		int[] hei = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(s.trap(hei));
	}
}
