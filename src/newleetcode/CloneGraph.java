//http://oj.leetcode.com/problems/clone-graph/
package newleetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import dyc.UndirectedGraphNode;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> currentQ = new LinkedList<UndirectedGraphNode>();
		Queue<UndirectedGraphNode> newQ = null; // new
												// LinkedList<UndirectedGraphNode>();
		currentQ.add(node);
		UndirectedGraphNode origin = node;
		UndirectedGraphNode upperCopy;
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(copy.label, copy);
		while (!currentQ.isEmpty()) {
			newQ = new LinkedList<UndirectedGraphNode>();
			while (true) {
				origin = currentQ.poll();
				
				if (origin == null) {
					break;
				}
				upperCopy = map.get(origin.label);
				// copy = new UndirectedGraphNode(node.label);
				// map.put(node.label, copy);
				for (UndirectedGraphNode neighbor : origin.neighbors) {
					if (!map.containsKey(neighbor.label)) {
						copy = new UndirectedGraphNode(neighbor.label);
						map.put(neighbor.label, copy);
						newQ.add(neighbor);
						upperCopy.neighbors.add(copy);
					} else {
						upperCopy.neighbors.add(map.get(neighbor.label));
					}
				}
			}
			currentQ = newQ;
		}
		return map.get(node.label);
	}
	
	public static void main(String args[]) {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		
		node0.neighbors.add(node1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		UndirectedGraphNode copy =new CloneGraph().cloneGraph(node0);
		System.out.println(copy);
	}

}
