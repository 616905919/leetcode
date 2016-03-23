public class Solution {
    public int[] plusOne(int[] digits) {
    	for(int i = digits.length -1 ; i >=0 ; i--){
    		digits[i] += 1;
    		if(digits[i]!=10) return digits;
    		else digits[i] =0;
    	}
    	int[] ans = new int[digits.length+1];
    	ans[0]=1;
    	System.arraycopy(digits, 0,ans, 1, ans.length-1);
    	return ans;
    }
}
