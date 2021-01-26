package Latihan1;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Latihan1 {
    private static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr.get(j-1) > arr.get(j)){
                    temp = arr.get(j-1);
                    arr.set(j-1,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> bilangan = new ArrayList<Integer>();
//        int bilangan[] ={21,23,26,12,15};
        int target = 0;
        int left=0;
        int middle;

        System.out.print("Masukan Jumlah Data :");
        int jm = sc.nextInt();
        for(int i=0;i<jm;i++){
            System.out.print("Data ke "+(i+1)+":");
            int dt = sc.nextInt();
            bilangan.add(dt);
        }
        System.out.println("Hasil : " + bilangan);
        int right = bilangan.size()-1;
        System.out.println("--------------------------");
        System.out.println("Sebelum Dilakukan Sorting");
        System.out.print("Data : ");
        for(int i=0; i < bilangan.size(); i++){
            System.out.print(bilangan.get(i) + " ");
        }
        System.out.println();
        //method shorting
        bubbleSort(bilangan);

        System.out.println("--------------------------");
        System.out.println("Sesudah Dilakukan Sorting");
        System.out.println("--------------------------");
        System.out.print("Data : ");
        for(int i=0; i < bilangan.size(); i++){
            System.out.print(bilangan.get(i) + " ");
        }
        System.out.println("\n--------------------------");
        System.out.print("Masukan Data Yang Di Cari : ");
        int cr = sc.nextInt();
        System.out.println("--------------------------");
        while(left<= right){
            middle = (left+right)/2;
            if(bilangan.get(middle) == cr){
                System.out.println(cr+" found at index "+ middle);
                break;
            }else if (bilangan.get(middle)< cr){
                left = middle+1;
            }else if (bilangan.get(middle)> cr){
                right = middle-1;
            }
        }
        System.out.println("--------------------------");
    }


}

