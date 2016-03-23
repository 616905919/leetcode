package hhd;

import java.util.HashMap;
import java.util.Hashtable;

public class Ans {

	public int[] twoSum(int[] nums, int target) {
		int ans[] = new int[2];
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int fin = target - nums[i];
			if (s.containsKey(fin)) {
				ans[0] = s.get(fin);
				ans[1] = i;
				return ans;
			}
			s.put(nums[i], i);
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer mm = new Integer(2);
		int wer = mm;
		Ans a = new Ans();
		int[] ss = new int[] {1,2,3};
		int[] ssss = a.twoSum(ss, 3);

	}
}
