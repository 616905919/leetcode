package hhd;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	String zuo= new String("([{");
    	String you = ")]}";
        Stack<Character> st = new Stack<Character>();
        for(int i = 0 ; i <s.length()  ;i ++){
        	if(zuo.indexOf(s.charAt(i)) != -1 ){
        		st.push(s.charAt(i));
        	}
        	else if(you.indexOf(s.charAt(i))!=-1){
        		char tmp;
        		try {
					tmp = st.pop();
				} catch (Exception e) {
					return false;
					// TODO: handle exception
				}
        		if(zuo.indexOf(tmp) != you.indexOf(s.charAt(i))){
        			return false;
        		}
        	}
        }
        return st.empty();
    }
    public static void main(String[] args) {
    	Solution a = new Solution();
    	System.out.println(a.isValid("()"));
		
	}
}
