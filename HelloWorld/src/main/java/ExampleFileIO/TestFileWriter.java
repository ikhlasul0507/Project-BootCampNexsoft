package ExampleFileIO;

import java.io.FileWriter;

public class TestFileWriter {
    public static void main(String[] args) {
        try{
            FileWriter fw = new FileWriter("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
            fw.write("Selamat Datang Ikhlasul");
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Success....");
    }
}
