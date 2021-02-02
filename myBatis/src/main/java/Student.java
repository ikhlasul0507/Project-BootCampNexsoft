public class Student {
    private int id,percentage,phone;
    private String name,branch,email;

    public Student(int id, String name, String branch, int percentage, int phone, String email) {
        super();
        this.id = id;
        this.setPercentage(percentage);
        this.phone = phone;
        this.name = name;
        this.setBranch(branch);
        this.email = email;
    }

    public Student() {
    }
    public Student(String name, String branch, int percentage, int phone, String email){
        this(0, name, branch, percentage, phone, email);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(id).append(" - ");
        sb.append("Name = ").append(name).append(" - ");
        sb.append("Branch = ").append(branch).append(" - ");
        sb.append("Percentage = ").append(percentage).append(" - ");
        sb.append("Phone = ").append(phone).append(" - ");
        sb.append("Email = ").append(email);
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
