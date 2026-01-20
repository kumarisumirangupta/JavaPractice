package thread;

import java.util.concurrent.*;

public class ThreadPoolLearn {
    public static void main(String[] args) {
       ExecutorService executor =  new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new ThreadPoolExceptionHandler());

      /* for(int i=0; i< 20; i++) {
           executor.submit(new Runnable() {
               @Override
               public void run() {
                   System.out.println("printing from task1 " + Thread.currentThread().getName());
                   throw new RuntimeException("Throwing exeception");
               }
           });
       }*/
        Future<?> submit = executor.submit(() -> {
            try{
                Thread.sleep(7000);
                System.out.println("this is the task which thread will execute");
            } catch (Exception e){

            }
        });
        System.out.println("cancelling task "+submit.cancel(true));
        System.out.println("without get "+submit.isDone());
        try{
            submit.get(2, TimeUnit.SECONDS);
            System.out.println("without get after 2 seconds"+submit.isDone());
        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
        try{
            submit.get();
        } catch (Exception e){

        }

        System.out.println("with get "+submit.isDone());
        System.out.println(submit.isDone());
        System.out.println("cancelled "+submit.isCancelled());
        executor.shutdown();

    }

    private static class CustomThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    private static class ThreadPoolExceptionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Thread is not available");
        }
    }
}
