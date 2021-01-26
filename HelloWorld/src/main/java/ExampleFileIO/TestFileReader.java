package ExampleFileIO;

import java.io.FileReader;

public class TestFileReader {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
        int i;

        while ((i= fr.read())!=-1)
            System.out.print((char)i);
            fr.close();
    }
}
