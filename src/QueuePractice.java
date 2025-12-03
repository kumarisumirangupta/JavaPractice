import java.util.*;

public class QueuePractice {
    public static void main(String[] args) {
//       q1();
       // q2();
        q3();
    }

    /*1. Create queue & perform add, offer, poll, peek.
    Data: Perform: add("A"), add("B"), offer("C")
    Operations: peek(), poll(), poll()*/

    /*2. Convert Queue → List.
    Data: ["Red", "Green", "Blue"]
    Convert queue to list. */
    private static  void q1(){
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.addLast("C");
        queue.add("D");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.poll());
       // queue.removeFirst();

        ArrayList<String> strings = new ArrayList<>(queue);
        System.out.println(strings);
    }

    /*3 Use PriorityQueue (natural order).
    Data: [5, 1, 8, 2]
    Store in PQ → poll in sorted order.*/
    private static  void q2(){
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("C");
        queue.offer("B");
        queue.add("A");
        queue.add("D");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    /*4 PriorityQueue with Comparator.
    Data: ["Bob", "Alexander", "John"]
    Sort by string length.*/
    private static  void q3(){
      //  PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> b.compareTo(a));
        queue.offer("Bob");
        queue.offer("Alexander");
        queue.add("John");
        System.out.println(queue);
        System.out.println(queue.peek());
    }


}
