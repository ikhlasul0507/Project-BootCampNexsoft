package ExampleMultithreading;

class Latihanthread{

    Thread thread;
    int jumlah = 7;

    public static void main(String[] args) {
        Latihanthread test = new Latihanthread();
        test.proses_satu();
        test.proses_dua();
    }

    void proses_satu(){
        thread = new Thread(){
            public void run(){
                try{
                        System.out.println("Nomor: ");
                        sleep(1000); //Waktu Pending

                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

    void proses_dua(){
        thread = new Thread(){
            public void run(){
                try{
                        System.out.println("Salam Programmer");
                        sleep(1000); //Waktu Pending

                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }
}