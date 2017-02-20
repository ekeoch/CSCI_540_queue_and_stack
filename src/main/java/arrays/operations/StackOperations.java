package arrays.operations;

/**
 * Created by Ekeocha on 2/18/2017.
 */
public interface StackOperations {
    //push an item unto the stack
    public void push(int item);

    //pop an item off the stack
    public int pop();

    //return the top item from the top of the stack
    public int peek();

    //return true if empty, otherwise false
    public boolean isEmpty();
}
