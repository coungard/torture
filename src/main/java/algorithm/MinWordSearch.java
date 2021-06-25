package algorithm;

public class MinWordSearch {

	public int getNumber(String text) {
		String[] parts = text.split(" ");
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < parts.length; i++) {
			int minimun = Math.min(parts[i].length(), min);
			if (minimun < min) {
				result = i;
				min = minimun;
			}
		}
		return ++result;
	}
}
