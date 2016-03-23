
public class Solution {
    public String multiply(String num1, String num2) {
    	char[] ans = new char[num1.length()+num2.length()];
    	for(int i = 0 ; i<ans.length ;i++){
    		ans[i] = '0';
    	}
        for(int i = num1.length()-1 ; i>=0 ; i--){
        	for(int j = num2.length()-1  ; j>=0 ; j--){
        		 int m = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + ans[i+j+1]-'0';
        		 if(m<10) ans[i+j+1] = (char) (m+'0');
        		 else {
        			 int ss = i+j+1;
        			 while(m>=10) {
        				 ans[ss] = (char) (m%10+'0');
        				 ss--;
        				 m = m/10+ans[ss]-'0';
        			 }
        			 ans[ss] = (char) (m+'0');
        		 }
        	}
        }
        String s = new String(ans);
        while (s.charAt(0) == '0' && s.length()>=2) s= s.substring(1);
        return s;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.multiply("123", "456"));
	}

}
