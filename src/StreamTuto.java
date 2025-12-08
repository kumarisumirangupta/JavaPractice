import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTuto {

    public static void main(String[] args) {
        Stream<Integer>  stream1 = Stream.of(1,2,3,4,5); //1
        List<Integer> list = Stream.generate(() -> 1).limit(5).toList(); //2
        System.out.println(list);
        String [] array = new String[]{"Sita", "Gita", "Babita", "hello","world"};
        Arrays.stream(array); //3
        list.stream(); //4
        Stream.iterate(1, n -> n + 10).limit(5); //5
        Stream.Builder<Integer> build = Stream.builder(); //6
        build.add(5);
        build.add(6);
        Stream<Integer> build1 = build.build();
    }
}
