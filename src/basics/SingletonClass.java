package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Changing a reference does not affect immutability; only changing the internal state of an object does.
//Immuatable class means state of the variable should not change after the creation
// Immutable means the internal state of an object cannot change after creation

// Example of state change (object becomes mutable)
//List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3));
//integerList.add(40); // state change → NOT immutable
// Example of reference change (object remains unchanged)
// List<Integer> integerList2 = new ArrayList<>(Arrays.asList(1,2,3));
//integerList2 = new ArrayList<>(); // reference change, old object still unchanged
//An immutable object is one whose internal state cannot be changed after it is created.
//A mutable class is a class whose object’s internal state can be changed after the object is created
        //If any field value of an object can be modified after construction, the class is mutable.
final class ImmutableClass{
    private final Integer age;
    private final List<Integer> integerList;

    ImmutableClass(Integer age, List<Integer> list){
        this.age = age;
        this.integerList = new ArrayList<>(list); //defensive copy
    }

    public List<Integer> getIntegerList(){
        return new ArrayList<>(integerList); //defensive copy
    }
    public Integer getAge(){
        return age;
    }
}
public class SingletonClass {
    public static void main(String[] args) {
        List<Integer> constructorList = new ArrayList<>(Arrays.asList(1,2,3));
        ImmutableClass immutableClass = new ImmutableClass(25, constructorList);
        Integer age = immutableClass.getAge();
        age = age +5;
        System.out.println(age + " "+ "class age "+ immutableClass.getAge());
//        List<Integer> integerList = immutableClass.getIntegerList();
//        System.out.println(integerList);
//        integerList.add(50);
//        System.out.println(integerList);
        constructorList.add(60);
        System.out.println(immutableClass.getIntegerList());
    }
}

//Eager Initialization
class DBCollection{
    static DBCollection dbCollection = new DBCollection(); //static variables get initiated when class
    //loads by jvm  so dbcollection object is initiated eagerly even no on creates it.

    private DBCollection(){

    }

    public static DBCollection getInstanceOfDbCollection(){
        return dbCollection;
    }
}

//again practising
class A{
    static A a = new A();
    private A(){
    }
    static A getInstanceOfA(){
        return a;
    }
}

//Lazy Initialization
class B{
    static B b;
    private B(){

    }
    public static B getInstanceOfB(){ //this create issues when multiple threads access same time
        if(b==null){
            b = new B();
        }
        return b;
    }
}

// Synchronized singleton
class S{
    static S s;
    private S(){

    }
    synchronized public static S getInstanceOfS(){ //it solve above issue still it is taking lock on whole method not on critical part only causes threads to wait and makes slow
        if(s==null){
            s = new S();
        }
        return s;
    }
}

//Double check locking
class DC{
    static volatile DC dc; // volatile because any read/write happens on volatile variable will be into memory not in l1/l2 cache
    private DC(){

    }
    public static DC getInstanceOfDC(){
            synchronized (dc){
                if(dc == null){
                    dc = new DC();
                }
            }
        return dc;
    }
}

//Bill Pugh Solution
class bps{
    private static class bpsInnerClass{//nested class doenot load at class loading time it will be loaded and static field will be initialized only when it gets invoke
        private static final bps bbObject = new bps();
    }
    public static bps getInstanceOfbps(){
        return bpsInnerClass.bbObject;//how it is thread safe bcz jvm ensure only one class created for each class so only one class and only one initialization
    }
    private bps(){}
}

enum enumWay{//enum is singelton and only one instance will be created per application
    enumWayObj;
}

