package arrays;

import arrays.exceptions.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ekeocha on 3/9/2017.
 */
public class ArrayQueueTests {

    private ArrayQueue arrayQueue;

    @Before
    public void setUp(){
        arrayQueue = new ArrayQueue();
    }

    //test peek enqueue dequeue isEmpty toString

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmptyQueueException(){
        arrayQueue.peek();
    }

    @Test
    public void testPeekEmptyQueueExceptionMessage(){
        try{
            arrayQueue.peek();
        }catch(NoSuchElementException exception){
            assertEquals("There are no items in the Queue...its Empty!!", exception.getMessage());
        }
    }

    @Test
    public void testPeek(){
        arrayQueue.enqueue(2);
        assertEquals(2, arrayQueue.peek());
    }

    @Test
    public void testSingleEnqueue(){
        arrayQueue.enqueue(2);
        assertEquals(2, arrayQueue.peek());
    }

    @Test
    public void testMultiplePushes(){
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(8);
        assertEquals(2, arrayQueue.peek());
    }

    /**
     * base array size is 10 if extension works I should get another 10 spots added
     * to the array to do this we will add 11 items and then dequeue 10 times to get the
     * 11th item
     */
    @Test
    public void testBaseArraySizeExtension(){
        for(int i = 1; i < 12; i++){
            arrayQueue.enqueue(i);
        }

        for(int i = 1; i < 11; i++){
            arrayQueue.dequeue();
        }

        assertEquals(11, arrayQueue.peek());
    }

    @Test
    public void testLargeNumberOfEnqueue(){
        for(int i = 1; i < 101; i++){
            arrayQueue.enqueue(i);
        }
        assertEquals(1, arrayQueue.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testExceptionOnEmptyDequeue(){
        arrayQueue.dequeue();
    }

    @Test
    public void testSingleDequeue(){
        arrayQueue.enqueue(2);
        assertEquals(2, arrayQueue.dequeue());
    }

    @Test
    public void testMultipleDequeues(){
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(8);

        assertEquals(2, arrayQueue.dequeue());
        assertEquals(4, arrayQueue.dequeue());
    }

    @Test
    public void testEnqueueDequeueVariation(){
        arrayQueue.enqueue(12);
        arrayQueue.enqueue(14);
        arrayQueue.dequeue();
        arrayQueue.enqueue(2);
        arrayQueue.dequeue();
        arrayQueue.enqueue(4);
        arrayQueue.dequeue();
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(8);
        int out = arrayQueue.dequeue();

        assertEquals(4, out);
    }

    @Test
    public void testDequeueOnExtendedArray(){
        for(int i = 1; i < 12; i++){
            arrayQueue.enqueue(i);
        }
        assertEquals(1, arrayQueue.dequeue());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(arrayQueue.isEmpty());
        arrayQueue.enqueue(1);
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testToStringEmptyQueue(){
        assertEquals("front [ ] back\t(empty queue)", arrayQueue.toString());
    }

    @Test
    public void toStringNonEmptyQueue(){
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        assertEquals("front: 0 back: 3\n" +
                "front [ 1 2 3 ] back", arrayQueue.toString());
    }

}
