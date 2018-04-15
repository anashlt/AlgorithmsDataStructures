import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;


public class Queue<T> extends AbstractQueue{
	
	private int size;
	private int maxSize;
	private Comparator<? super T> comp;
	Object[] queue;
	
	public Queue () {
		maxSize = 10;
		queue = new Object[10];
		size = 0;
	}
	
	/**
	 * 
	 * @param maxSize - max size of queue
	 */
	public Queue (int maxSize) {
		this.maxSize = maxSize;
		queue = new Object[maxSize];
	}
	
	@Override
	/**
	 * @param object that will be enqueued
	 * @return if object was added or not
	 */
	public boolean add(Object t) {
		if (!offer(t)) {
			return false;
		}
		
		queue[size] = t;
		size++;
		return true;
		
		
		
	}
	
	@Override
	/**
	 * @return if max size of queue is reached or not
	 */
	public boolean offer(Object e) {
		if (this.size == this.maxSize) {
			return false;
		}
		return true;
	}

	@Override
	/**
	 * @return the next item to queue and remove it from queue
	 */
	public Object poll() {
		Object o = queue[0];
		queue[0] = null;
		//move all other elements back
		for (int i = 0; i < size; i++) {
			queue[i] = queue[i+1];
		}
		size--;
		return o;
	}

	@Override
	/**
	 * @return the next item to dequeue
	 */
	public Object peek() {
		return queue[0];
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	/**
	 * @return size of queue
	 */
	public int size() {
		return size;
	}

}
