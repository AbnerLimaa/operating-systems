package question2;

public class Program {

    public static void main(String[] args) {
        int routeLength = 20;
        Thread thread1 = new Thread(new Runner("1", routeLength, 1));
        Thread thread2 = new Thread(new Runner("2", routeLength, 1));
        Thread thread3 = new Thread(new Runner("3", routeLength, 1));
        Thread thread4 = new Thread(new Runner("4", routeLength, 1));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
