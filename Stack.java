import java.util.*;

public class Stack<E> {
	private ArrayList<E> stack = new ArrayList<E>();
	private int top = 0;
	
	// returns the size of the stack
	public int size() {
		return top;
	}
	
	// method push to add item to the stack.
	public void push(E item) {
		stack.add(top++, item);
	}
	
	// method pop to remove top item in the stack and return it
	public E pop() {
		return stack.remove(--top);
	}

}