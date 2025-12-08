import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParellelStreamPractice {
    public static void main(String[] args) {
//        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
//
//        long beforeStartingThread = System.currentTimeMillis();
//        arrayList.stream()
//                .parallel()
//                .forEach(System.out::println);
//        long timeTaken = System.currentTimeMillis() - beforeStartingThread;
//        System.out.println("time took by parallel thread " +timeTaken);
//
//        long beforeStartingStream = System.currentTimeMillis();
//        arrayList.stream()
//                .forEach(System.out::println);
//        long normaltimeTaken =  System.currentTimeMillis() - beforeStartingStream;
//        System.out.println("time taken by stream "+normaltimeTaken);

        long before = System.currentTimeMillis();
        IntStream.range(1, 10000000)
                .parallel()
                .sum();
        long after = System.currentTimeMillis();
        System.out.println("Parallel: " + (after - before));

        before = System.currentTimeMillis();
        IntStream.range(1, 10000000)
                .sum();
        after = System.currentTimeMillis();
        System.out.println("Normal: " + (after - before));


    }
}
