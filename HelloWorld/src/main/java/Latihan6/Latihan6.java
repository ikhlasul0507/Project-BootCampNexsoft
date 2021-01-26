package Latihan6;

import Latihan5.Main;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Latihan6{
    static Scanner sc = new Scanner(System.in);
    static prosesLatihan6 pl6 = new prosesLatihan6();
    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        boolean pilihan = true;
        while (pilihan) {
            System.out.println("========================================");
            System.out.println("------------------MENU------------------");
            System.out.println("========================================");
            System.out.println("1. Buat Simple Thread (10)");
            System.out.println("2. Buat ThreadPool (10)");
            System.out.println("3. Buat Baca/Tulis (ASC)");
            System.out.println("4. Buat Baca/Tulis (DESC)");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan : ");
            int pil = 0;
            try {
                pil = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Masukkan Angka (1) sampai (5)!");
            }
            sc.nextLine();
            switch (pil) {
                case 1:
                    pl6.simpleThread();
                    break;
                case 2:
                    //
                    for (int i=0; i<5;i++){
                        Runnable worker = new prosesLatihan6();
                        executor.execute(worker);
                    }
                    executor.shutdown();
                    while (!executor.isTerminated()){
                    }
                    break;
                case 3:
                    pl6.bacaTulisAsc();
                    break;
                case 4:
                    pl6.bacaTulisDesc();
                    break;
                case 5:
                    System.out.println("================================================================");
                    System.out.println("----------------------Program Selesai---------------------------");
                    System.out.println("================================================================");
                    pilihan = false;
                    break;

                default:
                    System.out.println("Pilihan Anda Tidak Tersedia");
            }
        }
    }


}
