package thread;

import java.sql.Time;
import java.util.concurrent.*;

public class ThreadLocalLearn {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName());
            }
        });
//        t1.start();
//        System.out.println(threadLocal.get());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> iLoveYouLokesh = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("I love you Lokesh");
            }
        }, 0, 2, TimeUnit.SECONDS);

         scheduledExecutorService.schedule(() -> iLoveYouLokesh.cancel(true), 10, TimeUnit.SECONDS);

         scheduledExecutorService.schedule(scheduledExecutorService::shutdown, 6, TimeUnit.SECONDS);

        ExecutorService service = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello 5");
            return 5;
        }, service);
        service.shutdown();

    }
}
