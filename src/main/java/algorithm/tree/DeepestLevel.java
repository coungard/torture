package algorithm.tree;

public class DeepestLevel {

	public int getDeepLevel(Node root) {
		int deepLeft = 0;
		int deepRight = 0;

		if (root.left != null) {
			deepLeft = getDeepLevel(root.left) + 1;
		}
		if (root.right != null) {
			deepRight = getDeepLevel(root.right) + 1;
		}

		return Math.max(deepLeft, deepRight);
	}
}
