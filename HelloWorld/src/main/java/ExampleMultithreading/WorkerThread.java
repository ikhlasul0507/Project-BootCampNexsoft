package ExampleMultithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Testworker implements Runnable{
    private String message;
    public Testworker(String s){
        this.message=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start Message = )"+message);
        processmessage();
        System.out.println(Thread.currentThread().getName()+" (End =)" +message);
    }
    public void processmessage(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class WorkerThread {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i=0; i<10;i++){
            Runnable worker = new Testworker(""+i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()){

        }
        System.out.println("Finished all threads");
    }
}
