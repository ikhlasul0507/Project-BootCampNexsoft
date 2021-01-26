package ExampleInherintance;

interface Animal{

}
class Mammal implements Animal{

}

public class TestDogInterface extends Mammal {

    public static void main(String args[]) {
        Mammal m = new Mammal();
        TestDogInterface d = new TestDogInterface();

        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal);
    }
}
