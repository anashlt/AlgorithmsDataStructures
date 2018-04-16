import static org.junit.Assert.*;

import java.util.List;


public class LinkedListTest {
	
	LinkedList<String> list = new LinkedList<String>();
    LinkedList ll = new LinkedList();
    

    @org.junit.Test
    public void insert()
    {
        ll.insert(new LinkedListNode<String>("Test")); // insert at start of list
        assertEquals(ll.getFirst(), "Test"); // check LinkedList is empty
    }
    
    @org.junit.Test
    public void remove()
    {
        ll.insert(new LinkedListNode<String>("Test")); // insert at start of list
        ll.remove(); // remove at start of list
        assertTrue(ll.isEmpty()); // check linked is empty
    }

}