import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    String name;
    List<Integer> mobileNumbers;
    List<String> nickNames;

    public Student(String name, List<Integer> mobileNumbers, List<String> nickNames) {
        this.name = name;
        this.mobileNumbers = mobileNumbers;
        this.nickNames = nickNames;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mobileNumbers=" + mobileNumbers +'\'' +
                ", nickNames=" + nickNames +'\'' +
                '}';
    }
}
public class MapVsFlatMap {

    public static void main(String[] args) {
        /*List<Integer> l1 = List.of(1,2,3,4,5);
        List<Integer> l2 = List.of(6,7);
        List<Integer> l3= List.of(8,9);

        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(l1);
        arrayList.add(l2);
        arrayList.add(l3);

        System.out.println(arrayList);
        System.out.println(arrayList.getFirst());
        List<Integer> integers = flatList(arrayList);
        System.out.println(integers);

        Function<String, Integer> functionMap = new Function<String, Integer>(){
            @Override
            public Integer apply(String s){
                return s.length();
            }
        };

        Function<String, List<String>> funFlatMap = new Function<String, List<String>>(){
            @Override
            public List<String> apply(String str){
                String[] strList = str.split("");
                return Arrays.asList(strList);
            }
        };
        List<String> listOfStrings = List.of("sumiran", "simran", "lokesh","sachin");
        List<Integer> outputList = map(listOfStrings, functionMap);
        System.out.println("calling map function");
        System.out.println(outputList);
        System.out.println("calling flatmap function");
        List<String> flatOutputList = flatMap(listOfStrings, funFlatMap);
        System.out.println(flatOutputList);*/

        List<Student> studentList = new ArrayList<>(Arrays.asList(new Student("Sumiran", Arrays.asList(12343535, 15353535), List.of("sumi", "joy")),
                new Student("Simran", Arrays.asList(46547367, 4658348), List.of("motki", "pagali")),
                new Student("John", Arrays.asList(2436436, 689595), List.of("jo", "jon"))));

        /*Function<Student, List<Integer>> flatMapForStudent = new Function<Student, List<Integer>>() {
            @Override
            public List<Integer> apply(Student student) {
                return student.mobileNumbers;
            }
        };
        List<Integer> mobileNumbers = extractMobileNumber(studentList, flatMapForStudent);
        System.out.println(mobileNumbers);
        Stream<Student> studentStream = studentList.stream();
        List<Integer> stream2 = studentStream.flatMap(new Function<Student, Stream<Integer>>() {
            @Override
            public Stream<Integer> apply(Student student){
                return student.mobileNumbers.stream();
            }
        }).toList();

        //Map practice
        List<Integer> integerList = List.of(1,2,3,4,45,6,7);
        List<String> outputString = integerList.stream().map(new Function<Integer, String>(){
            @Override
            public String apply(Integer input){
                return "value is "+input;
            }
        }).toList();
        System.out.println(outputString);*/

        //find length of nick names of each student
        List<Integer> nickNamesList = studentList.stream().map(new Function<Student, List<Integer>>() {
                    @Override
                    public List<Integer> apply(Student student) {
                        List<Integer> lenghtOfNicknames = new ArrayList<>();
                        for (String nickName : student.nickNames) {
                            lenghtOfNicknames.add(nickName.length());
                        }
                        return lenghtOfNicknames;
                    }
                })
                .flatMap(new Function<List<Integer>, Stream<Integer>>() {
                    @Override
                    public Stream<Integer> apply(List<Integer> integers) {
                        return integers.stream();
                    }
                })
                .collect(Collectors.toList());

        //using flatMap
        List<Integer> nickNamesListUsingFlatMap = studentList.stream().flatMap(new Function<Student, Stream<Integer>>() {
//            List<Integer> lengthList = new ArrayList<>(); -> this is wrong every object will use shared list
            @Override
            public Stream<Integer> apply(Student student) {
                List<Integer> lengthList = new ArrayList<>();
                for(String nickName: student.nickNames){
                    lengthList.add(nickName.length());
                }
                return lengthList.stream();
            }
        }).collect(Collectors.toList());

        //write using lambda expression

        System.out.println(nickNamesList);


        List<Integer> nickNamesListUsingFlatMap2 = studentList
                .stream()
                .flatMap(student -> student.nickNames.stream().map(String::length)
        ).toList();
        System.out.println(nickNamesListUsingFlatMap2);
        List<String> nickNames = studentList.stream().flatMap(student -> student.nickNames.stream()).toList();
        System.out.println(nickNames);
    }

    static List<Integer> extractMobileNumber(List<Student> studentList, Function<Student, List<Integer>> mapper){
        List<Integer> flattenedList = new ArrayList<>();
        for(Student student : studentList){
            flattenedList.addAll(mapper.apply(student));
        }
        return flattenedList;
    }

    static <R,T> List<R> flatMap(List<T> stringList, Function<T, List<R>> funFlatMap){
        List<R> listOfIntegers = new ArrayList<>();
        for(T str: stringList) {
            List<R> intValue = funFlatMap.apply(str); //mapping
            listOfIntegers.addAll(intValue); //flattening
        }
        return listOfIntegers;
    }

    static <R,T> List<R> map(List<T> stringList, Function<T, R> mapperFunct){
        List<R> listOfIntegers = new ArrayList<>();
        for(T str: stringList) {
            R intValue = mapperFunct.apply(str);
            listOfIntegers.add(intValue);
        }
        return listOfIntegers;
    }
    static <T>List<T> flatList(List<List<T>> listToFlat) {
        List<T> mergedList = new ArrayList<>();
        for (List<T> listOfInteger : listToFlat) {
            for (T val : listOfInteger) {
                mergedList.add(val);
            }
        }
        return mergedList;
    }
}
