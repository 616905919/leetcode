package hhd;

public class Solution {
    public int firstMissingPositive(int[] nums) {
    	if(nums.length == 0) return 1;
        for(int i = 0  ; i <nums.length ; i++){
        	if(nums[i] > 0 ){
        		if(nums[i] > nums.length) nums[i] = -1;
        		else if(nums[nums[i]-1] != nums[i]){
        			int tmp = nums[nums[i]-1];
        			nums[nums[i]-1] = nums[i];
        			nums[i] = tmp;
        			i--;
        		}
        	}
        }
        for(int i = 0 ; i< nums.length ; i++){
        	if(nums[i]!=i+1 ) return i+1;
        }
        return nums.length+1;
    }
    public static void main (String[] args){
    	Solution a = new Solution();
    	int nums[] = new int[] {3,4,-1,1};
    	System.out.println(100&0xffff);
    	System.out.println(a.firstMissingPositive(nums));
    }
}
