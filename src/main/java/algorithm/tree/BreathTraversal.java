package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BreathTraversal {

	public int[] getBreath(Node root) {
		ArrayDeque<Node> deque = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();

		deque.addLast(root);
		while (!deque.isEmpty()) {
			Node node = deque.removeFirst();
			list.add(node.value);

			if (node.left != null) {
				deque.addLast(node.left);
			}
			if (node.right != null) {
				deque.addLast(node.right);
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
