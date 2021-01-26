package ExampleInherintance;

class Calculator{
    int z;
    public void addition(int x, int y){
        z= x + y;
        System.out.println("The sum of the given numbers "+z);
    }
    public void  Subtraction(int x, int y){
        z= x-y;
        System.out.println("The difference beetwen the given numbers "+z);
    }
}

public class CalculatorInheritance extends Calculator{
    //class calculatorinheritance dapat memakai semua attribut
    //dan method pada class calculator karena sudah extens/diwarisi
    public void Multiplication(int x, int y){
        z = x * y;
        System.out.println("The product of the given numbers "+z);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        CalculatorInheritance demo= new CalculatorInheritance();
        System.out.println("======================");
        System.out.println("Output method addition");
        demo.addition(a,b);
        System.out.println("======================");
        System.out.println("Output method Subtraction");
        demo.Subtraction(a,b);
        System.out.println("======================");
        System.out.println("Output method Multiplication");
        demo.Multiplication(a,b);
    }
}
