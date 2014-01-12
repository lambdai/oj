package newleetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class ACMata {
	ACNode root = new ACNode();

	public ACMata(String[] strs) {
		for (String str : strs) {
			byte[] bytes = str.getBytes();
			ACNode node = root.add(bytes, 0, bytes.length);
			node.orginalString = str;
		}
	}

	public void updateFailedField() {
		root.failed = root;
		Queue<ACNode> q = new LinkedList<ACNode>();
		Queue<ACNode> parents = new LinkedList<ACNode>();
		q.add(root);
		parents.add(root);
		ACNode current;
		ACNode parent;
		while (!q.isEmpty()) {
			current = q.poll();
			parent = parents.poll();
			if (current.orginalString != null) {
				current.matches.put(current.orginalString.length(),
						current.orginalString);
			}
			ACNode pfails = parent.failed;
			while (pfails != root && current.failed == null) {
				current.failed = pfails.nextNodes.get(current.val);
				pfails = pfails.failed;
			}
			current.failed = current.failed == null ? root.nextNodes
					.get(current.val) : current.failed;

			if (current.failed == current || current.failed == null) {
				current.failed = root;
			} else {
				HashMap<Integer, String> map = current.failed.matches;
				for (Entry<Integer, String> entry : map.entrySet()) {
					current.matches.put(entry.getKey(), entry.getValue());
				}
			}
			for (ACNode next : current.nextNodes.values()) {
				// We cannot calculate the nodes of next level until all current
				// level is done.
				// However, we must record the parent node of the node which are
				// lied in next level;
				q.offer(next);
				parents.offer(current);
			}
		}
	}

	public static void main(String args[]) {
		ACMata ac = new ACMata(new String[] { "he", "her", "she", "shy" });
		ac.updateFailedField();
		ac.dump();
		return;
	}

	public void dump() {
		dump(root, root, "");
	}

	private void dump(ACNode node, ACNode root, String prefix) {
		System.out.println(prefix
				+ String.format(
						"Id: %d Node: %s failed: %d",
						node.hashCode(),
						node == root ? "root" : String
								.valueOf((char) (node.val & 0xFF)), node.failed
								.hashCode()));
		System.out.println(prefix + node.matches);
		prefix += "  ";
		for (ACNode nodes : node.nextNodes.values()) {
			dump(nodes, root, prefix);
		}

	}

}

class ACNode {
	byte val;
	HashMap<Byte, ACNode> nextNodes = new HashMap<Byte, ACNode>();
	String orginalString;
	ACNode failed;
	HashMap<Integer, String> matches = new HashMap<Integer, String>();

	ACNode add(byte[] str, int start, int end) {
		if (start == end) {
			return this;
		}
		ACNode nextNode = nextNodes.get(str[start]);
		if (nextNode == null) {
			nextNode = new ACNode();
			nextNode.val = str[start];
			nextNodes.put(str[start], nextNode);
		}
		return nextNode.add(str, start + 1, end);
	}
}
