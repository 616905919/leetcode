package hhd;

public class Ans {
	public boolean match(char a, char b) {
		if (b == '?' || a == b)
			return true;
		else
			return false;
	}

	public boolean meq(String a, String b) {
		if (a.length() != b.length())
			return false;
		else
			for (int i = 0; i < a.length(); i++) {
				if (!match(a.charAt(i), b.charAt(i)))
					return false;
			}
		return true;
	}

	public int mindexof(String a, String b) {
		if (b.length() == 0)
			return 0;
		for (int i = 0; i <= a.length() - b.length(); i++) {
			if (match(a.charAt(i), b.charAt(0))) {
				boolean br =false;
				for (int j = 1; j < b.length(); j++) {
					if (!match(a.charAt(i + j), b.charAt(j))) {
						br =true;
						break;
						
					}
				}
				if(!br) return i;
			}
		}
		return -1;
	}
	
	public boolean mmatch(String a, String b) {
		// TODO Auto-generated method stub
		if(b.indexOf('*')==-1)
			return mindexof(a, b)!=-1;
		else if(b.charAt(0)=='*') return mmatch(a,b.substring(1));
		else {
			int m=b.indexOf('*'); 
			int tmp=0;
			if((tmp = mindexof(a, b.substring(0,m)))==-1) return false;
			else return mmatch(a.substring(tmp+m), b.substring(m+1));
		}
	}

	public boolean isMatch(String s, String p) {
		if (p.indexOf('*') == -1)
			return meq(s, p);
		else {
			if ("*".equals(p))
				return true;
			int indf = 0, indl = 0;
			if (p.charAt(indf) != '*') {
				while (p.charAt(indf) != '*') {
					if (indf > s.length()-1 || !match(s.charAt(indf), p.charAt(indf)))
						return false;
					indf++;
				}
			}
			if (p.charAt(p.length() - 1) != '*') {
				while (p.charAt(p.length() - 1 - indl) != '*') {
					if (s.length()-1- indl < 0 || !match(s.charAt(s.length() - 1 - indl),
							p.charAt(p.length() - 1 - indl)))
						return false;
					indl++;
				}
			}
			if (indf > s.length()-indl) return false;
			else if (indf == p.length() - 1 - indl)
				return true;
			else
				return mmatch(s.substring(indf, s.length() - indl),
						p.substring(indf + 1, p.length() - 1 - indl));
		}
	}


	public static void main(String args[]) {
		Ans a = new Ans();
		String b = "*";
		a.isMatch("mississippi",
				"m*issi*iss*");
		//System.out.println(a.mindexof("aksjdgfkasfhdk asghfkdgfaiof", "jdg"));
	}
}
