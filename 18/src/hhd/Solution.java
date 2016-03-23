package hhd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Vector<Integer> v = new Vector<Integer>();
		Hashtable<Integer, Entry<Integer, Integer>> ht= new Hashtable<Integer, Entry<Integer,Integer>>();
 		Arrays.sort (nums);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				for (int k = j + 1; k < nums.length - 1; k++) {
					if(k!=j+1 && nums[k] == nums[k-1]  ) continue;
					Integer ti = new Integer(0);
					if ((ti = hm.get(0 - nums[i] - nums[j] -nums[k])) != null) {
						if (ti > k) {
							tmp = new ArrayList<Integer>();
							tmp.add(nums[i]);
							tmp.add(nums[j]);
							tmp.add(nums[k]);
							tmp.add(nums[ti]);
							// Collections.sort(tmp);
							ans.add(tmp);
						}
					}
				}
			}
		}
		return ans;
	}
}
