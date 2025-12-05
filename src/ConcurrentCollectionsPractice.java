import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsPractice {

    public static void main(String[] args) {
//        q1();
        q2();
    }

   /* Put: 1→"A", 2→"B"
    Task: iterate while adding new key (should NOT throw exception).*/
    static void q1(){
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
        concurrentHashMap.put(1,"A");
        concurrentHashMap.put(2,"D");
        concurrentHashMap.put(3,"C");

        for(Map.Entry<Integer, String> entrySet: concurrentHashMap.entrySet()){
            if(entrySet.getKey() == 1){
                concurrentHashMap.put(4, "sumiran");
            }
        }
        System.out.println(concurrentHashMap);
    }

    /*Data: ["A","B","C"]
    Task: iterate & add "D" while iterating safely.*/
    static void q2(){
        List<Integer> concurrentHashMap = new CopyOnWriteArrayList<Integer>();
        concurrentHashMap.add(1);
        concurrentHashMap.add(2);
        concurrentHashMap.add(3);

        for(Integer entrySet: concurrentHashMap){
          //  if(entrySet == 1){
                concurrentHashMap.add(4);
           // }
           // System.out.println("Iterating");
        }
        //System.out.println(concurrentHashMap);

        /*ConcurrentLinkedQueue usage.
        Data: add: "A","B","C"
        poll all elements.*/

        ConcurrentLinkedQueue<Integer> integersQueue = new ConcurrentLinkedQueue<>();
        integersQueue.offer(1);
        integersQueue.offer(2);
        integersQueue.offer(8);
        integersQueue.offer(3);

        integersQueue.forEach((a) -> {
            System.out.println(a);
            System.out.println(integersQueue.element());
            System.out.println(integersQueue.poll());
        });

        /*Synchronized List wrapper.
        Data: [1,2,3]
        Wrap using Collections.synchronizedList().*/

        List<Integer> source = new ArrayList<>(List.of(10,20,30));
        /*source.forEach(a -> {
        throws concurrent modification exception
            source.add(11*a);
        });*/
        source = Collections.synchronizedList(source); //This only makes list method synchronized but iterator methods are still not synchronized an dfail-fats means throws cme
        List<Integer> finalSource = source;
        source.forEach(a -> {
        //Runs without error
            finalSource.add(11*a);
        });


    }

}
