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

	/// Inserts the value at the last position of list
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

	/// Remove from first position 
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

	/// Remove first match of node having the value same as input value
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

	// lets try
	public static void main(String[] args) {
		final DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

		// Inserts the node with value 5 at the head position
		doublyLinkedList.insertFirst(5);

		// Inserts the node with value 1 at the head position, pushing the
		// previously inserted node to second position
		doublyLinkedList.insertFirst(1);

		// Inserts the node with value 2 at the head position, pushing the
		// previously inserted node to second position
		doublyLinkedList.insertFirst(2);

		// Inserts the node with value 3 at the tail position
		doublyLinkedList.insertLast(3);

		// Inserts the node with value 4 at the tail position, pushing the
		// previously inserted node to second position from last
		doublyLinkedList.insertLast(4);

		// At this point, LinkedList will look like: 2 <=> 1 <=> 5 <=> 3 <=> 4

		// Removes the node with value 2 since it is head node. This operation
		// will also make node with value 1 as head node
		System.out.println(doublyLinkedList.removeFirst());

		// Removes the node with value 1 since it is head node. This operation
		// will also make node with value 5 as head node
		System.out.println(doublyLinkedList.removeFirst());

		// Removes the node with value 4 since it is tail node. This operation
		// will also make node with value 3 as tail node
		System.out.println(doublyLinkedList.removeLast());

		// Removes the node with value 3 since it is tail node. This operation
		// will also make node with value 5 as tail node
		System.out.println(doublyLinkedList.removeLast());

		// Removes the node with value 5
		System.out.println(doublyLinkedList.remove(5));

		// Returns null since there is no node with value 2 as it was removed
		// due to earlier removeXXX method calls
		System.out.println(doublyLinkedList.remove(2));

	}

}