import java.util.Stack;

public class Solution {
	public String simplifyPath(String path) {
		String[] l = path.split("/");
		Stack<String> s = new Stack<String>();
		for (String str : l) {
			if ("..".equals(str)) {
				if (!s.empty())
					s.pop();
			} else if (".".equals(str)) {
			} else if (!str.isEmpty()) {
				s.push(str);
			}
		}
		String ans = "";
		while (!s.isEmpty()) {
			ans = "/" + s.pop() + ans;
		}
		if(ans.isEmpty()) return "/";
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().simplifyPath("/..."));
	}
}
