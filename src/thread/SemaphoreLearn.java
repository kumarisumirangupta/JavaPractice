package thread;

import java.util.concurrent.Semaphore;

public class SemaphoreLearn {
    boolean isAvailable = false;
    Semaphore semaphore = new Semaphore(2);
    //wait -> In semaphore await method
    //notify -> In semaphore signal method
    void semaphoreResource(){
        try {
            System.out.println("Inside semaphore method "+Thread.currentThread().getName());
            semaphore.acquire();
            System.out.println("Lock acquired by Thread "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isAvailable = true;
        try {
            System.out.println("sleeping thread "+Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        System.out.println("waking thread "+Thread.currentThread().getName());
    }

    /*@GetMapping
    public void getUser() throws InterruptedException {
        call("jhsbkvuasbu");
    }

    Semaphore s = new Semaphore(10);
    public void call(String url) throws InterruptedException {

        s.acquire();
        //call recuiter
        s.release();
    }*/

    public static void main(String[] args) {
        SemaphoreLearn semaphoreLearn = new SemaphoreLearn();
        Thread thread = new Thread(semaphoreLearn::semaphoreResource);
        Thread thread2 = new Thread(semaphoreLearn::semaphoreResource);
        thread.start();
        thread2.start();
    }
}
