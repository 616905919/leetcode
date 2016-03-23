import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Solution {
	public boolean nextPermutation(int[] nums) {
		int m = 9999999;
		int index = 9999;
		for (int i = nums.length - 1; i > 0; --i) {
			if (nums[i] > nums[i - 1]) {
				for (int j = i; j < nums.length; j++) {
					int tmp = nums[j] - nums[i - 1];
					if (tmp > 0 && tmp < m) {
						m = tmp;
						index = j;
					}
				}
				nums[index] = nums[i - 1];
				nums[i - 1] += m;
				Arrays.sort(nums, i, nums.length);
				List<Integer> tmp = new ArrayList<Integer>();
				for (int q = 0; q < nums.length; q++) {
					tmp.add(nums[q]);
				}
				ans.add(tmp);
				return true;
			}
		}
		return false;
	}

	public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums,0,nums.length);
		ans  = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		for (int q = 0; q < nums.length; q++) {
			tmp.add(nums[q]);
		}
		ans.add(tmp);
		while(nextPermutation(nums));
		return ans;
    }
	public static void main(String[] args){
		Solution s = new Solution();
		s.permuteUnique(new int[]{1,1});
	}
}
