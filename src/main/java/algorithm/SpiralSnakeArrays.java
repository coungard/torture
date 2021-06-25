package algorithm;

public class SpiralSnakeArrays {

	/**
	 * {1,  2,  3,   4}
	 * {10, 11, 12,  5}
	 * {9,  8,  7,   6}
	 */
	public int[][] getSpiral(int height, int width) {
		int[][] res = new int[height][width];
		int incr = 1;
		int i = 0;
		int j = 0;
		int widthShift = 0;
		int heightShift = 0;
		Vector vector = width > 1 ? Vector.RIGHT : Vector.BOTTOM;
		do {
			res[i][j] = incr++;
			switch (vector) {
				case RIGHT:
					j++;
					if (j == width - widthShift - 1) {
						vector = Vector.BOTTOM;
						widthShift++;
					}
					break;
				case BOTTOM:
					i++;
					if (i == height - heightShift - 1) {
						vector = Vector.LEFT;
						heightShift++;
					}
					break;
				case LEFT:
					j--;
					if (j == widthShift - 1) {
						vector = Vector.TOP;
					}
					break;
				case TOP:
					i--;
					if (i == heightShift) {
						vector = Vector.RIGHT;
					}
					break;
			}
		} while (incr <= width * height);
		return res;
	}

	private enum Vector {
		LEFT,
		RIGHT,
		TOP,
		BOTTOM
	}
}
