import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsPractice {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(List.of(10,20,30));
        printCollection(source);
    }

    static <T> void printCollection(Collection<T> collection) {
        System.out.println(collection);
    }
}
