package algorithm.tree;

public class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node{" +
			   "value=" + value +
			   ", left=" + left +
			   ", right=" + right +
			   '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Node node = (Node) o;

		if (value != node.value) {
			return false;
		}
		if (left != null ? !left.equals(node.left) : node.left != null) {
			return false;
		}
		return right != null ? right.equals(node.right) : node.right == null;
	}

	@Override
	public int hashCode() {
		int result = value;
		result = 31 * result + (left != null ? left.hashCode() : 0);
		result = 31 * result + (right != null ? right.hashCode() : 0);
		return result;
	}
}
