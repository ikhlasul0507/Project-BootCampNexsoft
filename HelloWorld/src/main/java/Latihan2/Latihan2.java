import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

abstract class Worker {
    private int idKaryawan;
    private String namaKaryawan;
    String absen;
    //parameter yang dikirim

    public abstract void setAbsen() ;

    public Worker(int idKaryawan, String namaKaryawan) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void cetakKaryawan() {
        System.out.println(getIdKaryawan() + "\t" + getNamaKaryawan());
    }

    public abstract void absen(int idKaryawan, String namaKaryawan, String jabatanKaryawan, String absenKaryawan);

}

class Staff extends Worker {
    private String jabatanKaryawan;
    private int absen;

    public int getAbsen() {
        return absen;
    }


    public Staff(int idKaryawan, String namaKaryawan, String jabatanKaryawan, int absen) {
        super(idKaryawan, namaKaryawan);
        setJabatanKaryawan(jabatanKaryawan);
        this.absen =absen;
    }

    public String getJabatanKaryawan() {
        return jabatanKaryawan;
    }

    public void setJabatanKaryawan(String jabatanKaryawan) {
        this.jabatanKaryawan = jabatanKaryawan;
    }

    @Override
    public void setAbsen() {
        absen++;
    }



    @Override
    public void absen(int idKaryawan, String namaKaryawan, String jabatanKaryawan, String absenKaryawan) {

    }

}

public class Latihan2 {

    static LinkedList<Staff> st = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean aktif = true;
        do {
            System.out.println("=============================================");
            System.out.println("Pilih Menu");
            System.out.println("=============================================");
            System.out.println("1. Buat Staff\n2. Absensi\n3. Cetak");
            System.out.println("=============================================");
            System.out.print("Pilih Menu :");
            int data = sc.nextInt();
            switch (data) {
                case 1:
                    buatStaff();
                    break;
                case 2:
                    absensiKaryawan();
                    break;
                case 3:
                    cetak();
                    break;
                default:
                    break;
            }
        } while (aktif);
    }

    //buat staff
    static void buatStaff() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan Jumlah Data : ");
        int jml = sc.nextInt();
        for (int i=0; i<jml;i++){
            System.out.print("ID Karyawan : ");
            int idk = sc.nextInt();
            System.out.print("Nama Karyawan : ");
            String nmk = sc.next();
            System.out.print("Jabatan karyawan : ");
            String jk = sc.next();
            st.add(new Staff(idk, nmk, jk, 0));
            System.out.println("-----------------------------");
        }
    }

    static void cetak(){
        Iterator itr2 = st.iterator();
        System.out.println("=============================================");
        System.out.println("ID\tNama\tJabatan\t\t\tAbsensi/Hari");
        System.out.println("=============================================");
        while (itr2.hasNext()) {
            Staff mh = (Staff) itr2.next();
            System.out.println(mh.getIdKaryawan() + "\t" + mh.getNamaKaryawan() + "\t" + mh.getJabatanKaryawan()+"\t" +
                    "\t\t"+mh.getAbsen());
        }
        System.out.println("===========================");
    }
    static void absensiKaryawan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pilih ID Karyawan : ");
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
            st.get(index).setAbsen();
        }else{
            System.out.println("Data Tidak Di Temukan !");
            absensiKaryawan();
        }
    }
}

