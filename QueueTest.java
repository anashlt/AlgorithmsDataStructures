import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	
	Queue<String> q = new Queue<String>();
	Queue<Integer> qInt = new Queue<Integer>();
	
	@Before
	public void setUp() throws Exception {
		q.add("s");
		q.add("c");
		q.add("a");
		
		qInt.add(3);
		qInt.add(7);
		qInt.add(1);
	}

	@Test
	public void pollTest() {
		//test string input
		assertEquals(q.poll() , "s");
		assertEquals(q.poll() , "c");
		assertEquals(q.poll() , "a");
		assertEquals(q.poll() , null);
		assertEquals(q.poll() , null);
		
		//test int input
		assertEquals(qInt.poll() , 3);
		assertEquals(qInt.poll() , 7);
		assertEquals(qInt.poll() , 1);
		assertEquals(qInt.poll() , null);
		assertEquals(qInt.poll() , null);
	}
	
	@Test
	public void peekTest() {
		assertEquals(q.peek() , "s");
		q.poll();
		assertEquals(q.peek() , "c");
		q.poll();
		assertEquals(q.poll() , "a");
		q.poll();
		assertEquals(q.poll() , null);
		q.poll();
		assertEquals(q.poll() , null);
		
		assertEquals(qInt.peek() , 3);
		qInt.poll();
		assertEquals(qInt.peek() , 7);
		qInt.poll();
		assertEquals(qInt.poll() , 1);
		q.poll();
		assertEquals(qInt.poll() , null);
		qInt.poll();
		assertEquals(qInt.poll() , null);
	}
	
	@Test
	public void sizeTest() {
		assertEquals(q.size(),3);
		q.add("g");
		assertEquals(q.size(),4);
		q.poll();
		assertEquals(q.size(),3);
	}
	
	@Test
	public void offerTest() {
		Queue<String> q2 = new Queue<String>(2);
		assertTrue(q2.add("t"));
		assertTrue(q2.add("s"));
		assertFalse(q2.add("c"));
	}

}
