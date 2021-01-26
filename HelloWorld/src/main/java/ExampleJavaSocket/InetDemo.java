package ExampleJavaSocket;

import java.net.InetAddress;

public class InetDemo {
    public static void main(String[] args) {
        try{
            InetAddress ip = InetAddress.getByName("www.javapoint.com");
            System.out.println("Host Name : "+ ip.getHostName());
            System.out.println("Address Name : "+ ip.getHostAddress());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
