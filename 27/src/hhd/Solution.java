package hhd;

public class Solution {
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = nums.length - 1; i <= j; i++) {
			if (nums[i] == val) {
				while (nums[j--] == val) {
					if (j+1 == i)
						return i;
				}
				nums[i] = nums[j + 1];
			}
		}
		return i;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] { 2,3 };
		int sss = s.removeElement(nums, 2);
		System.out.println(sss);
	}
}
