package hhd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				Integer ti = new Integer(0);
				if ((ti = hm.get(0 - nums[i] - nums[j])) != null) {
					if (ti.intValue() != i && ti.intValue() != j && ti>j) {
						tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[ti]);
						//Collections.sort(tmp);
						ans.add(tmp);
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		int[] nums = new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14,
				-4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6,
				11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1,
				-9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12,
				14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12,
				13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
		long m = System.currentTimeMillis();
		a.threeSum(nums);
		System.out.println(System.currentTimeMillis() - m);
	}
}
