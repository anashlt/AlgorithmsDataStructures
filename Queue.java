import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;


public class Queue<T> extends AbstractQueue{
	
	private int size;
	private int maxSize;
	private Comparator<? super T> comp;
	Object[] stack;
	
	public Queue () {
		maxSize = 10;
		stack = new Object[10];
		size = 0;
	}
	
	public Queue (int maxSize) {
		this.maxSize = maxSize;
		stack = new Object[maxSize];
	}
	
	public boolean add(Object t) {
		if (!offer(t)) {
			return false;
		}
		
		stack[size] = t;
		size++;
		return true;
		
		
		
	}
	
	@Override
	public boolean offer(Object e) {
		if (this.size == this.maxSize) {
			return false;
		}
		return true;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
