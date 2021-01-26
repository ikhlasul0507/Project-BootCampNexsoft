package ExampleFileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class TestBufferedWriter {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileWriter writer = new FileWriter("C:\\Users\\User\\IdeaProjects\\HelloWorld\\test.txt");
        BufferedWriter buffer = new BufferedWriter(writer);

        System.out.print("Masukan Nama Anda :");
        String nama = sc.next();
        buffer.write("-----------------------------\nWelcome "+nama+"\n---------------------------");
        buffer.close();
        System.out.println("Success...");
    }
}
