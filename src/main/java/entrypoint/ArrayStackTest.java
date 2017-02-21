package entrypoint;

import arrays.ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ekeocha on 2/20/2017.
 */
public class ArrayStackTest {

    private static boolean areEqual(ArrayStack A, ArrayStack B){

        if (A != null && A.equals(B)) return true;

        ArrayList<Integer> tmpA = new ArrayList<Integer>();
        ArrayList<Integer> tmpB = new ArrayList<Integer>();

        while(A != null && !A.isEmpty()){
            tmpA.add(A.pop());
        }

        while(B != null && !B.isEmpty()){
            tmpB.add(B.pop());
        }

        boolean verdict = Arrays.equals(tmpA.toArray(), tmpB.toArray());

        for (int i : tmpA){
            A.push(i);
        }

        for (int i : tmpB) {
            B.push(i);
        }

        return verdict;
    }

    private static ArrayStack duplicateStack(ArrayStack input){
        ArrayStack output = (input == null) ? null : new ArrayStack();
        if(output == null) return null;

        ArrayList<Integer> tmpA = new ArrayList<Integer>();
        do{
            tmpA.add(input.pop());
        }while(!input.isEmpty());

        for (int i : tmpA){
            output.push(i);
            input.push(i);
        }

        return output;
    }

    public static void main(String[] args) {
        ArrayStack arrayStackA = new ArrayStack();
        arrayStackA.push(3);
        arrayStackA.push(1);
        arrayStackA.push(7);

        ArrayStack arrayStackA1 = new ArrayStack();
        arrayStackA.push(3);
        arrayStackA.push(1);
        arrayStackA.push(7);

        System.out.println(ArrayStackTest.areEqual(arrayStackA, arrayStackA)); // should return true
        System.out.println(ArrayStackTest.areEqual(arrayStackA, arrayStackA1)); // should return false

        arrayStackA = new ArrayStack();
        arrayStackA1 = new ArrayStack();
        System.out.println(ArrayStackTest.areEqual(arrayStackA, arrayStackA1)); // should return true

        arrayStackA.push(3);
        arrayStackA.push(1);
        arrayStackA.push(7);

        arrayStackA1.push(3);
        arrayStackA1.push(1);
        arrayStackA1.push(7);
        System.out.println(ArrayStackTest.areEqual(arrayStackA, arrayStackA1)); // should return true

        ArrayStack arrayStackB = ArrayStackTest.duplicateStack(arrayStackA);
        System.out.println(ArrayStackTest.areEqual(arrayStackA, arrayStackB)); // should return true **Duplicate test**

    }
}
