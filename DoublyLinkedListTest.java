import static org.junit.Assert.*;

import java.util.List;


public class DoublyLinkedListTest {
	
    DoublyLinkedList dll = new DoublyLinkedList();
    

    @org.junit.Test
    public void insertFirst()
    {
        dll.insertFirst(1); // insert at start of list
        assertEquals(dll.get(0), 1); // check LinkedList is empty
    }
    
    @org.junit.Test
    public void insertLast()
    {
        dll.insertLast(1); // insert at start of list
        assertEquals(dll.get(0), 1); // check LinkedList is empty
    }
    
}