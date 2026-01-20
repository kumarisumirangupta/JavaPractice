package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducerNew {
    public static void main(String[] args) {
        ConsumerProducer consumerProducer = new ConsumerProducer(5, 0);
        Thread t1 = new Thread(consumerProducer::produce);
        Thread t2 = new Thread(consumerProducer::consume);
        t1.start();
        t2.start();
        consumerProducer.test();
    }
}

class ConsumerProducer {

    Queue<Integer> buffer = new LinkedList<>();
    Integer size;
    Integer element;

    ConsumerProducer(Integer size, Integer element) {
        this.size = size;
        this.element = element;
    }

    public void consume() {
        while (true) {
            synchronized (this){
                while(buffer.isEmpty()) {
                    System.out.println("Waiting Consumer");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Removing data" + buffer.poll());
                notifyAll();
                System.out.println("Notifying Producer");
            }

        }
    }

    public void produce() {
        while (true) {
            synchronized (this) {
                while (buffer.size() == size) {
                    try {
                        System.out.println("Waiting Producer buffer is full");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                buffer.add(element++);
                System.out.println("Adding element "+element);
                notifyAll();
                System.out.println("Notifying Consumer");
            }

        }
    }

    public void test(){
        System.out.println("jyjgjhgh");
    }
}
