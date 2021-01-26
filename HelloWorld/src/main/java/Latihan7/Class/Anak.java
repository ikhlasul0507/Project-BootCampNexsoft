package Latihan7.Class;

import Latihan7.Interface.Ayah;
import Latihan7.Interface.Ibu;

import java.util.Scanner;

public class Anak implements Ayah, Ibu {
    Scanner sc = new Scanner(System.in);

    public void namaAnak() {
        System.out.println("||-----------------------------------");
        System.out.print("|| Input Nama Anak  :");
        String namaAnak = sc.next();
        System.out.print("|| Input Sifat Anak :");
        String sifatAnak = sc.next();
        System.out.print("|| Input Nama Kakek :");
        String namaKakek = sc.next();
        System.out.print("|| Input Nama Ayah  :");
        String namaAyah = sc.next();
        System.out.print("|| Input Sifat Ayah :");
        String sifatAyah = sc.next();
        System.out.print("|| Input Nama Ibu   :");
        String namaIbu = sc.next();
        System.out.print("|| Input Sifat Ibu  :");
        String sifatIbu = sc.next();


        System.out.println("||-----------------------------------");
        System.out.println("|| HASIL DATA");
        System.out.println("||-----------------------------------");
        System.out.println("||=> Nama Anak    : " + namaAnak);
        sifatAnak(sifatAnak);
        namaKakek(namaKakek);
        namaAyah(namaAyah);
        sifatAyah(sifatAyah);
        namaIbu(namaIbu);
        sifatIbu(sifatIbu);
        System.out.println("||-----------------------------------");

    }

    public void sifatAnak(String sifatAnak) {
        System.out.println("||=> Sifat        : " + sifatAnak);
    }

    public void namaKakek(String namaKakek) {
        System.out.println("||=> Nama Kakek   : " + namaKakek);
    }

    public void namaAyah(String namaAyah) {
        System.out.println("||=> Nama Ayah    : " + namaAyah);
    }

    public void sifatAyah(String sifatAyah) {
        System.out.println("||=> Sifat Ayah   : " + sifatAyah);
    }

    public void namaIbu(String namaIbu) {
        System.out.println("||=> Nama Ibu     : " + namaIbu);
    }

    public void sifatIbu(String sifatIbu) {
        System.out.println("||=> Sifat Ibu    : " + sifatIbu);
    }
}
