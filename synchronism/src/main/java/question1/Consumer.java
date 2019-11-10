package question1;

import java.util.Random;

public class Consumer implements Runnable {

    private Dropbox dropbox;
    private final Parity parity;

    public Consumer(Parity parity) {
        this.dropbox = Dropbox.getInstance();
        this.parity = parity;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            while (true) {
                int number = dropbox.take();
                if(parity == Parity.EVEN && number % 2 == 0)
                    System.out.println(String.format("Consumidor par obtem %d", number));
                if(parity == Parity.ODD && number % 2 != 0)
                    System.out.println(String.format("Consumidor impar obtem %d", number));
                Thread.sleep(random.nextInt(100));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
