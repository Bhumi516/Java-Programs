// Name   : Prachi Chavan
// Roll No: 44
// Experiment 11: Implementation of different database operations using JDBC
// Program 2: Transaction Management, Batch Insert, ResultSetMetaData,
//            Stored-Procedure style call (CallableStatement)
//
// ─────────────────────────────────────────────────────────────────────
// SETUP INSTRUCTIONS (MySQL):
//   Same as JDBCCrudDemo.java — ensure java_lab DB exists.
//   Also create the stored procedure once in MySQL:
//
//   DELIMITER $$
//   CREATE PROCEDURE GetStudentsByDept(IN dept VARCHAR(50))
//   BEGIN
//       SELECT * FROM students WHERE department = dept;
//   END$$
//   DELIMITER ;
// ─────────────────────────────────────────────────────────────────────

import java.sql.*;

public class JDBCAdvancedDemo {

    static final String DB_URL  = "jdbc:mysql://localhost:3306/java_lab";
    static final String DB_USER = "root";
    static final String DB_PASS = "your_password";   // ← change this

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    // ====================================================
    // PART 1: Transaction Management
    // Demonstrates COMMIT and ROLLBACK
    // ====================================================
    static void transactionDemo() {
        System.out.println("\n============================================================");
        System.out.println("PART 1: Transaction Management (COMMIT / ROLLBACK)");
        System.out.println("============================================================");

        String insertSQL = "INSERT INTO students (name, roll_no, department, marks) VALUES (?, ?, ?, ?)";
        String deleteSQL = "DELETE FROM students WHERE roll_no = ?";

        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false); // ← Start transaction manually

            PreparedStatement psInsert = conn.prepareStatement(insertSQL);
            psInsert.setString(1, "Transaction Test");
            psInsert.setInt   (2, 99);
            psInsert.setString(3, "Test Dept");
            psInsert.setDouble(4, 55.0);
            psInsert.executeUpdate();
            System.out.println("  [TX] Inserted Roll No 99 (not yet committed).");

            PreparedStatement psDelete = conn.prepareStatement(deleteSQL);
            psDelete.setInt(1, 99);
            psDelete.executeUpdate();
            System.out.println("  [TX] Deleted Roll No 99 (not yet committed).");

