import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {

    private Socket mSoket;

    @Override
    public void run() {
        super.run();

        try{

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter sendWriter = new PrintWriter(mSoket.getOutputStream());
            String sendString;

            while (true)
            {
                sendString = bufferedReader.readLine();

                if (sendString.equals("exit"))
                {
                    break;
                }

                sendWriter.println(sendString);
                sendWriter.flush();
            }

            sendWriter.close();
            bufferedReader.close();
            mSoket.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSoket (Socket socket){
        mSoket = socket;
    }
}
