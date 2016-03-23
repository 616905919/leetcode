package hhd;

public class Ans {
	public boolean islo(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (!(s.charAt(i) == s.charAt(j)))
				return false;
		}
		return true;
	}

	public String longestPalindrome(String s) {
		String ans = s.substring(0, 1);
		int lent = 1;
		for (int i = 0; i < s.length(); i++) {
			int j = 1;
			while (i - j >= 0 && i + j < s.length()) {
				if (s.charAt(i - j) != s.charAt(i + j))
					break;
				else
					j++;
			}
			if (2 * j - 1 > lent) {
				lent = 2 * j - 1;
				ans = s.substring(i - j + 1, i + j);
			}
			j=1;
			if( (i+1< s.length())&&s.charAt(i) == s.charAt(i+1) )
			{
				while(i-j>=0 && i+j+1 <s.length()){
					if(s.charAt(i-j) != s.charAt(i+j+1)) break;
					else j++;
				}
				if(2*j > lent) {
					lent = 2*j ;
					ans = s.substring(i-j+1 ,  i+j+1);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiy"
				+ "xzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfi"
				+ "tmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhx"
				+ "vjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgi"
				+ "lrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqa"
				+ "qbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsq"
				+ "imqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspw"
				+ "hvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcu"
				+ "xzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbj"
				+ "axlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpio"
				+ "lklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx";
		String s1 = "ssssassssssssss";
		Ans a = new Ans();
		long aa = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		System.out.println(a.longestPalindrome(s1));
		System.out.println(System.currentTimeMillis() - aa);
	}
}
