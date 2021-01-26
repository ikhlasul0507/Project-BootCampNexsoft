abstract class Employee {
    private String name;
    private String address;
    private int number;

    //parameter yang dikirim
    Employee(String name, String address, int number) {
        System.out.println("Constructiong an employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck() {
        System.out.println("Mailing a check to " + this.getName() + " " + this.getAddress());
    }

    public String toString() {
        return getName() + " " + getAddress() + " " + getNumber();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class Salary extends Employee {

    private double salary;

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("Within maincheck of salary class");
        System.out.println("Maling Check to " + getName() + " with Salary " + getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double ComputePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }

}

public class TestVirtualMethod {
    public static void main(String[] args) {
//        Salary s = new Salary("Ikhlasul Amal", "Tangerang",8222,5000000);
//        Employee e = new Salary("Silo","Bogor",12,6000000);
//        System.out.println("call main check using salary reference");
//        s.mailCheck();
//        System.out.println("After compute Pay "+ (int)s.ComputePay());
//        System.out.println("\ncall main check using Employee reference");
//        e.mailCheck();
//        System.out.println("After compute Pay "+ (int)s.ComputePay());

        //untuk cetak data dari abstrak kelas
        Salary s = new Salary("Ikhlasul Amal", "Tangerang",8222,5000000);
        Employee e = new Salary("Silo", "Bogor", 12,600000);
        System.out.println("call main check using salary reference");
        s.mailCheck();
        System.out.println("\ncall main check using Employee reference");
        e.mailCheck();
        s.ComputePay();
    }
}
