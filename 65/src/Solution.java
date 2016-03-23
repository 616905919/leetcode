import java.util.regex.Pattern;

public class Solution {
	public boolean isNumber(String s) {
		// return s.matches("-?//d+.?(//d+)?(e?-?//d+.?//d+)?");
		s = s.trim();
		Pattern pattern = Pattern
				.compile("(-|\\+)?((\\d+)|(\\d+\\.\\d*)|(\\d*\\.\\d+))(e(-|\\+)?(\\d+))?");
		return pattern.matcher(s).matches();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isNumber("6e6.5"));
	}
}
