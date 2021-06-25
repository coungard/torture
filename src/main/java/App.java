import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		int[] array = new int[]{1, 4, 7};
		Arrays.sort(array);
		Arrays.binarySearch(array, 4);
	}
}

class Record {
	Long getLong(String param) {
		return 1L;
	}
}

class Binding {
	Long getLong(String param) {
		return 0L;
	}
}
