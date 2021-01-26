import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Worker1 {
    private int idKaryawan;
    private String namaKaryawan;
    private int tunjanganPulsa;
    private int gajiPokok;
    int absen;

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public int getTunjanganPulsa() {
        return tunjanganPulsa;
    }

    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public void setAbsen() {
        absen++;
    }

    public Worker1(int idKaryawan, String namaKaryawan, int tunjanganPulsa, int gajiPokok, int absen) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.tunjanganPulsa = tunjanganPulsa;
        this.gajiPokok = gajiPokok;
        this.absen = absen;
    }
}

class Staff1 extends Worker1 {

    private int tunjanganMakan;
    private int absen;

    public Staff1(int idKaryawan, String namaKaryawan, int gajiPokok,int tunjanganPulsa,  int tunjanganMakan, int absen) {
        super(idKaryawan, namaKaryawan, tunjanganPulsa, gajiPokok, absen);
        this.tunjanganMakan = tunjanganMakan;
        this.absen = absen;
    }

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }
    public int hitungTunjanganMakan(){
        return tunjanganMakan * 20000 * getAbsen();
    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }


    public int getAbsen() {
        return absen;
    }

    public void setAbsen() {
        absen++;
    }

}

class Manager extends Worker1 {
    private int tunjanganTransport;
    private int tunjanganEntertaint;
    int absen;
    public Manager(int idKaryawan, String namaKaryawan, int gajiPokok, int tunjanganPulsa, int tunjanganTransport,
                   int tunjanganEntertaint, int absen) {
        super(idKaryawan, namaKaryawan, tunjanganPulsa, gajiPokok, absen);
        this.tunjanganTransport = tunjanganTransport;
        this.tunjanganEntertaint = tunjanganEntertaint;
        this.absen = absen;
    }
    public int getAbsen() {
        return absen;
    }

    public void setAbsen() {
        absen++;
    }

    public int getTunjanganTransport() {
        return tunjanganTransport;
    }
    public int hitungTunjanganTransport(){
        return tunjanganTransport * 50000 * getAbsen();
    }

    public void setTunjanganTransport(int tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }

    public int getTunjanganEntertaint() {
        if (tunjanganEntertaint==1) {
            return 0;
        }else{
            return tunjanganEntertaint;
        }
    }

    public int hitungTunjanganEntertaint(int lm){
        return tunjanganEntertaint = tunjanganEntertaint * lm * 500000;
    }
    public void setTunjanganEntertaint(int tunjanganEntertaint) {
        this.tunjanganEntertaint = tunjanganEntertaint;
    }
}

public class Latihan3 {

    static Scanner sc = new Scanner(System.in);
    static LinkedList<Staff1> st = new LinkedList<>();
    static LinkedList<Manager> mn = new LinkedList<>();

