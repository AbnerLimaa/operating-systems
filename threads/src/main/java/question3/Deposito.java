package question3;

public class Deposito implements Runnable {

    private ContaBancaria account;
    private int value;

    public Deposito(ContaBancaria account, int value) {
        this.account = account;
        this.value = value;
    }

    @Override
    public void run() {
        if(value >= 0) {
            Boolean increased = account.increaseBalance(value);
            if(increased)
                System.out.println("Deposito de " + value + " realizado para a conta " + account.getName() + "\n" + account + "\n");
            else
                System.out.println("Nao foi possivel depositar " + value + " na conta " + account.getName() + "\n" + account + "\n");
        }
    }
}
