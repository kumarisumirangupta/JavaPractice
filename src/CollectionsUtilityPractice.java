import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilityPractice {
    public static void main(String[] args) {
        /*Use Collections.frequency().
        Data: [1,2,2,3,3,3]
        Find frequency of 3.*/
        Integer [] array = new Integer[]{1,2,2,3,3,3};
        System.out.println(Collections.frequency(Arrays.asList(array), 3));

       /* Data: source = [10,20,30]
        dest = [0,0,0]
        Copy source → dest.*/
        List<Integer> source = new ArrayList<>(List.of(10,20,30));
        List<Integer> dest = new ArrayList<>(6);
        dest.add(0);
        dest.add(0);
        dest.add(0);
        dest.add(0);
        Collections.copy(dest, source);
        System.out.println(dest);
        Collections.fill(source, 89);
        System.out.println(source);
        Collections.swap(dest, 0,1);
        System.out.println(dest);
        Collections.rotate(dest, 3);
        System.out.println(dest);

    }
}
