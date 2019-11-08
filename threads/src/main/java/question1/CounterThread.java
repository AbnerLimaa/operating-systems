package question1;

public class CounterThread extends Thread {

    private String threadName;

    public CounterThread(String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while(Counters.descending >= 0) {
            System.out.println(threadName + " - decrescente: " + Counters.descending);
            Counters.descending--;
        }
    }
}
