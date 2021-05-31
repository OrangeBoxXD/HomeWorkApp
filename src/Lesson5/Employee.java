package Lesson5;

public class Employee {
    //ФИО, должность, email, телефон, зарплата, возраст
    private String fullName;
    private String position;
    private String email;
    private long contacts;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, long contacts, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.contacts = contacts;
        this.salary = salary;
        this.age = age;
    }

    public void ShowInfo() {
        System.out.printf("Employee %s is %d year old, is working as %s, gets paid %d$ a week.%nEmail: %s%nContacts: %d%n%n" ,
                GetFullName(), GetAge(), GetPosition(), GetSalary(), GetEmail(), GetContacts());
    }

    public String  GetFullName() {
        return this.fullName;
    }
    public String  GetPosition() {
        return this.position;
    }
    public String  GetEmail() {
        return this.email;
    }
    public long  GetContacts() {
        return this.contacts;
    }
    public int  GetSalary() {
        return this.salary;
    }
    public int  GetAge() {
        return this.age;
    }

}
