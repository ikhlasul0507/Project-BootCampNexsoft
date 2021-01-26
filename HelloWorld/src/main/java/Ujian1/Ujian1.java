package Ujian1;

import Ujian1.Staff.Staff;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ujian1 {
    static Staff st = new Staff();

    public static void main(String[] args) {
//        st.menuUtama();
        menuLogin();
    }

    static void menuLogin(){

        Scanner sc = new Scanner(System.in);
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Ujian1\\akun" +
                    ".properties"));
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");
            System.out.println("=============================================");
            System.out.println("Username : "+user+"\nPassword : "+pass);
            System.out.println("=============================================");

            System.out.println("-- Program Kelola Data Mahasiswa Sederhana --");
            Boolean aktif = true;
            do {
                System.out.println("Silahkan Login !");
                System.out.println("=====================");

                System.out.print("Username : ");
                String us = sc.nextLine();

                System.out.print("Password : ");
                String pas = sc.nextLine();

                /* Pattern username sesuai dengan email. */
                Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
                Matcher m = p.matcher(us);
                /* Password dengan karakteristik lebih dari 8 character, ada huruf besar dan kecil, memiliki special character */
                Pattern pp = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$");

                Matcher mp = pp.matcher(pas);
                //Matcher mp1 = pas;
                if (!m.matches()) {
                    System.out.println("Username Tidak Sesuai !");
                } else if (!mp.matches()) {
                    System.out.println("Password Tidak Sesuai !");
                } else if ((m.matches() == true) && (mp.matches() == true)) {
                    if (user.equals(us) && pass.equals(pas)) {
                        System.out.println("---Berhasil Login---");
                        st.menuUtama();
                        aktif = false;
                    } else {
                        System.out.println("Username Dan Password Salah !");
                    }
                }

                System.out.println();
            } while (aktif);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
