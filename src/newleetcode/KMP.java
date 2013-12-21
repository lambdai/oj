package newleetcode;

public class KMP {
	public int[] calfail(char[] str) {
		int [] fail = new int[str.length];
		for(int i = 0; i < str.length ; i++) { 
			fail[i] = -1;
		}
		for (int i = 0; i < str.length; ++i) {
			if (i == 0) {
				fail[i] = -1;
			} else {
				int pre = i-1;
				while (pre != -1) {
					if(str[fail[pre]+1] == str[i]) {
						fail[i] = fail[pre] +1;
						break;
					} else {
						pre = fail[pre];
						fail[i] = -1;
					}
				}
			}
		}
		for (int i = 0; i< str.length ; ++i	) {
			System.out.println("" + i + ":" + fail[i]);
		}
		return fail;
	}
	
	boolean match(String str, String pattern) {
		char[] strpattern = pattern.toCharArray();
		int [] fails = calfail(strpattern);
		char [] src = str.toCharArray();
		int state = -1;
		int i = 0;
		while(state != strpattern.length-1) {
			if (i == src.length) {
				return false;
			}
			if (src[i] == strpattern[state+1]) {
				++i;
				++state;
			} else if (state == -1) {
				++i;
			} else {
				state = fails[state];
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new KMP().match("ABCDABAA" , "ABCDABD"));
	}
	
	
}
