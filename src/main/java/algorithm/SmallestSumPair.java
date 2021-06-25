package algorithm;

public class SmallestSumPair {

	public int determine(int[] buffer) {
		if (buffer.length < 3) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < buffer.length - 2; i += 2) {
			int sum = buffer[i] + buffer[i + 2];
			int currMinimum = Math.min(sum, min);
			if (currMinimum < min) {
				min = currMinimum;
			}
		}
		return min;
	}
}
