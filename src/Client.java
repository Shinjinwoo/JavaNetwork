import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket sk = new Socket("127.0.0.1",5050);

        ReciveThread reciveThread = new ReciveThread();
        reciveThread.setSoket(sk);

        SendThread sendThread = new SendThread();
        sendThread.setSoket(sk);

        reciveThread.start();
        sendThread.start();
    }
}
