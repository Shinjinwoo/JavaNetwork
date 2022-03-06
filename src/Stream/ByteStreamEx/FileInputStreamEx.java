package Stream.ByteStreamEx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = null;
        try {
//            int i ;
//            while ((i=fis.read()) != -1 ) {
//                System.out.println((char) i);
//                System.out.println(i);
//            }

            byte[] buffer = new byte[10];
            int i;

            while ((i = fis.read(buffer)) != -1) {

//                for ( byte b: buffer ){
//                    //기존 자료가 남아있어 마지막 4개의 공간에 데이터가 들어있다
//                    //알파벳 26자 , 사용한 버퍼의 크기 10,10,6 + 앞에서 쓴 버퍼에 잔존한 데이터 4개
//                    System.out.print((char)b + (b + " "));
//                }

                for (int j = 0; j < i; j++) {
                    System.out.println((char) buffer[j] + (" " + buffer[j] + " "));
                    // 배열 전체의 출력이 아닌, 바이트 수만큼 ( i의 개수) 만큼 출력하도록 코드 개선 2022.02.19
                }

                System.out.println(": " + i + "바이트 읽음");
            }

            System.out.println("인풋스트림 종료");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
    }
}
