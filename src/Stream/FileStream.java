package Stream;

import java.io.*;

public class FileStream {


    public static void main(String[] args) {

        InputStream is = null;
        OutputStream os = null;

        try {

            File f = new File("D:\\Temp\\googlelogo_color_272x92dp.png");

            is = new FileInputStream(f);
            os = new FileOutputStream("./test.png");

            int bufferRead = -1;
            byte[] buffer = new byte[4096];

            while ((bufferRead = is.read(buffer)) != -1) {
                os.write(buffer,0,bufferRead);
            }

            is.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
