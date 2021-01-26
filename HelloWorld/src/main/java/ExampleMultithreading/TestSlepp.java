package ExampleMultithreading;

public class TestSlepp extends Thread{
    public void run(){
        for (int i=1;i<5;i++){
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TestSlepp t1 = new TestSlepp();
        TestSlepp t2 = new TestSlepp();

        t1.start();
        t2.start();
    }
}
