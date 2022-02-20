package Stream.SubStream;

import java.io.*;

public class BufferdStreamEx {

    public static void main(String[] args) throws IOException {

        long millisecond = 0;

        FileInputStream fis = new FileInputStream("testZip.zip");
        FileOutputStream fos = new FileOutputStream("copyTestZip.zip");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        boolean useBuffer = true;
        if (useBuffer) {

            int bufferReader;

            while ((bufferReader = bis.read()) != -1) {
                bos.write(bufferReader);
            }

            System.out.println("파일을 복사 소요시간 : " + millisecond);

        } else {

            millisecond = System.currentTimeMillis();

            int bufferReader;

            while ((bufferReader = fis.read()) != -1) {
                fos.write(bufferReader);
            }

            System.out.println("파일을 복사 소요시간 : " + millisecond);
        }
    }
}
