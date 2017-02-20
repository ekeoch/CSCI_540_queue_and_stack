package entrypoint;

import arrays.ArrayStack;

/**
 * Created by Ekeocha on 2/18/2017.
 */
public class ArraysTestCode {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        //arrayStack.peek();
        //arrayStack.pop();
        System.out.println(arrayStack); //empty stack
        arrayStack.push(1);
        System.out.println(arrayStack); // one element
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        System.out.println(arrayStack); // 4 elements

        //push past 10 elements
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.push(9);
        arrayStack.push(10);
        arrayStack.push(11);
        System.out.println(arrayStack); // 11 elements checking the dynamic array implementation

        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack); // Check pop implementation 7 elements
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack); // Check pop implementation empty
        arrayStack.peek(); //Test throw exception




    }
}
