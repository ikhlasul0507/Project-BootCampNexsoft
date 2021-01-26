package ExampleInherintance;

//create class
class SuperClass{
    int age;
    //constructor class
    SuperClass(int age){
        this.age = age;
    }
    //print of age
    public void getAge(){
        System.out.println("The value of the variable named age in super class is :" +age);
    }
}
//class child extend parent class
public class SuperClassConstructor extends SuperClass {
    int id;
    //contructor
    SuperClassConstructor(int id,int age) {
        super(age);
        this.id =id;
    }
    public static void main(String[] args) {
        SuperClassConstructor s = new SuperClassConstructor(24, 21);
        s.getAge();
    }
}
