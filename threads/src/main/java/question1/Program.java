package question1;

public class Program {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CounterRunnable("thread 1"));
        Thread thread2 = new Thread(new CounterRunnable("thread 2"));
        CounterThread thread3 = new CounterThread("thread 3");
        CounterThread thread4 = new CounterThread("thread 4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
