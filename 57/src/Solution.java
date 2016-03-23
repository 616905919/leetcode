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

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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
		boolean ok = false;
		while (it.hasNext()) {
			Interval n = it.next();
			if (!ok && n.start > newInterval.end) {
				ans.add(newInterval);
				ok = true;
			}
			if (ok || newInterval.start> n.end) {
				ans.add(n);
			} else {
				newInterval.start = Integer.min(n.start, newInterval.start);
				newInterval.end = Integer.max(n.end, newInterval.end);
			}
		}
		if(!ok) ans.add(newInterval);
		return ans;
	}
}