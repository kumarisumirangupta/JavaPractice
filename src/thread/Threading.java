package thread;

public class Threading {
    public static void main(String[] args) {
       /* thread.ThreadPractice tp = new thread.ThreadPractice();
        Thread thread = new Thread(tp);
        thread.start();
        System.out.println("inside main thread "+Thread.currentThread().getName());
*/
    /* thread.ThreadPracticeExtend tpe = new thread.ThreadPracticeExtend();
     tpe.start();*/
        SynchronizeCode sc = new SynchronizeCode();
        Thread t1 = new Thread(sc::task1);
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                sc.task2();
            }
        });
        Thread t3 = new Thread(() -> sc.task3());

        t1.start();
        t2.start();
        t3.start();
    }
}

class ThreadPractice implements Runnable{
    @Override
    public void run() {
        System.out.println("thread.ThreadPractice class run method "+Thread.currentThread().getName());
    }
}

class ThreadPracticeExtend extends Thread{
    @Override
    public void run() {
        System.out.println("thread.ThreadPractice class run method "+Thread.currentThread().getName());
    }
}

class SynchronizeCode {
    synchronized void task1() {
        System.out.println("printing from task1 " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        } catch (Exception ignored){

        }
        System.out.println("lock is realising from task 1");

    }

    void task2() {
        System.out.println("Inside task2 waiting for lock");
        synchronized (this) {
            System.out.println("printing from task2 " + Thread.currentThread().getName());
        }
    }

    void task3() {
        System.out.println("printing from task3 " + Thread.currentThread().getName());
    }
}
