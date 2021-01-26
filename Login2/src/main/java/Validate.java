import java.sql.*;

public class Validate {
    public static boolean checkUser(String user,String pass)
    {
        boolean st =false;
        try {
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_ujian2", "root", "ABcd//12"
            );
            String query= "select * from user where username='"+user+"' and password='"+pass+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
