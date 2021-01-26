package ExampleInherintance;

class Animal2{

}
class Mamalia extends Animal2{

}
class Reptile extends Animal2{

}
public class InheritanceRelationshipExample  extends Mamalia{
    public static void main(String[] args) {
        Animal2 a = new Animal2();
        Mamalia m = new Mamalia();
        InheritanceRelationshipExample dog = new InheritanceRelationshipExample();
        System.out.println(m instanceof Animal2);
        System.out.println(dog instanceof Mamalia);
        System.out.println(dog instanceof Animal2);
    }
}
