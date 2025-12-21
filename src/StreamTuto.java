import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTuto {

    public static void main(String[] args) {

        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        //longest string in a list of string

        strings.sort((a, b) -> {
                    if (b.length() > a.length()) {
                        return 1;  // b is bigger
                    } else if (b.length() < a.length()) {
                        return -1; // a is bigger
                    }
                    return 0;       // equal
                });

        System.out.println(strings);
        //comparator.compare(a, b) >= 0 ? a : b;
        Optional<String> max = strings.stream()
                .max((a, b) -> {
                    if (a.length() > b.length()) {
                        return 1;  //this means keep existing best max value
                    } else if (a.length() < b.length()) {
                        return -1; //this means new value is max so replace with new value
                    }
                    return 0; //this means keep existing best max value
                });
        max.ifPresent(System.out::println);
        strings.stream()
                .max(Comparator.comparingInt(String::length));

        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        //Calculate the average age of a list of Person objects
        double v = persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        System.out.println(v);

        //Check if a list of integers contains a prime number using Java streams
        List<Integer> arrayList = List.of(1,1,2,2,3,4,5,6,7,8,9,10,11,12,13);
        List<Integer> list2 = Arrays.asList(12,56,12,13, 1);
        List<Integer> mergedList = Stream.concat(arrayList.stream(), list2.stream())
                .sorted()
                .toList();
        List<Integer> intersectionList = arrayList
                .stream()
                .filter(a -> list2.contains(a))
                .distinct()
                .toList();
        System.out.println(intersectionList);
        System.out.println(mergedList);
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        //frequemcy of each words
        Map<String, Long> collect = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        //partition a list into two groups based on a predicate using Java streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
        List<Student> studlist = Arrays.asList(
                new Student(1, "Rohit", "Kumar", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish", "Malag", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98)
        );

        //students firstname starts with A
        List<Student> a = studlist.stream()
                .filter(s -> s.getFirstName().startsWith("A"))
                .toList();
        System.out.println(a);

        //group students by department name
        Map<String, Map<Integer, String>> collect1 = studlist.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.toMap(Student::getRank, Student::getFirstName, (oldVal, newVal) -> newVal)));
        System.out.println(collect1);

        //Dept → List<Map<Rank, FirstName>>
//        studlist.stream()
//                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.mapping()));
//        //Dept → Map<Rank, List<FirstName>>
    }

    static class Person{
        String name;
        Integer age;
        Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public static class Student {
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private String gender;
        private String departmantName;
        private int joinedYear;
        private String city;
        private int rank;

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public String getDepartmantName() {
            return departmantName;
        }

        public int getJoinedYear() {
            return joinedYear;
        }

        public String getCity() {
            return city;
        }

        public int getRank() {
            return rank;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setDepartmantName(String departmantName) {
            this.departmantName = departmantName;
        }

        public void setJoinedYear(int joinedYear) {
            this.joinedYear = joinedYear;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public Student(int id, String firstName, String lastName, int age, String gender, String departmantName,
                       int joinedYear, String city, int rank) {
            super();
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
            this.departmantName = departmantName;
            this.joinedYear = joinedYear;
            this.city = city;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", departmantName=" + departmantName + ", joinedYear=" + joinedYear + ", city=" + city + ", rank=" + rank + "]";
        }
    }
}
