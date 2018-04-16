import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;


public class StackTest {
	
	Double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
    Integer[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    List<Item> items = new LinkedList<Item>();
    
    Stack stack = new Stack();
    
    @org.junit.Before
    public void Before()
    {
        items.add(new Item("123","yes",1996,"Theme","Subtheme",14,28,"url",23.3,23.3,23.3,23.3,"packaging", "availability"));
		items.add(new Item("121","yes",1996,"Theme","Subtheme",14,28,"url",23.3,23.3,23.3,23.3,"packaging", "availability"));
		items.add(new Item("127","yes",1996,"Theme","Subtheme",14,28,"url",23.3,23.3,23.3,23.3,"packaging", "availability"));
		items.add(new Item("12SD","yes",1996,"Theme","Subtheme",14,28,"url",23.3,23.3,23.3,23.3,"packaging", "availability"));
    }

    @org.junit.Test
    public void isEmpty()
    {
        stack.push(doubleElements[0]); // push a double element
        assertFalse(stack.isEmpty()); // check stack is not empty
        
        stack.pop(); // pop element from the stack
        assertTrue(stack.isEmpty()); // check stack is empty
    }

    @org.junit.Test
    public void push()
    {
        stack.push(integerElements[0]); // push int 1 to stack
        assertEquals(stack.peek(), 1); // check using peek to confirm 
        
        stack.push(items.get(0).itemNumber); // push first itemNumber to stack
        assertEquals(stack.peek(), "123"); // check using peek to confirm itemNumber
    }

    @org.junit.Test
    public void pop()
    {
    	stack.push(integerElements[1]); // push int 2 to stack
        stack.pop(); // pop it 
        assertTrue(stack.isEmpty()); // check if stack is empty after popping single element it had.
    }

}