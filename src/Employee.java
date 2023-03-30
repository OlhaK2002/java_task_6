public class Employee {
    private int id;
    private static int nextId=1;
    private String name, surname;
    private double salary;

    Employee(String name_value, String surname_value, double salary_value) {
        setId();
        setName(name_value);
        setSurname(surname_value);
        setSalary(salary_value);
    }

    public void setId() {
        this.id = nextId++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String successCreate () {
        return "Employee creates success";
    }
}


