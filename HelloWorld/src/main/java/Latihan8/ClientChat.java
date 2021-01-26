package Latihan8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Socket s = new Socket("192.168.0.12",4000);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String pesan ="", str="";
            while (!pesan.equalsIgnoreCase("stop")) {

                System.out.print("|| Masukan Pesan Singkat : ");
                pesan = sc.nextLine();
                dout.writeUTF(pesan);
                System.out.println("Berhasil....");
                str = (String) dis.readUTF();
                System.out.println("||=> Respon Server : " + str);
                dout.flush();
            }
            dout.close();
            s.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
