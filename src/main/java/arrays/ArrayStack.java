package arrays;

import arrays.exceptions.NoSuchElementException;
import arrays.operations.StackOperations;

/**
 * Created by Ekeocha on 2/18/2017.
 */
public class ArrayStack implements StackOperations {
    private static final int DEFAULT_SIZE = 10;
    //Internal array to house stack contents
    private int[] arrayStack;
    //track indexes of array
    private int currentIndex = -1;
    //arrays.exceptions.NoSuchElementException message
    private static String EMPTY_STACK_EXCEPTION_MESSAGE = "There are no longer any items in the Stack...its Empty!!";

    public ArrayStack() {
        arrayStack = new int[DEFAULT_SIZE]; //initialize base array size to 10
    }

    @Override
    public void push(int item) {
        currentIndex++; //Up the current index

        //if the new currentIndex is less than the array length add the item
        //else increase the array size and then add the item
        if(currentIndex <= arrayStack.length - 1){
            arrayStack[currentIndex] = item;
        }else {
            int[] tmpArray = new int[DEFAULT_SIZE + arrayStack.length];

            /**
             * While I can loop through the elements in array and copy them over to
             * tmpArray. Based on sources online System.arraycopy seems to do a
             * better job
             */
            System.arraycopy(arrayStack, 0, tmpArray, 0, arrayStack.length);
            arrayStack = tmpArray;
            arrayStack[currentIndex] = item;
        }
    }

    /**
     * Would be nice to decrease the size of the array after if the number of empty slots exceeds 10
     * @return Last entry in the array and decrease the counter
     */
    @Override
    public int pop() {
        if(isEmpty()) throw new NoSuchElementException(EMPTY_STACK_EXCEPTION_MESSAGE);

        int out = arrayStack[currentIndex];
        arrayStack[currentIndex] = 0; //Zero out current position, if it were an object set it to null
        currentIndex--; //drop down one step one the stack

        return out;
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new NoSuchElementException(EMPTY_STACK_EXCEPTION_MESSAGE); //Should be thrown if stack is empty as well
        return arrayStack[currentIndex];
    }

    @Override
    public boolean isEmpty() {
        return (currentIndex > -1) ? false : true; //If there is at least some in the array return false
    }

    @Override
    public String toString() {
        String output;

        if(isEmpty()){
            output =  "top [ ] bottom\t(empty stack)";
        }else if(currentIndex == 0){
            output = "top [ " + arrayStack[0] + " ] bottom\t(stack with one element)";
        }else{
            //loop through array backwards and concatenate string
            StringBuilder stringBuilder = new StringBuilder("top [ ");

            for (int i = currentIndex; i > -1; i--){
                stringBuilder.append(String.format("%1$d ",arrayStack[i]));
            }
            stringBuilder.append(String.format("] bottom\t(stack with %1$d elements)", currentIndex + 1));

            output = stringBuilder.toString();
        }

        return output;
    }
}
