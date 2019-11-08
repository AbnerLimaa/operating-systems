package question3;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private static Scanner scanner = new Scanner(System.in);
    private static ContaBancaria account1 = new ContaBancaria("1", 1000);
    private static ContaBancaria account2 = new ContaBancaria("2", 1000);
    private static ArrayList<Runnable> operations = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(account1);
        System.out.println(account2);
        System.out.println("Operacoes que serao realizadas nas contas");
        System.out.println("0 - Encerrar");
        System.out.println("1 - Sacar da conta 1");
        System.out.println("2 - Sacar da conta 2");
        System.out.println("3 - Depositar na conta 1");
        System.out.println("4 - Depositar na conta 2");
        System.out.println("5 - Transferir da conta 1 para a conta 2");
        System.out.println("6 - Transferir da conta 2 para a conta 1");
        String operation = "";
        while(!operation.equals("0")) {
            System.out.println("Escolha uma operacao");
            operation = scanner.nextLine();
            switch (operation) {
                case "0":
                    break;
                case "1": operation1();
                    break;
                case "2": operation2();
                    break;
                case "3": operation3();
                    break;
                case "4": operation4();
                    break;
                case "5": operation5();
                    break;
                case "6": operation6();
                    break;
                default: System.out.println("Escolha uma opcao valida");
            }
        }
        for(Runnable task : operations) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    private static void operation1() {
        System.out.println("Informe o valor a ser sacado da conta 1");
        int value = scanner.nextInt();
        operations.add(new Saque(account1, value));
    }

    private static void operation2() {
        System.out.println("Informe o valor a ser sacado da conta 2");
        int value = scanner.nextInt();
        operations.add(new Saque(account2, value));
    }

    private static void operation3() {
        System.out.println("Informe o valor a ser depositado na conta 1");
        int value = scanner.nextInt();
        operations.add(new Deposito(account1, value));
    }

    private static void operation4() {
        System.out.println("Informe o valor a ser depositado na conta 2");
        int value = scanner.nextInt();
        operations.add(new Deposito(account2, value));
    }

    private static void operation5() {
        System.out.println("Informe o valor de transferencia da conta 1 para a conta 2");
        int value = scanner.nextInt();
        operations.add(new Transferencia(account1, account2, value));
    }

    private static void operation6() {
        System.out.println("Informe o valor de transferencia da conta 2 para a conta 1");
        int value = scanner.nextInt();
        operations.add(new Transferencia(account2, account1, value));
    }
}
