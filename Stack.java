import java.util.*;

public class Stack<E> {
	private ArrayList<E> stack = new ArrayList<E>();
	private int top = 0;
	
	// returns the size of the stack
	public int size() {
		return top;
	}
	
	// check if stack is empty
	public boolean isEmpty() {
        return (top == 0);
    }
	
	// method push to add item to the stack.
	public void push(E item) {
		stack.add(top++, item);
	}
	
	// method pop to remove top item in the stack and return it
	public E pop() {
		if (isEmpty()) // if stack is empty
		      throw new EmptyStackException("Stack is empty, cannot pop");
		return stack.remove(--top);
	}
	

}

class EmptyStackException extends RuntimeException {
	  public EmptyStackException() {
	    this("Stack is empty");
	  }

	  public EmptyStackException(String exception) {
	    super(exception);
	  }
}