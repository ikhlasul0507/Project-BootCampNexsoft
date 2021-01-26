package Latihan4;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Mahasiswa1{
    private int idMahasiswa;
    private String namaMahasiswa;

    ArrayList<Mahasiswa1> mahasiswa = new ArrayList<>();
    ArrayList<nilaiMahasiswa> nilai = new ArrayList<>();

    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);

    public Mahasiswa1(int idMahasiswa, String namaMahasiswa) {
        this.idMahasiswa = idMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.nilai=nilai;
    }

    public Mahasiswa1() {
    }

    public Mahasiswa1(int idm, String nm, ArrayList<nilaiMahasiswa> nilai) {

    }

    public ArrayList<nilaiMahasiswa> getNilai() {
        return nilai;
    }

    public void setNilai(ArrayList<nilaiMahasiswa> nilai) {
        this.nilai = nilai;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

}

class nilaiMahasiswa extends Mahasiswa1{
    private double nilaiBahasaInggris;
    private double nilaiFisika;
    private double nilaiAlogoritma;

    public nilaiMahasiswa(double nilaiBahasaInggris, double nilaiFisika,
                          double nilaiAlogoritma) {
        this.nilaiBahasaInggris = nilaiBahasaInggris;
        this.nilaiFisika = nilaiFisika;
        this.nilaiAlogoritma = nilaiAlogoritma;
    }

    public nilaiMahasiswa() {

    }

    public double getNilaiBahasaInggris() {
        return nilaiBahasaInggris;
    }

    public void setNilaiBahasaInggris(double nilaiBahasaInggris) {
        this.nilaiBahasaInggris = nilaiBahasaInggris;
    }

    public double getNilaiFisika() {
        return nilaiFisika;
    }

    public void setNilaiFisika(double nilaiFisika) {
        this.nilaiFisika = nilaiFisika;
    }

    public double getNilaiAlogoritma() {
        return nilaiAlogoritma;
    }

    public void setNilaiAlogoritma(double nilaiAlogoritma) {
        this.nilaiAlogoritma = nilaiAlogoritma;
    }
}
class prosesMahasiswa extends Mahasiswa1{

