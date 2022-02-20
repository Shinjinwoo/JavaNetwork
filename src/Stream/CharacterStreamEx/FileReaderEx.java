package Stream.CharacterStreamEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {


        //한글을 바이트 단위 스트림으로로 읽어올 경우 글자가 꺠진다.
        FileInputStream fis = new FileInputStream("reader.txt");
        //리더클래스를 사용하면 문자를 처리하기 용이하다 한글이 깨지지 않는다.
        FileReader fr = new FileReader("reader.txt");

        int i;
        while ((i=fis.read())!= -1) {
            System.out.println((char)i);
        }

        System.out.println("파일읽기 종료");
    }
}
