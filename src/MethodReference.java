

@FunctionalInterface
interface Isum {
    Integer sum(Integer a, Integer b);
}

interface Iprint {
    void print(String input);

    default void print2(String input){}
}

public class MethodReference {
    public static void main(String[] args) {
        Isum isum = new Isum() {
            @Override
            public Integer sum(Integer a, Integer b) {
                return a + b;
            }
        };
        System.out.println(isum.sum(5, 4));

        Isum isum2 = MethodReference::sum;
        System.out.println(isum2.sum(10, 1000));
        Isum isum3 = Integer::sum;
//        (a,b) -> Integer.sum(a, b);

        isum3.sum(0, 3);
        Iprint iprint = a-> System.out.println(a);
        Iprint iprint1 = MethodReference::print;
        iprint1.print("Learning method reference for passing function in method reference you have to worry about parameters passing in the referenced method not return type only when interface has void type return");
        //basically method reference have type parameters of interface method but only defination so if void then return type in implementaion will be ignoered and implementation will be of void return type
    }

    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static String print(String input) {
        System.out.println(input);
        return input;
    }


}
