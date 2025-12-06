import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

interface IsumV2{
    Integer sum(ArbitraryObjMethodRef arbitraryObj, Integer a, Integer b);
}

interface IupperCase{
    String upperCase(ArbitraryObjMethodRef arbitraryObj, String string);
}

interface I3{
    void print2(PrintStream printStream, String string);
}
public class ArbitraryObjMethodRef {

    public static void main(String[] args) {
//        IsumV2 isumV2 = ArbitraryObjMethodRef::sum;
//        isumV2.sum(5,10);

        //If the ArbitraryObjMethodRef.sum is not static then for passing method by reference
        //IsumV2 isumV2 = new ArbitraryObjMethodRef()::sum; //here created a object of the class  and passed the method refrence
        IsumV2 isumV2 = ArbitraryObjMethodRef::sum; //Method is not static but passing like static method how?
        //because in interface method declaration An imagainary object is passed during the method invocation
        System.out.println(isumV2.sum(new ArbitraryObjMethodRef(),5, 10)); //(obj, a, b) -> obj.sum(a, b)
        /*Using ClassName::instanceMethod as a method reference does NOT require the method to be static.
        The functional interface must take the target object as its first parameter.
        Java then calls obj.method(...) internally.
        If you don’t pass the object, the compiler thinks you expect a static method.*/

        Function<String, String> stringFunction = String::toUpperCase;
        stringFunction.apply("test"); //test.apply() -> test.toUpperCase;
        IupperCase iupperCase = ArbitraryObjMethodRef::testUpperCase;
        iupperCase.upperCase(new ArbitraryObjMethodRef(), "sumiran"); //this is same internally new ArbitraryObjMethodRef().testuppercase

        I3 biFunction = PrintStream::println;
//       biFunction.print2(System.out, "hello");
        biFunction.print2(new PrintStream(System.out), "hello");
        BiConsumer<PrintStream, String> biConsumer = PrintStream::println;
        biConsumer.accept(new PrintStream(System.out), "learning method reference");

        BiConsumer<ArrayList<Integer>, Integer> arrayListIntegerBiConsumer = ArrayList::add;
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        arrayListIntegerBiConsumer.accept(arrayList, 12); //internally calling arrayList.add(12)
        System.out.println(arrayList);
       // BiFunction<Integer, Integer, Integer> biFunction1 = ArbitraryObjMethodRef::sum;
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public String testUpperCase(String s){
        return s.toUpperCase();
    }
}
