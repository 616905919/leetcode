package hhd;

public class Solution {
	public int removeDuplicates(int[] nums) {
		int ans=0;
		for(int i = 0 ; i<nums.length ; i++){
			if(nums[i]!=nums[ans]){
				nums[++ans] = nums[i];
			}
		}
		return ans+1;
	}
}
