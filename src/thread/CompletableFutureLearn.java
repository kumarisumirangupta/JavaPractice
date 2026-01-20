package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureLearn {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));
        //use case1
        /*Future<?> res1 = executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
            System.out.println("void return type");
        });
        System.out.println(res1.state());
        System.out.println(res1.isDone());
        System.out.println("Main thread " + Thread.currentThread().getName());
        executorService.shutdown();
        System.out.println(res1.state());*/

        /*//Use case 2
        List<Integer> list = new ArrayList<>();
        List<Integer> finalList = list;
        Future<List<Integer>> submit = executorService.submit(() -> finalList.add(50), list);
        try{
            list = submit.get();
        } catch (Exception e){

        }
        executorService.shutdown();
        System.out.println(list);*/

        //Use case 2
        List<Integer> list = new ArrayList<>();
        List<Integer> finalList = list;
        Future<List<Integer>> submit = executorService.submit(() -> {
            finalList.add(50);
            return finalList;
        });
        try {
            list = submit.get();
        } catch (Exception e) {

        }

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Async ");
                    System.out.println(Thread.currentThread().getName());
                    return "abcd";
                }, executorService)
                .thenApplyAsync((a) -> {
                    System.out.println(a);
                    System.out.println(Thread.currentThread().getName());
                    return "defg";
                })
                .thenApplyAsync((a) -> {
//                    System.out.println("sumiran");
                    System.out.println(a+"hello");
                    System.out.println(Thread.currentThread().getName());
                    return "ghdhdhd";
                }, executorService);
        try {
            cf.get();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println(list);
    }
}
