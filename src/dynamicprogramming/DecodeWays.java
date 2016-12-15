package dynamicprogramming;

public class DecodeWays {
	public int numDecodings(String s) {
	       if (s == null || s.length() == 0 || s.charAt(0) == '0') {
	           return 0;
	       }
	       int[] f = new int[s.length() + 1];
	       f[s.length()] = 1;
	       f[s.length()-1] = s.charAt(s.length()-1) == '0'? 0 : 1;
	       
	       for (int i = s.length()-2; i >= 0; --i) {
	           if (s.charAt(i) == '0') continue;
	           int trimmed = Integer.valueOf(s.substring(i,i+2));
	           if (trimmed <= 26) {
	               f[i] = f[i+1] + f[i+2];
	           } else {
	               f[i] = f[i+1];
	           }
	       }
	       
	       return f[0];
	    }
}
