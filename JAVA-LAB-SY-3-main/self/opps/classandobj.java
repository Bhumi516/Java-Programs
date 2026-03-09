
import javax.print.attribute.standard.PrinterInfo;

// class pen{
//     String name;
//     String colour;
//     public void write(){
//         System.out.println("writing something");
//         System.out.println(this.colour);
//         System.out.println(this.name);
//     }
// }

// public class classandobj{
//     public static void main(String[] args) {
//         pen pen1= new pen();
//         pen1.colour="red";
//         pen1.name="trimax";
//         pen1.write();
//         // System.out.println(pen1.name);
//         // System.out.println(pen1.colour);
//     }
// }


// class Student{
//     String name;
//     int age;
//     int roll;

//     public void printinfo(){
//         System.out.println(name);
//         System.out.println(this.age);
//         System.out.println(this.roll);
//     }

//     Student(){
//        System.out.println("constructor called");
//     }
// }

// public class classandobj{
//     public static void main(String[] args){
//         Student s1 = new Student();
//         s1.name="atahrv";
//         s1.age=19;
//         s1.roll=15;
        // s1.printinfo();
//     }
// }

// class object function constructor

class Student{
    String name;
    int age;
    int roll;

    Student(int age,String name,int roll){
       this.age=age;
       this.name=name;
       this.roll=roll;
    }
    public void printinfo(){
        System.out.println(name);
        System.out.println(this.age);
        System.out.println(this.roll);
    }
    // copy constructor
    Student(Student a1){
        this.name=a1.name;
        this.roll=a1.roll;
        this.age=a1.age;
    }
}

public class classandobj{
    public static void main(String[] args) {
        Student s1= new Student(12,"atharv",12);
        // copy constructor
        Student s2 = new Student(s1);
        s1.printinfo();
        s2.printinfo();
    }
}


