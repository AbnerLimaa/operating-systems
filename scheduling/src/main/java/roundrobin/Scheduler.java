package roundrobin;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Scheduler {

    private static Scheduler instance;
    private BlockingQueue<Counter> queue;
    private int quantum;

    private Scheduler() {
        queue = new LinkedBlockingQueue<>();
        this.quantum = 100;
    }

    public static Scheduler getInstance() {
        if(instance == null)
            instance = new Scheduler();
        return instance;
    }

    public void addThread(Counter thread) throws InterruptedException {
        queue.put(thread);
    }

    public void schedule() {
        try {
            int numberFinishedThreads = 0;
            int totalTime = 0;
            while (numberFinishedThreads < 5) {
                Counter counter = queue.take();
                if(counter.isStarted()) {
                    counter.restart();
                    System.out.println("Reiniciou a thread " + counter.getName());
                }
                else {
                    counter.start();
                    System.out.println("Iniciou a thread " + counter.getName());
                }
                long startTime = System.currentTimeMillis();
                while(true) {
                    if(counter.isEnded()) {
                        System.out.println("Terminou a thread " + counter.getName());
                        numberFinishedThreads++;
                        totalTime += counter.waitingTime();
                        break;
                    }
                    long currentTime = System.currentTimeMillis();
                    if(currentTime - startTime >= quantum) {
                        counter.stop();
                        System.out.println("Pausou a thread " + counter.getName());
                        queue.put(counter);
                        break;
                    }
                }
            }
            System.out.println("Tempo de turnaround total: " + totalTime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
