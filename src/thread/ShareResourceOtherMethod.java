package thread;

class ShareResourceProduce {

    boolean isAvailable = false;

    synchronized void produce(){
        System.out.println("Lock Acquired "+ Thread.currentThread().getName());
        isAvailable = true;
        try{
            Thread.sleep(10000);
        } catch (Exception e){

        }
        System.out.println("Lock Release "+ Thread.currentThread().getName());
    }
}

public class ShareResourceOtherMethod{
    public static void main(String[] args) {
        ShareResourceProduce shareResourceProduce = new ShareResourceProduce();
        System.out.println("main thread "+Thread.currentThread().getName());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                shareResourceProduce.produce();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shareResourceProduce.produce();
            }
        });

        t1.start();
        t2.start();
        System.out.println("main thread end "+Thread.currentThread().getName());
    }
}

