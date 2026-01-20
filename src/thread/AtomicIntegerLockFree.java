package thread;

import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerLockFree {

    static AtomicInteger counter = new AtomicInteger(0);
//    static Integer counter = 0;
    public static void increment(){
        counter.incrementAndGet();
        System.out.println("counter value is "+counter +"called by thread "+Thread.currentThread().getName());
//        counter++;
    }
    public static int get(){
        return counter.get();
//        return counter;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
//            System.out.println("inside run method thread 1 "+Thread.currentThread().getName());
            for(int i=0; i<100; i++){
//                System.out.println("increment run method thread 1 "+Thread.currentThread().getName());
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
//            System.out.println("inside run method thread 2 "+Thread.currentThread().getName());
            for(int i=0; i<100; i++){
//                System.out.println("increment run method thread 2 "+Thread.currentThread().getName());
                increment();
            }
        });
        Thread t3 = new Thread(() -> {
//            System.out.println("inside run method thread 2 "+Thread.currentThread().getName());
            for(int i=0; i<100; i++){
//                System.out.println("increment run method thread 2 "+Thread.currentThread().getName());
                increment();
            }
        });
        Thread t4 = new Thread(() -> {
//            System.out.println("inside run method thread 2 "+Thread.currentThread().getName());
            for(int i=0; i<100; i++){
//                System.out.println("increment run method thread 2 "+Thread.currentThread().getName());
                increment();
            }
        });

        Thread t5 = new Thread(() -> {
//            System.out.println("inside run method thread 3 "+Thread.currentThread().getName());
            for(int i=0; i<100; i++){
//                System.out.println("increment run method thread 3 "+Thread.currentThread().getName());
                increment();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("after incremenet value is "+ get() +" "+Thread.currentThread().getName());
        ConcurrentLinkedDeque<Integer> integers = new ConcurrentLinkedDeque<>();
        HashSet<Integer> hashSet = new HashSet<>();
        CopyOnWriteArrayList<Integer> integers1 = new CopyOnWriteArrayList<>();
        hashSet.add(1);
        integers1.add(4);
    }
}
