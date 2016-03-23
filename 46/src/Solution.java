import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Solution {
	public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> permute(int[] nums) {
		ans = new ArrayList<List<Integer>>();
		// List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(nums[i]);
			// ans2.add(tmp);
			int[] tmpi = Arrays.copyOf(nums, nums.length);
			tmpi[i] = tmpi[tmpi.length - 1];
			if (nums.length != 1)
				getans(tmpi, tmp, 1);
			else //if (!ans.contains(tmp))
				ans.add(tmp);
		}
		return ans;

	}

	private void getans(int[] nums, List<Integer> ans2, int ind) {
		for (int i = 0; i < nums.length - ind; i++) {
			List<Integer> thisl = new ArrayList<Integer>(ans2);
			thisl.add(nums[i]);
			if (ind + 1 == nums.length)
				//if (!ans.contains(thisl))
					ans.add(thisl);
				else {
					int[] tmp = Arrays.copyOf(nums, nums.length);
					tmp[i] = tmp[tmp.length - 1 - ind];
					getans(tmp, thisl, ind + 1);

				}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		long m = System.currentTimeMillis();
		s.permute(new int[] { 1,-1,1,2,-1,2,2,-1 });
		System.out.println(System.currentTimeMillis()-m);
	}
}
