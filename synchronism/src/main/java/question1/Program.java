package question1;

public class Program {

    public static void main(String[] args) {
        new Thread(new Consumer(Parity.EVEN)).start();
        new Thread(new Consumer(Parity.ODD)).start();
        new Thread(new Producer()).start();
    }
}