    public prosesMahasiswa(int idMahasiswa, String namaMahasiswa) {
        super(idMahasiswa, namaMahasiswa);
    }
    public prosesMahasiswa() {
        super();
    }
    public void menu() {
        System.out.println("===========================");
        System.out.println("Silahkan Pilih Menu Berikut !");
        System.out.println("===========================");
        System.out.println("1. Input Data\n2. Hapus Data\n3. Edit Data\n4. Lihat File\n5. Keluar");
        System.out.println("===========================");
    }
    public void menuData() throws Exception {
        boolean aktif = true;
        do {
            menu();
            System.out.println("===========================");
            System.out.print("Pilih Menu : ");
            String mn = br.readLine();
            int menu = Integer.parseInt(mn);
            switch (menu) {
                case 1:
                    inputData();
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    cetakData();
                    break;
                case 5:
                    System.out.println("SELESAI");
                    aktif = false;
                    break;
            }
        } while (aktif);
        r.close();
        br.close();
    }
    public void inputData() throws Exception {
        System.out.println("===========================");
        System.out.print("Masukan Jumlah Data : ");
        try {
            dataInput();
        }catch(Exception e){
            System.out.println("Masukan Kode Yang Benar !");
            inputData();
        }
    }
    public void dataInput() throws IOException {
        String data = br.readLine();
        System.out.println("===========================");
        int jm = Integer.parseInt(data);
        for (int i = 0; i < jm; i++) {
            Mahasiswa1 mhs = new Mahasiswa1();
            nilaiMahasiswa nilaiM = new nilaiMahasiswa();
            System.out.print("Data ke " + (i + 1));
            System.out.print("\nID : ");
            String id = br.readLine();
            int idm = Integer.parseInt(id);
            mhs.setIdMahasiswa(idm);
            System.out.print("Nama : ");
            String nm = br.readLine();
            mhs.setNamaMahasiswa(nm);
            System.out.println("Nilai :");
            System.out.print("1. Bahasa Inggris : ");
            String nbh = br.readLine();
            double nbh1 = Double.parseDouble(nbh);
            nilaiM.setNilaiBahasaInggris(nbh1);
            System.out.print("2. Fisika : ");
            String nlm = br.readLine();
            double nlm1 = Double.parseDouble(nlm);
            nilaiM.setNilaiFisika(nlm1);
            System.out.print("3. Algoritma : ");
            String nal = br.readLine();
            double nal1 = Double.parseDouble(nal);
            nilaiM.setNilaiAlogoritma(nal1);
            mahasiswa.add(mhs);
            nilai.add(nilaiM);
            mhs.setNilai(nilai);
            System.out.println("===========================");
        }
    }
    public void cetakData() {
        Iterator itr2 = mahasiswa.iterator();
        Iterator itr3 = nilai.iterator();
        System.out.println("================================================");
        System.out.println("ID\tNama\tBahasa Inggris\tFisika\t\tAlgoritma");
        System.out.println("================================================");
        while (itr2.hasNext() && itr3.hasNext()) {
            Mahasiswa1 mhs = (Mahasiswa1) itr2.next();
            nilaiMahasiswa nms = (nilaiMahasiswa) itr3.next();
            System.out.println(mhs.getIdMahasiswa() + "\t" +
                    mhs.getNamaMahasiswa()+"\t"+
                    nms.getNilaiBahasaInggris()+"\t\t\t"+
                    nms.getNilaiFisika()+"\t\t"+
                    nms.getNilaiAlogoritma());
        }
        System.out.println("===============================================");
    }
    public void hapusData() throws IOException {
        boolean hps = true;
        while (hps) {
            System.out.print("Masukkan ID yang ingin dihapus : ");
            try {
                String id = br.readLine();
                int idhapus = Integer.parseInt(id);
                int hasilCari = cariID(idhapus);
                if (hasilCari >= 0) {
                    mahasiswa.remove(hasilCari); // problem is here
                    System.out.println("Data Berhasil Dihapus!");
                    hps = false;
                } else {
                    System.out.println("Data Tidak Di Temukan!");
                }
            } catch (Exception e) {
                System.out.println("Masukan Angka!");
            }
        }
    }
    public int cariID(int id) {
        int index = -1;
        int i = 0;
        for (Mahasiswa1 mhs : mahasiswa) {
            if (mhs.getIdMahasiswa() == id) {
                index = i;
            }
            i++;
        }
        return index;
    }
    public void editData(){
        boolean edit = true;
        while (edit) {
            System.out.print("Masukkan ID yang ingin dihapus : ");
            try {
                String id = br.readLine();
                int idhapus = Integer.parseInt(id);
                int hasilCari = cariID(idhapus);
                if (hasilCari >= 0) {
                    Mahasiswa1 mhs = new Mahasiswa1();
                    nilaiMahasiswa nilaiM = new nilaiMahasiswa();

                    System.out.print("Nama : ");
                    String nm = br.readLine();
                    mahasiswa.get(hasilCari).setNamaMahasiswa(nm);
                    System.out.println("Nilai :");
                    System.out.print("1. Bahasa Inggris : ");
                    String nbh = br.readLine();
                    double nbh1 = Double.parseDouble(nbh);
                    nilaiM.setNilaiBahasaInggris(nbh1);
                    System.out.print("2. Fisika : ");
                    String nlm = br.readLine();
                    double nlm1 = Double.parseDouble(nlm);
                    nilaiM.setNilaiFisika(nlm1);
                    System.out.print("3. Algoritma : ");
                    String nal = br.readLine();
                    double nal1 = Double.parseDouble(nal);
                    nilaiM.setNilaiAlogoritma(nal1);
                    nilai.add(nilaiM);
                    mahasiswa.get(hasilCari).setNilai(nilai);
                    System.out.println("===========================");
                    edit = false;
                } else {
                    System.out.println("Data Tidak Di Temukan!");
                }
            } catch (Exception e) {
                System.out.println("Masukan Angka!");
            }
        }

    }


}
public class Latihan4 {
    static Scanner sc =new Scanner(System.in);
    static prosesMahasiswa pm = new prosesMahasiswa();

    public static void main(String[] args){
        menu();
    }
    static void menu() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\resources\\data" +
                    ".properties"));
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");
            System.out.println("=====================");
            System.out.println("Masukan Akun Berikut !");
            System.out.println("=====================");
            System.out.println("US : "+user+"\nPass : "+pass);
            System.out.println("=====================");
            System.out.println("Silahkan Login !");
            System.out.println("=====================");
            System.out.print("Username : ");
            String us = sc.next();
            Pattern p = Pattern.compile("^(.+)@(.+)$");
            Matcher m = p.matcher(us);
            if (m.find()){
                System.out.print("Password : ");
                String pas = sc.next();
                Pattern pp = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
                Matcher mp = pp.matcher(pas);
                if (mp.find()){
                    if (user.equalsIgnoreCase(us) && pass.equalsIgnoreCase(pas)) {
                        System.out.println("---Berhasil Login---");
                        pm.menuData();
                    }else {
                        System.out.println("Username Dan Password Salah !");
                    }
                }else{
                    System.out.println("Password Tidak Sesuai !");
                    menu();
                }
            }else{
                System.out.println("Username Tidak Sesuai !");
                menu();
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
