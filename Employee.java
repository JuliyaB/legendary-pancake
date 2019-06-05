/**
 * Java. Lesson5. My Homework5.
 *
 * @author Juliya
 * @version dated 5.06.2019
 */
public class Employee {
    private String fullname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee() {
        fullname = "Ivanov Ivan";
        position = "Engineer";
        email = "ivivan@mailbox.com";
        phone = "892312312";
        salary = 30000;
        age = 30;
    }

    public Employee(String fullname, String position, String email, String phone, int salary, int age) {
        this.fullname=fullname;
        this.position=position;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
    }

    void setFullname(String fullname){
        if (fullname!=null) {
            this.fullname = fullname;
        }
    }

    String getFullname(){
        return fullname;
    }

    void setPosition(String position){
        if (position!=null) {
            this.position = position;
        }
    }

    String getPosition(){
        return position;
    }

    void setEmail(String email){
        if (email!=null) {
            this.email = email;
        }
    }

    String getEmail(){
        return email;
    }

    void setPhone(String phone){
        if (phone!=null) {
            this.phone = phone;
        }
    }

    String getPhone(){
        return phone;
    }

    void setSalary(int salary){
        this.salary = salary;
    }

    int getSalary(){
        return salary;
    }

    void setAge(int age){
        this.age = age;
    }

    int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "ФИО: "+getFullname()+", "+"Должность: "+getPosition()+", "+"email: "+getEmail()+", "+
                "Телефон: "+getPhone()+", "+"Зарплата: "+getSalary()+"руб."+", "+"Возраст: "+getAge()+"\n";
    }

    public void info(){
        System.out.println(this);
    }

}
