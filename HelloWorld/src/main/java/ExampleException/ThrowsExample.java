package ExampleException;

import java.io.IOException;

public class ThrowsExample {
    int makUmur = 20;
    int umurPengunjung = 16;
    void m() throws IOException {
        throw new IOException("Device Error");// checked exception
//        System.out.println("Device Operation performed");
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
//            if(umurPengunjung<=makUmur){
//                throw new IOException("Pengunjung dibawah umur, tidak boleh masuk");
//            }else{
//                System.out.println("Pengunjung diperbolehkan masuk");
//            }
            n();
        } catch (Exception e) {
            //get messege for use get messege from throw
            System.out.println(e.getMessage());
            System.out.println("Exception handled");
        }
    }

    public static void main(String[] args) throws IOException {
        ThrowsExample obj = new ThrowsExample();
        obj.p();
        obj.method();
        System.out.println("Normal Flow");
    }

    void method() throws IOException {
        try {
            throw new IOException("Device Error");
        }catch (Exception e){
            System.out.println("Berhasil ");
        }
    }
}
