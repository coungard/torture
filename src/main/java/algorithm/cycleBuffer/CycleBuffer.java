package algorithm.cycleBuffer;

import java.util.LinkedList;

/**
 * Реализуйте класс “Циклический Буфер”. Это коллекция с ограничением по размеру.
 * Если при добавлении нового элемента в буфер оказывается, что он уже содержит максимальное количество элементов,
 * самый старый элемент перезаписывается новым. Должны поддерживаться следующие операции:
 * <p>
 * добавить элемент
 * получить текущее количество элементов
 * получить элемент по индексу
 * удалить элемент по индексу
 */
public class CycleBuffer<E> implements ICycleBuffer<E> {

	private final int size;
	private int count;
	private Node<E> last;

	public CycleBuffer(int size) {
		this.size = size;
	}

	@Override
	public E add(E e) {
		if (count < size) {
			count++;
		}
		linkLast(e);
		return e;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid index!");
		}
		Node<E> x = last;
		for (int i = 0; i < index; i++) {
			x = x.prev;
		}
		return x.item;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid index!");
		}
		return unlink(node(index));
	}

	@Override
	public int count() {
		return count;
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	/**
	 * Links e as last element.
	 */
	void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, e, null);
		last = newNode;
		if (l != null) {
			l.next = newNode;
		}
	}

	/**
	 * Unlinks non-null node x.
	 */
	E unlink(Node<E> x) {
		final E element = x.item;
		final Node<E> next = x.next;
		final Node<E> prev = x.prev;

		if (prev != null) {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		return element;
	}

	/**
	 * Returns the (non-null) Node at the specified element index.
	 */
	Node<E> node(int index) {
		Node<E> x = last;
		for (int i = count - 1; i > index; i--) {
			x = x.prev;
		}
		return x;
	}
}

