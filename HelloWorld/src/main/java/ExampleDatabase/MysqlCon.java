package ExampleDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","ABcd//12");
            Statement stmt = con.createStatement();
            //tambah data
            stmt.executeUpdate("insert into emp values(4,'Silo',21)");
            //edit data
//            int result = stmt.executeUpdate("update emp set age=25 where id=4");
            //hapus data
//            int result1 = stmt.executeUpdate("Delete from emp where id=2");
            ResultSet rs = stmt.executeQuery("Select * From emp");



            while (rs.next())
                System.out.println("|| "+rs.getInt(1)+" || "+rs.getString(2)+" || "+rs.getString(3));

            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
