import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {
    public static void main(String[] args) {
        String question = "";
        try (Socket socket = new Socket()){
         socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),8080));
         PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("server data");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String currentString = "";
            for (; (currentString = bufferedReader.readLine()) != null; ) {
                question = question+currentString +"\n";

            }
            System.out.println(question);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
