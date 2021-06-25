package algorithm.cycleBuffer;

public interface ICycleBuffer<T> {

	T add(T t);

	T get(int index);

	T remove(int index);

	int count();
}
