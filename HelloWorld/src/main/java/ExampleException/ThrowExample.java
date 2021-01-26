package ExampleException;

public class ThrowExample {
    public static void main(String[] args) {
        validate(10);
    }
    static void validate(int age){
        if(age<18)
            throw new ArithmeticException("Not Valid");
        else
            System.out.println("Welcome to vote");
    }
}
