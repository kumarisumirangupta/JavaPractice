import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class StackPractice {

    /*Perform push, pop, peek.
    Data: Push: 10,20,30
    Then pop → output
    Then peek → output

    Convert Stack → List.
    Data: [10, 20, 30]
    Convert to List.

    Iterate Stack using Enumeration.
    Data: ["A","B","C"]
    Use Enumeration to iterate.*/
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        List<Integer> integerList = new ArrayList<>(stack);
        System.out.println(integerList);

        Enumeration<Integer> enumeration = stack.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        //Print stack in lifo
        for(int i=stack.size()-1; i>=0; i--) {
            System.out.println(stack.get(i));
        }

    }
}
