import java.util.HashMap;
import java.util.Vector;


public class Solution {
    public int jump(int[] nums) {
        //int[] tmp = new int[nums.length];
    	HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
    	Vector<int[]> s = new Vector<int[]>();
        for(int i = 0 ; i<nums.length ; i++){
        	nums[i] =i+nums[i];
        	if(mp.containsKey(nums[i]));
        	else {
        		mp.put(nums[i], i);
        		s.add(new int[]{i,nums[i]});
        	}
        }
        int aim = nums.length-1;
        if(aim==0) return 0;
        int step=0;
        for(int i = 0 ; i<s.size()-1 ; i++){
        	if(s.get(i)[1] >= aim){
        		aim=s.get(i)[0];
        		step++;
        		if(aim==0) return step;
        		i=-1;
        	}
        }
        return -1;
    }
    public static void main(String[] main) {
    	Solution s  = new Solution();
    	int[] nums = new int[]{2,3,1,1,4};
    	System.out.println(s.jump(nums));
	}
}
