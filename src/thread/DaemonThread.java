package thread;

public class DaemonThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            try {
                Thread.sleep(2000);
            }catch (Exception e){

            }
        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main Thread "+Thread.currentThread().getName());
        System.out.println(t1.getState());
//        A daemon thread is a background thread that provides services to user threads, and the JVM terminates it automatically when all user threads finish.
    }
}
