package question1;

import java.util.Random;

public class Producer implements Runnable {

    private Dropbox dropbox;

    public Producer() {
        this.dropbox = Dropbox.getInstance();
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            while (true) {
                int number = random.nextInt(10);
                Thread.sleep(random.nextInt(100));
                dropbox.put(number);
                System.out.println(String.format("Produtor gera %d", number));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
