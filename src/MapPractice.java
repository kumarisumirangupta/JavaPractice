import java.util.*;

public class MapPractice {

    public static void main(String[] args) {
       // q1();
//        q2();
//        q3();
//        q4();
//        q5();
//        q6();
//        q7();
//        q8();

    }
    /*21. Add, remove, replace operations.
    Map: Empty
    Operations: put(1,"A") put(2,"B") replace(2,"BB") remove(1)*/

    private static void q1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.replace(2, "BB");
        System.out.println(map);
        map.remove(1);
        System.out.println(map);
    }

    /*22. Iterate Map using entrySet, keySet, values.
    Data: {101:"Java", 102:"Python", 103:"C++"}
    Task: Use all iteration methods.

    23.Check if key & value exist.
    Data: {1:"Apple", 2:"Banana", 3:"Cherry"}
    Check: key 2, value "Cherry"

    24. Convert Map keys to List.
    Data: {1:"A", 2:"B", 3:"C"}
    Task: List of keys → [1, 2, 3]

    25. Convert Map values to List.
    Data: {1:"X", 2:"Y", 3:"Z"}
    Task: List → ["X","Y","Z"] */
    private static void q2(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        Set<Map.Entry<Integer, String >> mapEntry = map.entrySet();
        for(Map.Entry<Integer, String> m :mapEntry) {
            if(m.getKey() == 1) {
                m.setValue("Sumiran");
            }
            System.out.println("Iterating using entrySet key "+ m.getKey() + "value "+ m.getValue());
        }
        for(Integer key : map.keySet()){
            System.out.println(key + " " +map.get(key));
        }

        Collection<String> values =  map.values();
        System.out.println(values);
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("C"));
        List<Integer> keyList = new ArrayList<>(map.keySet());
        System.out.println(keyList);
        Collection<String> values1 = map.values();
        ArrayList<String> valueList = new ArrayList<>(values1);
        System.out.println(valueList);
    }

    /* 26. Sort Map by keys using TreeMap.
    Data: {3:"C", 1:"A", 2:"B"}
    Task: Convert → TreeMap → sorted.

    27. Sort Map by values.
    Data: {1:"Banana", 2:"Apple", 3:"Cherry"}
    Task: Sort by values alphabetically.*/

    static void q3(){
        Map<Integer, String> hashMap = new TreeMap<>((a,b) -> b-a);
        hashMap.put(3, "A");
        hashMap.put(1, "B");
        hashMap.put(2, "C");
        hashMap.put(4, "D");
        System.out.println("Treemap are in descending oredr of key "+ hashMap);

        Set<Map.Entry<Integer, String>>  entries = hashMap.entrySet();
        List<Map.Entry<Integer, String>> mapList = new ArrayList<>(entries);
    //    mapList.sort(Map.Entry.comparingByValue());
     //   mapList.sort((a,b) ->  a.getValue().compareTo(b.getValue()));
       // mapList.sort();
        System.out.println("list of map "+ mapList);
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f,true);
        for(Map.Entry<Integer,String> entry :mapList){
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("linked hashmap created "+linkedHashMap);
        linkedHashMap.get(4);
        System.out.println("after accessing 4 "+linkedHashMap);
        linkedHashMap.put(6,"abdcd");
        System.out.println("after adding 6 "+linkedHashMap);

    }

    /*29. Merge two Maps (handle conflicts).
    Map1: {1:"A", 2:"B"}
    Map2: {2:"BB", 3:"C"}
    Task:
    Merge → if key conflict → append:
    Result: {1:"A", 2:"B,BB", 3:"C"}*/

    static void q4(){
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(4, "K");
        map1.put(3, "C");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(2, "BB");
        map2.put(3, "C");

//        HashMap<Integer, String> mergeMap = new HashMap<>();
        /*for(Map.Entry<Integer, String> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey())){
                merge.put(entry.getKey(), entry.getValue()+","+map2.get(entry.getKey()));
            } else {
                merge.put(entry.getKey(), entry.getValue());
            }
        }

        for(Map.Entry<Integer, String> entry : map2.entrySet()) {
            if(!merge.containsKey(entry.getKey())){
                merge.put(entry.getKey(), entry.getValue());
            }
        }*/

        map1.merge(2, "lok", (s, s2) -> s + "::" + s2);

        HashMap<Integer, String> mergeMap = new HashMap<>(map1);
        map2.forEach((key, val) -> mergeMap.merge(key, val, (oldVal, newVal) -> oldVal + "," + newVal));
        System.out.println(mergeMap);
    }

    /*30. Remove all entries with a specific value.
    Data: {1:"X", 2:"Y", 3:"X", 4:"Z"}
    Remove value = "X"
    Result → {2:"Y", 4:"Z"}*/
    static void q5(){
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "X");
        map1.put(2, "Y");
        map1.put(4, "Z");
        map1.put(3, "X");

        Iterator<Map.Entry<Integer, String>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entryValue = iterator.next();
            if(entryValue.getValue().equals("X")){
                iterator.remove();
            }
        }
        System.out.println(map1);

        map1.entrySet().removeIf(a -> a.getValue().equals("X"));
        System.out.println(map1);
    }

    /*31. Map<String, List<String>> iteration.
    Data: "Java" → ["Spring", "Hibernate"]
          "Python" → ["Django", "Flask"]
    Task: Print key with all child values. */

    static void q6(){
        Map<String, List<String>> iteration = new HashMap<>();
        iteration.put("Java",Arrays.asList("Spring", "Hibernate"));
        iteration.put("Python",Arrays.asList("Spring", "Hibernate"));

        iteration.forEach((key, value) -> System.out.println(key+" -> "+ value));
    }

    static void q7(){
        /*IdentityHashMap.
        Data:Two strings with same content "A" but created using new
                Insert both → should be stored separately.*/

        IdentityHashMap<String, String> stringStringIdentityHashMap = new IdentityHashMap<>();
        String s1 = new String("hello");
        String s2 = "hello";

        stringStringIdentityHashMap.put(s1, "first");
        stringStringIdentityHashMap.put("hello","thrid");
        stringStringIdentityHashMap.put(s2, "second");
        System.out.println(stringStringIdentityHashMap); //IdentityHashMap compares key by == method means uses System.identityHashcode method that is memory address so
        //all objects are not same equals ke jagah == and Objects.hashcode ke jagah upar wala method but strong literal refrence to memory address so replaces value

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));


    }

    static void q8(){
        enum DAY{MON, TUE, WED};

        EnumMap<DAY, String> enumMap = new EnumMap<>(DAY.class);
        enumMap.put(DAY.MON, "Start");
        enumMap.put(DAY.TUE, "Run");
        enumMap.put(DAY.WED, "Rerun");

        System.out.println(enumMap);

    }

}
