package hhd;

import java.util.ArrayList;
import java.util.Vector;

public class Ans {
	double min(double a, double b) {
		if (a < b)
			return a;
		else
			return b;
	}

	double gets(int[] nums1, int start1, int le1, int[] nums2, int start2,
			int le2, int k) {
		if (le1 > le2)
			return gets(nums2, start2, le2, nums1, start1, le1, k);
		else if (le1 == 0)
			return nums2[start2 + k - 1];
		else if (k == 1)
			return min(nums1[start1], nums2[start2]);

		int a = (int) min(le1, k / 2);
		int b = k - a;
		if (nums1[a + start1 - 1] < nums2[b + start2 - 1])
			return gets(nums1, start1 + a, le1 - a, nums2, start2, le2, k - a);
		else if (nums1[a + start1 - 1] == nums2[b + start2 - 1])
			return nums1[a + start1 - 1];
		else
			return gets(nums1, start1, le1, nums2, start2 + b, le2 - b, k - b);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length%2 + nums2.length %2 == 1)
			return gets(nums1,0,nums1.length,nums2,0,nums2.length , (nums1.length+nums2.length)/2+1);
		else return (gets(nums1,0,nums1.length,nums2,0,nums2.length , (nums1.length+nums2.length)/2+1)+
				gets(nums1,0,nums1.length,nums2,0,nums2.length , (nums1.length+nums2.length)/2))/2;
	}
}
