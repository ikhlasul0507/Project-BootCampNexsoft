package ExampleEncapsulation;

class Encaptest{
    private String name;
    private String idNum;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
public class EncapsulationExample {
    public static void main(String[] args) {
        Encaptest encap = new Encaptest();
        encap.setIdNum("13");
        encap.setName("Ikhlasul Amal");
        encap.setAge(20);

        System.out.println("ID : "+ encap.getIdNum()+"\nName : "+encap.getName()+"\nAge : "+encap.getAge());

    }
}
