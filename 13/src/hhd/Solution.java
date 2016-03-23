package hhd;

public class Solution {
	public int romanToInt(String s) {
		int re = 0;
		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			char d = '#';
			if (i != s.length() - 1) {
				d = s.charAt(i + 1);
			}
			switch (c) {
			case 'M':
				re += 1000;
				i++;
				break;
			case 'C':
				if (d == 'M') {
					re += 900;
					i += 2;
				} else if (d == 'D') {
					re += 400;
					i += 2;
				} else {
					re += 100;
					i++;
				}
				break;
			case 'D':
				re += 500;
				i++;
				break;
			case 'X':
				if (d == 'C') {
					re += 90;
					i += 2;
				} else if (d == 'L') {
					re += 40;
					i += 2;
				} else {
					re += 10;
					i++;
				}
				break;
			case 'L':
				re += 50;
				i += 1;
				break;
			case 'I':
				if (d == 'X') {
					re += 9;
					i += 2;
				} else if (d == 'V') {
					re += 4;
					i += 2;
				} else {
					re++;
					i++;
				}
				break;
			case 'V':
				re += 5;
				i += 1;
				break;
			}
		}
		return re;
	}
}
