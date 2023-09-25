package Java8;

public class Employee {
    int id;
    public String name;
    int age;
    int salary;

    public Employee() {

    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public  String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
