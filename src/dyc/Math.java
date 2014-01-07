package dyc;

public class Math {
	static int choose(int m, int n) {
		if (m < n) {
			return 0;
		}
		if (m == n || n == 0) {
			return 1;
		}
		return choose(m-1, n) + choose(m-1, n-1);
	}

	public static void main(String args[]) {
		System.out.println(choose(32,16));
	}
}
