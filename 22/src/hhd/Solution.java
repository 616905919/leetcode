package hhd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<String> generateParenthesis(int n) {
        Stack<Boolean> st = new Stack<Boolean>();
        List<String> l = new ArrayList<String>();
        List<String> t = new ArrayList<String>();
        l.add("(");
        for(int i = 0 ; i< 2*n - 1 ; i++){
        	t = l;
        	l=new ArrayList<String>();
        	for(String str:t){
        		int le=0;
        		int ri=0;
        		for(int j = 0 ; j<str.length() ; j++){
        			
        			if(str.charAt(j) == '(') {
        				le++;
        			}
        			else ri++;
        		}
        		if(le==ri){
        			l.add(str.concat("("));
        		}
        		else if(le!= n) {
        			l.add(str.concat("("));
        			l.add(str.concat(")"));
        		}
        		else l.add(str.concat(")"));
        	}
        }
        return l;
     }
}
