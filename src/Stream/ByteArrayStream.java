package Stream;

import java.io.*;
import java.util.Arrays;

public class ByteArrayStream {
    public static void main(String[] args) {

        byte[] src = {0,1,2,3};
        byte[] dest = null;

        try {
            InputStream is = new ByteArrayInputStream(src);
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            int bytesRead = -1;
            while ((bytesRead = is.read()) != -1 ){
                os.write(bytesRead);
            }
            dest = os.toByteArray();
            System.out.println(Arrays.toString(dest));

        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
