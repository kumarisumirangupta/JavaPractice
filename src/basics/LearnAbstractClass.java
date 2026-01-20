package basics;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;


public class LearnAbstractClass {
    public static void main(String[] args) {
        Car car = new Car(10);
        car.numberOfWheel();
//        car.speedOfVehicle();
        Car.staticMethod();
        Student student = new Student();
        Student.Course course = student.new Course();
        WeakReference<Student> studentWeakReference = new WeakReference<Student>(new Student());
        String s1 = new String("hello");
        String s2 = new String("hello");
        boolean issggs = s1 == s2;
        System.out.println("is s1 = s2 ?" + issggs);
    }
}

class Student{
    static int age;
    static int marks;

   class Course{
        void noOfCourse(){
            int k = marks;
            System.out.println("Method noOfCourse "+age + " "+ marks);
        }
    }
}

class Vehicle {

    int mileage;
    Vehicle(int mileage){
        System.out.println("Parent Constructor "+mileage);
    }

//    public abstract void speedOfVehicle();
     void numberOfWheel(){
        System.out.println("Four wheel");
    }

    static void staticMethod(){
        System.out.println("static method");
    }
}

class Car extends Vehicle{

    Car(int mileage){
        super(mileage);
        System.out.println("child class constructor");
    }
//    @Override
//    public void speedOfVehicle() {
//        System.out.println("Average speed of car is 30Km/Hr");
//    }

    static void staticMethod(){
        System.out.println("static method from car");
    }

}

/*
Abstract Class — What it CAN have

Can have abstract methods
Can have concrete (implemented) methods
Can have static methods
Can have final methods
Can have private methods
Can have protected methods
Can have constructors
Can have instance variables
Can have static variables

Can have access modifiers: public, protected, default

Can extend only one class

Can implement multiple interfaces

                Can contain initialization blocks

                Can contain inner classes

❌ Abstract Class — What it CANNOT have / do

        ❌ Cannot create an object of abstract class

❌ Cannot use default keyword for methods

❌ Abstract methods cannot be:

private

static

final

synchronized

❌ Abstract class cannot be final

❌ Abstract method cannot have body

❌ Cannot have abstract static methods

❌ Cannot have abstract constructors

❌ Cannot extend multiple classes
*/
