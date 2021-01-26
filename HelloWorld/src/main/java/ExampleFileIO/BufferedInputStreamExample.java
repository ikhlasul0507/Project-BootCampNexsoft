package ExampleFileIO;

import java.io.*;

public class BufferedInputStreamExample {
    public static void main(String[] args){
        try {
            FileInputStream find = new FileInputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
            BufferedInputStream bin = new BufferedInputStream(find);
            int i;
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
            bin.close();
            find.close();
            System.out.println("\nSuccess...");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
