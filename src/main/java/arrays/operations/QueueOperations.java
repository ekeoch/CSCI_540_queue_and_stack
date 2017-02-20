package arrays.operations;

/**
 * Created by Ekeocha on 2/18/2017.
 */
public interface QueueOperations {
    //remove an element from the queue
    public int dequeue();

    //place and element on the queue
    public void enqueue(int element);

    //check if the queue is empty
    public boolean isEmpty();

    // return element at the head of the queue but don't remove it
    public int peek();
}
