package hhd;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public void nextPermutation(int[] nums) {
		int m = 9999999;
		int index = 9999;
		for (int i = nums.length - 1; i > 0; --i) {
			if (nums[i] > nums[i - 1]) {
				for (int j = i; j < nums.length; j++) {
					int tmp =nums[j]-nums[i-1];
					if(tmp>0 && tmp < m){
						m = tmp;
						index = j;
					}
				}
				nums[index] = nums[i - 1];
				nums[i - 1] += m;
				Arrays.sort(nums, i, nums.length);
				return;  
			}
		}
		Arrays.sort(nums);
	}
}
