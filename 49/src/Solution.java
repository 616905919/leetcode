import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Solution {
	public class hhd implements Comparator<hhd>{
		private char[] c;
		public hhd(char[] s) {
			// TODO Auto-generated constructor stub
			c=s;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return this.hashCode() == obj.hashCode();
		}
		@Override
		public int hashCode() {
			return  Arrays.hashCode(c);
		}
		@Override
		public int compare(hhd o1, hhd o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
//		Arrays.asList(strs).sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});;
		Vector<List<String>> v = new Vector<List<String>>();
		HashMap<hhd, Integer> h = new HashMap<hhd, Integer>();
		int ind = 0;
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			Integer m;
			hhd hhd1 = new hhd(c);
			if ((m = h.get(hhd1)) != null) {
				v.get(m).add(str);
			} else {
				h.put(new hhd(c), ind++);
				List<String> a = new ArrayList<String>();
				a.add(str);
				v.add(v.size(), a);
			}
		}
		for(List<String> l : v){
			l.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
		}
		return new ArrayList<List<String>>(v);
	}

	public static void main(String[] args) {
		new Solution().groupAnagrams(new String[] { "","" });
	}
}
