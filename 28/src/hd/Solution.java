package hd;

public class Solution {
    public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i)== needle.charAt(0)){
				boolean br =false;
				for (int j = 1; j < needle.length(); j++) {
					if (haystack.charAt(i + j)== needle.charAt(j)){
						br =true;
						break;
						
					}
				}
				if(!br) return i;
			}
		}
		return -1;
    }
}
