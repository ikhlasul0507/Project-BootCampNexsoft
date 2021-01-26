<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String id=request.getParameter("id");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_latihan10", "root", "ABcd//12");
Statement st=conn.createStatement();
int i=st.executeUpdate("DELETE FROM tbl_karyawan WHERE idKaryawan="+id+"");
out.println("Data Berhasil Di Hapus !");
            RequestDispatcher rd=request.getRequestDispatcher("karyawan.jsp");
            rd.include(request,response);

}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>