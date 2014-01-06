//http://oj.leetcode.com/problems/surrounded-regions/
package newleetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	static final char O = 'O', X = 'X', Z = 'Z';
	int width, height;
	char[][] board;

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		width = board[0].length;
		height = board.length;
		this.board = board;
		int x, y;
		for (x = 0; x < height; ++x) {
			bfs(x, 0);
			bfs(x, width - 1);
		}
		for (y = 0; y < width; ++y) {
			bfs(0, y);
			bfs(height - 1, y);
		}

		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {

				if (board[i][j] == Z) {
					board[i][j] = O;
				} else if (board[i][j] == O) {
					board[i][j] = X;
				}
			}
		}
	}

	void bfs(int x, int y) {
		if (board[x][y] != O) {
			return;
		}
		board[x][y] = Z;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x * width + y);
		int pos;
		// int x, y;
		int nx, ny;
		boolean visited;
		while (!q.isEmpty()) {
			pos = q.poll();
			x = pos / width;
			y = pos % width;
			// if(board[x][y] == O) {
			// board[x][y] = Z;
			if (x - 1 >= 0) {
				nx = x - 1;
				visited = visit(nx, y);
				if (!visited) {
					q.add(nx * width + y);
				}
			}
			if (x + 1 < height) {
				nx = x + 1;
				visited = visit(nx, y);
				if (!visited) {
					q.add(nx * width + y);
				}
			}
			if (y - 1 >= 0) {
				ny = y - 1;
				visited = visit(x, ny);
				if (!visited) {
					q.add(x * width + ny);
				}
			}
			if (y + 1 < width) {
				ny = y + 1;
				visited = visit(x, ny);
				if (!visited) {
					q.add(x * width + ny);
				}
			}
			// }
		}
	}

	boolean visit(int x, int y) {
		if (board[x][y] == O) {
			board[x][y] = Z;
			return false;
		}
		return true;
	}

	public static void main(String args[]) {
		char[][] board = new char[][] { new char[] { X,O,X,O,X,O },
				new char[] { O,X,O,X,O,X}, new char[] { X,O,X,O,X,O },
				new char[] { X,O,X,O,X,O }, };
		new SurroundedRegions().solve(board);
		return;

	}

}