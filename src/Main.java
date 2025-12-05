import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        collectionPractice();
//        q1();
//        q2();
//        q3();
//        q4();
//        q5();
//        q6();
//        q7();
//        q8();
//        q9();
//        q10();
//        q11();
//        q12();
//        q13();
 //       q14();
//        q15();
//        q16();
//        q17();
//        q18();
//        q19();
//        q20();
    }


    private static void q20() {
      /*{id:1, name:"A"}
        {id:1, name:"A"}
        Task: Insert into HashSet → override equals() & hashCode() → remove duplicate*/

        HashSet<Student> set1 = new HashSet<>();
        set1.add(new Student(1, "A"));
        set1.add(new Student(1, "A")); // if equals is not override then both will be addded
        System.out.println(set1);
        List stringList = new ArrayList();
//        stringList.add(1);
//        stringList.add("a");
    }

    private static class Student {
        public Integer id;
        public String name;

        Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj){
            if(obj == this) {
                return true;
            }
            if(!(obj instanceof Student stu)) { //return true either for student or its subclassaes
                return false;
            }
            if(!(obj.getClass() == Student.class)) { //this is strict check which will check only student type claa
                // not its subclasses
                return false;
            }
            return (Objects.equals(stu.id, this.id) && Objects.equals(stu.name, this.name));
        //    return (Objects.equals(stu.id, this.id) && Objects.equals(stu.name, this.name));
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString(){
            return "["+this.id+","+this.name+"]";
        }
    }

    private static void q19(){
     /* Set1: [1, 2, 3]
        Set2: [3, 1, 2]
        Task: Check equality irrespective of order.*/
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,1,2));

        System.out.println(set1 == set2); //false
        System.out.println(set1.equals(set2)); //true
    }

    private static void q18(){
        /*Data: [9, 3, 5, 1, 2]
        Task: TreeSet → sorted result.*/
        TreeSet<Integer> treeSet =  new TreeSet<>(Arrays.asList(9, 3, 5, 1, 2));
        System.out.println(treeSet);
        treeSet.add(30);
        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.ceiling(6));
        System.out.println(treeSet.last());
        System.out.println(treeSet.lower(5));
        System.out.println(treeSet.higher(5));

    }

    private static void q17(){
       /* Data: [3, 1, 4, 1, 5]
        Task: Insert into LinkedHashSet → print → order should be same.*/
        Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3,1,4,1,5));
        linkedHashSet.contains(3);
        System.out.println(linkedHashSet);
    }

    private static void q16(){
       /* Data: [3, 1, 4, 1, 5]
        Task: Insert into LinkedHashSet → print → order should be same.*/
        Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(2,3,1,4,1,5));
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(1,2,9,10));
       // linkedHashSet.retainAll(set2); set intersection of both set and retain only commmon data in linkedHashset
      //  linkedHashSet.addAll(set2); //find the union
        linkedHashSet.removeAll(set2); // find the difference
        System.out.println(linkedHashSet);
        System.out.println(set2);
    }

    private static void q15(){
        /*Data: ["A", "B", "A", "C", "B"]
        Task: Convert to list without duplicates.*/
        ArrayList<String> string = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "B"));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(string);
        hashSet.forEach(System.out::println);
    }

    private static void q14() {
       /*Data: [10, 20, 20, 30, 10]
        Task: Insert into HashSet → display → duplicates removed.*/
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(10,20,20,30,10));
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    private static void q13() {
        /*Data: ["Java", "Spring", "Hibernate"]
        Task:
        Make list unmodifiable and try modifying it → show UnsupportedOperationException.*/
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
        List<String> strings = Collections.unmodifiableList(list);
        strings.add("Guava");
    }

    private static void q12(){
        /*Traverse using ListIterator (forward + backward).
        Data: ["Red", "Green", "Blue"]*/
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
        ListIterator<String> stringListIterator = list.listIterator();
        while(stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }
        while(stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previous());
        }
        stringListIterator = list.listIterator(list.size());
        while(stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previousIndex());
            System.out.println(stringListIterator.previous());
            System.out.println(stringListIterator.nextIndex());
        }

    }

    private static void q11(){
        /*Data: ["A", "B", "C", "D"]
        Task: Shuffle using Collections.shuffle().*/
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        Collections.shuffle(list);
        System.out.println(list);
    }

    private static void q10(){
        /*Data: ["A", "B", "C", "D"]
        Task: Reverse using Collections.reverse().*/
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
        Collections.reverse(list);
        System.out.println(list);
        List<String> reversed = list.reversed();
        System.out.println(reversed);
    }

    private static void q9(){
        /*Data: ["Banana", "Apple", "Cherry"]
        Task:
        Sort alphabetically (ascending) using Comparator.*/
        String [] str = new String[]{"Banana", "Apple", "Cherry"};
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
                //s2 > s1 means swap return positive
            }
        });
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(str));
        strList.sort((a,b) -> a.compareTo(b));
        System.out.println(strList);
        Collections.sort(strList);
        System.out.println(Arrays.toString(str));
        System.out.println(strList);
    }

    private static void q8(){
      /*List1: [1, 2, 3]
        List2: [1, 2, 3]
        Task:
        Check if both lists are equal (order must match).*/

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(list1 == list2); // false
        System.out.println(list1.equals(list2)); //true
     }

    private static  void q7() {
     /*   Data: ["Java", null, "Python", null, "C"]
        Task: Remove null.*/
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Java");
        linkedList.add(null);
        linkedList.add("Python");
        linkedList.add(null);
        linkedList.add("C");
        linkedList.add("Lokesh");
        linkedList.removeIf((String val) -> {
                if(val == null) {
                    return true;
                }
                return false;
            });
        linkedList.removeAll(Arrays.asList("Lokesh", "C"));
        System.out.println(linkedList);
    }
    private static void q6(){
   /*     Data: [10, 20, 20, 30, 20, 40]
        Task: Replace every 20 with 99.*/
        List<Integer> arrayList = Stream.of(10,20,30,20,40)
                .map(a -> {
                    if(a == 20) {
                        return 99;
                    } else return a;
                }).toList();
        System.out.println(arrayList);

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(20);
        list1.add(40);

        /*for(int i=0;i <list1.size(); i++) {
            if(list1.get(i).equals(20)) {
                list1.set(i, 99);
            }
        }*/
        list1.replaceAll(a -> a.equals(20) ? 99 :  a);
        System.out.println(list1);
    }

    private static void q5(){
       /* Perform List operations(add, remove, get).Data:Empty List
        Operations:
        Add:"Apple", "Banana", "Cherry"
        Remove:"Banana"
        Get:index 1*/

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.remove("Banana");
        System.out.println(list.get(1));
        System.out.println(Arrays.toString(list.toArray(new String[0])));
    }

    private static void q4() {
        /*Data: ["A", "B", "C"]
        Task:
        Iterate with Iterator & modify list simultaneously → show ConcurrentModificationException.*/
        List<String> names = new LinkedList<>(Arrays.asList("Sumiran", "Ajay","Riya", "Ankit", "Mohit"));
        Iterator<String> stringIterator = names.iterator();
        while (stringIterator.hasNext()){
            String value = stringIterator.next();
            if(value.contains("A")) {
                names.add("abcd");
            }
        }
    }

    private static void q3(){
        //Data: ["Java", "Python", "C++"]
        //Task:
        //Convert collection → String[] array.
        List<String> names = new LinkedList<>(Arrays.asList("Sumiran", "Ajay","Riya", "Ankit", "Mohit"));
        String[] strArray = names.toArray(new String[0]);
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));
    }


    private static void q2() {
        /*Data: ["Ajay", "Riya", "Ankit", "Mohit", "Amit"]
        Task:
        Remove elements starting with 'A' using Iterator.remove().*/
        List<String> names = new LinkedList<>(Arrays.asList("Sumiran", "Ajay","Riya", "Ankit", "Mohit"));
        ListIterator<String> removeA = names.listIterator();
        while(removeA.hasNext()) {
            String name = removeA.next();
            if(name.charAt(0) == 'A') {
                removeA.remove();
            } else {
                removeA.add("hello");
            }
        }
        names.forEach(System.out::println);
    }

    private static void q1() {
        Collection<String> collection = new ArrayList<>();
        collection.add("Ravi");
        collection.add("Aman");
        collection.add("Neha");
        collection.add("Ravi");

        Iterator<String> stringIterator = collection.iterator();
        while ((stringIterator.hasNext())) {
            System.out.println(stringIterator.next());
        }

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String a) {
                System.out.println("Via consumer "+a);
            }
        };
        // collection.forEach(consumer);
        collection.forEach(a -> System.out.println("via consumer lambda "+a));
    }

    private static void collectionPractice() {
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
        /*ArrayDeque<Integer> queue = new ArrayDeque<>();

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
        }*/
    }
}