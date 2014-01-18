//http://oj.leetcode.com/problems/insert-interval/
package newleetcode;

import java.util.ArrayList;

import dyc.Interval;

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> ret = new ArrayList<Interval>();
		int mergePhase = 0;
		int start = 0, end = 0;
		for (Interval i : intervals) {
			// Interval current = i;
			if (mergePhase == 0) {
				if (newInterval.start > i.end) {
					ret.add(i);
				} else if (newInterval.start <= i.end) {
					if (newInterval.end < i.start) {
						ret.add(newInterval);
						ret.add(i);
						mergePhase = 2;
					} else {
						start = newInterval.start < i.start ? newInterval.start
								: i.start;
						end = newInterval.end > i.end ? newInterval.end : i.end;
						mergePhase = 1;
					}
				}
			} else if (mergePhase == 1) {
				if (end < i.start) {
					ret.add(new Interval(start, end));
					ret.add(i);
					mergePhase = 2;
				} else {
					end = end > i.end ? end : i.end;
				}
			} else {
				ret.add(i);
			}
		}
		if (mergePhase == 0) {
			ret.add(newInterval);
		} else if (mergePhase == 1) {
			ret.add(new Interval(start, end));
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
