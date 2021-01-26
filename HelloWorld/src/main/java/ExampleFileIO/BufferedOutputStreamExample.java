package ExampleFileIO;

import java.io.*;

public class BufferedOutputStreamExample {
    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String s ="Welcome Ikhlasul Amal";
        byte b[] = s.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("Success...");
    }
}
