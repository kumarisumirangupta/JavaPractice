import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class EmployeeV2{
    private String name;
    private Integer empId;
    private List<String> skills = new ArrayList<>();
    private Integer salary;

    public EmployeeV2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public EmployeeV2(String name, Integer empId, List<String> skills, Integer salary) {
        this.name = name;
        this.empId = empId;
        this.skills = skills;
        this.salary = salary;
    }
}
public class StreamPractice {
    static List<String> listOfString = Arrays.asList("Joy", "Mina", "Aishwariya", "Hero");
    static List<List<Integer>> listOfListIntegers = Arrays.asList(Arrays.asList(1, 2, 3, 4)
            , Arrays.asList(5, 1, 23)
            , Arrays.asList(6, 7, 8));
    static List<String> sentences = Arrays.asList("Hello world", "My name is Sumiran", "I am practising Stream API");
    static List<EmployeeV2> employeeV2List = Arrays.asList(new EmployeeV2("First", 1234, Arrays.asList("Java", "Python"), 58000),
            new EmployeeV2("Second", 5678, Arrays.asList("Java", "Sql", "Hibernate"), 60000),
            new EmployeeV2("Third", 6970, Arrays.asList("RDBMS", "Multithreading", "Python"), 50000)
    );

    static Product p1 = new Product("Laptop", 55000);
    static Product p2 = new Product("Mouse", 800);
    static Product p3 = new Product("Keyboard", 1500);

    static Product p4 = new Product("Phone", 30000);
    static Product p5 = new Product("Earbuds", 2000);
    static Product p6 = new Product("Charger", 1200);

    static Product p7 = new Product("Monitor", 10000);
    static Product p8 = new Product("HDMI Cable", 500);

    static Order o1 = new Order(101, Arrays.asList(p1, p2, p3));
    static Order o2 = new Order(102, Arrays.asList(p4, p5, p6));
    static Order o3 = new Order(103, Arrays.asList(p7, p8));

    static List<Order> orderList = Arrays.asList(o1, o2, o3);

    public static void main(String[] args) {
//        q1();
//        q2();
//        q3();
//        q4();
//        q5();
//        q6();
//        q7();
//        q8();
        q9();
    }

/*  Convert List<String> → List<Integer> of string lengths
    Question:Given List<String> words, use streams to return a list of lengths of each word.
    Concept tested: Function mapping, intermediate operations.*/

    static void q1() {
        List<Integer> list = listOfString.stream()
                .map(String::length)
                .toList();
        System.out.println(list);
    }

    /*Convert List<List<Integer>> → List<Integer> and remove duplicates*/

    static void q2() {

        //Returns unique entries
        List<Integer> collect = listOfListIntegers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream().filter(e -> e.getValue().equals(1L))
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
        System.out.println(collect);

        //Question solution
        List<Integer> collect1 = listOfListIntegers.stream()
                .flatMap(Collection::stream)
                .distinct()
                .sorted((a, b) -> b - a)
                .toList();
        System.out.println(collect);
    }

    /*Convert List<String> sentences → List<String> words using flatMap()
    Input example:["hello world", "java stream api"]*/
    static void q3(){
        List<String> list1 = sentences.stream()
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .toList();
        System.out.println(list1);

        List<String> list = sentences.stream()
                .map(new Function<String, String[]>() {
                    @Override
                    public String[] apply(String string){
                        return string.split(" ");
                    }
                })
                .flatMap(new Function<String[], Stream<String>>() {
                    @Override
                    public Stream<String> apply(String[] strings) {
                        return Arrays.stream(strings);
                    }
                })
                .toList();
        System.out.println(list);
    }

    //From List<Employee> extract salaries > 50k and return their names
    static void q4(){
         employeeV2List.stream()
                .filter(employee -> employee.getSalary() >= 50000)
                .map(EmployeeV2::getName)
                .forEach(System.out::println);
    }

    //Extract all unique skills from List<Employee> and return in sorted order
    static void q5(){
        employeeV2List.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    //Convert Stream<String> → Map<String,Integer> where key = string, value = length
    static void q6(){
        employeeV2List.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .distinct()
                .collect(Collectors.groupingBy(String::length))
                .forEach((key, value) -> System.out.println(key +" "+value));
    }

    //Use streams to calculate the total price of all products across all orders.
    static void q7(){
        double sum = orderList.stream()
                .flatMap(order -> order.products.stream())
                .mapToDouble(product -> product.price)
                .sum();
        System.out.println(sum);
    }

   /* Find the total number of products across all orders
    Example: Order 101 has 3 products, 102 has 3, 103 has 2 → Total = 8*/
    static void q8(){
        long count = orderList
                .stream()
                .flatMapToLong(order -> LongStream.of(order.products.size()))
                .sum();
        System.out.println(count);
    }

    /* Find the total number of products by each order
   Example: Order 101 has 3 products, 102 has 3, 103 has 2 → Total = 8
   Order 101 -> {
   a,
   b
   }
   */
    static void q9(){
        Map<Integer, List<String>> collect = orderList.stream()
                .collect(Collectors.groupingBy(o -> o.orderId, Collectors.collectingAndThen(
                                Collectors.toList(),
                                orders -> orders.stream().flatMap(order -> order.products.stream())
                                        .map(o -> o.name)
                                        .toList()
                        )
                ));
        System.out.println(collect);

        Map<Integer, List<String>> collect1 = orderList.stream()
                .collect(Collectors.toMap(order -> order.orderId, orders -> orders.products
                        .stream()
                        .map(o -> o.name)
                        .toList()));

        System.out.println(collect1);

        orderList.stream()
                .collect(Collectors.groupingBy(o -> o.orderId, Collectors.toList()
                ));

    }


}

class Order {
    int orderId;
    List<Product> products;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class CollectorImpl<T,A,R> implements Collector<T,A,R>{

    @Override
    public Supplier<A> supplier() {
        return null;
    }

    @Override
    public BiConsumer<A, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<A> combiner() {
        return null;
    }

    @Override
    public Function<A, R> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}

