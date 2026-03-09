class Student{
    String name;
    int roll;
    int age;


    public void printinfo(String name){
        this.name=name;
        System.out.println(name);
    }
    public void printinfo(int roll){
        this.roll=roll;
        System.out.println(roll);
    }
    public void printinfo(String name,int roll, int age){
        this.name=name;
        System.out.println(name);
        System.out.println(roll);
        System.out.println(age);

    }
}

public class polymorph{
    public static void main(String[] args){
        Student s1 = new Student();
        s1.name="atharv";
        s1.roll=15;
        s1.age=19;
    s1.printinfo(s1.name);
    s1.printinfo(s1.roll);
    s1.printinfo(s1.name,s1.roll,s1.age);

    }
}