package hhd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	ans = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<Integer>();
        getans(candidates , target ,0, tmp);
        return ans;
    }
	private void getans(int[] candidates, int target, int ind ,List<Integer> tmp) {
		if(ind == candidates.length) return;
		if(candidates[ind] > target) return ;
		List<Integer> al = new ArrayList<Integer>(tmp);
		if(candidates[ind] == target){
			al.add(target);
			ans.add(al);
			return ;
		}else {
			getans(candidates,target , ind+1 , al);
			al.add(candidates[ind]);
			getans(candidates, target-candidates[ind], ind,al );
		}
	}
	public static void main(String[] args) {
		int [] s = new int[]{11,5,12,7,9,8};
		Solution ss = new Solution();
		ss.combinationSum(s, 17);
		
	}
}
