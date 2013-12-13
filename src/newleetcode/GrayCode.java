package newleetcode;
import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 1 << n; i++) {
			int j = i, k = 1 << (n - 1);
			int result = 0;
			while (k > 0) {
				if ((j & k) > 0) {
					result |= k;
					j = ~j;
				}
				k >>= 1;
			}
			l.add(result);
			System.out.println(result);
		}
		return l;
	}

	public static void main(String[] args) {
		GrayCode code = new GrayCode();
		code.grayCode(3);
	}
}