            conn.commit(); // ← COMMIT: both changes saved
            System.out.println("  [TX] COMMIT successful — both changes saved.");

        } catch (SQLException e) {
            System.out.println("  [TX] Error: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback(); // ← ROLLBACK on error
                    System.out.println("  [TX] ROLLBACK executed — changes undone.");
                }
            } catch (SQLException ex) {
                System.out.println("  [TX] Rollback error: " + ex.getMessage());
            }
        } finally {
            try {
                if (conn != null) { conn.setAutoCommit(true); conn.close(); }
            } catch (SQLException e) {}
        }

        // Simulate a failed transaction (intentional duplicate roll_no)
        System.out.println("\n  --- Simulating ROLLBACK (duplicate roll_no) ---");
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement(insertSQL);
            ps.setString(1, "Alpha"); ps.setInt(2, 15);  // Roll 15 already exists!
            ps.setString(3, "CS");    ps.setDouble(4, 60.0);
            ps.executeUpdate();

            conn.commit();
            System.out.println("  [TX] Committed — this should NOT print.");

        } catch (SQLException e) {
            System.out.println("  [TX] Exception caught: " + e.getMessage());
            try {
                if (conn != null) { conn.rollback(); conn.setAutoCommit(true); conn.close(); }
                System.out.println("  [TX] ROLLBACK done. Data unchanged.");
            } catch (SQLException ex) {}
        }
    }

    // ====================================================
    // PART 2: Batch Insert using PreparedStatement
    // Efficient bulk inserts without multiple round-trips
    // ====================================================
    static void batchInsertDemo() {
        System.out.println("\n============================================================");
        System.out.println("PART 2: Batch Insert using PreparedStatement");
        System.out.println("============================================================");

        String sql = "INSERT INTO students (name, roll_no, department, marks) VALUES (?, ?, ?, ?)";

        String[][] data = {
            {"Batch Student 1", "101", "Batch Dept", "72.0"},
            {"Batch Student 2", "102", "Batch Dept", "85.5"},
            {"Batch Student 3", "103", "Batch Dept", "90.0"},
            {"Batch Student 4", "104", "Batch Dept", "68.0"},
            {"Batch Student 5", "105", "Batch Dept", "78.0"},
        };

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (String[] row : data) {
                ps.setString(1, row[0]);
                ps.setInt   (2, Integer.parseInt(row[1]));
                ps.setString(3, row[2]);
                ps.setDouble(4, Double.parseDouble(row[3]));
                ps.addBatch(); // add to batch
            }

            int[] results = ps.executeBatch(); // execute all at once
            conn.commit();

            System.out.println("  [BATCH] " + results.length + " students inserted in one batch.");

        } catch (SQLException e) {
            System.out.println("[DB Error] batchInsert: " + e.getMessage());
        }
    }

    // ====================================================
    // PART 3: ResultSetMetaData
    // Discover column names/types at runtime
    // ====================================================
    static void metaDataDemo() {
        System.out.println("\n============================================================");
        System.out.println("PART 3: ResultSetMetaData");
        System.out.println("============================================================");

        String sql = "SELECT * FROM students LIMIT 3";

        try (Connection conn = getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            System.out.println("  Column count: " + cols + "\n");
            System.out.printf("  %-15s %-20s %-10s%n", "Column Name", "Type Name", "Display Size");
            System.out.println("  " + "-".repeat(48));
            for (int i = 1; i <= cols; i++) {
                System.out.printf("  %-15s %-20s %-10d%n",
                        meta.getColumnName(i),
                        meta.getColumnTypeName(i),
                        meta.getColumnDisplaySize(i));
            }

            // Print rows
            System.out.println("\n  Sample rows:");
            while (rs.next()) {
                StringBuilder row = new StringBuilder("  | ");
                for (int i = 1; i <= cols; i++) {
                    row.append(rs.getString(i)).append(" | ");
                }
                System.out.println(row);
            }

        } catch (SQLException e) {
            System.out.println("[DB Error] metaDataDemo: " + e.getMessage());
        }
    }

    // ====================================================
    // PART 4: CallableStatement (Stored Procedure)
    // ====================================================
    static void callableStatementDemo() {
        System.out.println("\n============================================================");
        System.out.println("PART 4: CallableStatement (Stored Procedure)");
        System.out.println("============================================================");

        String call = "{CALL GetStudentsByDept(?)}";

        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(call)) {

            cs.setString(1, "Computer Engg");
            ResultSet rs = cs.executeQuery();

            System.out.println("  Students in 'Computer Engg' department:");
            System.out.printf("  %-5s %-20s %-8s %-7s%n", "ID", "Name", "Roll No", "Marks");
            System.out.println("  " + "-".repeat(45));
            while (rs.next()) {
                System.out.printf("  %-5d %-20s %-8d %-7.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("roll_no"),
                        rs.getDouble("marks"));
            }

        } catch (SQLException e) {
            System.out.println("[DB Error] callableStatement: " + e.getMessage());
            System.out.println("  (Ensure stored procedure 'GetStudentsByDept' exists in DB)");
        }
    }

    // ====================================================
    // PART 5: DatabaseMetaData
    // ====================================================
    static void databaseMetaDataDemo() {
        System.out.println("\n============================================================");
        System.out.println("PART 5: DatabaseMetaData");
        System.out.println("============================================================");

        try (Connection conn = getConnection()) {
            DatabaseMetaData dbMeta = conn.getMetaData();

            System.out.println("  DB Product    : " + dbMeta.getDatabaseProductName());
            System.out.println("  DB Version    : " + dbMeta.getDatabaseProductVersion());
            System.out.println("  Driver Name   : " + dbMeta.getDriverName());
            System.out.println("  Driver Version: " + dbMeta.getDriverVersion());
            System.out.println("  JDBC URL      : " + dbMeta.getURL());
            System.out.println("  User          : " + dbMeta.getUserName());
            System.out.println("  Max Connections: " + dbMeta.getMaxConnections());

        } catch (SQLException e) {
            System.out.println("[DB Error] dbMetaData: " + e.getMessage());
        }
    }

    // ====================================================
    // Main method
    // ====================================================
    public static void main(String[] args) {
        System.out.println("===== JDBC Advanced Demo — Prachi Chavan, Roll No: 44 =====");

        transactionDemo();
        batchInsertDemo();
        metaDataDemo();
        callableStatementDemo();
        databaseMetaDataDemo();

        System.out.println("\n===== All Parts Complete =====");
    }
}
