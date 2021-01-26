package Latihan10;

import java.sql.*;
import java.util.Scanner;

public class koneksiLatihan10 {
    Statement stmt;
    String namaJabatan;
    int TunjanganMakan, TunjanganTransport;
    int gajiKaryawan, idJabatan;
    Scanner sc = new Scanner(System.in);
    public Statement koneksiKeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_latihan10", "root", "ABcd//12");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stmt;
    }

    public void insertDataKaryawan(String namaKaryawan, int gajiKaryawan, int idJabatan) throws SQLException {
        //tambah data
        koneksiKeDatabase();
        stmt.executeUpdate("insert into tbl_karyawan values(NULL,'" + namaKaryawan + "'," + gajiKaryawan + "," + idJabatan + ")");
    }

    public void insertDataJabatan(String namaJabatan, int TunjanganMakan, int TunjanganTransport) throws SQLException {
        //tambah data
        koneksiKeDatabase();
        stmt.executeUpdate("insert into tbl_jabatan values(NULL,'" + namaJabatan + "'," + TunjanganMakan + "," + TunjanganTransport + ")");
    }

    public void updateDataKaryawan(String namaKaryawan, int gajiKaryawan, int idJabatan,int idKaryawan) throws SQLException {
        //edit data
        stmt.executeUpdate("update tbl_karyawan set namaKaryawan='"+namaKaryawan+"', gajiKaryawan="+gajiKaryawan+
                ", " + "idJabatan="+idJabatan+" " + "WHERE idKaryawan="+idKaryawan+"");
    }

    public void updateDataJabatan(String namaJabatan, int tunjanganMakan, int tunjanganTransport, int idJabatan) throws SQLException {
        //edit data
         stmt.executeUpdate("update tbl_jabatan set namaJabatan='"+namaJabatan+"', tunjanganMakan="+tunjanganMakan+ ", " + "tunjanganTransport="+tunjanganTransport+" " + "WHERE idJabatan="+idJabatan+"");
    }

    public void deleteKaryawan(int idKaryawan) throws SQLException {
        //hapus data
        stmt.executeUpdate("delete from tbl_karyawan where idKaryawan='"+idKaryawan+"'");
    }
    public void deleteKaryawanAll() throws SQLException {
        stmt.executeUpdate("delete from tbl_karyawan");
    }


}
