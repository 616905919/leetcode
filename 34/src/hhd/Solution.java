package hhd;

public class Solution {
	public static int left = -1;
	public static int right = -1;

	public void lsearch(int[] nums, int a, int b, int target, boolean leori) {
		if (a > b)
			return;
		if (a < 0)
			return;
		if (nums[(a + b) / 2] == target) {
			if (leori) {
				left = (a + b) / 2;
				lsearch(nums, a, (a + b) / 2 - 1, target, leori);
			} else {
				right = (a + b) / 2;
				lsearch(nums, (a + b) / 2 + 1, b, target, leori);
			}
		} else if (nums[(a + b) / 2] < target)
			lsearch(nums, (a + b) / 2 + 1, b, target, leori);
		else
			lsearch(nums, a, (a + b) / 2 - 1, target, leori);

	}

	public int[] searchRange(int[] nums, int target) {
		left = -1;
		right = -1;
		lsearch(nums, 0, nums.length - 1, target, true);
		lsearch(nums, 0, nums.length - 1, target, false);
		return new int[] { left, right };
	}
}
