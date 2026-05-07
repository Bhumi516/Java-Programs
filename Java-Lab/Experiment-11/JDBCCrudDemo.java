// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 11: Implementation of different database operations using JDBC
// Program 1: CRUD operations — Create, Read, Update, Delete on Student table
//
// ─────────────────────────────────────────────────────────────────────
// SETUP INSTRUCTIONS (MySQL):
//   1. Install MySQL and MySQL Connector/J JAR
//   2. Create database:
//        CREATE DATABASE java_lab;
//   3. Update DB_URL, DB_USER, DB_PASS below as per your MySQL config
//   4. Compile:
//        javac -cp .;mysql-connector-j-8.x.x.jar JDBCCrudDemo.java
//   5. Run:
//        java  -cp .;mysql-connector-j-8.x.x.jar JDBCCrudDemo
//
// NOTE: Change ; to : on Linux/Mac in the classpath.
// ─────────────────────────────────────────────────────────────────────

import java.sql.*;
import java.util.Scanner;

public class JDBCCrudDemo {

    // ── Database configuration ──
    static final String DB_URL  = "jdbc:mysql://localhost:3306/java_lab";
    static final String DB_USER = "root";
    static final String DB_PASS = "your_password";    // ← change this

    // ── Connection helper ──
    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    // ====================================================
    // CREATE TABLE (runs once)
    // ====================================================
    static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                   + "  id         INT AUTO_INCREMENT PRIMARY KEY,"
                   + "  name       VARCHAR(50)  NOT NULL,"
                   + "  roll_no    INT          NOT NULL UNIQUE,"
                   + "  department VARCHAR(50),"
                   + "  marks      DOUBLE"
                   + ")";
        try (Connection conn = getConnection();
             Statement stmt  = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("[DB] Table 'students' created / already exists.");
        } catch (SQLException e) {
            System.out.println("[DB Error] createTable: " + e.getMessage());
        }
    }

    // ====================================================
    // INSERT — Create
    // ====================================================
    static void insertStudent(String name, int rollNo, String dept, double marks) {
        String sql = "INSERT INTO students (name, roll_no, department, marks) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt   (2, rollNo);
            ps.setString(3, dept);
            ps.setDouble(4, marks);
            int rows = ps.executeUpdate();
            System.out.println("[INSERT] " + rows + " row(s) inserted. Student: " + name);
        } catch (SQLException e) {
            System.out.println("[DB Error] insertStudent: " + e.getMessage());
        }
    }

    // ====================================================
    // SELECT — Read all
    // ====================================================
    static void displayAllStudents() {
        String sql = "SELECT * FROM students ORDER BY roll_no";
        System.out.println("\n─────────────────────────────────────────────────────────");
        System.out.printf("%-5s %-20s %-8s %-20s %-7s%n",
                "ID", "Name", "Roll No", "Department", "Marks");
        System.out.println("─────────────────────────────────────────────────────────");

        try (Connection conn = getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            int count = 0;
            while (rs.next()) {
                count++;
                System.out.printf("%-5d %-20s %-8d %-20s %-7.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("roll_no"),
                        rs.getString("department"),
                        rs.getDouble("marks"));
            }
            System.out.println("─────────────────────────────────────────────────────────");
            System.out.println("Total records: " + count);

        } catch (SQLException e) {
            System.out.println("[DB Error] displayAllStudents: " + e.getMessage());
        }
    }

    // ====================================================
    // SELECT — Read by Roll No
    // ====================================================
    static void searchStudent(int rollNo) {
        String sql = "SELECT * FROM students WHERE roll_no = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("\n[SEARCH] Student Found:");
                System.out.println("  ID         : " + rs.getInt("id"));
                System.out.println("  Name       : " + rs.getString("name"));
                System.out.println("  Roll No    : " + rs.getInt("roll_no"));
                System.out.println("  Department : " + rs.getString("department"));
                System.out.println("  Marks      : " + rs.getDouble("marks"));
            } else {
                System.out.println("[SEARCH] No student found with Roll No: " + rollNo);
            }
        } catch (SQLException e) {
            System.out.println("[DB Error] searchStudent: " + e.getMessage());
        }
    }

    // ====================================================
    // UPDATE — Update marks by roll number
    // ====================================================
    static void updateMarks(int rollNo, double newMarks) {
        String sql = "UPDATE students SET marks = ? WHERE roll_no = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newMarks);
            ps.setInt   (2, rollNo);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("[UPDATE] Marks updated to " + newMarks
                        + " for Roll No: " + rollNo);
            else
                System.out.println("[UPDATE] No student with Roll No: " + rollNo);
        } catch (SQLException e) {
            System.out.println("[DB Error] updateMarks: " + e.getMessage());
        }
    }

    // ====================================================
    // DELETE — Delete by roll number
    // ====================================================
    static void deleteStudent(int rollNo) {
        String sql = "DELETE FROM students WHERE roll_no = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rollNo);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("[DELETE] Student with Roll No " + rollNo + " deleted.");
            else
                System.out.println("[DELETE] No student with Roll No: " + rollNo);
        } catch (SQLException e) {
            System.out.println("[DB Error] deleteStudent: " + e.getMessage());
        }
    }

    // ====================================================
    // Main method
    // ====================================================
    public static void main(String[] args) {

        System.out.println("===== JDBC CRUD Demo — Bhumi Bhadre, Roll No: 31 =====\n");

        // Step 1: Create table
        createTable();

        // Step 2: Insert students
        System.out.println("\n--- Inserting Students ---");
        insertStudent(d, "Computer Engg", 88.5);
        insertStudent("Riya Sharma",  22, "Computer Engg", 91.0);
        insertStudent("Saurabh More", 8,  "IT",            76.5);
        insertStudent("Neha Patil",   31, "Computer Engg", 83.0);
        insertStudent("Rahul Desai",  17, "Electronics",   70.0);

        // Step 3: Display all
        System.out.println("\n--- All Students ---");
        displayAllStudents();

        // Step 4: Search
        System.out.println("\n--- Search Student (Roll No 22) ---");
        searchStudent(22);

        // Step 5: Update
        System.out.println("\n--- Update Marks (Roll No: 31 → 95.0) ---");
        updateMarks(44, 95.0);

        // Step 6: Delete
        System.out.println("\n--- Delete Student (Roll No 8) ---");
        deleteStudent(8);

        // Step 7: Display final state
        System.out.println("\n--- Final Student Table ---");
        displayAllStudents();

        System.out.println("\n===== JDBC CRUD Demo Complete =====");
    }
}

