import java.util.ArrayList;

public class IntStreamPractice {

    public static void main(String[] args) {
        int i = 10;
        Integer i1 = Integer.valueOf(i); //Manually converting this is called boxing
        Integer i2 = i; //Auto boxing by compiler
        System.out.println(i1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1); //Integer.valueOf(1)
        arrayList.add(10); //autoboxing

        Integer i3 = arrayList.get(0);
        int i4 = arrayList.get(0); //No error because compiler is auto unboxing
        int i5 = i3.intValue(); // manual unboxing
        System.out.println("Available processor "+ Runtime.getRuntime().availableProcessors());
    }
}
