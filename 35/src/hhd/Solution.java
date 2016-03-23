package hhd;

public class Solution {
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		if (nums[0] > target)
			return 0;
		if (nums[nums.length - 1] < target)
			return nums.length;
		return bys(nums, 0, nums.length - 1, target);
	}

	private int bys(int[] nums, int i, int j, int target) {
		if (target < nums[i])
				return i;
		if (target > nums[j])
			return j + 1;
		if (i > j) {
			return bys(nums, j, i, target);
		}
		if (nums[(i + j) / 2] == target)
			return (i + j) / 2;
		else if (nums[(i + j) / 2] < target)
			return bys(nums, (i + j) / 2 + 1, j, target);
		else
			return bys(nums, i, (i + j) / 2 - 1, target);
	}
}
