package fcfs;

public class Program {

    public static void main(String[] args) {
        Process process1 = new Process(100, "1");
        Process process2 = new Process(200, "2");
        Process process3 = new Process(300, "3");
        Process process4 = new Process(400, "4");
        Process process5 = new Process(500, "5");
        new Thread(() -> Scheduler.getInstance().schedule()).start();
        process1.start();
        process2.start();
        process3.start();
        process4.start();
        process5.start();
    }
}
