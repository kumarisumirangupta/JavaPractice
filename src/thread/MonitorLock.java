package thread;

class MonitorLockTask {
    public synchronized void task1(){
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("inside task1 sleeping thread");
        } catch (Exception ignored) {

        }
    }

    public void task2() {
        System.out.println("inside task2");
        synchronized (this){
            System.out.println("inside task2 synchronized code");
        }
    }

    public void task3(){
        System.out.println("inside task3");
    }
}

public class MonitorLock {
    public static void main(String[] args) {
        MonitorLockTask monitorLockTask = new MonitorLockTask();
        Thread t1 = new Thread(monitorLockTask::task1);
        Thread t2 = new Thread(monitorLockTask::task2);
        Thread t3 = new Thread(monitorLockTask::task3);

        t1.start();
        t2.start();
        t3.start();
    }
}
