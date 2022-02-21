package Stream.CharacterStreamEx;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {


        FileWriter fw = new FileWriter("writer.txt");
        fw.write('A');

        char buffer[] = {'B','C','D','E','F','G'};

        fw.write(buffer);
        fw.write("잘써지나아");
        fw.write(buffer,1,2);
        fw.write("65");

        fw.flush();
        fw.close();

        FileReader fr = new FileReader("writer.txt");

        char buffer2[] = new char[256];

        int i ;
        while((i = fr.read())!= -1){
            System.out.print((char)i);
        }
    }
}
