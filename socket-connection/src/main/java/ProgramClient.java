import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ProgramClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("localhost", Constants.port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String message = "";
            while(!message.equals(Constants.EXIT)) {
                System.out.println("Digite uma mensagem");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            }
            dataOutputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
