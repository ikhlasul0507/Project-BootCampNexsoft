import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

class ComparatorScID implements Comparator<Mahasiswa> {
    @Override
    public int compare(Mahasiswa m1, Mahasiswa m2) {
        return m1.getIdMahasiswa() - m2.getIdMahasiswa();
    }
}

class Mahasiswa {
    private int idMahasiswa;
    private String namaMahasiswa;
    private double nilaiMahasiswa;

    LinkedList<Mahasiswa> mah = new LinkedList<Mahasiswa>();

    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);

    Mahasiswa(int idMahasiswa, String namaMahasiswa, double nilaiMahasiswa) {
        this.idMahasiswa = idMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.nilaiMahasiswa = nilaiMahasiswa;
    }

    public Mahasiswa() {

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

    public double getNilaiMahasiswa() {
        return nilaiMahasiswa;
    }

    public void setNilaiMahasiswa(double nilaiMahasiswa) {
        this.nilaiMahasiswa = nilaiMahasiswa;
    }

    public void inputData() throws Exception {
        System.out.println("===========================");
        System.out.print("Masukan Jumlah Data : ");
        try {
            String data = br.readLine();
            System.out.println("===========================");
            int jm = Integer.parseInt(data);
            for (int i = 0; i < jm; i++) {
                System.out.print("Data ke " + (i + 1));
                System.out.print("\nID : ");
                String id = br.readLine();
                int idm = Integer.parseInt(id);
                System.out.print("Nama : ");
                String nm = br.readLine();
                System.out.print("Nilai : ");
                String nl = br.readLine();
                double nlm = Double.parseDouble(nl);
                mah.add(new Mahasiswa(idm, nm, nlm));
                System.out.println("----------------------------");
            }
        }catch(Exception e){
            System.out.println("Masukan Kode Yang Benar !");
            inputData();
        }
    }

    public void tampilData() {
        Iterator itr2 = mah.iterator();
        int no = 1;
        System.out.println("===========================");
        System.out.println("No\tID\tNama\tNilai");
        System.out.println("===========================");
        while (itr2.hasNext()) {
            Mahasiswa mh = (Mahasiswa) itr2.next();
            System.out.println(no + "\t" + mh.getIdMahasiswa() + "\t" + mh.getNamaMahasiswa() + "\t" + (int) mh.getNilaiMahasiswa());
            no++;
        }
        System.out.println("===========================");
    }

    public void cetakData() {
        try {
            Iterator itr2 = mah.iterator();
            int no = 1;
            FileWriter fw = new FileWriter("C:\\Users\\User\\IdeaProjects\\HelloWorld\\Mahasiswa.txt");
            fw.write("===========================");
            fw.write("No   ID   Nama   Nilai\n");
            fw.write("===========================");
            while (itr2.hasNext()) {
                Mahasiswa mh = (Mahasiswa) itr2.next();
                fw.write(no + "    " + mh.getIdMahasiswa() + "   " + mh.getNamaMahasiswa() + "   " + (int) mh.getNilaiMahasiswa() +
                        "\n");
                no++;
            }
            System.out.println("===========================");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success..Di Cetak !");
    }

    public void lihatFile() throws Exception {
        FileReader fr = new FileReader("C:\\Users\\User\\IdeaProjects\\HelloWorld\\Mahasiswa.txt");
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
        System.out.println();
        fr.close();
    }

    public void hapusData() throws Exception {
        System.out.print("Masukan ID Yang Mau Di Hapus : ");
        String hp = br.readLine();
        int hapus = Integer.parseInt(hp);
        for (Mahasiswa data : mah) {
            if (data.getIdMahasiswa() == hapus) {
                mah.remove(data); // problem is here
                System.out.println(hapus + " Berhasil Di Hapus !");
            } else {
                System.out.println("Data Tidak Di Temukan !");
                hapusData();
            }
        }
    }

    public void cariData() throws Exception {
        System.out.println("Cari Berdasarkan :\n1. ID\n2. Nama");
        System.out.print("Pilih Data : ");
        String cr = br.readLine();
        int cari = Integer.parseInt(cr);
        switch (cari) {
            case 1:
                cariDataId();
                break;
            case 2:
                cariDataNama();
                break;
        }
    }

    public void cariDataId() throws Exception {
        System.out.print("Masukan ID : ");
        String crId = br.readLine();
        int cariId = Integer.parseInt(crId);
        for (Mahasiswa data : mah) {
            if (data.getIdMahasiswa() == cariId) {
                System.out.println("ID :" + data.getIdMahasiswa());
                System.out.println("Nama :" + data.getNamaMahasiswa());
                System.out.println("Nilai :" + data.getNilaiMahasiswa());
                break;
            } else {
                System.out.println("Data Tidak Di Temukan !");

            }
        }
    }

    public void cariDataNama() throws Exception {
        System.out.print("Masukan Nama : ");
        String crNama = br.readLine();
        for (Mahasiswa data : mah) {
            if (data.getNamaMahasiswa() == crNama) {
                System.out.println("ID :" + data.getIdMahasiswa());
                System.out.println("Nama :" + data.getNamaMahasiswa());
                System.out.println("Nilai :" + data.getNilaiMahasiswa());
                break;
            } else {
                System.out.println("Data Tidak Di Temukan !");

            }
        }
    }

    //    public void urutkanData() throws  Exception{
//        System.out.println("Urut Berdasarkan :\n1. ID\n2. Nilai");
//        System.out.print("Pilih Data : ");
//        String cr = br.readLine();
//        int cari = Integer.parseInt(cr);
//        switch (cari){
//            case 1:
//                //id
//                prosesUrutanId();
//                tampilData();
//                break;
//            case 2:
//                //nama
//                prosesUrutanNilai();
//                tampilData();
//                break;
//        }
//    }
    public void prosesUrutanId() {
        System.out.println("Urutan Berdasarkan ID");
        ComparatorScID compID = new ComparatorScID();
        mah.sort(compID);
        tampilData();
    }

    public void prosesUrutanNilai() {
        System.out.println("Urutan Berdasarkan Nilai");
        for (int i = 0; i < mah.size(); i++) {
            for (int j = 1; j < mah.size() - 1; j++) {
                Mahasiswa tempId = mah.get(j);
                if (mah.get(j).getNilaiMahasiswa() > mah.get(j + 1).getNilaiMahasiswa()) {
                    mah.set(j, mah.get(j + 1));
                    mah.set(j + 1, tempId);
                }
            }
        }
    }


    public void menu() {
        System.out.println("===========================");
        System.out.println("Silahkan Pilih Menu Berikut !");
        System.out.println("===========================");
        System.out.println("1. Input Data\n2. Tampil Data\n3. Hapus Data\n4. Cetak Data\n5. Lihat File\n6. Cari\n7. " +
                "Urutkan Data\n8. Keluar");
        System.out.println("===========================");
    }
}

public class Tugas1 {
    public static void main() throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        Mahasiswa mahasiswa = new Mahasiswa();

        boolean aktif = true;
        do {
            mahasiswa.menu();
            System.out.println("===========================");
            System.out.print("Pilih Menu : ");
            String mn = br.readLine();
            int menu = Integer.parseInt(mn);
            switch (menu) {
                case 1:
                    mahasiswa.inputData();
                    break;
                case 2:
                    mahasiswa.tampilData();
                    break;
                case 3:
                    mahasiswa.hapusData();
                    break;
                case 4:
                    mahasiswa.cetakData();
                    break;
                case 5:
                    mahasiswa.lihatFile();
                    break;
                case 6:
                    mahasiswa.cariData();
                    break;
                case 7:
                    mahasiswa.prosesUrutanId();
                    break;
                case 8:
                    System.out.println("SELESAI");
                    aktif = false;
                    break;
            }
        } while (aktif);
        r.close();
        br.close();
    }
}

