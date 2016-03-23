package hhd;

import hhd.Solution.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Solution {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				int s = Integer.compare(o1.start, o2.start);
				if (s == 0)
					return Integer.compare(o1.end, o2.end);
				else
					return s;
			}
		});
		List<Interval> ans = new ArrayList<Interval>();
		Iterator<Interval> it = intervals.iterator();
		Interval curr;
		if (it.hasNext())
			curr = it.next();
		else
			return ans;
		while (it.hasNext()) {
			Interval n = it.next();
			if (curr.end < n.start) {
				it.remove();
				ans.add(curr);
				curr = n;
			} else
				curr.end = Integer.max(curr.end, n.end);
		}
		ans.add(curr);
		return ans;
	}
}