package Stream.SubStream;

import java.io.*;

public class InputStreamReaderEx {
    public static void main(String[] args) throws IOException {


        InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"));

        int bufferReader;


        while ((bufferReader = isr.read())!=-1) {
            System.out.println((char)bufferReader);
        }
    }
}
