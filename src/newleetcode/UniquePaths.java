//http://oj.leetcode.com/problems/unique-paths/
package newleetcode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int paths[] = new int[n];
		for (int i = 0; i < n; ++i) {
			paths[i] = 1;
		}
		for (int j = 1; j < m; ++j) {
			for (int i = 1; i < n; ++i) {
				if (i == 0) {
					paths[i] = 1;
				} else {
					paths[i] = paths[i] + paths[i - 1];
				}
			}
		}
		return paths[n - 1];
	}
}
