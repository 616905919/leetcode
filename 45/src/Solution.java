
public class Solution {
    public int jump(int[] nums) {
    	int setp = 0;
    	int last = 0,cu =0;
        for(int i= 0 ; i<nums.length - 1 ; i++){
        	if(i>last){
        		last=cu;
        		setp++;
        	}
        	cu=Math.max(cu, nums[i]+i);
        	if(cu>=nums.length -1 ) return setp;
        }
        return 0;
    }
}
