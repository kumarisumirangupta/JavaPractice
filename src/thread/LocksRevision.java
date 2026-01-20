package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class LocksRevision {
//    static ReentrantLock reentrantLock = new ReentrantLock();
//    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    static StampedLock stampedLock = new StampedLock();
//    static StampedLock stampedLock = new StampedLock(); //Optimistic Lock
    static Semaphore semaphore = new Semaphore(2);
    static int a = 10;
    static void resourceMethod(){
        System.out.println("Acquired Lock queue");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        reentrantLock.lock();
//        readWriteLock.readLock().lock();
//        readWriteLock.writeLock().lock();
//        long l = stampedLock.readLock();
//        long l = stampedLock.writeLock();
        System.out.println("Acquired Lock queue "+a);
//        long l = stampedLock.tryOptimisticRead();
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        System.out.println("Thread is sleeping name "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
//        readWriteLock.readLock().unlock();
//        reentrantLock.unlock();
//        readWriteLock.writeLock().unlock();
//        stampedLock.unlockRead(l);
//        stampedLock.unlockWrite(l);
//        if(stampedLock.validate(l)){
//            System.out.println("lock is validated "+a);
//        }
        semaphore.release();
        System.out.println("Lock Release");
    }

    static void increaseA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        long l = stampedLock.writeLock();
        System.out.println("write lock acquired");
        a = a+1;
//        stampedLock.unlockWrite(l);
        System.out.println("write lock released");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(LocksRevision::resourceMethod);
//        Thread t2 = new Thread(LocksRevision::increaseA);
        Thread t2 = new Thread(LocksRevision::resourceMethod);
        Thread t3 = new Thread(LocksRevision::resourceMethod);
        t1.start();
        t2.start();
        t3.start();
    }

}
