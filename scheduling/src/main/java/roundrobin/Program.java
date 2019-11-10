package roundrobin;

public class Program {

    public static void main(String[] args) {
        Process process1 = new Process("1", 100);
        Process process2 = new Process("2", 200);
        Process process3 = new Process("3", 300);
        Process process4 = new Process("4", 400);
        Process process5 = new Process("5", 500);
        new Thread(() -> Scheduler.getInstance().schedule()).start();
        process1.start();
        process2.start();
        process3.start();
        process4.start();
        process5.start();
    }
}
