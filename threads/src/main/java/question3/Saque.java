package question3;

public class Saque implements Runnable {

    private ContaBancaria account;
    private int value;

    public Saque(ContaBancaria account, int value) {
        this.account = account;
        this.value = value;
    }

    @Override
    public void run() {
        if(value >= 0) {
            Boolean decreased = account.decreaseBalance(value);
            if(decreased)
                System.out.println("Saque de " + value + " realizado na conta " + account.getName() + "\n" + account + "\n");
            else
                System.out.println("Nao foi possivel sacar " + value + " da conta " + account.getName() + "\n" + account + "\n");
        }
    }
}
