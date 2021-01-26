import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class LoginDao {
    public static boolean validate(String name,String pass){
        boolean status=false;

        try{
            Connection con;
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\User\\Downloads\\simplelogin\\simplelogin\\src\\main\\webapp\\akundatabase.properties"));
            String database = prop.getProperty("database");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+database+"", ""+username+"", ""+password+""
            );
            String query= "select * from user where username='"+name+"' and password='"+pass+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            status=rs.next();

        }catch(Exception e){System.out.println(e);}
        return status;
    }
}