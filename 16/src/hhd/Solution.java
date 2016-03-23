package hhd;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
	public int findn(int[] nums, int s, int e, int tar) {
		if (s == e)
			return nums[s];
		if (nums[s] >= tar)
			return nums[s];
		else if (nums[e] <= tar)
			return nums[e];
		else if (e - s == 1) {
			if (nums[e] - tar < tar - nums[s])
				return nums[e];
			else
				return nums[s];
		} else {
			int a = nums[(s + e) / 2];
			if (a < tar)
				return findn(nums, (s + e) / 2, e, tar);
			else if (a == tar)
				return a;
			else
				return findn(nums, s, (s + e) / 2, tar);
		}
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int re = 1100000;
		int ch = re - target;
		if (ch < 0)
			ch *= -1;
		for (int i = 0; i < nums.length - 2; i++) {
			if ( i < nums.length - 3&&nums[i] == nums[i + 3] ) continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				// if (nums[j] == nums[j + 1] && j < nums.length - 2) continue;
				int cos = findn(nums, j + 1, nums.length - 1, target - nums[i]
						- nums[j]);
				int tmp = nums[i] + nums[j] + cos;
				int r = target - tmp;
				if (r < 0)
					r *= -1;
				if (r == 0)
					return tmp;
				if (r < ch) {
					re = tmp;
					ch = r;
				}
			}
		}
		return re;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] n = new int[] { 13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15,
				20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1, -15, -2, 8, -2,
				-9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0,
				9, 5, -7, -4, 20, 18, 9, 0, 12, -1, 10, -17, -11, 16, -13, -14,
				-3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11,
				-10, 1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5,
				-10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7, 0, -16, -5, 16,
				-12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6 };
		System.out.println(s.threeSumClosest(n, -59));
	}
}
