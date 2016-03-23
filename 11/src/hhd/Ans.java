package hhd;

public class Ans {
	public int maxArea(int[] height) {
		int naxA = 0;
		for (int i = 0, j = height.length - 1; j - i > 0;) {
			naxA = Integer.max(naxA, Integer.min(height[i], height[j])
					* (j - i));
			if (height[i] < height[j]) {
				int tmp = height [i];
				i++;
				while (j - i > 0 && height[i] <= tmp)
					i++;
			} else {
				int tmp = height[j];
				j--;
				while (j - i > 0 && height[j] <=tmp )
					j--;
			}
		}
		return naxA;
	}
}
