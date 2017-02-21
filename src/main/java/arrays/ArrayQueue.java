package arrays;

import arrays.exceptions.NoSuchElementException;
import arrays.operations.QueueOperations;

/**
 * Created by Ekeocha on 2/19/2017.
 */
public class ArrayQueue implements QueueOperations {
    private static final int DEFAULT_SIZE = 5;
    //Internal array to house queue contents
    private int[] queueArray;
    //arrays.exceptions.NoSuchElementException message
    private static final String EMPTY_QUEUE_EXCEPTION_MESSAGE = "There are no items in the Queue...its Empty!!";

    int frontIndex; //Track front index of queue
    int backIndex; //Track back index of queue
    int size; //maintain the overall size of queue. Will come in handy for resizing


    public ArrayQueue() {
        queueArray = new int[DEFAULT_SIZE];
    }


    @Override
    public int dequeue() {
        //If queue is empty throw exception
        if(isEmpty()) throw new NoSuchElementException(EMPTY_QUEUE_EXCEPTION_MESSAGE);

        int out = queueArray[frontIndex];
        queueArray[frontIndex] = 0; //Zero out array space, if it were an object set it to null

        //Increment front index and drop array size checker
        frontIndex++;
        size--;

        if(frontIndex == queueArray.length) frontIndex = 0; //If we have exceeded the bounds of the array loop around
        return out;
    }

    @Override
    public void enqueue(int element) {

        //Check if array is maxed out
        if(size == queueArray.length){

            //create tmp array and put in arrayqueue elements from front
            int[] tmpArray = new int[DEFAULT_SIZE + queueArray.length];

            for(int i = 0; i < size; i++){
                if(frontIndex >= queueArray.length) frontIndex = 0;//if we have exceeded bounds of arrayqueue loop around
                tmpArray[i] = queueArray[frontIndex++];
            }

            queueArray = tmpArray;
            frontIndex = 0;

            //Since this approach of resizing is like sorting a list
            //the new backindex will be the size of the array
            backIndex = size;
        }

        if(backIndex == queueArray.length) backIndex = 0;
        queueArray[backIndex++] = element;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return (size <= 0);
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new NoSuchElementException(EMPTY_QUEUE_EXCEPTION_MESSAGE);
        return queueArray[frontIndex];
    }

    @Override
    public String toString() {
        String output;

        if(isEmpty()){
            output = "front [ ] back\t(empty queue)";
        }else if(size == 1){
            output = String.format("front: %1$d back: %2$d\n", frontIndex, backIndex);
            output += "front [ " + queueArray[frontIndex] + " ] back";
        } else{
            StringBuilder stringBuilder = new StringBuilder(String.format("front: %1$d back: %2$d\n", frontIndex, backIndex));
            stringBuilder.append("front [ ");
            int fIndex = frontIndex;

            for(int i = 0; i < size; i++){
                stringBuilder.append(String.format("%1$d ", queueArray[fIndex]));
                if(++fIndex > queueArray.length) fIndex = 0;
            }

            stringBuilder.append("] back");
            output = stringBuilder.toString();
        }

        return output;
    }
}
