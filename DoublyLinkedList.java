public class DoublyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;

	//Inserts the value at the first position of list
	public void insertFirst(final T value) {
		final Node<T> node = new Node<>(value);
		node.next = head;
		if (head != null) {
			head.previous = node;
		}

		head = node;

		if (tail == null) {
			tail = node;
		}
	}

	// Inserts the value at the last position of list
	public void insertLast(final T value) {
		final Node<T> node = new Node<>(value);
		if (tail != null) {
			tail.next = node;
			node.previous = tail;
		}
		tail = node;

		if (head == null) {
			head = node;
		}
	}

	// Remove from first position 
	public T removeFirst() {
		T value = null;
		if (head != null) {
			value = head.value;
			if (head == tail) {
				tail = null;
			}

			head = head.next;
			head.previous = null;
		}

		return value;
	}

	// Remove last position
	public T removeLast() {
		T value = null;
		if (tail != null) {
			value = tail.value;

			if (tail == head) {
				head = tail = null;
			} else {
				tail = tail.previous;
				tail.next = null;
			}
		}
		return value;
	}

	// Remove first match of node having the value same as input value
	public T remove(final T value) {
		T deletedObj = null;
		if (head != null) {
			if (head == tail) {
				if (head.value.equals(value)) {
					deletedObj = head.value;
					head = tail = null;
				}
			} else {
				Node<T> node = head;
				do {
					if (node.value.equals(value)) {
						deletedObj = node.value;

						if (node.previous != null) {
							node.previous.next = node.next;

						}
						node.next.previous = node.previous;
						break;
					}
					node = node.next;
				} while (node != null);
			}
		}

		return deletedObj;
	}

	// Implementation of a Node of a Doubly Linked List
	private static class Node<T> {
		T value;
		Node<T> next;
		Node<T> previous;

		private Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}

	}

}