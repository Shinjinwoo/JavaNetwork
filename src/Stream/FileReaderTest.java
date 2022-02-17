package Stream;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) {
        Reader reader = null;

        try{
            reader = new FileReader("./src/txtTest.txt");

            int count = 0;
            int data = -1;
            while( (data = reader.read()) != -1 ){
                count++;
                System.out.print((char)data + " ");
            }
            System.out.println("\n 읽은횟수 : " + count);
        }
        catch (FileNotFoundException e){
            System.out.println("파일 없음");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("I/O 에러");
            e.printStackTrace();
        }
    }
}