package ExampleFileProperties;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ExampleApp {

    static String root = "src/main/java/";

    public static void main(String[] args) {
        Properties prop =  new Properties();
        OutputStream output = null;
        try{
            output = new FileOutputStream(root + "ExampleFileProperties/config.properties");
                //set the properties value
            prop.setProperty("server","localhost");
            prop.setProperty("port","666");
            prop.store(output,null);
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            if(output!=null){
                try{
                    output.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }

        InputStream input = null;
        try{
            input = new FileInputStream(root+"ExampleFileProperties/config.properties");
            //load a properties file
            prop.load(input);
            //get properti value and print it out
            System.out.println(prop.getProperty("server"));
            System.out.println(prop.getProperty("port"));
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            if(output!=null){
                try{
                    output.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
