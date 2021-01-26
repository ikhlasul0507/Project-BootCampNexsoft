package Latihan10;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Karyawan {
    Scanner sc = new Scanner(System.in);
    private String namaKaryawan;
    private int gajiKaryawan, idJabatan;
    koneksiLatihan10 kon = new koneksiLatihan10();
    Main mn = new Main();
    Jabatan jb = new Jabatan();

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public int getGajiKaryawan() {
        return gajiKaryawan;
    }

    public void setGajiKaryawan(int gajiKaryawan) {
        this.gajiKaryawan = gajiKaryawan;
    }

    public int getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(int idJabatan) {
        this.idJabatan = idJabatan;
    }

    public void menuKaryawanAll(Statement stmt) throws SQLException {
        boolean aktif = true;
        do {
            System.out.println("=========================");
            System.out.println("Pilihan Menu List Karyawan");
            System.out.println("1. Staff\n2. Manajer\n3. Semua Karyawan\n4. Kembali");
            System.out.println("=========================");
            System.out.print("Pilih : ");
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
//                    tampil staff all
                    tampilStaffAll(stmt);
                    break;
                case 2:
//                    tampil staff manajer
                   tampilManajerAll(stmt);
                    break;
                case 3:
//                    semua karyawan
                    tampilDataAllManajerStaffPagination(stmt);
                    break;
                case 4:
                    mn.menu();
                    break;
                default:
                    System.out.println("Pilihan Salah !");
                    aktif = true;
                    break;
            }
        } while (aktif);
    }
    public void menuKaryawan(Statement stmt) throws SQLException {
        boolean aktif = true;
        do {
            System.out.println("=========================");
            System.out.println("Pilihan Menu");
            System.out.println("1. Input Karyawan\n2. Update Karyawan\n3. Delete Karyawan\n4. Delete All" +
                    "\n5. Kembali");
            System.out.println("=========================");
            System.out.print("Pilih : ");
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
//                    input jabatan
                    inputKaryawan(stmt);
                    break;
                case 2:
//                    update jabatan
                    listKaryawanPagination(stmt);
                    updateKaryawan(stmt);
                    break;
                case 3:
//                    delete karyawan
                    listKaryawanPagination(stmt);
                    deleteKaryawan(stmt);
                    break;
                case 4:
                    //delete all karyawan
                    listKaryawanPagination(stmt);
                    deleteKaryawanAll(stmt);
                    break;
                case 5:
                    mn.menu();
                    break;
                default:
                    System.out.println("Pilihan Salah !");
                    aktif = true;
                    break;
            }
        } while (aktif);
    }

    public void inputKaryawan(Statement stmt) throws SQLException {
        System.out.println("=========================");
        sc.nextLine();
        System.out.print("Nama Karyawan :");
        String namaKar = sc.nextLine();
        sc.nextLine();
        setNamaKaryawan(namaKar);
        System.out.print("Gaji Karyawan :");
        int gajiK = sc.nextInt();
        setGajiKaryawan(gajiK);
        jb.listJabatanAll(stmt);
        System.out.print("ID Jabatan :");
        int idJab = sc.nextInt();
        setIdJabatan(idJab);
        kon.insertDataKaryawan(getNamaKaryawan(), getGajiKaryawan(), getIdJabatan());
        System.out.println("==> Data Berhasil Di Simpan Di Database....");
    }
    public void updateKaryawan(Statement stmt) throws SQLException {
        System.out.println("=========================");
        System.out.print("Masukan ID Karyawan  :");
        int hasilId = sc.nextInt();
        int cari = cariID(hasilId, stmt);
        if (cariID(hasilId, stmt) > 0) {
            tampilDataById(cari, stmt);
            editDataKaryawan(cari, stmt);
        }
    }
    public void deleteKaryawan(Statement stmt) throws SQLException {
        System.out.println("=========================");
        System.out.print("Masukan ID Karyawan  :");
        int hasilId = sc.nextInt();
        int cari = cariID(hasilId, stmt);
        if (cariID(hasilId, stmt) > 0) {
            kon.deleteKaryawan(cari);
            System.out.println("==> Data ID " + cari + " Berhasil Di Hapus Di Database....");
        }
    }
    public void deleteKaryawanAll(Statement stmt) throws SQLException {
        kon.deleteKaryawanAll();
        System.out.println("==> Semua Data Berhasil Di Hapus Di Database....");
    }
    public int cariID(int idKaryawan, Statement stmt) throws SQLException {
        kon.koneksiKeDatabase();
        ResultSet rs = stmt.executeQuery("Select * From tbl_karyawan");
        int tempId = 0;
        while (rs.next()) {
            if (rs.getInt(1) == idKaryawan) {
                tempId = rs.getInt(1);
                break;
            }
        }
        if (tempId == idKaryawan) {
            return idKaryawan;
        } else {
            System.out.println("ID Tidak Di Temukan !");
            updateKaryawan(stmt);
        }
        return idKaryawan;
    }
    public void listKaryawanPagination(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM tbl_karyawan");
        rs.next();
        int count = rs.getInt(1);
        System.out.println(count);
        int limit = 2;
        int page = (int) Math.ceil(count / (float) limit);
        int start = 0;

        int i = 0;
        int banding=1;
        while (i < page) {
            String sql = "SELECT * FROM tbl_karyawan LIMIT " + start + "," + limit;
            ResultSet result = stmt.executeQuery(sql);
            System.out.println("\nHalaman - " + (i + 1));
            System.out.println("||-------------------------------------------------------------||");
            System.out.println("||ID Karyawan  || Nama Karyawan ||    Gaji    ||  ID Jabatan   ||");
            System.out.println("||-------------------------------------------------------------||");
            while (result.next())
                System.out.println("\t\t" + result.getString(1) + "\t\t\t" + result.getString(2) + "\t\t\t" + result.getString(3) +
                        "\t" +
                        "\t\t" + result.getString(4));
            System.out.println("||-------------------------------------------------------------||");
            if (page > 1) {
                if (page == banding){
                    System.out.println();
                    break;
                }
                while (true) {
                    System.out.print("Lihat data selanjutnya (Y/N) ? ");
                    String jawaban = sc.next();
                    if (jawaban.equalsIgnoreCase("Y")) {
                        start += limit;
                        i++;
                        banding++;
                        break;
                    } else if (jawaban.equalsIgnoreCase("n")) {
                        System.out.println("terimakasih.....");
                        i += page;
                        break;
                    } else {
                        System.out.println("Pilihan tidak ada !!!");
                    }
                }
            } else {
                start += limit;
                i++;
                banding++;
            }
        }
    }
    public void tampilStaffAll(Statement stmt) {
        kon.koneksiKeDatabase();
        try {
            ResultSet rs=stmt.executeQuery("SELECT a.idKaryawan, a.namaKaryawan, a.gajiKaryawan, b.namaJabatan, b" +
                    ".tunjanganMakan, " +
                    "b" +
                    ".tunjanganTransport FROM tbl_karyawan a INNER JOIN tbl_jabatan b ON a.idJabatan = b.idJabatan " +
                    "AND b.idJabatan=4");

            System.out.println("||------------------------------------------------------------------------------||");
            System.out.println("|| ID  ||  Nama Karyawan ||  Gaji Pokok  ||  Jabatan   || T Makan  ||  T Transport");
            System.out.println("||------------------------------------------------------------------------------||");
            while(rs.next()) {
            System.out.println("   "+rs.getInt(1) + "\t\t" + rs.getString(2)
                        + "\t\t\t\t" + rs.getInt(3)+ "\t\t  " + rs.getString(4)
                        + "\t\t  " + rs.getInt(5)+ "\t\t   " + rs.getInt(6));
            }
            System.out.println("||------------------------------------------------------------------------------||");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void tampilManajerAll(Statement stmt) {
        kon.koneksiKeDatabase();
        try {
            ResultSet rs=stmt.executeQuery("SELECT a.idKaryawan, a.namaKaryawan, a.gajiKaryawan, b.namaJabatan, b" +
                    ".tunjanganMakan, " +
                    "b" +
                    ".tunjanganTransport FROM tbl_karyawan a INNER JOIN tbl_jabatan b ON a.idJabatan = b.idJabatan " +
                    "AND b.idJabatan=1");

            System.out.println("||------------------------------------------------------------------------------||");
            System.out.println("|| ID  ||  Nama Karyawan ||  Gaji Pokok  ||  Jabatan   || T Makan  ||  T Transport");
            System.out.println("||------------------------------------------------------------------------------||");
            while(rs.next()) {
                System.out.println("   "+rs.getInt(1) + "\t\t" + rs.getString(2)
                        + "\t\t\t" + rs.getInt(3)+ "\t\t  " + rs.getString(4)
                        + "\t\t  " + rs.getInt(5)+ "\t\t   " + rs.getInt(6));
            }
            System.out.println("||------------------------------------------------------------------------------||");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void tampilDataAllManajerStaffPagination(Statement stmt) throws SQLException  {
        ResultSet result = stmt.executeQuery("SELECT COUNT(*) FROM tbl_karyawan");
        result.next();
        int count = result.getInt(1);
        int limit = 2;
        int page = (int)Math.ceil(count/(float)limit);
        int start = 0;

        int i = 0;
        int banding=1;
        while (i < page){
            String sql= "SELECT a.idKaryawan, a.namaKaryawan, a.gajiKaryawan, b.namaJabatan, b.tunjanganMakan, b" +
                    ".tunjanganTransport FROM" +
                    " tbl_karyawan a INNER JOIN tbl_jabatan b ON a.idJabatan = b.idJabatan LIMIT "+start+","+limit;
            ResultSet rs=stmt.executeQuery(sql);

            System.out.println("||------------------------------------------------------------------------------||");
            System.out.println("|| ID  ||  Nama Karyawan ||  Gaji Pokok  ||  Jabatan   || T Makan  ||  T Transport");
            System.out.println("||------------------------------------------------------------------------------||");
            while(rs.next()) {
                System.out.println("   "+rs.getInt(1) + "\t\t" + rs.getString(2)
                        + "\t\t\t\t" + rs.getInt(3)+ "\t\t  " + rs.getString(4)
                        + "\t\t  " + rs.getInt(5)+ "\t\t   " + rs.getInt(6));
            }
            System.out.println("||------------------------------------------------------------------------------||");

            if (page > 1){
                if (page == banding){
                    System.out.println();
                    break;
                }
                while (true){
                    System.out.print("Lihat data selanjutnya (Y/N) ? ");
                    String jawaban = sc.next();
                    if (jawaban.equalsIgnoreCase("Y")){
                        start += limit;
                        i++;
                        banding++;
                        break;
                    }else if(jawaban.equalsIgnoreCase("n")){
                        System.out.println("terimakasih.....");
                        i += page;
                        break;
                    }else {
                        System.out.println("Pilihan tidak ada !!!");
                    }
                }
            }else {
                start += limit;
                i++;
                banding++;
            }
        }
    }
    public void tampilDataById(int idKaryawan, Statement stmt) {
        kon.koneksiKeDatabase();
        try {
            ResultSet rs = stmt.executeQuery("Select * From tbl_karyawan where idKaryawan='" + idKaryawan + "'");
            System.out.println("||-------------------------------------------------------------||");
            System.out.println("||ID Karyawan  || Nama Karyawan ||    Gaji    ||  ID Jabatan   ||");
            System.out.println("||-------------------------------------------------------------||");
            while (rs.next())
                System.out.println("\t\t" + rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) +
                        "\t" +
                        "\t\t" + rs.getString(4));
            System.out.println("||-------------------------------------------------------------||");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void editDataKaryawan(int idKaryawan, Statement stmt) throws SQLException {
        System.out.println("=========================");
        sc.nextLine();
        System.out.print("Nama Karyawan :");
        String namaKar = sc.nextLine();
        sc.nextLine();
        setNamaKaryawan(namaKar);
        System.out.print("Gaji Karyawan :");
        int gajiK = sc.nextInt();
        setGajiKaryawan(gajiK);
        jb.listJabatanAll(stmt);
        System.out.print("ID Jabatan :");
        int idJab = sc.nextInt();
        setIdJabatan(idJab);
        kon.updateDataKaryawan(getNamaKaryawan(), getGajiKaryawan(), getIdJabatan(), idKaryawan);
        System.out.println("==> Data Berhasil Di Edit Di Database....");
    }

}

class Jabatan {
    Scanner sc = new Scanner(System.in);
    private String namaJabatan;
    private int tunjanganMakan, tunjanganTransport;
    koneksiLatihan10 kon = new koneksiLatihan10();
    Main mn = new Main();

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public int getTunjanganTransport() {
        return tunjanganTransport;
    }

    public void setTunjanganTransport(int tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }

    public void menuJabatan(Statement stmt) throws SQLException {
        boolean aktif = true;
        do {
            System.out.println("=========================");
            System.out.println("Pilihan Menu");
            System.out.println("1. Input Jabatan\n2. Update Jabatan\n3. List Jabatan\n4. Kembali");
            System.out.println("=========================");
            System.out.print("Pilih : ");
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
//                    input jabatan
                    inputJabatan();
                    break;
                case 2:
//                    update jabatan
                    listJabatanAll(stmt);
                    updateJabatan(stmt);
                    break;
                case 3:
//                    list all jabatan
                    listJabatanAll(stmt);
                    break;
                case 4:
                    mn.menu();
                    break;
                default:
                    System.out.println("Pilihan Salah !");
                    aktif = true;
                    break;
            }
        } while (aktif);
    }

    public void inputJabatan() throws SQLException {
        System.out.println("=========================");
        System.out.print("Nama Jabatan        :");
        String namaJab = sc.nextLine();
        sc.nextLine();
        setNamaJabatan(namaJab);
        System.out.print("Tunjangan Makan     :");
        int tMakan = sc.nextInt();
        setTunjanganMakan(tMakan);
        System.out.print("Tunjangan Transport :");
        int tTransport = sc.nextInt();
        setTunjanganTransport(tTransport);
        kon.insertDataJabatan(getNamaJabatan(), getTunjanganMakan(), getTunjanganTransport());
        System.out.println("==> Data Berhasil Di Simpan Di Database....");
    }

    public int cariID(int idJabatan, Statement stmt) throws SQLException {
        kon.koneksiKeDatabase();
        ResultSet rs = stmt.executeQuery("Select * From tbl_jabatan");
        int tempId = 0;
        while (rs.next()) {
            if (rs.getInt(1) == idJabatan) {
                tempId = rs.getInt(1);
                break;
            }
        }
        if (tempId == idJabatan) {
            return idJabatan;
        } else {
            System.out.println("ID Tidak Di Temukan !");
            updateJabatan(stmt);
        }
        return idJabatan;
    }

    public void listJabatanAll(Statement stmt) {
//        kon.koneksiKeDatabase();

        try {
            ResultSet rs = stmt.executeQuery("Select * From tbl_jabatan");
            System.out.println("||-------------------------------------------------------------||");
            System.out.println("||ID Jabatan  || Nama Jabatan ||   T Makan    ||  T Transport  ||");
            System.out.println("||-------------------------------------------------------------||");
            if(rs.getFetchSize()<0){
                System.out.println("data Ksoong");
            }
            while (rs.next())
                System.out.println("\t\t" + rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t" +
                        "\t" + rs.getString(4));
            System.out.println("||-------------------------------------------------------------||");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateJabatan(Statement stmt) throws SQLException {
        System.out.println("=========================");
        System.out.print("Masukan ID Jabatan  :");
        int hasilId = sc.nextInt();
        int cari = cariID(hasilId, stmt);
        if (cariID(hasilId, stmt) > 0) {
            tampilDataById(cari, stmt);
            editDataJabatan(cari, stmt);
        }
    }

    public void tampilDataById(int idJabatan, Statement stmt) {
        kon.koneksiKeDatabase();
        try {
            ResultSet rs = stmt.executeQuery("Select * From tbl_jabatan where idJabatan='" + idJabatan + "'");
            System.out.println("||-------------------------------------------------------------||");
            System.out.println("||ID Jabatan  || Nama Jabatan ||   T Makan    ||  T Transport  ||");
            System.out.println("||-------------------------------------------------------------||");
            while (rs.next())
                System.out.println("\t\t" + rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t" +
                        "\t" + rs.getString(4));
            System.out.println("||-------------------------------------------------------------||");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editDataJabatan(int idJabatan, Statement stmt) throws SQLException {
        System.out.println("=========================");
        System.out.print("Nama Jabatan        :");
        String namaJabedit = sc.next();
        setNamaJabatan(namaJabedit);
        System.out.print("Tunjangan Makan     :");
        int tMakan = sc.nextInt();
        setTunjanganMakan(tMakan);
        System.out.print("Tunjangan Transport :");
        int tTransport = sc.nextInt();
        setTunjanganTransport(tTransport);
        kon.updateDataJabatan(getNamaJabatan(), getTunjanganMakan(), getTunjanganTransport(), idJabatan);
        System.out.println("==> Data Berhasil Di Edit Di Database....");
    }

}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Karyawan kar = new Karyawan();
    static Jabatan jab = new Jabatan();
    static koneksiLatihan10 kon = new koneksiLatihan10();

    public static void main(String[] args) throws SQLException {
        menu();
    }

    static void menu() throws SQLException {
        Statement stmt = kon.koneksiKeDatabase();
        boolean aktif = true;
        do {
            menuData();
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
//                    menu jabatan
                    jab.menuJabatan(stmt);
                    break;
                case 2:
//                    menu karyawan
                    kar.menuKaryawan(stmt);
                    break;
                case 3:
                    kar.menuKaryawanAll(stmt);
                    break;
                default:
                    stmt.close();
                    System.out.println("Program Selesai !");
                    aktif = false;
                    break;
            }
        } while (aktif);
    }

    static void menuData() {
        System.out.println("=========================");
        System.out.println("Pilihan Menu");
        System.out.println("1. Menu Jabatan\n2. Menu Karyawan\n3. Menu List Karyawan\n4. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
    }
}
