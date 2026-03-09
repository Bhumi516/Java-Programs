// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 2: Design and develop programs for different types of inheritance
// Program 2: Hierarchical Inheritance — Employee → Manager, Developer, Programmer

// Superclass
class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    double calculateBonus() {
        return salary * 0.10;  // default 10%
    }

    void generateReport() {
        System.out.println(jobTitle + " " + name + " performance is satisfactory.");
    }

    void manageProject() {
        System.out.println(jobTitle + " " + name + " is managing a project.");
    }

    void displayDetails() {
        System.out.println("\nName     : " + name);
        System.out.println("Address  : " + address);
        System.out.println("Salary   : " + salary);
        System.out.println("Job Title: " + jobTitle);
    }
}

class Manager extends Employee {
    Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    double calculateBonus() { return salary * 0.20; }  // 20%
}

class Developer extends Employee {
    Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    @Override
    double calculateBonus() { return salary * 0.15; }  // 15%
}

class Programmer extends Employee {
    Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    @Override
    double calculateBonus() { return salary * 0.12; }  // 12%
}

public class Company {
    public static void main(String[] args) {

        Manager m    = new Manager("Atharv Kate", "Ichalkaranji", 80000);
        Developer d  = new Developer("Atharv Kate", "Ichalkaranji", 60000);
        Programmer p = new Programmer("Atharv Kate", "Ichalkaranji", 50000);

        m.displayDetails();
        System.out.println("Bonus: " + m.calculateBonus());
        m.generateReport();
        m.manageProject();

        d.displayDetails();
        System.out.println("Bonus: " + d.calculateBonus());
        d.generateReport();
        d.manageProject();

        p.displayDetails();
        System.out.println("Bonus: " + p.calculateBonus());
        p.generateReport();
        p.manageProject();
    }
}
