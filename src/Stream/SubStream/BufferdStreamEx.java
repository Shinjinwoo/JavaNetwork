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


            millisecond = System.currentTimeMillis();
            int bufferReader;

            while ((bufferReader = bis.read()) != -1) {
                bos.write(bufferReader);
            }

            millisecond = System.currentTimeMillis() - millisecond;
            System.out.println("파일을 복사 소요시간 : " + ((float)millisecond/1000));

        } else {

            millisecond = System.currentTimeMillis();
            int bufferReader;

            while ((bufferReader = fis.read()) != -1) {
                fos.write(bufferReader);
            }


            millisecond = System.currentTimeMillis() - millisecond;
            System.out.println("파일을 복사 소요시간 : " + (millisecond)/1000);
        }
    }
}
