package question1;

public class Dropbox {

    private static Dropbox instance;
    private int number;

    private Dropbox() {

    }

    public static Dropbox getInstance() {
        if(instance == null)
            instance = new Dropbox();
        return instance;
    }

    public synchronized int take() {
        return number;
    }

    public synchronized void put(int number) {
        this.number = number;
    }
}
