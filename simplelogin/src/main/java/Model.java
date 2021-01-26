import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Model {
    Statement stmt;

    Model() {
        try {
            Connection con;
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\User\\Downloads\\simplelogin\\simplelogin\\src\\main\\webapp\\akundatabase.properties"));
            String database = prop.getProperty("database");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database + "", "" + username + "", "" + password + ""
            );
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //    public void koneksi() throws IOException, ClassNotFoundException, SQLException {
//        Connection con;
//        Properties prop = new Properties();
//        prop.load(new FileInputStream("C:\\Users\\User\\Downloads\\simplelogin\\simplelogin\\src\\main\\webapp\\akundatabase.properties"));
//        String database = prop.getProperty("database");
//        String username = prop.getProperty("username");
//        String password = prop.getProperty("password");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/" + database + "", "" + username + "", "" + password + ""
//        );
//        stmt = con.createStatement();
//    }
    public void inputDataJabatan(String namaJabatan, String tunjanganMakan, String tunjanganTransport) throws ClassNotFoundException,
            IOException,
            SQLException {
//        koneksi();
        stmt.executeUpdate("insert into tbl_jabatan values(NULL,'" + namaJabatan + "'," + tunjanganMakan + "," + tunjanganTransport +
                ")");
    }

    public void inputDataKaryawan(String namaKaryawan, String gajiKaryawan, String idJabatan) throws ClassNotFoundException, IOException,
            SQLException {
//       koneksi();
        stmt.executeUpdate("insert into tbl_karyawan" +
                " values(NULL," +
                "'" + namaKaryawan + "'," +
                "" + gajiKaryawan + "," +
                "" + idJabatan + ")");
    }

    public void updateDataJabatan(String idJabatan, String namaJabatan, String tunjanganMakan,
                                  String tunjanganTransport) throws ClassNotFoundException,
            IOException,
            SQLException {
        stmt.executeUpdate("update tbl_jabatan set " +
                "namaJabatan='" + namaJabatan + "'," +
                "tunjanganMakan='" + tunjanganMakan + "', " +
                "tunjanganTransport='" + tunjanganTransport + "' " +
                "where idJabatan=" + idJabatan + "");
    }

    public void updateDataKaryawan(String idKaryawan, String namaKaryawan, String gajiKaryawan,
                                   String idJabatan) throws ClassNotFoundException,
            IOException,
            SQLException {
        stmt.executeUpdate("update tbl_karyawan set " +
                "namaKaryawan='" + namaKaryawan + "', " +
                "gajiKaryawan='" + gajiKaryawan + "', " +
                "idJabatan='" + idJabatan + "' " +
                "where idKaryawan=" + idKaryawan + "");
    }

}
