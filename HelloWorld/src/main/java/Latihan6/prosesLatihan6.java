package Latihan6;


import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class prosesLatihan6 implements Runnable{
    @Override
    public void run() {
        hasilBacaFile();
    }

    Thread thread;
    String fileName = "C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Latihan6\\data.txt";
    String fileNameAsc = "C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Latihan6\\fileDataAsc.txt";
    String fileNameDesc = "C:\\Users\\User\\IdeaProjects\\HelloWorld\\src\\main\\java\\Latihan6\\fileDataDesc.txt";
    String line = "";
    String separator = ",";
    FileWriter fw =null;
    BufferedReader br = null;
    String enter="";

    public void hasilBacaFile() {

        try {
            br = new BufferedReader(new FileReader(fileName));
            System.out.println("========================");
            System.out.println("Hasil Baca File !");
            System.out.println("========================");
            while ((line = br.readLine()) != null) {
                String[] parsingFile = line.split(separator);
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"(Data Ke -"+(i+1)+" ): "+parsingFile[i]);
                }
            }
            System.out.println("========================");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void simpleThread() throws InterruptedException {
        thread = new Thread() {
            public void run() {
                hasilBacaFile();
                System.out.println("Tunggu 5 Detik ya !");
                try {
                    thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        thread.join();
    }

    public void bacaTulisAsc() throws InterruptedException {
        thread = new Thread() {
            public void run() {
                bacaAsc();
                System.out.println("Tunggu 5 Detik ya !");
                try {
                    thread.sleep(5000);
                    tulisAsc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        thread.join();
    }

    public void bacaTulisDesc() throws InterruptedException {
        thread = new Thread() {
            public void run() {
                bacaDesc();
                System.out.println("Tunggu 5 Detik ya !");
                try {
                    thread.sleep(5000);
                    tulisDesc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        thread.join();
    }

    public void bacaAsc(){

        try {
            br = new BufferedReader(new FileReader(fileName));
            System.out.println("========================");
            System.out.println("Hasil Baca File ASC !");
            System.out.println("========================");
            while ((line = br.readLine()) != null) {
                String[] parsingFile = line.split(separator);
                Arrays.sort(parsingFile);
                for (int i = 0; i < 10; i++) {
                    if ((i+1) % 2 == 0){
                        enter="\n";
                    }else{
                        enter="";
                    }
                    System.out.print(parsingFile[i]+", "+enter);
                }
            }
            System.out.println("========================");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void bacaDesc(){

        try {
            br = new BufferedReader(new FileReader(fileName));
            System.out.println("========================");
            System.out.println("Hasil Baca File DESC !");
            System.out.println("========================");
            while ((line = br.readLine()) != null) {
                String[] parsingFile = line.split(separator);
                Arrays.sort(parsingFile, Collections.reverseOrder());
                for (int i = 0; i < 10; i++) {
                    if ((i+1) % 2 == 0){
                        enter="\n";
                    }else{
                        enter="";
                    }
                    System.out.print(parsingFile[i]+", "+enter);
                }
            }
            System.out.println("========================");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tulisAsc(){
        System.out.println("Tulis ASC File fileDataAsc.text");
        System.out.println("Success......");

        try {
            br = new BufferedReader(new FileReader(fileName));
            fw = new FileWriter(fileNameAsc);
            fw.write("==================================================================================================\n");
            fw.write("                            Hasil Baca File ASC !\n");
            fw.write("==================================================================================================\n");

            while ((line = br.readLine()) != null) {
                String[] parsingFile = line.split(separator);
                Arrays.sort(parsingFile);
                for (int i = 0; i < parsingFile.length; i++) {
                    if ((i+1) % 5 == 0){
                        enter="\n";
                    }else{
                        enter="";
                    }
                    fw.write("||     "+parsingFile[i]+"      ||"+enter);
                }
            }
            fw.write("==================================================================================================\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tulisDesc(){
        System.out.println("Tulis DESC File fileDataDesc.text");
        System.out.println("Success......");
        try {
            br = new BufferedReader(new FileReader(fileName));
            fw = new FileWriter(fileNameDesc);
            fw.write("==================================================================================================\n");
            fw.write("                            Hasil Baca File DESC !\n");
            fw.write("==================================================================================================\n");

            while ((line = br.readLine()) != null) {
                String[] parsingFile = line.split(separator);
                Arrays.sort(parsingFile, Collections.reverseOrder());
                for (int i = 0; i < parsingFile.length; i++) {
                    if ((i+1) % 5 == 0){
                        enter="\n";
                    }else{
                        enter="";
                    }
                    fw.write("||     "+parsingFile[i]+"      ||"+enter);
                }
            }
            fw.write("==================================================================================================\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
