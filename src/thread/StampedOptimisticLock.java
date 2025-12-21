package thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticLock {
    int a = 10;
    StampedLock lock = new StampedLock();

    void producer() {
        long l = lock.tryOptimisticRead();
        System.out.println("lock value " + l + " " + Thread.currentThread().getName());
        System.out.println("updated value " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        if (lock.validate(l)) {
            System.out.println("updated value successfully " + Thread.currentThread().getName());
        } else {
            a = 10;
            System.out.println("RollBack value a : " + a + " " + Thread.currentThread().getName());
        }
    }

    void consumer() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long l = lock.writeLock();
        System.out.println("write lock " + l + " " + Thread.currentThread().getName());
        a = a+10;
        System.out.println("updated in consumer value a : " + a + " " + Thread.currentThread().getName());
        lock.unlockWrite(l);
    }

    public static void main(String[] args) {
        StampedOptimisticLock sh = new StampedOptimisticLock();

        Thread thread = new Thread(() -> sh.producer());

        Thread thread2 = new Thread(() -> sh.consumer());
        thread.start();
        thread2.start();
    }

}
