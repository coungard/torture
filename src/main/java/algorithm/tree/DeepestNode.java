package algorithm.tree;

import java.util.ArrayDeque;

public class DeepestNode {

	public Node getDeepestNode(Node root) {
		ArrayDeque<Node> deque = new ArrayDeque<>();
		Node result = null;

		deque.addLast(root);
		while (!deque.isEmpty()) {
			Node node = deque.removeFirst();
			if (node.left != null) {
				deque.addLast(node.left);
			}
			if (node.right != null) {
				deque.addLast(node.right);
			}
			if (deque.isEmpty()) {
				result = node;
				break;
			}
		}
		return result;
	}
}
