package Latihan8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SeverUser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(4000);
            Socket s = ss.accept();

            DataInputStream disServer = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String pesan = "", strServer = "";
            while (!strServer.equalsIgnoreCase("stop")) {

                strServer = (String) disServer.readUTF();
                System.out.println("||=> Respon User : " + strServer);

                System.out.print("|| Masukan Pesan Singkat : ");
                pesan = sc.nextLine();
                dout.writeUTF(pesan);
                System.out.println("Berhasil....");
            }
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
