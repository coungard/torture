import algorithm.AdjacentElements;
import algorithm.BinarySearch;
import algorithm.MinWordSearch;
import algorithm.SmallestSumPair;
import algorithm.SpiralSnakeArrays;
import algorithm.cycleBuffer.CycleBuffer;
import algorithm.tree.BinaryTree;
import algorithm.tree.BreathTraversal;
import algorithm.tree.DeepestLevel;
import algorithm.tree.DeepestNode;
import algorithm.tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlgorithmTest {

	@Test
	public void DeepLevelTraversalTest() {
		int[] array = {3, 5, 4, 7, 2, 1};
		int[] array2 = {10, 4, 2, 16, 18, 17, 13};
		Node root = new BinaryTree().build(array);
		Node root2 = new BinaryTree().build(array2);

		DeepestLevel deepestLevel = new DeepestLevel();

		assertEquals(2, deepestLevel.getDeepLevel(root));
		assertEquals(3, deepestLevel.getDeepLevel(root2));
	}

	@Test
	public void DeepNodeTraversalTest() {
		int[] array = {3, 5, 4, 7, 2, 1};
		int[] array2 = {10, 4, 2, 16, 18, 3, 17, 13};
		Node root = new BinaryTree().build(array);
		Node root2 = new BinaryTree().build(array2);

		DeepestNode deepestNode = new DeepestNode();
		Node deepest = deepestNode.getDeepestNode(root);
		Node deepest2 = deepestNode.getDeepestNode(root2);

		Node node = new Node(7, null, null);
		Node node2 = new Node(17, null, null);
		assertEquals(deepest, node);
		assertEquals(deepest2, node2);
	}

	@Test
	public void BreathTraversalTest() {
		int[] array = {3, 5, 4, 7, 2, 1};
		int[] array2 = {10, 19, 17, 21, 5, 1, 6};
		Node root = new BinaryTree().build(array);
		Node root2 = new BinaryTree().build(array2);

		BreathTraversal breathTraversal = new BreathTraversal();
		int[] breath = breathTraversal.getBreath(root);
		int[] breath2 = breathTraversal.getBreath(root2);

		assertArrayEquals(new int[]{3, 2, 5, 1, 4, 7}, breath);
		assertArrayEquals(new int[]{10, 5, 19, 1, 6, 17, 21}, breath2);
	}

	@Test
	public void BinaryTreeTest() {
		int[] array = {3, 5, 4, 7, 2, 1};
		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.build(array);

		Node four = new Node(4, null, null);
		Node seven = new Node(7, null, null);
		Node one = new Node(1, null, null);
		Node two = new Node(2, one, null);
		Node five = new Node(5, four, seven);
		Node three = new Node(3, two, five);

		assertEquals(root, three);
		assertEquals(root.right, five);
		assertEquals(five.left, four);
	}

	@Test
	public void CycleBufferTest() {
		CycleBuffer<Integer> cycleBuffer = new CycleBuffer<>(4);
		cycleBuffer.add(1);
		cycleBuffer.add(3);
		cycleBuffer.add(5);

		assertEquals(new Integer(5), cycleBuffer.get(0));
		assertEquals(new Integer(3), cycleBuffer.get(1));
		assertEquals(new Integer(1), cycleBuffer.get(2));

		cycleBuffer.add(7);
		cycleBuffer.add(10);

		assertEquals(new Integer(10), cycleBuffer.get(0));
		assertEquals(new Integer(7), cycleBuffer.get(1));
		assertEquals(new Integer(5), cycleBuffer.get(2));
		assertEquals(new Integer(3), cycleBuffer.get(3));

		cycleBuffer.remove(0);
		assertEquals(new Integer(7), cycleBuffer.get(0));
	}

	@Test
	public void BinarySearchTest() {
		BinarySearch algrorithm = new BinarySearch();
		assertTrue(algrorithm.exist(3, new int[]{1, 3, 5, 7, 9, 11, 20}));
		assertFalse(algrorithm.exist(4, new int[]{1, 3, 5, 7, 9, 11, 20}));
	}

	@Test
	public void SpiralSnakeTest() {
		SpiralSnakeArrays algorithm = new SpiralSnakeArrays();
		int[][] spiral1 = algorithm.getSpiral(3, 4);
		int[][] spiral2 = algorithm.getSpiral(6, 7);
		int[][] spiral3 = algorithm.getSpiral(2, 1);

		assertArrayEquals(new int[][]{
				{1, 2, 3, 4},
				{10, 11, 12, 5},
				{9, 8, 7, 6}}, spiral1);

		assertArrayEquals(new int[][]{
				{1, 2, 3, 4, 5, 6, 7},
				{22, 23, 24, 25, 26, 27, 8},
				{21, 36, 37, 38, 39, 28, 9},
				{20, 35, 42, 41, 40, 29, 10},
				{19, 34, 33, 32, 31, 30, 11},
				{18, 17, 16, 15, 14, 13, 12}}, spiral2);

		assertArrayEquals(new int[][]{
				{1},
				{2}}, spiral3);
	}

	@Test
	public void testAdjacents() {
		AdjacentElements algorithm = new AdjacentElements();

		int[] adjacentElements3 = algorithm.replace(new int[]{0});
		int[] adjacentElements2 = algorithm.replace(new int[]{1, 6});
		int[] adjacentElements5 = algorithm.replace(new int[]{3, 5, 7});
		int[] adjacentElements = algorithm.replace(new int[]{1, 2, 3, 4, 5, 6});
		int[] adjacentElements4 = algorithm.replace(new int[]{1, 2, 3, 4, 5});
		assertArrayEquals(new int[]{0}, adjacentElements3);
		assertArrayEquals(new int[]{1, 6}, adjacentElements2);
		assertArrayEquals(new int[]{3, 5, 7}, adjacentElements5);
		assertArrayEquals(new int[]{1, 3, 2, 5, 4, 6}, adjacentElements);
		assertArrayEquals(new int[]{1, 3, 2, 4, 5}, adjacentElements4);
	}

	@Test
	public void testMinWordSearch() {
		MinWordSearch algorithm = new MinWordSearch();

		int found = algorithm.getNumber("Java is good");
		int found2 = algorithm.getNumber("Today i feel good");
		int found3 = algorithm.getNumber("Today feel good then me");
		int found4 = algorithm.getNumber("Today");
		assertEquals(2, found);
		assertEquals(2, found2);
		assertEquals(5, found3);
		assertEquals(1, found4);
	}

	@Test
	public void testSmallestSumPair() {
		SmallestSumPair algorithm = new SmallestSumPair();
		int min = algorithm.determine(new int[]{8, 7, 6, 5, 4, 3, 2});
		int min2 = algorithm.determine(new int[]{8, 7, 6});
		int min3 = algorithm.determine(new int[]{8, 7});

		assertEquals(0, min3);
		assertEquals(6, min);
		assertEquals(14, min2);
	}
}
