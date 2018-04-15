import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

	BinarySearch bs = new BinarySearch();
	
	List<String> list = new LinkedList<String>();
	List<Integer> listInt = new LinkedList<Integer>();
	
	Stack<String> stackStr = new Stack<String>();
	Stack<Integer> stackInt = new Stack<Integer>();
	
	QuickSort qs = new QuickSort();
	
	@Before
	public void setUp() throws Exception {
		
		list.add("F");
		list.add("D");
		list.add("E");
		list.add("B");
		list.add("C");
		list.add("A");
		
		listInt.add(4);
		listInt.add(2);
		listInt.add(7);
		listInt.add(1);
		listInt.add(9);
		listInt.add(12);
		
		stackStr.push("B");
		stackStr.push("E");
		stackStr.push("C");
		stackStr.push("A");
		
		stackInt.push(6);
		stackInt.push(1);
		stackInt.push(5);
		stackInt.push(2);
		
		//before performing binary search the collection must be sorted
		qs.quickSort(list, 0, list.size()-1);
		qs.quickSort(listInt, 0, listInt.size()-1);
		qs.quickSort(stackStr, 0, stackStr.size()-1);
		qs.quickSort(stackInt, 0, stackInt.size()-1);
	}

	@Test
	public void binSearchTest() {
		
		assertEquals(bs.binSearch(list, "F") , "F");
		assertEquals(bs.binSearch(list, "A") , "A");
		assertEquals(bs.binSearch(list, "U") , null);
		
		assertTrue(bs.binSearch(listInt, 2) == 2);
		assertTrue(bs.binSearch(listInt, 9) == 9);
		assertTrue(bs.binSearch(listInt, 124) == null);
		
		assertEquals(bs.binSearch(stackStr, "E") , "E");
		assertEquals(bs.binSearch(stackStr, "A") , "A");
		assertEquals(bs.binSearch(stackStr, "U") , null);
		
		assertTrue(bs.binSearch(stackInt, 5) == 5);
		assertTrue(bs.binSearch(stackInt, 1) == 1);
		assertTrue(bs.binSearch(stackInt, 124) == null);
		
	}

}
