import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReciveThread extends Thread {

    private Socket mSoket;

    @Override
    public void run() {
        super.run();

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mSoket.getInputStream()));
            String receiveString;

            while (true) {
                receiveString = bufferedReader.readLine();

                if (receiveString == null) {
                    System.out.println("상대방 연결이 끊어졌습니다.");
                    break;
                } else {

                    System.out.println("상대방 : " + receiveString);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSoket(Socket socket) {
        mSoket = socket;
    }
}
