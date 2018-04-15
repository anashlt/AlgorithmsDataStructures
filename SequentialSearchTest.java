import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class SequentialSearchTest {
	
	List<String> listStr = new LinkedList<String>();
	List<Integer> listInt = new LinkedList<Integer>();
	
	Stack<String> stackStr = new Stack<String>();
	Stack<Integer> stackInt = new Stack<Integer>();
	
	SequentialSearch ss = new SequentialSearch();
	
	@Before
	public void setUp() throws Exception {
		
		//setup test cases
		//for seq search they dont need to be ordered
		
		listStr.add("C");
		listStr.add("E");
		listStr.add("A");
		listStr.add("D");
		listStr.add("B");
		listStr.add("1");
		
		listInt.add(5);
		listInt.add(3);
		listInt.add(7);
		listInt.add(1);
		listInt.add(12);
		
		stackStr.push("N");
		stackStr.push("R");
		stackStr.push("E");
		stackStr.push("S");
		stackStr.push("G");
		stackStr.push("1");
		
		stackInt.push(4);
		stackInt.push(2);
		stackInt.push(7);
		stackInt.push(1);
		stackInt.push(0);
		
	}

	@Test
	public void StringSearchTest() {
		
		assertEquals(ss.seqSearch(listStr, "A") , "A");
		assertEquals(ss.seqSearch(listStr, "E") , "E");
		assertEquals(ss.seqSearch(listStr, "U") , null);
		assertEquals(ss.seqSearch(listStr, 1) , null);
		
		assertEquals(ss.seqSearch(stackStr, "N") , "N");
		assertEquals(ss.seqSearch(stackStr, "G") , "G");
		assertEquals(ss.seqSearch(stackStr, "U") , null);
		assertEquals(ss.seqSearch(stackStr, 1) , null);
		
	}
	
	@Test
	public void IntSearchTest() {

		assertEquals(ss.seqSearch(listInt, 1) , 1);
		assertEquals(ss.seqSearch(listInt, 12) , 12);
		assertEquals(ss.seqSearch(listInt, 123) , null);
		assertEquals(ss.seqSearch(listInt, "1") , null);
		
		assertEquals(ss.seqSearch(stackInt, 4) , 4);
		assertEquals(ss.seqSearch(stackInt, 0) , 0);
		assertEquals(ss.seqSearch(stackInt, 123) , null);
		assertEquals(ss.seqSearch(stackInt, "1") , null);
		
	}

}
