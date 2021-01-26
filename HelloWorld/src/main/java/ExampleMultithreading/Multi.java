package ExampleMultithreading;

public class Multi  extends Thread{
    public void run(){
        System.out.println("thread is running....");
    }
    public void run1(){
        System.out.println("thread is running 2....");
    }
    public static void main(String[] args) {
        Multi t1 = new Multi();
        t1.start();
        t1.run1();
    }
}

