import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        //서버 소켓을 생성
        ServerSocket ssk = new ServerSocket(5050);

        System.out.println("접속 대기");

         //실제로 송신을 하는것은 바로 저 sock 이라는 변수이다.
            Socket sock = ssk.accept();

            System.out.println("사용자 접속 했습니다");
            System.out.println("Client ip :"+ sock.getInetAddress());

            ReciveThread reciveThread = new ReciveThread();
            reciveThread.setSoket(sock);

            SendThread sendThread = new SendThread();
            sendThread.setSoket(sock);

            reciveThread.start();
            sendThread.start();


    }
}