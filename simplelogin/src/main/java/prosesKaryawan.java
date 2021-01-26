import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputDataKaryawan")
public class prosesKaryawan extends HttpServlet {
    private String namaKaryawan, gajiKaryawan, idJabatan,idKaryawan;
    Model md = new Model();

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getGajiKaryawan() {
        return gajiKaryawan;
    }

    public void setGajiKaryawan(String gajiKaryawan) {
        this.gajiKaryawan = gajiKaryawan;
    }

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("namaKaryawan");
        setNamaKaryawan(n);
        String p = request.getParameter("gajiKaryawan");
        setGajiKaryawan(p);
        String j = request.getParameter("idJabatan");
        setIdJabatan(j);

        try {
            md.inputDataKaryawan(getNamaKaryawan(),getGajiKaryawan(),getIdJabatan());
            out.print("Data Berhasil Di Simpan !");

            RequestDispatcher rd=request.getRequestDispatcher("karyawan.jsp");
            rd.include(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.close();
    }

}  