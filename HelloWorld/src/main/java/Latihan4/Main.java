package Latihan4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<Mahasiswa> mahaS = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    Properties user = new Properties();

    public static void login() {
        Scanner sc = new Scanner(System.in);
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Latihan4\\user" +
                    ".properties"));
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");

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
                //Pattern pp = Pattern.compile("^.(?=.{8,})(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=]).*$");
//                Pattern pp = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
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
                        menuUtama();
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

    public static void menuUtama() {
        boolean pilihan = true;
        while (pilihan) {
            System.out.println("========================================");
            System.out.println("------------------MENU------------------");
            System.out.println("========================================");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Sunting Data Mahasiswa");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Tampilkan Laporan Mahasiswa");
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
                    inputData();
                    break;
                case 2:
                    tampilData();
                    ganti();
                    break;
                case 3:
                    tampilData();
                    hapus();
                    break;
                case 4:
                    urutkanNama();
                    tampilData();
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

    public static void ambilNilaiMahasiswa(int index) {
        System.out.println("ID      : " + mahaS.get(index).getIdMahasiswa());
        System.out.println("Nama    : " + mahaS.get(index).getNama());
        System.out.println("---------------------------------------------");
        System.out.println("No\tBahasa Inggris\tFisika\tAlgoritma");
        //ulang data nilaii dari mahasiswa
//        int jml = mahaS.get(index).getNilai().size();
        int nomor = 1;
        for (Nilai n : mahaS.get(index).getNilai()) {
            System.out.print((nomor++) + "\t\t" + n.getbInggris() + "\t\t" + n.getFisika() + "\t" + n.getAlgoritma() + "\n");
        }
    }

    public static void ganti() {
        boolean gantiData = true;
        int idEdit = 0;
        while (gantiData) {
            System.out.print("Masukkan ID yang ingin diganti : ");
            try {
                idEdit = sc.nextInt();
                gantiData = false;
            } catch (Exception e) {
                System.out.println("Masukkan Angka!");
            }
        }
        int hasilCari = cariID(idEdit);
        if (hasilCari >= 0) {
            System.out.print("Masukkan Nama Baru : ");
            String nama = sc.next();
            mahaS.get(hasilCari).setNama(nama);
            boolean rubah = true;
            char pilih = 0;
            while (rubah) {
                System.out.print("Apakah Anda ingin merubah data nilai ?? (Y/N)... ");
                pilih = sc.next().charAt(0);
                if (pilih == 'Y' || pilih == 'y') {
                    ambilNilaiMahasiswa(hasilCari);
                    int indexNilai;
                    while (true) {
                        System.out.print("Pilih no nilai : ");
                        try {
                            indexNilai = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Masukkan Angka");
                        }
                    }
                    int cariNilaii = cariNilai(mahaS.get(hasilCari).getNilai().size(), (indexNilai - 1));
                    if (cariNilaii >= 0) {
                        Nilai newNilai = new Nilai();
                        double inggris;
                        while (true) {
                            System.out.print("Nilai Bahasa Inggris  : ");
                            try {
                                inggris = sc.nextDouble();
                                break;
                            } catch (Exception e) {
                                System.out.println("Masukkan Angka!");
                            }
                        }
                        double fisika;
                        while (true) {
                            System.out.print("Nilai Fisika          : ");
                            try {
                                fisika = sc.nextDouble();
                                break;
                            } catch (Exception e) {
                                System.out.println("Masukkan Angka !!");
                            }
                        }
                        double algoritma;
                        while (true) {
                            System.out.print("Nilai Algoritma       : ");
                            try {
                                algoritma = sc.nextDouble();
                                break;
                            } catch (Exception e) {
                                System.out.println("Masukkan Angka!");
                            }
                        }
                        newNilai.setAlgoritma(algoritma);
                        newNilai.setFisika(fisika);
                        newNilai.setbInggris(inggris);
                        mahaS.get(hasilCari).getNilai().set(cariNilaii, newNilai);
                        rubah = false;
                    } else {
                        System.out.println("Data tidak tersedia!");
                    }
                } else if (pilih == 'N' || pilih == 'n') {
                    rubah = false;
                } else {
                    System.out.println("Data yang anda masukkan tidak valid");
                }
            }
            System.out.println("Data berhasil dirubah.....");
        } else {
            System.out.println("Data Tidak Di Temukan !");
        }
    }

    public static int cariNilai(int size, int indx) {
        int index = -1;
        if (indx >= 0) {
            if (indx < size) {
                index = indx;
            }
        }
        return index;
    }

    public static void hapus() {
        boolean hps = true;
        while (hps) {
            System.out.print("Masukkan ID yang ingin dihapus : ");
            try {
                int idhapus = sc.nextInt();
                int hasilCari = cariID(idhapus);
                if (hasilCari >= 0) {
                    mahaS.remove(hasilCari); // problem is here
                    System.out.println("Data Berhasil Dihapus!");
                    hps = false;
                } else {
                    System.out.println("Data Tidak Di Temukan!");
                }
            } catch (Exception e) {
                System.out.println("Masukan Angka!");
            }
            sc.nextLine();
        }
    }

    public static void tampilData() {
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

    public static void urutkanNama() {
        for (int i = 0; i < mahaS.size(); i++) {
            for (int j = 0; j < mahaS.size() - 1; j++) {
                Mahasiswa tempMahasiswa = mahaS.get(j);
                if (mahaS.get(j).getNama().compareTo(mahaS.get(j + 1).getNama()) > 0) {
                    mahaS.set(j, mahaS.get(j + 1));
                    mahaS.set(j + 1, tempMahasiswa);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        login();
    }
}
