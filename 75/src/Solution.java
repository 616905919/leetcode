public class Solution {
	public void sortColors(int[] nums) {
		int ind1 = -1;
		int ind2 = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2) {
				if (ind2 == -1)
					ind2 = i;
			} else if (nums[i] == 1) {
				if (ind2 == -1) {
					if (ind1 == -1)
						ind1 = i;
				} else {
					nums[ind2] = 1;
					if (ind1 == -1)
						ind1 = ind2;
					ind2++;
					nums[i] = 2;
				}
			} else {
				if (ind1 == -1 && ind2 == -1)
					continue;
				else if (ind1 == -1 && ind2 != -1) {
					nums[ind2++] = 0;
					nums[i] = 2;
				} else if (ind1 != -1 && ind2 == -1) {
					nums[ind1++] = 0;
					nums[i] = 1;
				} else {
					nums[ind1++] = 0;
					nums[ind2++] = 1;
					nums[i] = 2;
				}
			}
		}
	}
}
