package thread;

import java.util.concurrent.locks.ReentrantLock;

//Different object but have to synchronized then use this lock
public class ReentrantLockLearn {
    public static void main(String[] args) {
        SharedResource sh = new SharedResource(); //different object method will have lock inside it individually
        SharedResource sh1 = new SharedResource();
        ReentrantLock lock = new ReentrantLock(); //for lock shared resource should exist
        Thread thread = new Thread(() -> {
            sh.produce(lock);
        });

        Thread thread2 = new Thread(() -> {
            sh.produce(lock);
        });
        thread.start();
        thread2.start();
    }

    private static class SharedResource {
//        ReentrantLock lock = new ReentrantLock();
        boolean isAvailable = false;

        void produce(ReentrantLock lock) {
            System.out.println("Inside produce method " + Thread.currentThread().getName());
            try {
                lock.lock();
                isAvailable = true;
                System.out.println("Lock acquired " + Thread.currentThread().getName());
                Thread.sleep(4000);
                System.out.println("Sleep over " + Thread.currentThread().getName());
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
            System.out.println("Lock released " + Thread.currentThread().getName());
        }

    }
}


