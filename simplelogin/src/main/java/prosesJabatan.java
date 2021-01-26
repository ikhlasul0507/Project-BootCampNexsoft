

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputDataJabatan")
public class prosesJabatan extends HttpServlet {
    private String namaJabatan, tunjanganMakan, tunjanganTransport;
    private String idJabatan;
    Model md = new Model();

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public String getTunjanganMakan() {
        return tunjanganMakan;
    }

    public void setTunjanganMakan(String tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public String getTunjanganTransport() {
        return tunjanganTransport;
    }

    public void setTunjanganTransport(String tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("namaJabatan");
        setNamaJabatan(n);
        String p = request.getParameter("tunjanganMakan");
        setTunjanganMakan(p);
        String j = request.getParameter("tunjanganTransport");
        setTunjanganTransport(j);

        try {
            md.inputDataJabatan(getNamaJabatan(), getTunjanganMakan(), getTunjanganTransport());
            out.print("Data Berhasil Di Simpan !");
            RequestDispatcher rd = request.getRequestDispatcher("jabatan.jsp");
            rd.include(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        out.close();
    }

}