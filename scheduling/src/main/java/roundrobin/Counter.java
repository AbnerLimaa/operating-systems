package roundrobin;

public class Counter implements Runnable {

    private String name;
    private boolean started;
    private boolean stopped;
    private boolean ended;
    private long startTime;
    private long endTime;
    private int limit;
    private Thread thread;

    public Counter() {

    }

    public Counter(String name, int limit) {
        this.name = name;
        this.limit = limit;
        started = false;
        stopped = false;
        ended = false;
        startTime = 0;
        endTime = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public boolean isStarted() {
        return this.started;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public boolean isEnded() {
        return this.ended;
    }

    public Long waitingTime() {
        return endTime - startTime;
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        stopped = true;
    }

    public void restart() {
        stopped = false;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void run() {
        try {
            started = true;
            int counter = 0;
            while(counter <= limit) {
                Thread.sleep(5);
                synchronized (this) {
                    while (stopped)
                        wait();
                }
                counter++;
            }
            endTime = System.currentTimeMillis();
            ended = true;
            System.out.println("Contador " + name + ": " + counter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
