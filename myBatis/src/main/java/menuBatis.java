
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

    public class menuBatis {
        Scanner in;
        SqlSession session;

        public static void main(String[] args) throws IOException {
            menuBatis app = new menuBatis();

            while (true) {
                app.printMenu();
                String inputMenu = app.in.nextLine();

                if (inputMenu.equals("1")) {
                    // view all
                    app.viewAll();
                } else if (inputMenu.equals("2")) {
                    // insert
                    app.insert();
                } else if (inputMenu.equals("3")) {
                    // update
                    app.update();
                } else if (inputMenu.equals("4")) {
                    // delete
                    app.delete();
                } else if (inputMenu.equals("5")) {
                    break;
                }
            }
            app.session.close();
        }

        public menuBatis() throws IOException {
            in = new Scanner(System.in);
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        }

        public void printMenu() {
            System.out.print("\n== Menu Batis ==\n1. View All\n2. Insert Data\n3. Update Data\n4. Delete Data\n5. Exit\n\nInput : ");
        }

        public void viewAll() {
            //select contact all contacts
            List<Student> student = session.selectList("Student.getAll");
            System.out.println("== Students ==");
            for (Student st : student) {
                System.out.println("Id        \t: " + st.getId());
                System.out.println("Name      \t: " + st.getName());
                System.out.println("Branch    \t: " + st.getBranch());
                System.out.println("Percentage\t: " + st.getPercentage());
                System.out.println("Email     \t: " + st.getEmail());
                System.out.println("Phone     \t: " + st.getPhone());
                System.out.println("============================");
            }
            session.commit();
        }

        public void insert() {
            System.out.print("\n== Insert New Student Data ==\nName : ");
            String name = in.nextLine();
            System.out.print("Branch : ");
            String branch = in.nextLine();
            System.out.print("Percentage : ");
            int percentage = Integer.parseInt(in.nextLine());
            System.out.print("Phone : ");
            int phone = Integer.parseInt(in.nextLine());
            System.out.print("Email : ");
            String email = in.nextLine();

            //Create a new student object
            Student student = new Student(name, branch, percentage, phone, email);

            //Insert student data
            session.insert("Student.insert", student);
            System.out.println("record inserted successfully");
            session.commit();
        }

        public void update() {
            System.out.print("\n== Update Student Data ==\nStudent ID : ");
            int id = Integer.parseInt(in.nextLine());
            //select a particular student using id
            Student student = (Student) session.selectOne("Student.getById", id);
            System.out.println(" == Current details of the student are ==");
            System.out.println(student.toString());

            System.out.println("== Input new data ==");
            System.out.print("New Email : ");
            String newEmail = in.nextLine();
            System.out.print("New Phone number : ");
            int newPhone = Integer.parseInt(in.nextLine());
            //Set new values to the mail and phone number of the student
            student.setEmail(newEmail);
            student.setPhone(newPhone);

            //Update the student record
            session.update("Student.update", student);
            System.out.println("Record updated successfully");
            session.commit();

            //verifying the record
            Student std = (Student) session.selectOne("Student.getById", id);
            System.out.println(" == Details of the student after update operation == ");
            System.out.println(std.toString());
            session.commit();
        }

        public void delete() {
            System.out.println("== Delete Student Data ==");
            System.out.print("Student ID : ");
            int delId = Integer.parseInt(in.nextLine());
            //Delete operation
            session.delete("Student.deleteById", delId);
            System.out.println("Record deleted successfully");
            session.commit();
        }

    }
