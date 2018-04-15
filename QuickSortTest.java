import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	List<String> strings = new LinkedList<String>();
	List<Integer> ints = new LinkedList<Integer>();
	Queue<String> queueStr = new PriorityQueue<String>();
	Queue<Integer> queueInt = new PriorityQueue<Integer>();
	Stack<String> stackStr = new Stack<String>();
	Stack<Integer> stackInt = new Stack<Integer>();
	
	QuickSort qs = new QuickSort();
	
	
	@Before
	public void setUp() throws Exception {
		
		strings.add("C");
		strings.add("A");
		strings.add("J");
		
		ints.add(6);
		ints.add(3);
		ints.add(1);
		
		queueStr.add("C");
		queueStr.add("A");
		queueStr.add("J");
		
		queueInt.add(6);
		queueInt.add(3);
		queueInt.add(1);
		
		stackStr.push("C");
		stackStr.push("A");
		stackStr.push("J");
		
		stackInt.push(6);
		stackInt.push(3);
		stackInt.push(1);
		
	}

	@Test
	public void testsmartBubbleSortString() {
		qs.quickSort(strings, 0 , strings.size()-1);
		
		assertEquals(strings.get(0) , "A");
		assertEquals(strings.get(1) , "C");
		assertEquals(strings.get(2) , "J");
		
		assertTrue(strings.get(0).compareTo(strings.get(1)) < 0);
		assertTrue(strings.get(1).compareTo(strings.get(2)) < 0);
		
		//stack has opposite order
		qs.quickSort(stackStr , 0,stackStr.size()-1);
		assertEquals(stackStr.pop() , "J");
		assertEquals(stackStr.pop() , "C");
		assertEquals(stackStr.pop() , "A");

		//set up again because stack items were removed
		stackStr.push("C");
		stackStr.push("A");
		stackStr.push("J");

		assertTrue(stackStr.pop().compareTo(stackStr.peek()) > 0);
		assertTrue(stackStr.pop().compareTo(stackStr.peek()) < 0);
		
	}
	
	@Test
	public void testsmartBubbleSortInteger() {
		
		qs.quickSort(ints , 0 , ints.size()-1);
		
		assertEquals(ints.get(0).toString() , "1");
		assertEquals(ints.get(1).toString() , "3");
		assertEquals(ints.get(2).toString() , "6");
		
		assertTrue(ints.get(0) < ints.get(1));
		assertTrue(ints.get(1) < ints.get(2));
		
		qs.quickSort(stackInt,0,stackInt.size()-1);
		//stack is opposite order
		assertEquals(stackInt.pop().toString() , "6");
		assertEquals(stackInt.pop().toString() , "3");
		assertEquals(stackInt.pop().toString() , "1");
		
		//set up again because stack items were removed
		stackInt.push(6);
		stackInt.push(3);
		stackInt.push(1);
		
		assertTrue(stackInt.pop().compareTo(stackInt.peek()) < 0);
		assertTrue(stackInt.pop().compareTo(stackInt.peek()) < 0);
		
		
	}
}
