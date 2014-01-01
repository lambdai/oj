
//http://oj.leetcode.com/problems/max-points-on-a-line/
package newleetcode;

import java.util.HashMap;
import java.util.Map.Entry;

import dyc.Point;

public class MaxPointsOnLine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) { return 0;}
			
		int max = 1;
		for (Point p0 : points) {
			//p0.dump();
			HashMap<Gradient, Integer> m = new HashMap<Gradient, Integer>();
			for (Point p : points) {
				//p.dump();
				Gradient g = new Gradient(p.x - p0.x, p.y - p0.y);
				//g.dump();
				if (m.containsKey(g)) {
					m.put(g, m.get(g) + 1);
				} else {
					m.put(g, 1);
				}
			}
			Gradient g = new Gradient(0, 0);
			int naive = m.get(g);
			if (naive > max) { max = naive;}
			m.remove(g);
			for (Entry<Gradient, Integer> e : m.entrySet()) {
				int v = e.getValue();
				if (v + naive > max) {
					max = v + naive;
				}
			}
		}
		return max;
	}
	
	 public static void main(String args[]) {
	 
		System.out.println(new MaxPointsOnLine().maxPoints(new Point[]{new Point(1,2), new Point(2,4)}));
	}
	
}

class Gradient {
	public int numerator;
	public int denominator;

	Gradient(int x, int y) {
		if (y == 0) {
			if (x == 0) {
				numerator = 0;
				denominator = 0;
			} else {
				numerator = 1;
				denominator = 0;
			}
		} else if (x == 0) {
			numerator = 0;
			denominator = 1;
		} else { 
			if (y < 0) {
				numerator = -x;
				denominator = -y;
			} else {
				numerator = x;
				denominator = y;
			}
			x = x > 0 ? x : -x;
			y = y > 0 ? y : -y;
			while (x != 0) {
				y = y % x;
				int temp = y;
				y = x;
				x = temp;
			}
			numerator /= y;
			denominator /= y;
		}
	}
	public boolean equals(Object g) {
		if (g.getClass() == Gradient.class) {
			Gradient gg = (Gradient)g;
			return gg.numerator == this.numerator && gg.denominator == this.denominator;
		}
		return false;
	
	}
	public int hashCode(){
        int hashcode = 0;
        hashcode = numerator*65535 + denominator;
        return hashcode;
    }
	void dump() {
		System.out.println("" + numerator+ " " + denominator);
	}
	
}