package question1;

public class CounterRunnable implements Runnable {

    private String threadName;

    public CounterRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while(Counters.ascending <= 100) {
            System.out.println(threadName + " - crescente: " + Counters.ascending);
            Counters.ascending++;
        }
    }
}
