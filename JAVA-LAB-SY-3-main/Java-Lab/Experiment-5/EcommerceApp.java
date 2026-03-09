// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 4: User Defined Packages
// Program 2: EcommerceApp — uses Ecommerce package
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . Ecommerce/Product.java
//   Step 2: javac -d . Ecommerce/Customer.java
//   Step 3: javac -d . Ecommerce/Order.java
//   Step 4: javac EcommerceApp.java
//   Step 5: java EcommerceApp

import Ecommerce.Customer;
import Ecommerce.Order;
import Ecommerce.Product;

public class EcommerceApp {
    public static void main(String[] args) {

        // Create products
        Product p1 = new Product(1, "Laptop",      55000.00, 10);
        Product p2 = new Product(2, "Mouse",         500.00, 50);
        Product p3 = new Product(3, "Keyboard",     1200.00, 30);

        // Display product details
        System.out.println("========== Product Catalogue ==========");
        System.out.println("Product 1:"); p1.displayProduct();
        System.out.println("Product 2:"); p2.displayProduct();
        System.out.println("Product 3:"); p3.displayProduct();

        // Create customers
        Customer c1 = new Customer(201, "Atharv Kate", "atharv@email.com", "Ichalkaranji");
        Customer c2 = new Customer(202, "Riya Sharma",  "riya@email.com",   "Pune");

        // Display customers
        System.out.println("\n========== Customers ==========");
        System.out.println("Customer 1:"); c1.displayCustomer();
        System.out.println("Customer 2:"); c2.displayCustomer();

        // Place orders
        System.out.println("\n========== Placing Orders ==========");
        Order order1 = new Order(301, c1);
        order1.placeOrder(p1, 1);
        order1.placeOrder(p2, 2);

        Order order2 = new Order(302, c2);
        order2.placeOrder(p3, 3);
        order2.placeOrder(p2, 60);  // exceeds stock — should show error

        // Display orders and totals
        System.out.println("\n========== Order Summary ==========");
        System.out.println("Order 1:"); order1.displayOrder();
        System.out.println("\nOrder 2:"); order2.displayOrder();

        // Updated stock
        System.out.println("\n========== Updated Stock ==========");
        System.out.println("Product 1:"); p1.displayProduct();
        System.out.println("Product 2:"); p2.displayProduct();
        System.out.println("Product 3:"); p3.displayProduct();
    }
}
