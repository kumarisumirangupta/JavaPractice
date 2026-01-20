package thread;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConsumerProducerExample {

    public static void main(String[] args) {

        System.out.println("inside main method thread "+ Thread.currentThread().getName());
        SharedResource sr = new SharedResource(5);

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=5; i++){
                    try {
                        System.out.println("adding item " + i +":::::"+ sr.queue);
                        sr.produce(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=5; i++){
                    try {
                        System.out.println("removing item " + i +":::::"+ sr.queue);
                        sr.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        consumerThread.setPriority(10);
        producerThread.start();
        consumerThread.start();
        try {
            consumerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread");

    }

    static class SharedResource{
        Queue<Integer> queue = new ArrayDeque<>();
        Integer bufferSize;

        SharedResource(Integer bufferSize){
            this.bufferSize = bufferSize;
        }
        public synchronized void produce(int item) throws InterruptedException {
            System.out.println("inside produce method "+ Thread.currentThread().getName());
            while (queue.size() == bufferSize){
                System.out.println("queue is full "+ Thread.currentThread().getName());
                wait();
                System.out.println("queue is full after wait "+ Thread.currentThread().getName());
            }
            System.out.println("pruducing item from queue thread "+ Thread.currentThread().getName());
            queue.offer(item);
            notify();
            System.out.println("consume method finishes "+ Thread.currentThread().getName());
        }
        public synchronized void consume() throws InterruptedException {
            System.out.println("inside consume method "+ Thread.currentThread().getName());
            while (queue.isEmpty()){
                System.out.println("queue is empty "+ Thread.currentThread().getName());
                wait();
                System.out.println("queue is empty after wait"+ Thread.currentThread().getName());
            }
            System.out.println(queue.poll() +"consuming item from queue thread "+ Thread.currentThread().getName());
            notify();
            System.out.println("consume method finishes "+ Thread.currentThread().getName());
        }
    }
}

