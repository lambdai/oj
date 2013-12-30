//http://oj.leetcode.com/problems/add-binary/
package newleetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
    	char sa[] = a.toCharArray();
    	char sb[] = b.toCharArray();
    	char sc[] = new char[sa.length + sb.length +1];
    	char carrier = 0;
    	char[] left;
    	int ileft;
    	int lena = sa.length, ia=lena-1;
    	int lenb = sb.length, ib=lenb-1;
    	int i = 0;
    	while(ia >= 0 && ib >= 0) {
    		char a1 = (char) (sa[ia] - '0');
    		char b1 = (char) (sb[ib] - '0');
    		sc[i] = (char) ('0' + ((a1 + b1 + carrier) & 1));
    		carrier = (char) ((a1+b1+carrier) >> 1);
    		--ia;--ib;++i;
    	}
    	if(ib < 0) {
    		left = sa;
    		ileft = ia;
    	} else {
    		left = sb;
    		ileft = ib;
    	}
    	for(;ileft >=0;--ileft) {
    		sc[i] = (char)(((left[ileft] - '0' + carrier) & 1) + '0');
    		carrier = (char)((left[ileft] - '0' + carrier) >> 1);
    		++i;
    	}
    	if (carrier == 1) {
    		sc[i] = '1';
    	} else {
    		--i;
    	}
    	
    	for(int j = 0, k = i; j < k; ++j,--k){
    		char temp = sc[j];
    		sc[j] = sc[k];
    		sc[k] = temp;
    	}
    	return String.valueOf(sc, 0, i+1);
    }
    
    public static void main(String args[]) {
    	System.out.println(new AddBinary().addBinary("0", "0"));
    }
}
