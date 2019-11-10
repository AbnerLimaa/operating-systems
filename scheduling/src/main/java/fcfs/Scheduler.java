package fcfs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Scheduler {

    private static Scheduler instance;
    private BlockingQueue<Thread> queue;
    private int queueSize;

    private Scheduler() {
        queue = new LinkedBlockingQueue<>();
        this.queueSize = 5;
    }

    public static Scheduler getInstance() {
        if(instance == null)
            instance = new Scheduler();
        return instance;
    }

    public void addThread(Thread thread) throws InterruptedException {
        queue.put(thread);
        queueSize++;
    }

    public void schedule() {
        try {
            for(int i = 0; i < queueSize; i++) {
                Thread thread = queue.take();
                thread.start();
                thread.join();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
