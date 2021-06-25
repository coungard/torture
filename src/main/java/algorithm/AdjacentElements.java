package algorithm;


public class AdjacentElements {

	public int[] replace(int[] buffer) {
		if (buffer.length < 4) {
			return buffer;
		}
		for (int i = 1; i < buffer.length - 2; i+=2) {
			swap(buffer, i);
		}
		return buffer;
	}

	private void swap(int[] buffer, int i) {
		int temp = buffer[i];
		buffer[i] = buffer[i + 1];
		buffer[i + 1] = temp;
	}
}
