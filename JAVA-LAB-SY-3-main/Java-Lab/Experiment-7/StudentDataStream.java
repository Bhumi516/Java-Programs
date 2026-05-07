// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 6: Implementation of different I/O operations using I/O Streams
// Program 2: Store and retrieve student info using DataOutputStream + DataInputStream

import java.io.*;
import java.util.Scanner;

public class StudentDataStream {

    static final String FILE_NAME = "student.dat";

    // -------- Write student data using DataOutputStream --------
    static void writeStudentData(String name, int age, double weight,
                                  double height, String city, String phone) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(FILE_NAME))) {

            dos.writeUTF(name);       // String
            dos.writeInt(age);        // int
            dos.writeDouble(weight);  // double
            dos.writeDouble(height);  // double
            dos.writeUTF(city);       // String
            dos.writeUTF(phone);      // String

            System.out.println("\nStudent data written to \"" + FILE_NAME + "\" successfully.");

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }
    }

    // -------- Read student data using DataInputStream --------
    static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(FILE_NAME))) {

            String name   = dis.readUTF();
            int    age    = dis.readInt();
            double weight = dis.readDouble();
            double height = dis.readDouble();
            String city   = dis.readUTF();
            String phone  = dis.readUTF();

            System.out.println("\n========== Retrieved Student Data ==========");
            System.out.println("Name        : " + name);
            System.out.println("Age         : " + age + " years");
            System.out.println("Weight      : " + weight + " kg");
            System.out.println("Height      : " + height + " cm");
            System.out.println("City        : " + city);
            System.out.println("Phone No    : " + phone);
            System.out.println("============================================");

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Student Information Entry ==========");

        System.out.print("Enter Name        : ");
        String name = sc.nextLine();

        System.out.print("Enter Age         : ");
        int age = sc.nextInt();

        System.out.print("Enter Weight (kg) : ");
        double weight = sc.nextDouble();

        System.out.print("Enter Height (cm) : ");
        double height = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter City        : ");
        String city = sc.nextLine();

        System.out.print("Enter Phone No    : ");
        String phone = sc.nextLine();

        // Write to file
        writeStudentData(name, age, weight, height, city, phone);

        // Read from file and display
        readStudentData();

        sc.close();
    }
}
