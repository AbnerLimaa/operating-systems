import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProgramServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Constants.port);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = dataInputStream.readUTF();
            String oldMessage = "";
            while(!message.equals(Constants.EXIT)) {
                if(!oldMessage.equals(message))
                    System.out.println(message);
                oldMessage = message;
                message = dataInputStream.readUTF();
            }
            System.out.println("Servidor será desligado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
