package ExampleFileIO;

import java.io.*;

public class TestInputConsole {
    public static void main(String[] args) throws Exception {
        InputStreamReader r =new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.print("Enter Your Name :");
        String name = br.readLine();
        System.out.println("Selamat Datang "+name);
        //metode 2
        String nama="";
        while (!nama.equalsIgnoreCase("stop")){
            System.out.print("Enter Data :");
            nama = br.readLine();
            System.out.println("Data Is : "+nama);
        }
        br.close();
        r.close();
    }
}
