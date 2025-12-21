package thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StampedReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource sh = new SharedResource();

        Thread thread = new Thread(() -> sh.produce(lock));

        Thread thread2 = new Thread(() -> sh.produce(lock));
        thread.start();
        thread2.start();
    }

    private static class SharedResource {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        boolean isAvailable = false;

        void produce(ReadWriteLock lock) {
            System.out.println("Inside produce method " + Thread.currentThread().getName());
            try {
                lock.readLock().lock();
                isAvailable = true;
                System.out.println("Lock acquired " + Thread.currentThread().getName());
                Thread.sleep(4000);
                System.out.println("Sleep over " + Thread.currentThread().getName());
            } catch (Exception e) {

            } finally {
                lock.readLock().unlock();
            }
            System.out.println("Lock released " + Thread.currentThread().getName());
        }
    }
}
