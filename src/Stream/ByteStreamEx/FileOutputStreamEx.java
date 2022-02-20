package Stream.ByteStreamEx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream("output2.txt");

        try {
            byte[] buffer = new byte[26];
            byte data = 65; // 대문자 'A'의 아스키코드 값

            for (int i=0; i<buffer.length; i++) {
                buffer[i] = data;
                data++;
            }
            fos.write(buffer); //전체 바이트 배열을 한번에 출력

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
