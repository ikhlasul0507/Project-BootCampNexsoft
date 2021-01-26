package ExampleInherintance;

class Super_class{
    int num = 20;
    //method display
    public void display(){
        System.out.println("This is the display method of superclass");
    }
}
class Sub_class extends Super_class{
    int num =20;

    //method display
    public void display(){
        System.out.println("This is the display method of subclass");
    }
    //my method
    public void my_method() {
        //instansiasi class
        Sub_class sub = new Sub_class();
        //invoking display method of sub class
        sub.display();
        //invoking display method of super class
        //super adalah parent dari child class yang extends
        super.display();
        //printing the value of variable num of subclass
        System.out.println("value of the variable named num in sub class "+sub.num);
        //printing the value of variable num of subclass
        System.out.println("value of the variabel named num in super class "+super.num);
    }

}
public class SuperClassInhertitance {
    public static void main(String[] args) {
        Sub_class obj = new Sub_class();
        obj.my_method();
        obj.display();
    }
}
