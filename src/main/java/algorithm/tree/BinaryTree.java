package algorithm.tree;

public class BinaryTree {

	public Node build(int[] array) {
		Node root = null;
		for (int value : array) {
			root = insert(root, value);  // root - ВСЕГДА ОДНА И ТА ЖЕ НОДА!!!
		}
		return root;
	}

	private Node insert(Node root, int value) {
		if (root == null) {
			return new Node(value, null, null);
		}
		if (value >= root.value) {
			root.right = insert(root.right, value);
		}
		if (value < root.value) {
			root.left = insert(root.left, value);
		}
		return root;
	}
}
