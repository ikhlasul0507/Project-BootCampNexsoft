package ExampleFileIO;

import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try{
            FileOutputStream fout = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
//            fout.write(65);
            String s = "Saya Lapar";
            byte b[]=s.getBytes();//convert string into byte array
            fout.write(b);
            fout.close();
            System.out.println("Success...");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
