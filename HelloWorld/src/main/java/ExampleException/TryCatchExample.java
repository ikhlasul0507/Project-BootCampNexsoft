package ExampleException;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int data = 50 / 0;
            System.out.println("Success...");
        }catch (Exception e){
            System.out.println("Error : "+e);
        }finally { //selalu di cetak
            System.out.println("Finally Block is always executed ");
        }

        System.out.println("rest of the code ....");
    }

}
