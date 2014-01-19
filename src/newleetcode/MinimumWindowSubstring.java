//http://oj.leetcode.com/problems/minimum-window-substring/
package newleetcode;

import java.util.HashMap;
import java.util.Set;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int lt = T.length();
		HashMap<Character, Integer> thash = new HashMap<Character, Integer>();
		HashMap<Character, Integer> shash = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			Integer count = null;
			char c = T.charAt(i);
			count = thash.get(c);
			if (count == null) {
				count = new Integer(0);
			}
			count++;
			thash.put(c, count);
		}
		for (char c : thash.keySet()) {
			shash.put(c, 0);
		}
		Set<Character> keySet = thash.keySet();
		int min = Integer.MAX_VALUE;
		int minends = 0;
		int ends = 0;
		int keySatisfied = 0;
		int needKeys = keySet.size();
		int currentlen = 0;
		for (int j = 0; j < S.length(); j++) {
			char c = S.charAt(j);
			if (keySatisfied < needKeys) {
				if (keySet.contains(c)) {
					int newCount = shash.get(c) + 1;
					shash.put(c, newCount);
					if (newCount == thash.get(c)) {
						keySatisfied++;
					}
				}
				currentlen++;
				ends = j;
				if (keySatisfied == needKeys) {
					// the current windows contains all the ones have the chars.
					// However, we should delete the leadings so that we might
					// get smaller windows
					for (int k = 0; k < j; k++) {
						char leadChar = S.charAt(k);
						if (!keySet.contains(leadChar)) {
							currentlen--;
						} else {
							if (shash.get(leadChar) > thash.get(leadChar)) {
								shash.put(leadChar, shash.get(leadChar) - 1);
								currentlen--;
							} else {
								break;
							}
						}
					}
					minends = ends;
					min = currentlen;
				}
			} else {
				ends = j;
				currentlen++;
				// if this is bad char, it can not be a minimum string
				if (keySet.contains(c)) {
					int newCount = shash.get(c) + 1;
					shash.put(c, newCount);
					// the currentwindow contains all the keys, try trim from
					// the leading
					for (int k = j - currentlen + 1; k < j; k++) {
						c = S.charAt(k);
						if (!keySet.contains(c)) {
							currentlen--;
						} else {
							if (shash.get(c) > thash.get(c)) {
								shash.put(c, shash.get(c) - 1);
								currentlen--;
							} else {
								break;
							}
						}
					}
					if (min > currentlen) {
						min = currentlen;
						minends = ends;
					}
				}
			}
		}
		if (keySatisfied < needKeys) {
			return "";
		} else {
			return S.substring(minends - min + 1, minends + 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinimumWindowSubstring().minWindow(
				"babcefaecbef", "abc"));
	}

}
