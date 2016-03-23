import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans = new ArrayList<String>();
		int fiin = 0;
		int lain = -1;
		int tmpl = 0;
		boolean last = true;
		for (int i = 0; i < words.length + 1; i++) {
			if (i == words.length) {
				lain = i - 1;
				last = false;
			} else {
				tmpl += words[i].length();
				if (tmpl + i - fiin > maxWidth) {
					lain = i - 1;
					tmpl -= words[i].length();
				}
			}
			if (lain >= fiin && last) {
				if (fiin == lain) {
					String into = new String(words[fiin]);
					while (into.length() < maxWidth)
						into = into.concat(" ");
					ans.add(into);
					fiin = i;
					if (i < words.length)
						tmpl = words[i].length();
					continue;
				}
				int cc = lain - fiin;
				int sp = maxWidth - tmpl;
				int sp1 = sp / cc, sp2 = sp % cc;
				String into = "";
				int n = 0;
				for (int k = 0; k < cc; k++) {
					into += words[fiin + k];
					int m = 0;
					while (m < sp1) {
						into = into.concat(" ");
						m++;
					}
					if (n < sp2) {
						into = into.concat(" ");
						n++;
					}
				}
				into += words[lain];
				fiin = i;
				ans.add(into);
				if (i < words.length)
					tmpl = words[i].length();
			} else if (!last) {
				String into = "";
				for (int m = fiin; m < lain; m++) {
					into += words[m] + " ";
				}
				into += words[lain];
				while (into.length() < maxWidth) {
					into = into.concat(" ");
				}
				ans.add(into);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().fullJustify(new String[] { "" }, 0);
	}
}
