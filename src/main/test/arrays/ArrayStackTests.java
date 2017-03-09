package arrays;

import arrays.exceptions.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ekeocha on 3/8/2017.
 */
public class ArrayStackTests {

    private ArrayStack arrayStack;

    @Before
    public void setUp(){
        arrayStack = new ArrayStack();
    }

    //Test push pop peek isEmpty toString

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmptyStackException(){
        arrayStack.peek();
    }

    @Test
    public void testPeekEmptyStackExceptionMessage(){
        try{
            arrayStack.peek(); //peeking into an empty stack should throw Exception so we can use that
        }catch(NoSuchElementException exception){
            assertEquals("There are no items in the Stack...its Empty!!", exception.getMessage());
        }
    }

    @Test
    public void testPeek(){
        arrayStack.push(15);
        assertEquals(15, arrayStack.peek());
    }

    @Test
    public void testSinglePush(){
        arrayStack.push(15);
        assertEquals(15, arrayStack.peek());
    }

    @Test
    public void testMultiplePushes(){
        arrayStack.push(15);
        arrayStack.push(16);
        arrayStack.push(17);
        assertEquals(17, arrayStack.peek()); //should return last push
    }

    /**
     * base array size is 10 if extension works I should get another 10 spots added
     * to the array
     */
    @Test
    public void testBaseArraySizeExtension(){
        for(int i = 1; i < 12; i++){
            arrayStack.push(i);
        }
        assertEquals(11, arrayStack.peek());
    }

    @Test
    public void testLargeNumberOfPushes(){
        for(int i = 1; i < 101; i++){
            arrayStack.push(i);
        }
        assertEquals(100, arrayStack.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testExceptionOnEmptyPop(){
        arrayStack.pop();
    }

    @Test
    public void testSinglePop(){
        arrayStack.push(10);
        assertEquals(10, arrayStack.pop());
    }

    @Test
    public void testMultiplePops(){
        arrayStack.push(10);
        arrayStack.push(11);
        arrayStack.push(12);

        assertEquals(12, arrayStack.pop());
        assertEquals(11, arrayStack.pop());
    }

    @Test
    public void testPushPopVariation(){
        arrayStack.push(10);
        arrayStack.push(11);
        arrayStack.pop();
        arrayStack.push(12);
        int out = arrayStack.pop();

        assertEquals(12, out);
    }

    @Test
    public void testPopOnExtendedArray(){
        for(int i = 1; i < 12; i++){
            arrayStack.push(i);
        }
        assertEquals(11, arrayStack.pop());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(arrayStack.isEmpty());
        arrayStack.push(10);
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    public void testToStringEmptyStack(){
        assertEquals("top [ ] bottom\t(empty stack)", arrayStack.toString());
    }

    @Test
    public void testToStringNonEmptyStack(){
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        assertEquals("top [ 3 2 1 ] bottom\t(stack with 3 elements)", arrayStack.toString());
    }

}
