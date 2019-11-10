package roundrobin;

import java.util.Random;

public class Process extends Thread {

    private String name;
    private int limit;
    private Scheduler scheduler;

    public Process(String name, int limit) {
        this.name = name;
        this.limit = limit;
        this.scheduler = Scheduler.getInstance();
    }

    @Override
    public void run() {
        try {
            Counter counter = new Counter(name, limit);
            counter.setStartTime(System.currentTimeMillis());
            Random random = new Random();
            Thread.sleep(random.nextInt(5));
            scheduler.addThread(counter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
