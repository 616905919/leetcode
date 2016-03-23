package hhd;

public class Ans {
    public int reverse(int x) {
    	int max= 0x7fffffff;
    	int min= max+1;
    	long ans2 = 0;
    	boolean l0= false;
    	if(x<0 ) {
    		x*= -1;
    		l0 = true;
    	}
    	while(x/10!=0){
    		ans2 += x%10;
    		ans2*=10;
    		x/=10;
    	}
    	ans2+=x%10;
    	if(l0) ans2*=-1;
    	if (ans2>max || ans2 < min) return 0;
    	else return (int)ans2;
        int s = x<0 ? -1:1;
        Integer xx= x;
        String xs = xx.toString();
        if(s == -1) xs=xs.substring(1, xs.length());
        String ans = "";
        for(int i = xs.length()-1  ; i >= 0 ; i--){
        	ans+= xs.charAt(i);
        }
        try {
        	xx = Integer.valueOf(ans);
		} catch (Exception e) {
			return 0;
		}
        xx*=s;
        return xx;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ans a = new Ans();
		a.reverse(1534236469);

	}

}
