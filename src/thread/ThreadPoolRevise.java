package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolRevise {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2));
//        executor.allowCoreThreadTimeOut(true);
//        LinkedList<Integer> list = new LinkedList<>();
//        LinkedList<Integer> finalList = list;
//        Future<LinkedList<Integer>> submit = executor.submit(() -> finalList.add(5), list);
//        System.out.println(submit.isDone());
//        try {
//            System.out.println(submit.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        CompletableFuture<Void> helloWorld = CompletableFuture.runAsync(() -> System.out.println("hello world"));
//        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 50);
//        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Learning Java is ")
//                .thenApply((a) -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                   return a + "Fun hehehe";
//                })
//                .thenApplyAsync(b -> b +" \nInside then Apply Async");

//        try {
//            String get = stringCompletableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        String join = stringCompletableFuture.join();
//        System.out.println(join);
//        helloWorld.join();
//        executor.shutdown();

//        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> "Learning Java is ")
//                .thenComposeAsync((a) -> {
//                    try {
//                        System.out.println("Inside thenComposeAsync");
//                        Thread.sleep(10000);
//                        System.out.println("Wait is over in then compose async");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return CompletableFuture.completedFuture(1);
//                })
//                .thenApplyAsync(b -> {
//                    try {
//                        System.out.println("Inside thenApplyAsync");
//                        Thread.sleep(5000);
//                        System.out.println("Wait is over in then apply async");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return b +" \nInside then Apply Async";
//                })
//                .thenAccept((str) -> System.out.println(str +" hello this is the end!!!!!"));
//        completableFuture.join();
//        String join1 = completableFuture.join();

//        System.out.println(join1);
//        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println("c1 completed");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Hello";
//        });
//        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println("c2 completed");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "World";
//        });
//        CompletableFuture<String> stringCompletableFuture = c1.thenCombine(c2, (val1, val2) -> val1 + " " + val2);
//        System.out.println(stringCompletableFuture.join());

        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for(int i=0; i<10; i++){
            int finalI = i;
            completableFutures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return finalI;
            }));
        }
//        Integer sum = 0;
//        for(CompletableFuture<Integer> c :completableFutures){
//            sum = sum + c.join();
//        }
//        System.out.println(sum);
//        CompletableFuture.allOf(...) ka matlab:
//            “Mujhe ek naya CompletableFuture do
//            jo tab complete ho jab array ke saare futures complete ho jaayein.”
        List<Integer> join = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .thenApply(sum -> completableFutures
                        .stream()
                        .map(CompletableFuture::join)
                        .toList()
                ).join();
//        voidCompletableFuture.join();

        List<Integer> listCompletableFuture = completableFutures
                .stream()
                .map(CompletableFuture::join)
                .toList();

        ExecutorService service = Executors.newFixedThreadPool(2);
    }
}
