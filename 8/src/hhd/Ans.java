package hhd;

public class Ans {
	public int myAtoi(String str) {
		str = str.trim();
		int a = 1;
		if(str.length()==0) return 0;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			if (str.charAt(0) == '-')
				a = -1;
			str = str.substring(1, str.length());
		}
		int i = 0;
		long ans=0;
		if(str.length()==0) return 0;
		while(i<str.length()&&str.charAt(i)>='0' && str.charAt(i) <='9'){
			ans+=(str.charAt(i)-'0')*a;
			if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			else if(ans < Integer.MIN_VALUE ) return Integer.MIN_VALUE;
			ans*=10;
			i++;
		}
		ans/=10;
		return (int) ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ans a = new Ans();

		a.myAtoi("9223372036854775809");
	}

}
