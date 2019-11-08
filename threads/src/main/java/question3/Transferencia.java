package question3;

public class Transferencia implements Runnable {

    private ContaBancaria account1;
    private ContaBancaria account2;
    private int value;

    public Transferencia(ContaBancaria account1, ContaBancaria account2, int value) {
        this.account1 = account1;
        this.account2 = account2;
        this.value = value;
    }

    @Override
    public void run() {
        if(value >= 0) {
            Boolean transfer = account1.transfer(account2, value);
            if(transfer)
                System.out.println("Transferencia de " + value + " realizada da conta " + account1.getName() + " para a conta " + account2.getName() + "\n" + account1 + "\n" + account2 + "\n");
            else
                System.out.println("Nao foi possivel transferir " + value + " da conta " + account1.getName() + " para a conta " + account2.getName() + "\n" + account1 + "\n" + account2 + "\n");
        }
    }

}
