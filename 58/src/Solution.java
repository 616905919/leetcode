
public class Solution {
    public int lengthOfLastWord(String s) {
    	int ans = 0;
    	boolean find = false;
        for(int i = s.length()-1 ; i>=0 ; i--){
        	if(s.charAt(i)!=' '){
        		if(!find) find=true;
        		ans++;
        	}else if(find) return ans;
        }
        return ans;
    }
}
