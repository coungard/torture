package algorithm;

/**
 * Дан отсортированный массив. Необходимо написать метод, который проверяет, есть ли указанный элемент в массиве.
 * Массив может быть очень большим. Тип данных – int. Массив одномерный.
 */
public class BinarySearch {

	public boolean exist(int elem, int[] buffer) {
		int low = 0;
		int high = buffer.length;
		while (high > low) {
			int mid = (high - low) / 2;
			if (elem == buffer[mid]) {
				return true;
			}
			if (elem < buffer[mid]) {
				high = mid - 1;
			}
			if (elem > buffer[mid]) {
				low = mid + 1;
			}
		}
		return false;
	}
}