    public static void main(String[] args) {
        boolean aktif = true;
        do {
            menuData();
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    //buat object
                    buatObject();
                    break;
                case 2:
                absensiWorker();
                    break;
                case 3:
                hitungTunjangan();
                    break;
                case 4:
                    hitungGaji();
                    break;
                case 5:
                    laporanGaji();
                    break;
                default:
                    System.out.println("Program Selesai !");
                    aktif = false;
                    break;
            }
        } while (aktif);
    }

    static void menuData() {
        System.out.println("=========================");
        System.out.println("Pilihan Menu");
        System.out.println("1. Buat Object\n2. Absensi Worker\n3. Hitung Tunjungan\n4. Hitung Total Gaji\n5. Laporan " +
                "Gaji\n6. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
    }

    static void buatObject() {
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                inputManager();
                break;
            case 2:
                inputStaff();
                break;
            default:
                break;
        }
    }

    static void absensiWorker() {
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                AbsenManager();
                break;
            case 2:
                AbsenStaff();
                break;
            default:
                break;
        }
    }

    static  void AbsenManager(){
        System.out.print("Pilih ID Manager : ");
        int pilih = sc.nextInt();
        int i= 0;
        int index = -1;
        while(i < mn.size()){
            if (mn.get(i).getIdKaryawan()== pilih) {
                //jika dapat
                index = i;
            }
            i++;
        }
        if(index >= 0){
            if (mn.get(index).getAbsen()>19){
                System.out.println("Absen Terpenuhi !");
            }else {
                mn.get(index).setAbsen();
                System.out.println("Berhasil Absen !");
            }
        }else{
            System.out.println("Data Tidak Di Temukan !");
            AbsenManager();
        }
    }

    static  void AbsenStaff(){
        System.out.print("Pilih ID Staff : ");
        int pilih = sc.nextInt();
        int i= 0;
        int index = -1;
        while(i < st.size()){
            if (st.get(i).getIdKaryawan()== pilih) {
                //jika dapat
                index = i;
            }
            i++;
        }
        if(index >= 0){
            if(st.get(index).getAbsen()>19){
                System.out.println("Absen Terpenuhi !");
            }else {
                st.get(index).setAbsen();
                System.out.println("Berhasil Absen !");
            }
        }else{
            System.out.println("Data Tidak Di Temukan !");
            AbsenManager();
        }
    }

    static void laporanGaji() {
        System.out.println("=========================");
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                laporanManager();
                break;
            case 2:
                laporanStaff();
                break;
            default:
                break;
        }
    }

    static void laporanManager() {
        Iterator itr2 = mn.iterator();
        System.out.println("================================================================");
        System.out.println("ID\tNama\tGaji Pokok\tT Pulsa\tT Transport\tT Entertaint\tAbsen");
        System.out.println("================================================================");
        while (itr2.hasNext()) {
            Manager km = (Manager) itr2.next();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+
                    km.getGajiPokok()+"\t\t"+
                    km.getTunjanganPulsa()+"\t\t"+
                    km.hitungTunjanganTransport()+"\t\t"+
                    km.getTunjanganEntertaint()+"\t\t"+
                    km.absen);
        }
        System.out.println("================================================================");
    }

    static void laporanStaff() {
        Iterator itr2 = st.iterator();
        System.out.println("================================================================");
        System.out.println("ID\tNama\tGaji Pokok\tT Pulsa\t\tT Makan\t\tAbsen");
        System.out.println("================================================================");
        while (itr2.hasNext()) {
            Staff1 km = (Staff1) itr2.next();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+
                    km.getGajiPokok()+"\t\t"+
                    km.getTunjanganPulsa()+"\t\t"+
                    km.hitungTunjanganMakan()+"\t\t"+
                    km.getAbsen());
        }
        System.out.println("================================================================");
    }

    static void inputManager() {
        System.out.print("Masukan Jumlah Data :");
        int jml = sc.nextInt();
        System.out.println("=========================");
        for (int i = 0; i < jml; i++) {
            System.out.print("ID : ");
            int idm = sc.nextInt();
            System.out.print("Nama : ");
            String nmm = sc.next();
            System.out.print("Gaji Pokok : ");
            int gpm = sc.nextInt();
            System.out.print("Tunjangan Pulsa : ");
            int tpm = sc.nextInt();
            mn.add(new Manager(idm, nmm, gpm, tpm, 1, 1, 0));
            System.out.println("=========================");
        }
    }

    static void inputStaff() {
        System.out.print("Masukan Jumlah Data :");
        int jml = sc.nextInt();
        System.out.println("=========================");
        for (int i = 0; i < jml; i++) {
            System.out.print("ID : ");
            int ids = sc.nextInt();
            System.out.print("Nama : ");
            String nms = sc.next();
            System.out.print("Gaji Pokok : ");
            int gps = sc.nextInt();
            System.out.print("Tunjangan Pulsa : ");
            int tps = sc.nextInt();
            st.add(new Staff1(ids, nms, gps, tps, 1, 0));
            System.out.println("=========================");
        }
    }

    static void hitungTunjangan() {
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                tunjanganManager();
                break;
            case 2:
                tunjanganStaff();
                break;
            default:
                break;
        }
    }

    static void tunjanganManager(){
        System.out.print("Pilih ID Manager : ");
        int pilih = sc.nextInt();
        int i= 0;
        int index = -1;
        while(i < mn.size()){
            if (mn.get(i).getIdKaryawan()== pilih) {
                //jika dapat
                index = i;
            }
            i++;
        }
        if(index >= 0){
            System.out.print("Input jumlah hiburan :");
            int lm = sc.nextInt();
            mn.get(index).hitungTunjanganEntertaint(lm);
        }else{
            System.out.println("Data Tidak Di Temukan !");
            AbsenManager();
        }
    }

    static void tunjanganStaff(){
        System.out.print("Pilih ID Staff : ");
        int pilih = sc.nextInt();
        int i= 0;
        int index = -1;
        while(i < st.size()){
            if (st.get(i).getIdKaryawan()== pilih) {
                //jika dapat
                index = i;
            }
            i++;
        }
        if(index >= 0){
            System.out.print("Hasil Data Tunjangan");
            System.out.println("ID : "+st.get(index).getIdKaryawan());
            System.out.println("Nama : "+st.get(index).getNamaKaryawan());
            System.out.println("Gaji Pokok : "+st.get(index).getGajiPokok());
            System.out.println("Tunjangan Pulsa : "+st.get(index).getTunjanganPulsa());
            System.out.println("Tunjangan Makan : "+st.get(index).hitungTunjanganMakan());
        }else{
            System.out.println("Data Tidak Di Temukan !");
            AbsenManager();
        }
    }

    static void hitungGaji() {
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                gajiManager();
                break;
            case 2:
                gajiStaff();
                break;
            default:
                break;
        }
    }

    static void gajiManager() {
        Iterator itr2 = mn.iterator();
        System.out.println("======================");
        System.out.println("ID\tNama\tGaji Pokok");
        System.out.println("======================");
        int totalGaji =0;
        while (itr2.hasNext()) {
            Manager km = (Manager) itr2.next();
            int total =
                    km.getGajiPokok()+km.getTunjanganPulsa()+km.hitungTunjanganTransport()+km.getTunjanganEntertaint();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+total);
            totalGaji = totalGaji + total;
        }
        System.out.println("=======================");
        System.out.println("Total :Rp."+ totalGaji);
        System.out.println("=======================");
    }

    static void gajiStaff() {
        Iterator itr2 = st.iterator();
        System.out.println("======================");
        System.out.println("ID\tNama\tGaji Pokok");
        System.out.println("======================");
        int totalGaji=0;

        while (itr2.hasNext()) {
            Staff1 km = (Staff1) itr2.next();
            int total = km.getGajiPokok()+ km.hitungTunjanganMakan()+ km.getTunjanganPulsa();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+ total);
            totalGaji = totalGaji + total;
        }
        System.out.println("=======================");
        System.out.println("Total :Rp. "+ totalGaji);
        System.out.println("=======================");

    }

}
