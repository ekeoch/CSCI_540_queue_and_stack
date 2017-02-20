package arrays.exceptions;

/**
 * Created by Ekeocha on 2/18/2017.
 */
public class NoSuchElementException extends RuntimeException {

    //Include custom message in our exception
    public NoSuchElementException(String message) {
        super(message);
    }
}
