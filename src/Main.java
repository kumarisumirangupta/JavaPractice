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
        System.out.println(queue.element()); //Returns exception if queue is empty

        //Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else if (o2.equals(o1)) {
                    return 0;
                } return -1;
            }
        });

        //PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
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

        //Declaration of Arrays
        /*Integer [] array = {1,2,3,4,5,6};
        int [] array1 = new int[]{1,2,3,4,5};
        int []array2 = new int[5];
        String [] strArray = new String[5];
        Arrays.sort(array1);

        //Convert Array to ArrayList valid only for non primitive []
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));

        //Convert ArrayList to Array
        Integer [] newArr = arrayList.toArray(new Integer[0]);

        //Comparator
        Car car = new Car();
        System.out.println(car.getName()); //prints null default value
        System.out.println(car.getId()); // same
        System.out.println(car.getType()); //same
        System.out.println(car.getI()); //0 default value

        car.setId(5);
        System.out.println(car.getId()); //prints 5
        Car [] carArray = new Car[10];
        Car [] carArr = new Car[]{
                new Car(1,"Suv", "abcd"),
                new Car(2, "Ostrich", "hello"),
                new Car(3, "Hetchback", "petrol")
        };
        Arrays.sort(carArr, new Comparator<Car>() {
            @Override
            public int compare(Car obj1,  Car obj2) {
                // if obj1 is a and obj2 is b a>b return -1 if obj1 = b then b>a return 1 and swap
               // return obj1.getType().compareTo(obj2.getType());
                return obj2.getType().compareTo(obj1.getType());
                //b > a = 1 swap or obj1 = a then b>a = swap obj1=b a>b return -1
                the result is a negative integer if this String object lexicographically precedes the argument string.
                The result is a positive integer if this String object lexicographically follows the argument string.
                The result is zero if the strings are equal; compareTo returns 0
                exactly when the equals(Object) method would return true.
            }
        });
        for (Car value : carArr) {
            System.out.println(value);
        }

        Arrays.sort(carArr); //Sorting by comparable
        for (Car value : carArr) {
            System.out.println(value);
        }*/

        //Array Deque
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //Queue behaviour
        queue.addLast(2); //Adding in rear for empty queue tail and head = 0
        queue.addLast(3);
        //System.out.println(queue.peek());
        queue.removeFirst();
        //System.out.println(queue.peek());

        //Or using add method
        queue.add(11);//Internally calls add last
        queue.add(12);
        queue.remove();// Internally calls add first
        for(Integer q : queue){
            System.out.println(q);
        }

        //Implement Stack using Dequeu
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.addFirst("top1"); //Java convention to use top as first
        stack.addFirst("top2");
        stack.addFirst("top3");
        stack.removeFirst();
        for(String q : stack){
            System.out.println(q);
        }


        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Sumiran");
        map.put(2, "Lokesh");
        map.put(3, "Simran");

        map.forEach((key, value)-> {
            System.out.println("this is key "+key);
            System.out.println("this is value "+ value);
        });

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();

        //Iterating through for
        for(; iterator.hasNext(); ){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + next.getValue());
        }

        for(Map.Entry<Integer, String> mapEntry : entries) {
            System.out.println("map entry way "+ mapEntry.getKey() + mapEntry.getValue());
        }

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            String value = map.get(key);
            System.out.println("using key set "+ key + " "+ value);
        }

        Collection<String> values = map.values();
        for (String val : values) {
            System.out.println(val);
        }


    }
}