package Stream.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx1 {

    public static void main(String[] args) {


        java.io.FileInputStream fis = null;

        try {

            fis = new FileInputStream("input.txt");

            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());

        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            }catch (IOException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }

        System.out.println("종료");
    }
}
