import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*//Queue Practice
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(23);
        queue.add(1);
        queue.add(55);
        queue.offer(60);

        System.out.println(queue.peek());
        System.out.println(queue.poll()); //Returns null if queue is empty
        System.out.println(queue.peek()); //Returns null if queue is empty
        System.out.println(queue.remove()); //Returns exception if queue is empty
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.element()); //Returns exception if queue is empty */

        //Priority Queue
        /*PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else if (o2.equals(o1)) {
                    return 0;
                } return -1;
            }
        });*/

        /*PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        pq.offer(9);
        pq.offer(12);
        pq.offer(8);
        pq.offer(7);
        pq.offer(20);

        Iterator<Integer> iteratorPq = pq.iterator();
        while(iteratorPq.hasNext()) {
            //This will print level order traversal of heap
            System.out.println(iteratorPq.next());
        }*/
    }
}