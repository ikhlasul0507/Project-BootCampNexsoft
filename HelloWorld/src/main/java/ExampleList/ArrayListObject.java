package ExampleList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListObject {
    public static void main(String[] args) {
        //buat class student
        //add data dari class student
        Student s1 = new Student(101,"Sono", 23);
        Student s2 = new Student(102,"Ravi", 23);
        Student s3 = new Student(103,"Hanumat", 23);

        //create arraylist dari student
        ArrayList<Student> al =new ArrayList<Student>();
        //add data object kedalam arraylist
        al.add(s1);
        al.add(s2);
        al.add(s3);
        //get iterator
        Iterator iter=al.iterator();
        System.out.println("---------------------------");
        //cek iterator dari dari arraylist
        while (iter.hasNext()){
            Student st = (Student)iter.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);

        }
        System.out.println("--------------------------");
        //dengan menggunakan for
        for (Student data:al){
            System.out.println(data.rollno+" "+data.name+" "+ data.age);
        }

    }
}
