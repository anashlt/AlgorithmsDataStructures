public class LinkedList<T> {

	private LinkedListNode<T> first = null;
	
	// Insert at start of list
	public void insert(LinkedListNode<T> node) {
		node.setNext(first);
		first = node;
	}


	// Remove from start of list
	public void remove(){
		if(first.getNext()!=null)
			first = first.getNext();
		else first = null;
	}
	
	// Go over list and print the node value
	private void printList(LinkedListNode<T> node) {
		System.out.println("Node is " + node.getValue());
		if(node.getNext()!=null) printList(node.getNext());
	}

	public void print(){
		printList(first);
	}

}

class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> next;

	public LinkedListNode(T value) {
		this.value = value;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}
}