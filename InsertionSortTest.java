import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {

	List<String> strings = new LinkedList<String>();
	List<Integer> ints = new LinkedList<Integer>();
	InsertionSort is = new InsertionSort();
	
	
	@Before
	public void setUp() throws Exception {
		
		strings.add("C");
		strings.add("A");
		strings.add("J");
		
		ints.add(6);
		ints.add(3);
		ints.add(1);
		
	}

	@Test
	public void testInsertionSortString() {
		is.insertionSort(strings);
		
		assertEquals(strings.get(0) , "A");
		assertEquals(strings.get(1) , "C");
		assertEquals(strings.get(2) , "J");
		
		assertTrue(strings.get(0).compareTo(strings.get(1)) < 0);
		assertTrue(strings.get(1).compareTo(strings.get(2)) < 0);
		
		
	}
	
	@Test
	public void testInsertionSortInteger() {
		
		is.insertionSort(ints);
		
		assertEquals(ints.get(0).toString() , "1");
		assertEquals(ints.get(1).toString() , "3");
		assertEquals(ints.get(2).toString() , "6");
		
		assertTrue(ints.get(0) < ints.get(1));
		assertTrue(ints.get(1) < ints.get(2));
		
	}

}
