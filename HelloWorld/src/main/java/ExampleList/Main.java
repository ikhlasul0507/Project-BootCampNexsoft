package ExampleList;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World !");
        System.out.println("Data Array List");
        //create arraylist
        ArrayList<String> list = new ArrayList<String>();
        //add object to array;ist
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        //menginstansi object iterator
        Iterator itr = list.iterator();

        System.out.println("------------------------");
        //hasnext yaitu cek kondisi iterator apakah
        //mempunyai nilai pada element selanjutnya atau tidak
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("------------------------");
        System.out.println(list);
        System.out.println("------------------------");
        //use to for
        for (String obj:list){
            System.out.println(obj);
        }
        System.out.println("------------------------");

    }
}


