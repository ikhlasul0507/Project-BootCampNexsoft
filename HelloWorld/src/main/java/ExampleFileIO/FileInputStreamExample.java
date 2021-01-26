package ExampleFileIO;

import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try{
            FileInputStream fin = new FileInputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
            //single
            System.out.println("Ambil Satu Karakter");
            int j = fin.read();
            System.out.println((char)j);
            fin.close();

            fin = new FileInputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
            //semua karakter
            System.out.println("------------------------\nSemua Karakter");
            int i = 0;
            while ((i = fin.read()) !=-1){
                System.out.print((char)i);
            }
            fin.close();
            System.out.println("\nSuccess...");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
