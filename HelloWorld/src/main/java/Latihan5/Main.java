package Latihan5;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Runnable {
    static ArrayList<Mahasiswa> mahaS = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void run(){
        try {
            urutkanId();
            ambilData();
            cetakData();
        } catch (IOException e) {
            System.out.println("gagal");
            e.printStackTrace();
        }

    }
    public static void menuUtama() throws IOException, InterruptedException {
        boolean pilihan = true;
        while (pilihan) {
            System.out.println("========================================");
            System.out.println("------------------MENU------------------");
            System.out.println("========================================");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Laporan Mahasiswa");
            System.out.println("3. Lihat (Txt)");
            System.out.println("4. Tampil & Export ");
            System.out.println("5. Export");
            System.out.println("6. Keluar");
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
                    inputData();
                    break;
                case 2:
                    tampilCari();
                    break;
                case 3:
                    lihatFile();
                    break;
                case 4:
                    Main main = new Main();
                    Thread thread = new Thread(main);
                    thread.start();
                    thread.join();
                    break;
                case 5:
                    cetakData();
                    break;
                case 6:
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

    public static void cetakData() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\User\\IdeaProjects\\HelloWorld\\Mahasiswa.txt");
        if (mahaS.size() > 0) {
            fw.write("===========================================\n");
            fw.write("-------------DATA MAHASISWA-------------===\n");
            fw.write("===========================================\n");
            fw.write("ID\tNama\tBahasa Inggris\tFisika\tAlgoritma\n");
            fw.write("===========================================\n");
            for (int i = 0; i < mahaS.size(); i++) {
                String tampil = "";
                tampil += mahaS.get(i).getIdMahasiswa() + "\t" + mahaS.get(i).getNama();
                int j = 0;
                for (Nilai n : mahaS.get(i).getNilai()) {
                    if (j == 0) {
                        tampil += "\t\t" + n.getbInggris() + "\t\t" + n.getFisika() + "\t\t" + n.getAlgoritma() + "\n";
                    } else {
                        tampil += " \t\t\t\t" + n.getbInggris() + "\t\t" + n.getFisika() + "\t\t" + n.getAlgoritma() + "\n";
                    }
                    j++;
                }
                fw.write(tampil);
            }
        } else {
            fw.write("DATA KOSONG");
        }
        fw.close();
    }

    public static void lihatFile() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\User\\IdeaProjects\\HelloWorld\\Mahasiswa.txt");
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
        System.out.println();
        fr.close();
    }

    public static int tanyaJumlah() {
        boolean ulangiJumlah = true;
        int jumlah = 0;
        while (ulangiJumlah) {
            System.out.print("Masukkan jumlah data : ");
            try {
                jumlah = sc.nextInt();
                ulangiJumlah = false;
            } catch (Exception e) {
                System.out.println("Masukkan Angka!");
            }
            sc.nextLine();
        }
        return jumlah;

    }

    public static void tampilCari(){
        System.out.print("Masukan ID Mahasiswa : ");
        int idCari = sc.nextInt();
        int hasil_cari = cariID(idCari);
        System.out.println("ID      : " + mahaS.get(hasil_cari).getIdMahasiswa());
        System.out.println("Nama    : " + mahaS.get(hasil_cari).getNama());
        System.out.println("--------------------------------------");
        System.out.println("No\tBahasa Inggris\tFisika\tAlgoritma");
        //ulang data nilaii dari mahasiswa
//        int jml = mahaS.get(index).getNilai().size();
        int nomor = 1;
        for (Nilai n : mahaS.get(hasil_cari).getNilai()) {
            System.out.print((nomor++) + "\t\t" + n.getbInggris() + "\t\t" + n.getFisika() + "\t" + n.getAlgoritma() + "\n");
        }
    }

    public static int cariID(int id) {
        int index = -1;
        int i = 0;
        for (Mahasiswa mhs : mahaS) {
            if (mhs.getIdMahasiswa() == id) {
                index = i;
            }
            i++;
        }
        return index;
    }

    public static void inputData() {
        System.out.println("========================================");
        System.out.println("---------------INPUT DATA---------------");
        System.out.println("========================================");
        int jumlah = tanyaJumlah();
        int i = 0;
        while (i < jumlah) {
            System.out.println("-----------------------------------------");
            System.out.println("Data Mahasiswa Ke-" + (i + 1));
            Mahasiswa mhs = new Mahasiswa();
            boolean tanyaId = true;
            while (tanyaId) {
                System.out.print("ID\t\t: ");
                int id = 0;
                try {
                    id = sc.nextInt();
                    int index = cariID(id);
                    if (index < 0) {
                        mhs.setIdMahasiswa(id);
                        tanyaId = false;
                    } else {
                        System.out.println("ID telah digunakan!");
                    }
                } catch (Exception e) {
                    System.out.println("Masukkan Angka!");
                }
                sc.nextLine();
            }
            System.out.print("Nama\t: ");
            String nama = sc.next();
            mhs.setNama(nama);
            mahaS.add(mhs);
            int indx = mahaS.size() - 1;
            boolean jmlNilai = true;
            int jmlh = 0;
            while (jmlNilai) {
                System.out.print("Masukkan Jumlah Data Nilai : ");
                try {
                    jmlh = sc.nextInt();
                    jmlNilai = false;
                } catch (Exception e) {
                    System.out.println("Masukkan Angka!");
                }
                sc.nextLine();
            }
            for (int j = 0; j < jmlh; j++) {
                Nilai nilai = new Nilai();
                boolean binggris = true;
                while (binggris) {
                    System.out.print("Nilai Bahasa Inggris\t\t: ");
                    try {
                        double inggris = sc.nextDouble();
                        nilai.setbInggris(inggris);
                        binggris = false;
                    } catch (Exception e) {
                        System.out.println("Masukan Angka!");
                    }
                    sc.nextLine();
                }
                boolean fis = true;
                while (fis) {
                    System.out.print("Nilai Fisika\t\t: ");
                    try {
                        double fisika = sc.nextDouble();
                        nilai.setFisika(fisika);
                        fis = false;
                    } catch (Exception e) {
                        System.out.println("Masukan Angka!");
                    }
                    sc.nextLine();
                }
                boolean alg = true;
                while (alg) {
                    System.out.print("Nilai Algoritma\t\t: ");
                    try {
                        double algoritma = sc.nextDouble();
                        nilai.setAlgoritma(algoritma);
                        alg = false;
                    } catch (Exception e) {
                        System.out.println("Masukan Angka!");
                    }
                    sc.nextLine();
                }
                mahaS.get(indx).setNilai(nilai);
            }
            i++;
        }
    }

    public static void ambilData() {
        if (mahaS.size() > 0) {
            System.out.println("========================================");
            System.out.println("-------------DATA MAHASISWA-------------");
            System.out.println("========================================");
            System.out.println("ID\tNama\tBahasa Inggris\tFisika\tAlgoritma");
            for (int i = 0; i < mahaS.size(); i++) {
                String tampil = "";
                tampil += mahaS.get(i).getIdMahasiswa() + "\t" + mahaS.get(i).getNama();
                int j = 0;
                for (Nilai n : mahaS.get(i).getNilai()) {
                    if (j == 0) {
                        tampil += "\t\t" + n.getbInggris() + "\t\t" + n.getFisika() + "\t\t" + n.getAlgoritma() + "\n";
                    } else {
                        tampil += " \t\t\t\t" + n.getbInggris() + "\t\t" + n.getFisika() + "\t\t" + n.getAlgoritma() + "\n";
                    }
                    j++;
                }
                System.out.print(tampil);
            }
        } else {
            System.out.println("DATA KOSONG");
        }
    }

    public static void urutkanId() {
        for (int i = 0; i < mahaS.size(); i++) {
            for (int j = 0; j < mahaS.size() - 1; j++) {
                Mahasiswa tempMahasiswa = mahaS.get(j);
                if (mahaS.get(j).getIdMahasiswa()>mahaS.get(j + 1).getIdMahasiswa()) {
                    mahaS.set(j, mahaS.get(j + 1));
                    mahaS.set(j + 1, tempMahasiswa);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        menuUtama();
    }
}