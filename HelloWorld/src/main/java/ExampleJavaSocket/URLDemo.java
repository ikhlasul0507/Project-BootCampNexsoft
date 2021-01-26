package ExampleJavaSocket;

import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://facebook.com:8888/user.php");
            for(int i=0 ; i<3;i++) {
                System.out.println("||=> Data Ke -"+(i+1));
                System.out.println("------------------------------------");
                System.out.println("|| Protocol    : " + url.getProtocol());
                System.out.println("|| Port Name   : " + url.getHost());
                System.out.println("|| Port Number : " + url.getPort());
                System.out.println("|| File Name   : " + url.getFile());
                System.out.println("------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
