package ExampleBubbleSort;

import java.util.*;

public class Bubble {
    public static void main(String[] args) {
        int [] b = {4,85,7,1,0,36,-5,48};
        for (int i=0; i < b.length; i++){
            for (int j=0; j < b.length - 1 -i; j++){
                System.out.println("a[a+j] = "+ b[j+1]);
                System.out.println("a[j] = "+b[j]);
                if (b[j+1]<b[j]){
                    int temp = b[j];
                    b[j] = b[j+1];
                    b[j+1] = temp;
                }

            }
        }
    }
}
