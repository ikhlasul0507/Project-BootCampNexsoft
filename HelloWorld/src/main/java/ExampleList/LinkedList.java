package ExampleList;

import java.util.Iterator;

public class LinkedList {
    public static void main(String[] args) {
        System.out.println("--------------------------");
        //dengan menggunakan linkedlist
        java.util.LinkedList<String> all = new java.util.LinkedList<String>();
        all.add("Ravi");
        all.add("Vijay");
        all.add("Ravi");
        all.add("Ajay");
        //iterator
        Iterator<String> itr2 = all.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
        System.out.println("---------------------------");
        ///mencari data pada linkedlist
        if(all.contains("Ajay")){
            System.out.println("Data DiTemukan");
        }else{
            System.out.println("Data Tidak Di Temukan");
        }
        System.out.println("---------------------------");
        //cek jika ada data
        if(all.isEmpty()){
            System.out.println("Data Kosong");
        }else{
            System.out.println("Data Penuh");
        }
    }
}
