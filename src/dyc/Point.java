package dyc;

public class Point {
	public int x;
	public int y;

	Point() {
		x = 0;
		y = 0;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}
	
	public void dump() {
		System.out.println("Point: {" + x + "," + y+ "}");
	}
}
