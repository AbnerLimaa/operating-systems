package fcfs;

public class Counter implements Runnable {

    private int limit;
    private int value;

    public Counter(int limit) {
        this.limit = limit;
        value = 0;
    }

    @Override
    public void run() {
        try {
            while(value < limit) {
                Thread.sleep(5);
                value++;
            }
            System.out.println("Valor da thread: " + value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
