package question3;

public class ContaBancaria {

    private String name;
    private int balance;

    public ContaBancaria(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "a conta " + name + " possui " + balance + " de saldo";
    }

    public synchronized Boolean increaseBalance(int value) {
        balance += value;
        return true;
    }

    public synchronized Boolean decreaseBalance(int value) {
        if(value <= balance)
            balance -= value;
        return value <= balance;
    }

    public synchronized Boolean transfer(ContaBancaria account, int value) {
        Boolean decreased = decreaseBalance(value);
        Boolean increased = true;
        if(decreased)
            increased = account.increaseBalance(value);
        return decreased && increased;
    }
}
