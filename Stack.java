import java.util.*;

public class Stack<E> {
	private ArrayList<E> stack = new ArrayList<E>();
	private int top = 0;
	
	public void push(E item) {
		stack.add(top++, item);
	}

	public E pop() {
		return stack.remove(--top);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		System.out.println(s.pop());
	}

}