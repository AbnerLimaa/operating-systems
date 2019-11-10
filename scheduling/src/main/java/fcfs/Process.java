package fcfs;

public class Process extends Thread {

    private Scheduler scheduler;
    private int time;

    public Process(int time, String name) {
        super(name);
        scheduler = Scheduler.getInstance();
        this.time = time;
    }

    @Override
    public void run() {
        try {
            System.out.println("O processo " + getName() + " entrou no escalonador");
            Thread thread = new Thread(new Counter(time));
            Thread.sleep(time);
            scheduler.addThread(thread);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
