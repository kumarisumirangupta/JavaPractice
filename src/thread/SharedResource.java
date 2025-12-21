package thread;

class SharedResourceUtil {
    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("inside add item method "+ Thread.currentThread().getName());
        notifyAll();
    }

    //After notify() or notifyAll(), a thread moves out of WAITING and must reacquire the monitor. If the lock is unavailable, it enters BLOCKED; otherwise it becomes RUNNABLE directly.”
    public synchronized void consumeItem(){
        System.out.println("consumemethod "+Thread.currentThread().getName());
        while(!itemAvailable){
            try{//inside while when itemAvailable is false
                System.out.println("Thread "+ Thread.currentThread().getName() +" is waiting now");
                wait();
            } catch (Exception e){

            }
        }
        System.out.println("Item consumed by "+Thread.currentThread().getName());
        itemAvailable = false;
    }
}

class ProduceTask implements Runnable {

    SharedResourceUtil sharedResource;

    ProduceTask(SharedResourceUtil sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer Thread "+Thread.currentThread().getName());
        try{//inside while when itemAvailable is false
            System.out.println("Thread "+ Thread.currentThread().getName() +" is sleeping in producer thread");
            Thread.sleep(5000L);
        } catch (Exception e){

        }
        sharedResource.addItem();
    }
}

class ConsumeTask implements Runnable {

    SharedResourceUtil sharedResource;

    ConsumeTask(SharedResourceUtil sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("thread.ConsumeTask Thread "+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}

public class SharedResource {
    public static void main(String[] args) {
        System.out.println("Main Thread start ");
        SharedResourceUtil sharedResourceUtil = new SharedResourceUtil();
        Thread producerThread = new Thread(new ProduceTask(sharedResourceUtil));
        Thread consumerThread = new Thread(new ConsumeTask(sharedResourceUtil));
        producerThread.start();
        consumerThread.start();
        System.out.println("Main Thread end ");
    }
}