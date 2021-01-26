
import com.fasterxml.jackson.databind.ObjectMapper;
import org.intellij.lang.annotations.Language;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebServlet(
        name = "tampilkaryawan",
        urlPatterns = "/tampilKaryawan"
)
public class tampilJsonKaryawan extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<prosesKaryawan> dataKaryawan = new ArrayList<>();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from tbl_karyawan");

            while (rs.next()) {
                prosesKaryawan pk = new prosesKaryawan();
                String id = rs.getString(1);
                String nama = rs.getString(2);
                String gaji = rs.getString(3);
                String jabatan = rs.getString(4);
                pk.setIdKaryawan(id);
                pk.setNamaKaryawan(nama);
                pk.setGajiKaryawan(gaji);
                pk.setIdJabatan(jabatan);
                dataKaryawan.add(pk);
            }
            rs.close();
            stmt.close();
            con.close();

            JSONObject obj = null;
            JSONArray jr = new JSONArray();

            for (int i = 0; i < dataKaryawan.size(); i++) {
                obj = new JSONObject();
                obj.put("ID Karyawan", dataKaryawan.get(i).getIdKaryawan());
                obj.put("Nama Karyawan", dataKaryawan.get(i).getNamaKaryawan());
                obj.put("Gaji Karyawan", dataKaryawan.get(i).getGajiKaryawan());
                obj.put("ID Jabatan", dataKaryawan.get(i).getIdJabatan());
                jr.add(obj);
            }
            String array = JSONValue.toJSONString(jr);
            JSONParser parser = new JSONParser();

            Object obj2 = parser.parse(array);
            out.print(obj2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }
}