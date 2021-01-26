package ExampleInherintance;

class Animal1 {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dog extends Animal1 {
    public void move() {
        //memanggil fungsi move pada class animal1
        super.move();
        System.out.println("Dogs Can Walk And Run");
    }
}

public class TestOverriding {
    public static void main(String[] args) {
        Animal1 a = new Animal1();
        Animal1 b = new Dog();
        a.move();
        b.move();
    }
}
