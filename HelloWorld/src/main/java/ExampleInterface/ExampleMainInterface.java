package ExampleInterface;

interface Animal {
    //diisi oleh implements class dengan method yang sama
    public void eat();

    public void travel();

    public void drink();
}

public class ExampleMainInterface implements Animal {
    public void eat() {
        System.out.println("Mama1 Eats");
    }

    public void travel() {
        System.out.println("Mama1 travels");
    }

    @Override
    public void drink() {

    }


    public int noOfLegs() {
        return 0;
    }

    public static void main(String[] args) {
        ExampleMainInterface m = new ExampleMainInterface();
        m.eat();
        m.travel();
    }

}
