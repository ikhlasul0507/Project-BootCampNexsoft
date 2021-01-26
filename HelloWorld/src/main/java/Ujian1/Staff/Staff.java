package Ujian1.Staff;
import Ujian1.Worker.Worker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Staff extends Worker implements Runnable {
    private int tunjanganMakan = 220000;
    private int tunjanganTransport = 440000;
    private int totalGaji;
    private int absensi, cuti, izin;
    Scanner sc = new Scanner(System.in);
    LinkedList<Staff> st = new LinkedList<>();
    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public Staff(int id, String nama, int gajiPokok, int absensi, int cuti, int izin, int jumlahCuti, int jumlahIzin) {
        super(id, nama, gajiPokok, absensi, cuti, izin, jumlahCuti, jumlahIzin);
    }

    public Staff() {
        super();
    }

    public int getAbsensi() {
        return absensi;
    }

    public int getCuti() {
        return cuti;
    }

    public int getIzin() {
        return izin;
    }

    @Override
    public void setAbsen() {
        absensi++;
    }

    @Override
    public void setCuti() {
        cuti++;
    }

    @Override
    public void setIzin() {
        izin++;
    }


    public int getTotalGaji() {
        return totalGaji;
    }

    public void setTotalGaji(int totalGaji) {
        this.totalGaji = getAbsensi();
    }

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }

    public int getHitungTunjanganMakan() {
        return tunjanganMakan = tunjanganMakan - tunjanganMakan - ((tunjanganMakan / 22));
    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public int getTunjanganTransport() {
        return tunjanganTransport;
    }

    public int getHitungTunjanganTransport() {
        return tunjanganTransport = tunjanganTransport - tunjanganTransport - ((tunjanganTransport / 22));
    }

    public void setTunjanganTransport(int tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }


    //menu utama
    public void menuUtama() {
        hasilBacaFile();
        boolean pilihan = true;
        while (pilihan) {
            System.out.println("========================================");
            System.out.println("------------------MENU------------------");
            System.out.println("========================================");
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Edit Data Karyawan");
            System.out.println("3. Absensi Karyawan");
            System.out.println("4. Izin Karyawan");
            System.out.println("5. Cuti Karyawan");
            System.out.println("6. Hitung Total Gaji Karyawan");
            System.out.println("7. Laporan Per Karyawan");
            System.out.println("8. Laporan Karyawan & Export Data");
            System.out.println("9. Keluar");
            System.out.println("========================================");
            System.out.print("Masukkan Pilihan : ");
            int pil = 0;
            try {
                pil = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Masukkan Angka (1) sampai (8)!");
            }
            sc.nextLine();
            switch (pil) {
                case 1:
                    //input data karyawan
                    inputData();
                    break;
                case 2:
                    //edit data karyawan
                    ganti();
                    break;
                case 3:
                    //absensi data karyawan
                    absensiKaryawan();
                    break;
                case 4:
                    //izin karyawan
                    izinKaryawan();
                    break;
                case 5:
                    //cuti karyawan
                    cutiKaryawan();
                    break;
                case 6:
                    //hitung total gaji karyawan
                    totalgajiKaryawan();
                    break;
                case 7:
                    //laporan per karyawan
                    laporanGajiPerKaryawan();
                    break;
                case 8:
                    //laporan data karyawan & tulis data
                    //
                    for (int i = 0; i < 5; i++) {
                        Runnable worker = new Staff();
                        executor.execute(worker);
                    }
                    executor.shutdown();
                    while (!executor.isTerminated()) {
                    }
                    LaporanKaryawan();
                    tulisfFile();
                    break;
                case 9:
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

    @Override
    public void run() {
        LaporanKaryawan();
        tulisfFile();
    }

    //hasil baca file
    public void hasilBacaFile() {
        String fileName = "C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Ujian1\\Karyawan.txt";
        String line = "";
        String separator = ",";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] parsingFile = line.split(separator);
                String id = parsingFile[0];
                int idhasil = Integer.parseInt(id);
                String nama = parsingFile[1];
                String gajiPokok = parsingFile[2];
                int gajiHasil = Integer.parseInt(gajiPokok);
                setGajiPokok(gajiHasil);
                st.add(new Staff(idhasil, nama, gajiHasil, 0, 0, 0, 0, 0));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //buat karyawan
    public void inputData() {
        System.out.print("Masukan Jumlah Data : ");
        int jml = sc.nextInt();
        for (int i = 0; i < jml; i++) {
            System.out.print("ID Karyawan : ");
            int idk = sc.nextInt();
            setId(idk);
            System.out.print("Nama Karyawan : ");
            String nmk = sc.next();
            setNama(nmk);
            System.out.print("Gaji Pokok : ");
            int gjk = sc.nextInt();
            setGajiPokok(gjk);
            st.add(new Staff(idk, nmk, gjk, 0, 0, 0, 0, 0));
            System.out.println("-----------------------------");
        }
    }

    //ganti karyawan
    public void ganti() {
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
            int idk = idEdit;
            setId(idk);
            System.out.print("Nama Karyawan : ");
            String nmk = sc.next();
            setNama(nmk);
            System.out.print("Gaji Pokok : ");
            int gjk = sc.nextInt();
            setGajiPokok(gjk);
            st.set(hasilCari, new Staff(idk, nmk, gjk, 0, 0, 0, 0, 0));
            System.out.println("-----------------------------");
            System.out.println("Data berhasil dirubah.....");
        } else {
            System.out.println("Data Tidak Di Temukan !");
        }
    }
    //cari id karyawan
    public int cariID(int id) {
        int index = -1;
        int i = 0;
        for (Staff st1 : st) {
            if (st1.getId() == id) {
                index = i;
            }
            i++;
        }
        return index;
    }

    //cari nama karyawan
    public int cariNama(String nama) {
        int index = -1;
        int i = 0;
        for (Staff st1 : st) {
            if (st1.getNama().equalsIgnoreCase(nama)) {
                index = i;
            }
            i++;
        }
        return index;
    }

    //menu absensi karyawan
    public void absensiKaryawan() {
        System.out.println("1. ID\n2. Nama");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                LaporanKaryawanIdNama();
                absensiKaryawanID();
                break;
            case 2:
                LaporanKaryawanIdNama();
                absensiKaryawanNama();
                break;
            default:
                break;
        }
    }

    //absensi karyawan ID
    public void absensiKaryawanID() {
        System.out.print("Pilih ID Karyawan : ");
        int pilih = sc.nextInt();
        int i = 0;
        int hasilCari = cariID(pilih);
        if (hasilCari >= 0) {
            if (st.get(hasilCari).getAbsensi() < 20) {
                st.get(hasilCari).setAbsen();
                System.out.println("Berhasil Absen !");
            } else {
                System.out.println("Absen Terpenuhi !");
            }
        } else {
            System.out.println("Data Tidak Di Temukan !");
            absensiKaryawan();
        }
    }

    //absensi karyawan Nama
    public void absensiKaryawanNama() {
        System.out.print("Pilih Nama Karyawan : ");
        String pilih = sc.next();
        int hasilCari = cariNama(pilih);
        if (hasilCari >= 0) {
            if (st.get(hasilCari).getAbsensi() < 20) {
                st.get(hasilCari).setAbsen();
                System.out.println("Berhasil Absen !");
            } else {
                System.out.println("Absen Terpenuhi !");
            }
        }
    }

    //menu izin karyawan
    public void izinKaryawan() {
        System.out.println("1. ID\n2. Nama");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                LaporanKaryawanIdNama();
                izinKaryawanID();
                break;
            case 2:
                LaporanKaryawanIdNama();
                izinKaryawanNama();
                break;
            default:
                break;
        }
    }

    //izin karyawan ID
    public void izinKaryawanID() {
        System.out.print("Pilih ID Karyawan : ");
        int pilih = sc.nextInt();
        int i = 0;
        int hasilCari = cariID(pilih);
        if (hasilCari >= 0) {
            st.get(hasilCari).setIzin();
            System.out.println("Berhasil Izin !");
        } else {
            System.out.println("Data Tidak Di Temukan !");
            izinKaryawan();
        }
    }

    //izin karyawan Nama
    public void izinKaryawanNama() {
        System.out.print("Pilih Nama Karyawan : ");
        String pilih = sc.next();
        int hasilCari = cariNama(pilih);
        if (hasilCari >= 0) {
            st.get(hasilCari).setIzin();
            System.out.println("Berhasil Izin !");
        } else {
            System.out.println("Data Tidak Di Temukan !");
            izinKaryawan();
        }
    }

    //menu cuti karyawan
    public void cutiKaryawan() {
        System.out.println("1. ID\n2. Nama");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                LaporanKaryawanIdNama();
                cutiKaryawanID();
                break;
            case 2:
                LaporanKaryawanIdNama();
                cutiKaryawanNama();
                break;
            default:
                break;
        }
    }

    //cuti karyawan ID
    public void cutiKaryawanID() {
        System.out.print("Pilih ID Karyawan : ");
        int pilih = sc.nextInt();
        int i = 0;
        int hasilCari = cariID(pilih);
        if (hasilCari >= 0) {
            st.get(hasilCari).setCuti();
            System.out.println("Berhasil Cuti !");
        } else {
            System.out.println("Data Tidak Di Temukan !");
            cutiKaryawan();
        }
    }

    //cuti karyawan Nama
    public void cutiKaryawanNama() {
        System.out.print("Pilih Nama Karyawan : ");
        String pilih = sc.next();
        int hasilCari = cariNama(pilih);
        if (hasilCari >= 0) {
            st.get(hasilCari).setCuti();
            System.out.println("Berhasil Cuti !");
        } else {
            System.out.println("Data Tidak Di Temukan !");
            cutiKaryawan();
        }
    }

    //totalgajiKaryawan
    public void totalgajiKaryawan() {
        System.out.println("1. Per Karyawan\n2. Seluruh");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                totalGajiPerkaryawan();
                break;
            case 2:
                totalGajiSeluruhKaryawan();
                break;
            default:
                break;
        }
    }

    //totalgaji per karyawan
    public void totalGajiPerkaryawan() {
        System.out.print("Masukan ID Karyawan : ");
        int idCari = sc.nextInt();
        int hasil_cari = cariID(idCari);
        int totalG = st.get(hasil_cari).getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
        System.out.println("==========================");
        System.out.println("ID          : " + st.get(hasil_cari).getId());
        System.out.println("Nama        : " + st.get(hasil_cari).getNama());
        System.out.println("Total Gaji  : Rp." + totalG);
        System.out.println("==========================");
    }

    //totalgaji semua karyawan
    public void totalGajiSeluruhKaryawan() {
        Iterator itr2 = st.iterator();
        System.out.println("=================================================================");
        System.out.println("Data Gaji Karyawan ->");
        System.out.println("=================================================================");
        while (itr2.hasNext()) {
            Staff stk = (Staff) itr2.next();
            int tanpaKabar = 22 - (stk.getAbsensi() + stk.getCuti());
            int totalG = getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
            System.out.println("ID : " + stk.getId() +
                    "\n| Nama        :" + stk.getNama() +
                    "\n| Gaji Pokok  :Rp. " + totalG +
                    "\n-------------------------");
        }
        System.out.println("=================================================================");

    }

    //laporan per karyawan
    public void laporanGajiPerKaryawan() {
        System.out.println("1. ID \n2. Nama");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                laporanGajiPerKaryawanId();
                break;
            case 2:
                laporanGajiPerKaryawanNama();
                break;
            default:
                break;
        }
    }

    //laporan gaji perkaryawan by id
    public void laporanGajiPerKaryawanId() {
        System.out.print("Pilih ID Karyawan : ");
        int pilih = sc.nextInt();
        int hasilCari = cariID(pilih);
        if (hasilCari >= 0) {
            int tanpakabar =
                    22 - (st.get(hasilCari).getAbsensi() - st.get(hasilCari).getCuti() - st.get(hasilCari).getIzin());
            int totalG = st.get(hasilCari).getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
            System.out.println("==========================");
            System.out.println("ID          : " + st.get(hasilCari).getId());
            System.out.println("Nama        : " + st.get(hasilCari).getNama());
            System.out.println("Absensi     : " + st.get(hasilCari).getAbsensi());
            System.out.println("Cuti        : " + st.get(hasilCari).getCuti());
            System.out.println("Izin        : " + st.get(hasilCari).getIzin());
            System.out.println("Tanpa Kabar : " + tanpakabar);
            System.out.println("Total Gaji  : Rp." + totalG);
            System.out.println("==========================");
        } else {
            System.out.println("Data Tidak Di Temukan !");
            laporanGajiPerKaryawan();
        }
    }

    //laporan gaji perkaryawan by id
    public void laporanGajiPerKaryawanNama() {
        System.out.print("Pilih Nama Karyawan : ");
        String pilih = sc.next();
        int hasilCari = cariNama(pilih);
        if (hasilCari >= 0) {
            int tanpakabar =
                    22 - (st.get(hasilCari).getAbsensi() - st.get(hasilCari).getCuti() - st.get(hasilCari).getIzin());
            int totalG = st.get(hasilCari).getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
            System.out.println("==========================");
            System.out.println("ID          : " + st.get(hasilCari).getId());
            System.out.println("Nama        : " + st.get(hasilCari).getNama());
            System.out.println("Absensi     : " + st.get(hasilCari).getAbsensi());
            System.out.println("Cuti        : " + st.get(hasilCari).getCuti());
            System.out.println("Izin        : " + st.get(hasilCari).getIzin());
            System.out.println("Tanpa Kabar : " + tanpakabar);
            System.out.println("Total Gaji  : Rp." + totalG);
            System.out.println("==========================");
        } else {
            System.out.println("Data Tidak Di Temukan !");
            laporanGajiPerKaryawan();
        }
    }

    //tulisfile ke laporan karyawan
    public void tulisfFile() {
        System.out.println("Tulis File LaporanKaryawan.text");
        System.out.println("Success......");
        try {
            FileWriter fw = new FileWriter("C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Ujian1" +
                    "\\LaporanKaryawan.txt");
            Iterator itr2 = st.iterator();
            fw.write("=================================================\n");
            fw.write("ID\tNama\tJm Absen\tJm Cuti\tJm Alfa\tTotal Gaji\n");
            fw.write("=================================================\n");
            while (itr2.hasNext()) {
                Staff stk = (Staff) itr2.next();
                int tanpaKabar = 22 - (stk.getAbsensi() + stk.getJumlahCuti());
                int totalG = stk.getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
                fw.write(stk.getId() +
                        "\t" + stk.getNama() +
                        "\t\t" + stk.getAbsensi() +
                        "\t\t" + stk.getJumlahCuti() +
                        "\t\t" + tanpaKabar +
                        "\t\t" + totalG + "\n");
            }
            fw.write("================================================\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //laporan karyawan
    public void LaporanKaryawan() {
        Iterator itr2 = st.iterator();
        System.out.println("=================================================================");
        System.out.println("Laporan Data Karyawan ->");
        System.out.println("=================================================================");
        while (itr2.hasNext()) {
            Staff stk = (Staff) itr2.next();
            int tanpaKabar = 22 - (stk.getAbsensi() + stk.getCuti());
            int totalG = stk.getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
            System.out.println("ID : " + stk.getId() +
                    "\n| Nama        :" + stk.getNama() +
                    "\n| Absensi     :" + stk.getAbsensi() +
                    "\n| Cuti        :" + stk.getCuti() +
                    "\n| Izin        :" + stk.getIzin() +
                    "\n| Tanpa Kabar :" + tanpaKabar +
                    "\n| Gaji Pokok  :" + totalG +
                    "\n-------------------------");
        }
        System.out.println("=================================================================");

    }
    public void LaporanKaryawanIdNama() {
        Iterator itr2 = st.iterator();
        System.out.println("=================================================================");
        System.out.println("Laporan Data Karyawan ->");
        System.out.println("=================================================================");
        while (itr2.hasNext()) {
            Staff stk = (Staff) itr2.next();
            int tanpaKabar = 22 - (stk.getAbsensi() + stk.getCuti());
            int totalG = stk.getGajiPokok()+getHitungTunjanganMakan()+getHitungTunjanganTransport();
            System.out.println("ID : " + stk.getId() +
                    "\n| Nama        :" + stk.getNama() +
                    "\n-------------------------");
        }
        System.out.println("=================================================================");

    }


}
