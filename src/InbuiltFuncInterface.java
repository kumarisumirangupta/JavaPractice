import java.io.PrintStream;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

class Multiply{
    static Integer doMultiply(Integer a, Integer b){
        return a*b;
    }
    static boolean isEqual(Integer a, Integer b){
        return a.equals(b);
    }
}

interface Test1{
    String convertToUpperCase(String str);
}
public class InbuiltFuncInterface {

    public static void main(String[] args) {
        Consumer<List<Integer>> listConsumer = new Consumer<List<Integer>>(){
            @Override
            public void accept(List<Integer> integers) {
                Collections.sort(integers);
            }
        };

        Consumer<List<Integer>> listConsumer1 = a -> Collections.sort(a);
        Consumer<List<Integer>> listConsumer2 = a -> a.sort((obj1, obj2) -> {return (obj1-obj2);});
        Consumer<List<Integer>> listConsumer3 = Collections::sort;

        BiFunction<Integer, Integer, Integer> biFunctionMultiply = Multiply::doMultiply;
        Integer value = biFunctionMultiply.apply(10,20);
        System.out.println("multiplication of two number "+value);

        BiPredicate<Integer, Integer> biPredicate = Multiply::isEqual;
        BiPredicate<Integer, Integer> biPredicateLamda = (a,b) -> a.equals(b);
        BiPredicate<Integer, Integer> biPredicateObject = Objects::equals;
        //System.out gives printstream object and inside it there are println method
        Consumer<String> consumerPrint = System.out::println;
        Test1 func1 = String::toUpperCase;
        System.out.println(func1.convertToUpperCase("abcd"));

    }
}
